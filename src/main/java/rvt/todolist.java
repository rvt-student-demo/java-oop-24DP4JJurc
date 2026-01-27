package rvt;

import java.util.ArrayList;
import java.util.Scanner;

public class todolist {


    public static class TodoList {

        private ArrayList<String> tasks;

        public TodoList() {
            this.tasks = new ArrayList<>();
        }

        public void add(String task) {
            this.tasks.add(task);
        }

        public void print() {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ": " + tasks.get(i));
            }
        }

        public void remove(int number) {
            int index = number - 1;
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
            }
        }
    }


    public static class UserInterface {

        private TodoList list;
        private Scanner scanner;

        public UserInterface(TodoList list, Scanner scanner) {
            this.list = list;
            this.scanner = scanner;
        }

        public void start() {

            while (true) {
                System.out.print("Command: ");
                String command = scanner.nextLine();

                if (command.equals("stop")) {
                    break;
                }

                if (command.equals("add")) {
                    System.out.print("To add: ");
                    String task = scanner.nextLine();
                    list.add(task);
                }

                if (command.equals("list")) {
                    list.print();
                }

                if (command.equals("remove")) {
                    System.out.print("Which one is removed? ");
                    int id = Integer.valueOf(scanner.nextLine());
                    list.remove(id);
                }
            }
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList list = new TodoList();
        UserInterface ui = new UserInterface(list, scanner);

        ui.start();
    }
}
