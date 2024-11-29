package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.enums.Role;
import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the individual Islander component. This component is used after the islanders have been initialized.
 * Associated FXML: islander-component.fxml
 */
public class IslanderController {
    //#region FXML Properties
    @FXML
    private Text nameField;

    @FXML
    private Text strategyField;

    @FXML
    private CheckBox leaderCheckbox;

    @FXML
    private CheckBox survivorCheckbox;

    @FXML
    private CheckBox flirtCheckbox;

    @FXML
    private CheckBox rebelCheckbox;

    @FXML
    private Text scoreField;

    @FXML
    private ImageView avatarImage;
 //#endregion

    /**
     * Sets the score field on the UI.
     *
     * @param score The score.
     */
    public void setScore(int score) {
        scoreField.setText(Integer.toString(score));
    }

    /**
     * Sets the name on the UI.
     * @param name The name.
     */
    public void setName(String name) {
        nameField.setText(name);
    }

    /**
     * Sets the strategy field on the UI.
     * @param strategy The islander behavior strategy.
     */
    public void setStrategyField(IslanderBehaviorStrategy strategy) {
        strategyField.setText(strategy.getStrategyName());
    }

    /**
     * Populates the avatar image for the islander.
     * @param avatar The avatar image.
     */
    public void setAvatar(Image avatar) {
        avatarImage.setImage(avatar);
    }

    /**
     * Gets the selected roles for the islander.
     *
     * @return The roles that are selected.
     */
    public List<Role> getRoles() {
        List<Role> roles = new ArrayList<>();

        if (leaderCheckbox.isSelected()) {
            roles.add(Role.LEADER);
        }

        if (rebelCheckbox.isSelected()) {
            roles.add(Role.REBEL);
        }

        if (survivorCheckbox.isSelected()) {
            roles.add(Role.SURVIVOR);
        }

        if (flirtCheckbox.isSelected()) {
            roles.add(Role.FLIRT);
        }

        return roles;
    }

    /**
     * Set the islander's roles in the UI.
     * @param roles The list of roles to set.
     */
    public void setRoles(List<Role> roles) {
        if (roles == null || roles.isEmpty()) {
            if (leaderCheckbox != null) {
                leaderCheckbox.setSelected(false);
            }

            if (rebelCheckbox != null) {
                rebelCheckbox.setSelected(false);
            }

            if (survivorCheckbox != null) {
                survivorCheckbox.setSelected(false);
            }

            if (flirtCheckbox != null) {
                flirtCheckbox.setSelected(false);
            }

            return;
        }

        for (Role role : roles) {
            if (role.equals(Role.LEADER)) {
                leaderCheckbox.setSelected(true);
            }

            if (role.equals(Role.REBEL)) {
                rebelCheckbox.setSelected(true);
            }

            if (role.equals(Role.SURVIVOR)) {
                survivorCheckbox.setSelected(true);
            }

            if (role.equals(Role.FLIRT)) {
                flirtCheckbox.setSelected(true);
            }
        }
    }

    /**
     * Sets whether the checkboxes for roles are editable.
     *
     * @param editable True if the checkboxes should be editable, false otherwise.
     */
    public void setRolesEditable(boolean editable) {
        leaderCheckbox.setDisable(!editable);
        survivorCheckbox.setDisable(!editable);
        rebelCheckbox.setDisable(!editable);
        flirtCheckbox.setDisable(!editable);
    }

    /**
     * Gets the name from the name field.
     */
    public String getName() {
        return nameField.getText();
    }
}
