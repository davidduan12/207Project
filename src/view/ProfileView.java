package view;

import data_access.FileUserDataAccessObject;
import data_access.ProfileUserDataAccessObject;
import interface_adapter.LoggedIn.EditProfile.EditProfileController;
import interface_adapter.LoggedIn.EditProfile.EditProfileViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileView extends JPanel {
    private JButton editProfileButton;
    private JTextArea userInfoArea;

    final FileUserDataAccessObject fileUserDataAccessObject;

    final ProfileUserDataAccessObject profileUserDataAccessObject;

    public ProfileView(EditProfileViewModel editProfileViewModel, EditProfileController editProfileController, FileUserDataAccessObject fileUserDataAccessObject, ProfileUserDataAccessObject profileUserDataAccessObject) {
        this.fileUserDataAccessObject = fileUserDataAccessObject;
        this.profileUserDataAccessObject = profileUserDataAccessObject;
        this.setLayout(new BorderLayout());
        userInfoArea = new JTextArea(10, 30);
        userInfoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(userInfoArea);
        this.add(scrollPane, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        editProfileButton = new JButton("Edit Profile");
        editProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEditDialog();
            }
        });
        buttonPanel.add(editProfileButton);
        this.add(buttonPanel, BorderLayout.CENTER);

        displayUserInfo();
    }

    private void displayUserInfo() {

        String userInfo = "Username: " + profileUserDataAccessObject.getUsername() + "\n"
                + "Height: " + fileUserDataAccessObject.getHeight(profileUserDataAccessObject.getUsername()) + "cm \n"
                + "Weight: "+ fileUserDataAccessObject.getWeight(profileUserDataAccessObject.getUsername()) + "kg \n"
                + "Food Intake History:" + fileUserDataAccessObject.getFoodHistory(profileUserDataAccessObject.getUsername()) + "\n"
                + "Exercise History:" + fileUserDataAccessObject.getExerciseHistory(profileUserDataAccessObject.getUsername()) + "\n"
                ;
        userInfoArea.setText(userInfo);
    }


    private void showEditDialog() {
        JDialog editDialog = new JDialog();
        editDialog.setTitle("Edit Profile");
        editDialog.setSize(300, 200);

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Weight:"));
        JTextField weightField = new JTextField();
        panel.add(weightField);

        panel.add(new JLabel("Height:"));
        JTextField heightField = new JTextField();
        panel.add(heightField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String weight = weightField.getText();
                String height = heightField.getText();
                String password = new String(passwordField.getPassword());
                editDialog.dispose();
            }
        });

        editDialog.add(panel, BorderLayout.CENTER);
        editDialog.add(saveButton, BorderLayout.SOUTH);

        editDialog.setVisible(true);
    }

}
