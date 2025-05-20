import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JFrame {
    private String username;

    public MainMenu(String username) {
        this.username = username;
        setTitle("Main Menu - Welcome " + username);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton wardrobeButton = new JButton("Smart Wardrobe Organizer");
        JButton todoButton = new JButton("Personal To-Do List Manager");
        JButton recipeButton = new JButton("Recipe Book and Planner");
        JButton recommendButton = new JButton("Book/Movie Recommendation");
        JButton logoutButton = new JButton("Logout");

        add(wardrobeButton);
        add(todoButton);
        add(recipeButton);
        add(recommendButton);
        add(logoutButton);

        wardrobeButton.addActionListener(e -> new WardrobeOrganizer(username));
        todoButton.addActionListener(e -> new ToDoListManager(username));
        recipeButton.addActionListener(e -> new RecipePlanner(username));
        recommendButton.addActionListener(e -> new RecommendationCenter(username));
        logoutButton.addActionListener(e -> logout());

        setVisible(true);
    }

    private void logout() {
        new LoginScreen();
        dispose(); // close menu
    }
}
