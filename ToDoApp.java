import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ToDoApp extends JFrame implements ActionListener {
    private JTextField taskField;
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JButton addButton;
    private JButton deleteButton;
    private JButton clearAllButton;
    private JButton markCompleteButton;
    private JLabel statusLabel;

    public ToDoApp() {
        setTitle("ToDo List Application");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout(10, 10));
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        topPanel.setBackground(new Color(240, 240, 240));

        JLabel titleLabel = new JLabel("My ToDo List", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(new Color(50, 50, 150));
        topPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(10, 10));
        inputPanel.setBackground(new Color(240, 240, 240));

        taskField = new JTextField();
        taskField.setFont(new Font("Arial", Font.PLAIN, 14));
        taskField.addActionListener(this);
        inputPanel.add(taskField, BorderLayout.CENTER);

        addButton = new JButton("Add Task");
        addButton.setFont(new Font("Arial", Font.BOLD, 12));
        addButton.setBackground(new Color(100, 200, 100));
        addButton.setForeground(Color.WHITE);
        addButton.setFocusPainted(false);
        addButton.addActionListener(this);
        inputPanel.add(addButton, BorderLayout.EAST);

        topPanel.add(inputPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskList.setFont(new Font("Arial", Font.PLAIN, 14));
        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(new Color(240, 240, 240));

        deleteButton = new JButton("Delete Task");
        deleteButton.setFont(new Font("Arial", Font.BOLD, 12));
        deleteButton.setBackground(new Color(220, 100, 100));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        markCompleteButton = new JButton("Mark Complete");
        markCompleteButton.setFont(new Font("Arial", Font.BOLD, 12));
        markCompleteButton.setBackground(new Color(100, 150, 200));
        markCompleteButton.setForeground(Color.WHITE);
        markCompleteButton.setFocusPainted(false);
        markCompleteButton.addActionListener(this);
        buttonPanel.add(markCompleteButton);

        clearAllButton = new JButton("Clear All");
        clearAllButton.setFont(new Font("Arial", Font.BOLD, 12));
        clearAllButton.setBackground(new Color(150, 150, 150));
        clearAllButton.setForeground(Color.WHITE);
        clearAllButton.setFocusPainted(false);
        clearAllButton.addActionListener(this);
        buttonPanel.add(clearAllButton);

        add(buttonPanel, BorderLayout.SOUTH);

        JPanel statusPanel = new JPanel();
        statusPanel.setBackground(new Color(240, 240, 240));
        statusLabel = new JLabel("Total Tasks: 0");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        statusPanel.add(statusLabel);
        add(statusPanel, BorderLayout.SOUTH);

        JPanel combinedBottomPanel = new JPanel();
        combinedBottomPanel.setLayout(new BorderLayout());
        combinedBottomPanel.add(buttonPanel, BorderLayout.NORTH);
        combinedBottomPanel.add(statusPanel, BorderLayout.SOUTH);
        add(combinedBottomPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton || e.getSource() == taskField) {
            addTask();
        } else if (e.getSource() == deleteButton) {
            deleteTask();
        } else if (e.getSource() == markCompleteButton) {
            markComplete();
        } else if (e.getSource() == clearAllButton) {
            clearAll();
        }
    }

    private void addTask() {
        String task = taskField.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement("• " + task);
            taskField.setText("");
            updateStatus();
            JOptionPane.showMessageDialog(this, "Task added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this task?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listModel.remove(selectedIndex);
                updateStatus();
                JOptionPane.showMessageDialog(this, "Task deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void markComplete() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            String task = listModel.get(selectedIndex);
            if (!task.contains("✓")) {
                listModel.set(selectedIndex, task + " ✓");
                JOptionPane.showMessageDialog(this, "Task marked as complete!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Task is already completed!", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to mark complete!", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clearAll() {
        if (listModel.getSize() > 0) {
            int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to clear all tasks?", "Confirm Clear All", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                listModel.clear();
                updateStatus();
                JOptionPane.showMessageDialog(this, "All tasks cleared!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No tasks to clear!", "Info", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateStatus() {
        statusLabel.setText("Total Tasks: " + listModel.getSize());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoApp());
    }
}
