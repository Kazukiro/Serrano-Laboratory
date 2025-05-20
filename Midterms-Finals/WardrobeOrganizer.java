import java.awt.*;
import javax.swing.*;

public class WardrobeOrganizer extends JFrame {
    private String username;
    private DefaultListModel<String> outfitListModel;
    private JList<String> outfitList;
    private JTextField outfitField;

    public WardrobeOrganizer(String username) {
        this.username = username;
        setTitle("Wardrobe Organizer - " + username);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        outfitListModel = new DefaultListModel<>();
        outfitList = new JList<>(outfitListModel);

        JScrollPane scrollPane = new JScrollPane(outfitList);

        outfitField = new JTextField();
        JButton addButton = new JButton("Add Outfit");
        JButton removeButton = new JButton("Remove Selected Outfit");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout(5, 5));
        inputPanel.add(outfitField, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));
        bottomPanel.add(removeButton, BorderLayout.CENTER);

        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(bottomPanel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addOutfit());
        removeButton.addActionListener(e -> removeOutfit());

        setVisible(true);
    }

    private void addOutfit() {
        String outfit = outfitField.getText().trim();
        if (!outfit.isEmpty()) {
            outfitListModel.addElement(outfit);
            outfitField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter an outfit name.");
        }
    }

    private void removeOutfit() {
        int selectedIndex = outfitList.getSelectedIndex();
        if (selectedIndex != -1) {
            outfitListModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select an outfit to remove.");
        }
    }
}
