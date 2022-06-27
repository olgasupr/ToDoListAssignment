import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to your To-Do List!");
        Scanner scanner = new Scanner(System.in);

        ToDoList toDoList = ToDoItemsRepository.readFromFile();

        String userInput = "";
        do {
            System.out.println("\nPlease choose an option: ");
            System.out.println("""
                    1. Add a to-do item
                    2. Remove a to-do item
                    3. Mark the to-do item as complete
                    4. View pending to-do items
                    5. View all available to-do items
                    6. Exit the application
                    """);
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    toDoList.addToDoItem();
                    break;
                case "2":
                    toDoList.removeToDoItem();
                    break;
                case "3":
                    toDoList.markAsComplete();
                    break;
                case "4":
                    toDoList.viewAllPendingItems();
                    break;
                case "5":
                    toDoList.viewAllAvailableItems();
                    break;
                case "6":
                    System.out.println("Exiting the application...");
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while (!userInput.equals("6"));

        ToDoItemsRepository.writeToFile(toDoList);

    }
}
