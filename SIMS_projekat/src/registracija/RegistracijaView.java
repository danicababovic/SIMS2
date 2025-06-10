package registracija;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RegistracijaView extends JFrame {
    public JTextField imeIPrezimeField = new JTextField(20);
    public JTextField emailField = new JTextField(20);
    public JPasswordField passwordField = new JPasswordField(20);
    public JButton registerButton = new JButton("Registruj se");
    public JButton showUsersButton = new JButton("Prikaži sve korisnike");
    public JButton deleteUserButton = new JButton("Izbriši korisnika");
    public JTextField deleteEmailField = new JTextField(20);
    public JTextArea userListArea = new JTextArea(10, 30);
    public JLabel statusLabel = new JLabel("");

    public RegistracijaView() {
        setTitle("Registracija članova teretane");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

        inputPanel.add(new JLabel("Ime i prezime:"));
        inputPanel.add(imeIPrezimeField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Password:"));
        inputPanel.add(passwordField);
        inputPanel.add(registerButton);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(showUsersButton);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(new JLabel("Email koji želite da izbrišete:"));
        inputPanel.add(deleteEmailField);
        inputPanel.add(deleteUserButton);
        inputPanel.add(Box.createVerticalStrut(10));
        inputPanel.add(statusLabel);

        userListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userListArea);

        getContentPane().add(inputPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
    }

    public void prikaziPoruku(String message) {
        statusLabel.setText(message);
    }

    public void prikaziListuKorisnika(String usersText) {
        userListArea.setText(usersText);
    }
}