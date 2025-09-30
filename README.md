# task_6_java

# ToDo List Application - Task 6

## Project Overview
A desktop GUI ToDo List application built using Java Swing that allows users to manage their daily tasks with an intuitive graphical interface.

## Features Implemented

### GUI Components Used
- **JFrame**: Main window container
- **JTextField**: Input field for entering new tasks
- **JList**: Displays list of all tasks
- **JButton**: Interactive buttons for operations (Add, Delete, Mark Complete, Clear All)
- **JLabel**: Title and status display
- **JScrollPane**: Scrollable task list view
- **JPanel**: Organized layout sections

### Core Functionality

#### Add Task
- Enter task in text field
- Click "Add Task" button or press Enter
- Task added to list with bullet point
- Success confirmation dialog
- Input field clears automatically

#### Delete Task
- Select task from list
- Click "Delete Task" button
- Confirmation dialog before deletion
- Task removed from list

#### Mark Complete
- Select task from list
- Click "Mark Complete" button
- Checkmark (✓) added to task
- Prevents duplicate marking

#### Clear All
- Click "Clear All" button
- Confirmation dialog before clearing
- Removes all tasks from list

### Layout Management
- **BorderLayout**: Main frame organization
- **GridLayout**: Button panel arrangement
- Proper spacing and padding using EmptyBorder
- Responsive design with scroll functionality

### Event Handling
- **ActionListener**: Implemented for all buttons
- Action events for button clicks
- Enter key support for adding tasks
- Dialog confirmations for destructive actions

### UI Design Features
- Custom color scheme (Green for Add, Red for Delete, Blue for Complete)
- Professional fonts and sizing
- Status bar showing total task count
- Centered window positioning
- Custom styling for better user experience

## Key Java Swing Concepts Demonstrated

1. **Swing Components**: JFrame, JButton, JTextField, JList, JLabel, JPanel
2. **Layout Managers**: BorderLayout, GridLayout
3. **Event Handling**: ActionListener interface implementation
4. **DefaultListModel**: Dynamic list management
5. **JOptionPane**: Dialog boxes for user feedback
6. **SwingUtilities**: Event Dispatch Thread management

## How to Run

### Using Command Line:
```bash
javac ToDoApp.java
java ToDoApp
