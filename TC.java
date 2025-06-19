import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TC {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmailScreen());
    }
}

// Email Input Screen
class EmailScreen extends JFrame {
    JTextField emailField;

    public EmailScreen() {
        setTitle("ThermoMate - Welcome");
        setSize(400, 250);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 60));

        JLabel title = new JLabel("🌡️ ThermoMate");
        title.setBounds(100, 20, 300, 40);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));
        title.setForeground(new Color(255, 255, 255));
        add(title);

        JLabel prompt = new JLabel("Enter your email to continue:");
        prompt.setBounds(90, 80, 250, 25);
        prompt.setForeground(Color.WHITE);
        prompt.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(prompt);

        emailField = new JTextField();
        emailField.setBounds(90, 110, 220, 30);
        emailField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        add(emailField);

        JButton proceed = new JButton("Continue");
        proceed.setBounds(140, 160, 120, 30);
        proceed.setBackground(new Color(70, 130, 180));
        proceed.setForeground(Color.WHITE);
        proceed.setFocusPainted(false);
        add(proceed);

        proceed.addActionListener(e -> {
            String email = emailField.getText().trim();
            if (email.isEmpty() || !email.contains("@")) {
                JOptionPane.showMessageDialog(this, "Please enter a valid email.");
            } else {
                this.dispose();
                new TemperatureConverter(email);
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

// Temperature Converter + AI + Logout
class TemperatureConverter extends JFrame {
    JComboBox<String> fromBox, toBox;
    JTextField input, output;
    JButton convertBtn, chatbotBtn, logoutBtn;

    public TemperatureConverter(String userEmail) {
        super("ThermoMate - Temperature Converter");

        String[] units = {"Celsius", "Fahrenheit", "Kelvin", "Rankine", "Reaumur"};
        fromBox = new JComboBox<>(units);
        toBox = new JComboBox<>(units);
        input = new JTextField();
        output = new JTextField();
        convertBtn = new JButton("Convert");
        chatbotBtn = new JButton("🤖 AI Assistant");
        logoutBtn = new JButton("Logout");

        JLabel l1 = new JLabel("From:");
        JLabel l2 = new JLabel("To:");
        JLabel l3 = new JLabel("Input:");
        JLabel l4 = new JLabel("Output:");
        JLabel user = new JLabel("👤 " + userEmail);

        setLayout(null);
        l1.setBounds(30, 30, 50, 20); fromBox.setBounds(90, 30, 100, 20);
        l2.setBounds(210, 30, 50, 20); toBox.setBounds(260, 30, 100, 20);
        l3.setBounds(30, 70, 100, 20); input.setBounds(90, 70, 270, 25);
        l4.setBounds(30, 110, 100, 20); output.setBounds(90, 110, 270, 25);
        convertBtn.setBounds(140, 160, 120, 30);
        chatbotBtn.setBounds(120, 210, 160, 30);
        logoutBtn.setBounds(280, 5, 90, 25);
        user.setBounds(10, 5, 200, 20);

        output.setEditable(false);
        add(l1); add(fromBox); add(l2); add(toBox);
        add(l3); add(input); add(l4); add(output);
        add(convertBtn); add(chatbotBtn); add(logoutBtn); add(user);

        convertBtn.addActionListener(e -> convertTemp());

        chatbotBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, """
                🤖 Hi! I'm your AI Assistant.
                You can:
                • Enter temperature in any unit.
                • Convert it to another instantly.
                • Click Convert to see results.
                • Need help? Contact support@thermomate.ai
                """, "ThermoMate Bot", JOptionPane.INFORMATION_MESSAGE));

        logoutBtn.addActionListener(e -> {
            this.dispose();
            new EmailScreen();
        });

        getContentPane().setBackground(new Color(240, 248, 255));
        convertBtn.setBackground(new Color(0, 123, 255)); convertBtn.setForeground(Color.white);
        chatbotBtn.setBackground(new Color(52, 152, 219)); chatbotBtn.setForeground(Color.white);
        logoutBtn.setBackground(Color.RED); logoutBtn.setForeground(Color.white);

        setSize(400, 320);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void convertTemp() {
        try {
            float value = Float.parseFloat(input.getText());
            String from = (String) fromBox.getSelectedItem();
            String to = (String) toBox.getSelectedItem();
            float result = convert(value, from, to);
            output.setText(String.format("%.2f", result));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number.");
        }
    }

    private float convert(float temp, String from, String to) {
        float c = switch (from) {
            case "Celsius" -> temp;
            case "Fahrenheit" -> (temp - 32) * 5 / 9;
            case "Kelvin" -> temp - 273.15f;
            case "Rankine" -> (temp - 491.67f) * 5 / 9;
            case "Reaumur" -> temp * 1.25f;
            default -> temp;
        };
        return switch (to) {
            case "Celsius" -> c;
            case "Fahrenheit" -> (c * 9 / 5) + 32;
            case "Kelvin" -> c + 273.15f;
            case "Rankine" -> (c + 273.15f) * 9 / 5;
            case "Reaumur" -> c * 0.8f;
            default -> c;
        };
    }
}
