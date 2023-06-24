import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

public class TestFrame extends JFrame implements KeyListener {
    private StringBuilder userInput = new StringBuilder();
    private JLabel messageLabel;
    private Timer messageTimer;

    public TestFrame() {
        setTitle("Cheat Code Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                setExtendedState(JFrame.MAXIMIZED_BOTH);
            }
        });

        // Set the preferred size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setPreferredSize(screenSize);
        // Create a label for the message
        messageLabel = new JLabel();
        messageLabel.setFont(new Font("Arial", Font.BOLD, 24));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVisible(false);
        add(messageLabel, BorderLayout.CENTER);

        // Attach the key listener to the JFrame
        addKeyListener(this);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        // Append the character to the user input StringBuilder
        char keyChar = e.getKeyChar();
        userInput.append(keyChar);

        // Check if the user input matches the cheat code
        String cheatCode = "hamed";
        if (userInput.toString().equals(cheatCode)) {
            // Execute the cheat code functionality
            // For example, display a message
            showCheatCodeMessage("Kosmkkkkkkkk");

            // Clear the user input for the next cheat code
            userInput.setLength(0);
        }
        else if (userInput.length() > 6){
            showCheatCodeMessage(userInput.toString());
            userInput.setLength(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Implement if needed
        Hashtable<Character , Character> mapping = new Hashtable<>();

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implement if needed
    }

    private void showCheatCodeMessage(String message) {
        // Stop any ongoing timer
        if (messageTimer != null) {
            messageTimer.cancel();
            messageTimer = null;
        }

        // Update the message label
        messageLabel.setText(message);
        messageLabel.setVisible(true);

        // Start a timer to animate the message
        messageTimer = new Timer();
        messageTimer.scheduleAtFixedRate(new TimerTask() {
            private int counter = 0;

            @Override
            public void run() {
                // Perform transition animation
                if (counter % 2 == 0) {
                    messageLabel.setForeground(Color.RED);
                } else {
                    messageLabel.setForeground(Color.BLACK);
                }
                counter++;

                // Stop the timer after 3 seconds
                if (counter > 6) {
                    cancel();
                    messageLabel.setVisible(false);
                }
            }
        }, 0, 500); // Update every 500 milliseconds
    }

    public static void main(String[] args) {
        TestFrame example = new TestFrame();

        // Configure and display the JFrame
        example.setVisible(true);
    }
}
