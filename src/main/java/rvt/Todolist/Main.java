package rvt.Todolist;

import javax.swing.*;
import java.awt.*;

public class Main {
    private static TodoDB db = new TodoDB();
    private static DefaultListModel<String> model = new DefaultListModel<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame("To Do List");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField input = new JTextField();
        JButton addButton = new JButton("Add");
        JButton deleteButton = new JButton("Delete");

        JList<String> list = new JList<>(model);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(input, BorderLayout.CENTER);
        topPanel.add(addButton, BorderLayout.EAST);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(list), BorderLayout.CENTER);
        frame.add(deleteButton, BorderLayout.SOUTH);

        loadTasks();

        addButton.addActionListener(e -> {
            String task = input.getText();

            if (!task.isEmpty()) {
                db.add(task);
                input.setText("");
                loadTasks();
            }
        });

        deleteButton.addActionListener(e -> {
            String selected = list.getSelectedValue();

            if (selected != null) {
                int id = Integer.parseInt(selected.split("\\.")[0]);
                db.removeById(id);
                loadTasks();
            }
        });

        frame.setVisible(true);
    }

    private static void loadTasks() {
        model.clear();

        for (String task : db.findAll()) {
            model.addElement(task);
        }
    }
}