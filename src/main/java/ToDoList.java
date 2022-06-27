import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    Scanner scanner = new Scanner(System.in);
    Scanner scannerInt = new Scanner(System.in);
    ArrayList<ToDoItem> toDoList = new ArrayList<ToDoItem>();


    public void addToDoItem() {
        ToDoItem toDoItem = new ToDoItem();
        System.out.println("Please enter an id for the to-do item: ");
        toDoItem.itemId = scannerInt.nextInt();

        if (findById(toDoItem.itemId) != null) {
            System.out.println("The to-do item with the id provided already exists.");
        } else {
            System.out.println("Please enter a description for the to-do item: ");
            toDoItem.itemDescription = scanner.nextLine();
            addToDoItem(toDoItem);
            System.out.println("The to-do item (id " + toDoItem.itemId + ") added successfully.");
        }
    }

    public void addToDoItem(ToDoItem item) {
        toDoList.add(item);
    }

    public void removeToDoItem() {
        System.out.println("Please enter the id of the to-do item to be remove.");
        int itemId = scannerInt.nextInt();
        ToDoItem toDoItem = findById(itemId);
        if (toDoItem != null) {
            toDoList.remove(toDoItem);
            System.out.println("The to-do item id " + toDoItem.itemId + " successfully removed.");
        } else {
            System.out.println("The to-do item id" + toDoItem.itemId + " not found.");
        }
    }

    public void markAsComplete() {
        System.out.println("Please enter the id of the to-do item to be marked as complete.");
        int itemId = scannerInt.nextInt();
        ToDoItem toDoItem = findById(itemId);
        if (toDoItem != null) {
            toDoItem.isComplete = true;
            System.out.println("The to-do item id " + toDoItem.itemId + " (" + toDoItem.itemDescription + ") has been completed.");
        }else {
            System.out.println("The to-do item id " + toDoItem.itemId + " was not found.");
        }

    }

    public void viewAllPendingItems() {
        System.out.println("Pending to-do items are: ");

        for (ToDoItem toDoItem : toDoList) {
            if (!toDoItem.isComplete) {
                System.out.println("The to-do item id " + toDoItem.itemId + ": " + toDoItem.itemDescription + ".");
            }
        }
    }

    public void viewAllAvailableItems() {
        System.out.println("Your to-do list contains the following items: ");
        for (ToDoItem toDoItem : toDoList) {
            if (!toDoItem.isComplete) {
                System.out.println(toDoItem.itemId + ": " + toDoItem.itemDescription + " is pending.");
            } else {
                System.out.println(toDoItem.itemId + ": " + toDoItem.itemDescription + " is complete.");
            }
        }
    }

    public ToDoItem findById(int itemId) {
        for (ToDoItem toDoItem  : toDoList) {
            if (itemId == toDoItem.itemId) {
                return toDoItem;
            }
        }
        return null;
    }

    public ArrayList<ToDoItem> getToDoList() {
        return toDoList;
    }
}


