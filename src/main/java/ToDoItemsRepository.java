import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ToDoItemsRepository {

    public static void writeToFile(ToDoList toDoList) {
        try {
            PrintWriter out = new PrintWriter("filename.txt");
            for (ToDoItem toDoItem: toDoList.getToDoList()) {
                out.println(toDoItem.toString());
            }
            out.close();
        } catch (Exception e) {
            System.out.println("Unable to save to file.");
        }
    }

    public static ToDoList readFromFile() {
        String fileName = "filename.txt";
        ToDoList toDoList = new ToDoList();
        File file = new File(fileName);

        if (!file.exists()) {
            return toDoList;
        }

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");
                int itemId = Integer.parseInt(parts[0]);
                String itemDescription = parts[1];
                boolean isComplete = Boolean.parseBoolean(parts[2]);
                ToDoItem toDoItem = new ToDoItem(itemId, itemDescription, isComplete);

                toDoList.addToDoItem(toDoItem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return toDoList;
    }
}

