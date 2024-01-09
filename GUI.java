import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private CyclistManager playerManager;
    private RaceOfficialsManager moderatorManager;
    private ReportGenerator reportGenerator;

    private JTextField playerNameField;
    private JTextField playerEmailField;
    private JTextField playerDOBField;
    private JComboBox<String> categoryComboBox;

    private JTextField moderatorUsernameField;
    private JPasswordField moderatorPasswordField;
    private JTextField playerIDField;
    private JTextField FinishTimeField;
    private JTextField SprintPointsField;
    private JTextField StageRankingsField;
    private JTextField PenaltiesField;

    private JTextField reportsPlayerIDField;

    private boolean isModeratorLoggedIn = false;

    public GUI() {
        this.frame = new JFrame("Cyclist Race Competitor Management System");
        this.tabbedPane = new JTabbedPane();
        this.playerManager = new CyclistManager();
        this.moderatorManager = new RaceOfficialsManager();
        this.reportGenerator = new ReportGenerator();

        initializeGUI();
    }

    private void initializeGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        createPlayerRegistrationTab();
        createModeratorTab();
        createReportsTab();

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }

    private void createPlayerRegistrationTab() {
        JPanel playerRegistrationPanel = new JPanel();
        playerRegistrationPanel.setLayout(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        playerNameField = new JTextField();
        JLabel emailLabel = new JLabel("Email:");
        playerEmailField = new JTextField();
        JLabel dobLabel = new JLabel("Date of Birth:");
        playerDOBField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");

        String[] categories = {"Cyclocross", "Uphill Race", "Gravel Racing"};
        categoryComboBox = new JComboBox<>(categories);

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerPlayer();
            }
        });

        playerRegistrationPanel.add(nameLabel);
        playerRegistrationPanel.add(playerNameField);
        playerRegistrationPanel.add(emailLabel);
        playerRegistrationPanel.add(playerEmailField);
        playerRegistrationPanel.add(dobLabel);
        playerRegistrationPanel.add(playerDOBField);
        playerRegistrationPanel.add(categoryLabel);
        playerRegistrationPanel.add(categoryComboBox);
        playerRegistrationPanel.add(registerButton);

        tabbedPane.addTab("Player Registration", playerRegistrationPanel);
    }

    private void createModeratorTab() {
        JPanel moderatorPanel = new JPanel();
        moderatorPanel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username:");
        moderatorUsernameField = new JTextField();
        JLabel passwordLabel = new JLabel("Password:");
        moderatorPasswordField = new JPasswordField();
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginModerator();
            }
        });

        JLabel playerIDLabel = new JLabel("Player ID:");
        playerIDField = new JTextField();
        JLabel FinishTimeLabel = new JLabel("FinishTime:");
        FinishTimeField = new JTextField();
        JLabel SprintPointsLabel = new JLabel("SprintPoints:");
        SprintPointsField = new JTextField();
        JLabel StageRankingsLabel = new JLabel("StageRankings:");
        StageRankingsField = new JTextField();
        JLabel PenaltiesLabel = new JLabel("Penalties:");
        PenaltiesField = new JTextField();
        JButton submitScoreButton = new JButton("Submit Score");
        submitScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                submitScore();
            }
        });

        moderatorPanel.add(usernameLabel);
        moderatorPanel.add(moderatorUsernameField);
        moderatorPanel.add(passwordLabel);
        moderatorPanel.add(moderatorPasswordField);
        moderatorPanel.add(loginButton);
        moderatorPanel.add(playerIDLabel);
        moderatorPanel.add(playerIDField);
        moderatorPanel.add(FinishTimeLabel);
        moderatorPanel.add(FinishTimeField);
        moderatorPanel.add(SprintPointsLabel);
        moderatorPanel.add(SprintPointsField);
        moderatorPanel.add(StageRankingsLabel);
        moderatorPanel.add(StageRankingsField);
        moderatorPanel.add(PenaltiesLabel);
        moderatorPanel.add(PenaltiesField);
        moderatorPanel.add(submitScoreButton);

        tabbedPane.addTab("Moderator", moderatorPanel);
    }

    private void createReportsTab() {
        JPanel reportsPanel = new JPanel();
        reportsPanel.setLayout(new GridLayout(2, 2));

        JLabel playerIDLabel = new JLabel("Player ID:");
        reportsPlayerIDField = new JTextField();
        JButton averageScoreButton = new JButton("Generate Average Score Report");
        averageScoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateAverageScoreReport();
            }
        });

        JButton fullReportButton = new JButton("Generate Full Report");
        fullReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateFullReport();
            }
        });

        reportsPanel.add(playerIDLabel);
        reportsPanel.add(reportsPlayerIDField);
        reportsPanel.add(averageScoreButton);
        reportsPanel.add(fullReportButton);

        tabbedPane.addTab("Reports", reportsPanel);
    }

    private void registerPlayer() {
        try {
            String name = playerNameField.getText();
            String email = playerEmailField.getText();
            String dob = playerDOBField.getText();
            String category = (String) categoryComboBox.getSelectedItem();

            playerManager.registerPlayer(name, email, dob, category);
            JOptionPane.showMessageDialog(frame, "Player registered successfully!");
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error registering player: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loginModerator() {
        try {
            String username = moderatorUsernameField.getText();
            char[] passwordChars = moderatorPasswordField.getPassword();
            String password = new String(passwordChars);

            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException("Username and Password are required fields.");
            }

            if (moderatorManager.login(username, password)) {
                JOptionPane.showMessageDialog(frame, "Moderator login successful");
                isModeratorLoggedIn = true;
            } else {
                JOptionPane.showMessageDialog(frame, "Moderator login failed");
            }

            moderatorUsernameField.setText("");
            moderatorPasswordField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error logging in: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void submitScore() {
        try {
            if (!isModeratorLoggedIn) {
                throw new IllegalStateException("Moderator must log in before submitting scores.");
            }

            int playerID = Integer.parseInt(playerIDField.getText());
            int FinishTime = Integer.parseInt(FinishTimeField.getText());
            int SprintPoints = Integer.parseInt(SprintPointsField.getText());
            int StageRankings = Integer.parseInt(StageRankingsField.getText());
            int Penalties = Integer.parseInt(PenaltiesField.getText());

            if (FinishTime < 0 || SprintPoints < 0 || StageRankings < 0 || Penalties < 0) {
                throw new IllegalArgumentException("Scores cannot be negative.");
            }

            moderatorManager.inputScores(playerID, FinishTime, SprintPoints, StageRankings, Penalties);
            JOptionPane.showMessageDialog(frame, "Score submitted successfully!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            JOptionPane.showMessageDialog(frame, "Error submitting score: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateAverageScoreReport() throws NumberFormatException {
        try {
            int playerID = Integer.parseInt(reportsPlayerIDField.getText());
            String report = reportGenerator.generateAverageScoreReport(playerID);
            JOptionPane.showMessageDialog(frame, report);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error generating average score report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void generateFullReport() throws NumberFormatException {
        try {
            int playerID = Integer.parseInt(reportsPlayerIDField.getText());
            String report = reportGenerator.generateFullReport(playerID);
            JOptionPane.showMessageDialog(frame, report);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(frame, "Error generating full report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GUI());
    }
}
