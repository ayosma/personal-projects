import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JOptionPane;

public class MealPlanReminder {

    // Your meal plan
    private static Map<String, String> mealPlan = new HashMap<>();
    static {
        mealPlan.put("breakfast", "2-3 scrambled eggs with cheese and 1-2 slices of whole wheat toast");
        mealPlan.put("snack", "1-2 cups of Greek yogurt with honey and berries");
        mealPlan.put("lunch", "4-6 oz of grilled chicken or salmon with 1-2 cups of brown rice or quinoa and 1-2 cups of mixed vegetables");
        mealPlan.put("snack", "1-2 cups of cherry tomatoes and sliced cucumbers with hummus");
        mealPlan.put("dinner", "6-8 oz of steak or pork tenderloin with 1-2 baked sweet potatoes and 1-2 cups of steamed spinach or kale");
        mealPlan.put("dessert", "1 serving of ice cream or frozen yogurt");
    }

  // Function to send a reminder of the meal plan
private static void sendReminder(String meal) {
    // Get the current time
    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    String formattedTime = currentTime.format(formatter);
    // Construct the reminder message
    String message = String.format("Meal reminder: It's %s and time for your %s meal. Your meal plan for today includes %s.",
        formattedTime, meal, mealPlan.get(meal));
    // Use the JOptionPane class to display the reminder message
    JOptionPane.showMessageDialog(null, message);
}

    public static void main(String[] args) {
        // Set the times when the reminders should be sent
        LocalTime breakfastTime = LocalTime.of(8, 0);
        LocalTime snackTime = LocalTime.of(10, 30);
        LocalTime lunchTime = LocalTime.of(12, 0);
        LocalTime snackTime2 = LocalTime.of(15, 0);
        LocalTime dinnerTime = LocalTime.of(18, 0);
        LocalTime dessertTime = LocalTime.of(20, 0);
        // Create the GUI on the event dispatch thread
     SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        // Create the main window
        JFrame window = new JFrame("Meal Plan Reminder");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 200);

        // Create a panel for the meal plan reminder
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(600, 200));

        // Create a label for the meal plan reminder
        JLabel label = new JLabel("Meal Plan Reminder");

        // Create a text field for the meal plan reminder
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(600, 50));

        // Create a button for the meal plan reminder
        JButton button = new JButton("Remind Me!");
        button.setPreferredSize(new Dimension(100, 50));
        

        // Add the label, text field, and button to the panel
        panel.add(label, BorderLayout.NORTH);
        panel.add(textField, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);

        // Add the panel to the main window
        window.add(panel);

        // Add an action listener to the button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the current time
                LocalTime currentTime = LocalTime.now();
                // Check if it's time for breakfast
                if (currentTime.isAfter(breakfastTime) && currentTime.isBefore(snackTime)) {
                    sendReminder("breakfast");
                }
        // Check if it's time for breakfast
                if (currentTime.isAfter(breakfastTime) && currentTime.isBefore(snackTime)) {
                    sendReminder("breakfast");
                }
                // Check if it's time for the first snack
                else if (currentTime.isAfter(snackTime) && currentTime.isBefore(lunchTime)) {
                    sendReminder("snack");
                }
                // Check if it's time for lunch
                else if (currentTime.isAfter(lunchTime) && currentTime.isBefore(snackTime2)) {
                    sendReminder("lunch");
                }
                // Check if it's time for the second snack
                else if (currentTime.isAfter(snackTime2) && currentTime.isBefore(dinnerTime)) {
                    sendReminder("snack");
                }
                // Check if it's time for dinner
                else if (currentTime.isAfter(dinnerTime) && currentTime.isBefore(dessertTime)) {
                    sendReminder("dinner");
                }
                // Check if it's time for dessert
                else if (currentTime.isAfter(dessertTime)) {
                    sendReminder("dessert");
                }
            }
        });

        // Display the main window
        window.setVisible(true);
    }
});
}
}