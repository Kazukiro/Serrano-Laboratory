import java.awt.*;
import javax.swing.*;

public class RecipePlanner extends JFrame {
    private String username;
    private JTextArea recipeArea;
    private JTextField mealPlanField;
    private DefaultListModel<String> mealPlanModel;
    private JList<String> mealPlanList;

    public RecipePlanner(String username) {
        this.username = username;
        setTitle("Recipe Book & Planner - " + username);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        recipeArea = new JTextArea();
        recipeArea.setText("Sample Recipes:\n- Spaghetti\n- Fried Rice\n- Pancakes\n- Grilled Chicken");
        recipeArea.setEditable(false);
        JScrollPane recipeScroll = new JScrollPane(recipeArea);

        mealPlanField = new JTextField();
        JButton addMealButton = new JButton("Add to Meal Plan");

        mealPlanModel = new DefaultListModel<>();
        mealPlanList = new JList<>(mealPlanModel);
        JScrollPane mealPlanScroll = new JScrollPane(mealPlanList);

        JPanel topPanel = new JPanel(new BorderLayout(5,5));
        topPanel.add(new JLabel("Recipes:"), BorderLayout.NORTH);
        topPanel.add(recipeScroll, BorderLayout.CENTER);

        JPanel middlePanel = new JPanel(new BorderLayout(5,5));
        middlePanel.add(mealPlanField, BorderLayout.CENTER);
        middlePanel.add(addMealButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel(new BorderLayout(5,5));
        bottomPanel.add(new JLabel("Meal Plan:"), BorderLayout.NORTH);
        bottomPanel.add(mealPlanScroll, BorderLayout.CENTER);

        add(topPanel, BorderLayout.NORTH);
        add(middlePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        addMealButton.addActionListener(e -> addMeal());

        setVisible(true);
    }

    private void addMeal() {
        String meal = mealPlanField.getText().trim();
        if (!meal.isEmpty()) {
            mealPlanModel.addElement(meal);
            mealPlanField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a meal to plan.");
        }
    }
}
