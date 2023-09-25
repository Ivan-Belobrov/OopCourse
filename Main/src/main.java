import javax.swing.*;
import java.awt.*;

public class main {
        public static void main(String[] args) {
            JFrame frame = new JFrame("GridBagLayout Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new GridBagLayout());

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;

            JLabel nameLabel = new JLabel("Èìÿ:");
            constraints.gridx = 0;
            constraints.gridy = 0;
            constraints.gridwidth = 1;
            panel.add(nameLabel, constraints);

            JTextField nameTextField = new JTextField(20);
            constraints.gridx = 1;
            constraints.gridy = 0;
            constraints.gridwidth = 2;
            panel.add(nameTextField, constraints);

            JLabel emailLabel = new JLabel("Email:");
            constraints.gridx = 0;
            constraints.gridy = 1;
            constraints.gridwidth = 1;
            panel.add(emailLabel, constraints);

            JTextField emailTextField = new JTextField(20);
            constraints.gridx = 1;
            constraints.gridy = 1;
            constraints.gridwidth = 2;
            panel.add(emailTextField, constraints);

            JButton submitButton = new JButton("Submit");
            constraints.gridx = 1;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            panel.add(submitButton, constraints);

            JButton cancelButton = new JButton("Cancel");
            constraints.gridx = 2;
            constraints.gridy = 2;
            constraints.gridwidth = 1;
            panel.add(cancelButton, constraints);

            frame.add(panel);
            frame.pack();
            frame.setVisible(true);
        }
    }