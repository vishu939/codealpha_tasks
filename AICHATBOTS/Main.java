import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public Main() {

        // Window settings
        setTitle("AI Chatbot - Java");
        setSize(700, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Title
        JLabel title = new JLabel("🤖 AI Chatbot", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(new Color(30, 80, 160));

        panel.add(title, BorderLayout.NORTH);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setBackground(new Color(245, 247, 250));

        JScrollPane scrollPane = new JScrollPane(chatArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 15));

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        panel.add(bottomPanel, BorderLayout.SOUTH);

        add(panel);

        // Welcome message
        addMessage("Bot",
                "Hello! 👋 I am JavaBot. Ask me about Java, AI, NLP, " +
                "the project, date or time.");

        // Send button
        sendButton.addActionListener(e -> sendMessage());

        // Enter key
        inputField.addActionListener(e -> sendMessage());
    }

    // Send user message
    private void sendMessage() {

        String userMessage = inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        addMessage("You", userMessage);

        String response = getBotResponse(userMessage);

        addMessage("Bot", response);

        inputField.setText("");
        inputField.requestFocus();
    }

    // AI chatbot logic
    private String getBotResponse(String message) {

        String text = message.toLowerCase().trim();

        // Greetings
        if (text.contains("hello") ||
            text.equals("hi") ||
            text.contains("hey")) {

            return "Hello! 😊 How can I help you?";
        }

        // Name
        if (text.contains("your name") ||
            text.contains("who are you")) {

            return "My name is JavaBot. I am a Java-based AI chatbot.";
        }

        // How are you
        if (text.contains("how are you")) {

            return "I am doing great! 🤖 Thanks for asking.";
        }

        // Java
        if (text.contains("java")) {

            return "Java is a popular object-oriented programming language. " +
                   "It is used for desktop, web, mobile and enterprise applications.";
        }

        // Artificial Intelligence
        if (text.contains("artificial intelligence") ||
            text.equals("ai") ||
            text.contains("what is ai")) {

            return "Artificial Intelligence (AI) is a technology that allows " +
                   "computers to perform tasks that normally require human intelligence.";
        }

        // NLP
        if (text.contains("nlp") ||
            text.contains("natural language processing")) {

            return "NLP stands for Natural Language Processing. " +
                   "It helps computers understand and process human language.";
        }

        // Project
        if (text.contains("project") ||
            text.contains("chatbot")) {

            return "This project is a Java-based AI chatbot. " +
                   "It uses NLP-style text processing and rule-based responses " +
                   "with a graphical user interface.";
        }

        // Time
        if (text.contains("time")) {

            LocalTime time = LocalTime.now();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("hh:mm:ss a");

            return "The current time is " + time.format(formatter);
        }

        // Date
        if (text.contains("date") ||
            text.contains("today")) {

            LocalDate date = LocalDate.now();

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd MMMM yyyy");

            return "Today's date is " + date.format(formatter);
        }

        // Thanks
        if (text.contains("thank")) {

            return "You're welcome! 😊";
        }

        // Goodbye
        if (text.contains("bye") ||
            text.contains("goodbye") ||
            text.contains("exit")) {

            return "Goodbye! 👋 Have a great day!";
        }

        // Help
        if (text.contains("help")) {

            return "You can ask me questions like:\n" +
                   "• What is Java?\n" +
                   "• What is AI?\n" +
                   "• What is NLP?\n" +
                   "• What is your name?\n" +
                   "• What is the time?\n" +
                   "• What is today's date?";
        }

        // Unknown question
        return "Sorry, I don't understand that yet. 🤔\n" +
               "Try asking me about Java, AI, NLP, the project, date or time.";
    }

    // Display messages
    private void addMessage(String sender, String message) {

        chatArea.append(sender + ": " + message + "\n\n");

        chatArea.setCaretPosition(
                chatArea.getDocument().getLength()
        );
    }

    // Program starts here
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Main chatbot = new Main();

            chatbot.setVisible(true);
        });
    }
}