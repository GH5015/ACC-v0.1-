package javaapplication2;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.*;


public class JavaApplication2 {
    public static void main(String[] args) {
        // Create a login frame
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
    }
}

class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginFrame() {
        setTitle("Atacadinho");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        JLabel usernameLabel = new JLabel("Usuário:");
        JLabel passwordLabel = new JLabel("Senha:");
        usernameField = new JTextField(15);
        passwordField = new JPasswordField(15);
        JButton loginButton = new JButton("ENTRAR");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                if (isValidUser(username, password)) {
                    openManagementWindow();
                    dispose(); // Close login window
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(loginButton);
        add(panel, BorderLayout.CENTER);
    }

    // Method to check if the username and password are valid
    private boolean isValidUser(String username, String password) {
        // Add code to check if the username and password are valid
        return true; // For demonstration purposes only
    }

    // Method to open the management window
    private void openManagementWindow() {
        ManagementWindow managementWindow = new ManagementWindow();
        managementWindow.setVisible(true);
    }
}

class ManagementWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public ManagementWindow() {
        setTitle("Atacadinho");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("ATACADINHO");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setBounds(0, 10, 800, 20);
        panel.add(label);

        JButton depositButton = new JButton("ESTOQUE");
        depositButton.setBounds(100, 100, 200, 50);
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDepositWindow();
            }
        });
        panel.add(depositButton);

        JButton sellButton = new JButton("VENDER");
        sellButton.setBounds(500, 100, 200, 50);
        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openSellWindow();
            }
        });
        panel.add(sellButton);

        add(panel, BorderLayout.CENTER);
    }

    // Method to open the product deposit window
    private void openDepositWindow() {
        DepositWindow depositWindow = new DepositWindow();
        depositWindow.setVisible(true);
    }

    // Method to open the sell window
    private void openSellWindow() {
        SellWindow sellWindow = new SellWindow();
        sellWindow.setVisible(true);
    }
}

class DepositWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField productNameField;
    private JTextField quantityField;
    private JTextField buyPriceField;
    private JTextField sellPriceField;
    private JTextArea logTextArea;

    public DepositWindow() {
        setTitle("Product Deposit");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JLabel productNameLabel = new JLabel("Product Name:");
        productNameField = new JTextField(20);
        topPanel.add(productNameLabel);
        topPanel.add(productNameField);

        JLabel quantityLabel = new JLabel("Quantity:");
        quantityField = new JTextField(5);
        topPanel.add(quantityLabel);
        topPanel.add(quantityField);

        JLabel buyPriceLabel = new JLabel("Buy Price:");
        buyPriceField = new JTextField(10);
        topPanel.add(buyPriceLabel);
        topPanel.add(buyPriceField);

        JLabel sellPriceLabel = new JLabel("Sell Price:");
        sellPriceField = new JTextField(10);
        topPanel.add(sellPriceLabel);
        topPanel.add(sellPriceField);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                depositProduct();
            }
        });
        topPanel.add(depositButton);

        add(topPanel, BorderLayout.NORTH);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(logTextArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void depositProduct() {
        String productName = productNameField.getText();
        String quantityText = quantityField.getText();
        String buyPriceText = buyPriceField.getText();
        String sellPriceText = sellPriceField.getText();

        if (productName.isEmpty() || quantityText.isEmpty() || buyPriceText.isEmpty() || sellPriceText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter all fields.");
            return;
        }

        int quantity, buyPrice, sellPrice;
        try {
            quantity = Integer.parseInt(quantityText);
            buyPrice = Integer.parseInt(buyPriceText);
            sellPrice = Integer.parseInt(sellPriceText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid numbers.");
            return;
        }

        // Perform the product deposit logic here
        // You can add your own code to handle the deposit process and update the inventory
        // You can also perform additional calculations or validations based on the buy and sell prices

        // For demonstration purposes, let's just log the deposit information
        logTextArea.append("Product Name: " + productName + ", Quantity: " + quantity +
                ", Buy Price: " + buyPrice + ", Sell Price: " + sellPrice + "\n");
        clearFields();
    }

    private void clearFields() {
        productNameField.setText("");
        quantityField.setText("");
        buyPriceField.setText("");
        sellPriceField.setText("");
    }

}

class SellWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    public SellWindow() {
        setTitle("Sell");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
    }
}

