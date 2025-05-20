import java.awt.*;
import java.util.Random;
import javax.swing.*;

public class RecommendationCenter extends JFrame {
    private String username;
    private JTextArea outputArea;
    private JButton recommendButton;

    private String[] books = {
        "The Alchemist", "To Kill a Mockingbird", "1984", "The Great Gatsby", "Harry Potter"
    };
    private String[] movies = {
        "Inception", "The Shawshank Redemption", "Interstellar", "The Godfather", "Spirited Away"
    };

    public RecommendationCenter(String username) {
        this.username = username;
        setTitle("Book/Movie Recommendation - " + username);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        recommendButton = new JButton("Get Recommendation");

        add(scrollPane, BorderLayout.CENTER);
        add(recommendButton, BorderLayout.SOUTH);

        recommendButton.addActionListener(e -> recommend());

        setVisible(true);
    }

    private void recommend() {
        Random random = new Random();
        String book = books[random.nextInt(books.length)];
        String movie = movies[random.nextInt(movies.length)];

        outputArea.setText("📚 Book Recommendation:\n" + book + "\n\n🎬 Movie Recommendation:\n" + movie);
    }
}
