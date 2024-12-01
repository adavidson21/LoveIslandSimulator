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
 * Associated FXML: islander-component.fxml & small-islander-component.fxml
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

    @FXML
    private Text rolesTitle;
 //#endregion

    //#region Getters and Setters
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

        if (leaderCheckbox != null && leaderCheckbox.isSelected()) {
            roles.add(Role.LEADER);
        }

        if (rebelCheckbox != null && rebelCheckbox.isSelected()) {
            roles.add(Role.REBEL);
        }

        if (survivorCheckbox != null && survivorCheckbox.isSelected()) {
            roles.add(Role.SURVIVOR);
        }

        if (flirtCheckbox != null && flirtCheckbox.isSelected()) {
            roles.add(Role.FLIRT);
        }

        return roles;
    }

    /**
     * Set the islander's roles in the UI.
     * @param roles The list of roles to set.
     */
    public void setRoles(List<Role> roles) {
        resetRoleCheckBoxes();

        if (roles != null) {
            for (Role role : roles) {
                setRoleCheckbox(role, true);
            }
        }
    }

    /**
     * Sets whether the role checkboxes are visible.
     *
     * @param visible True if the checkboxes should be visible, false otherwise.
     */
    public void setRolesVisible(boolean visible) {
        if (leaderCheckbox != null) leaderCheckbox.setVisible(visible);
        if (rebelCheckbox != null) rebelCheckbox.setVisible(visible);
        if (survivorCheckbox != null) survivorCheckbox.setVisible(visible);
        if (flirtCheckbox != null) flirtCheckbox.setVisible(visible);
        if (rolesTitle != null) rolesTitle.setVisible(visible);
    }

    /**
     * Gets the name from the name field.
     */
    public String getName() {
        return nameField.getText();
    }

    //#endregion

    /**
     * Resets all role checkboxes to unselected.
     */
    private void resetRoleCheckBoxes() {
        setRoleCheckbox(Role.LEADER, false);
        setRoleCheckbox(Role.REBEL, false);
        setRoleCheckbox(Role.SURVIVOR, false);
        setRoleCheckbox(Role.FLIRT, false);
    }

    /**
     * Updates a specific checkbox based on the role.
     *
     * @param role     The role.
     * @param selected Whether the checkbox should be selected.
     */
    private void setRoleCheckbox(Role role, boolean selected) {
        switch (role) {
            case LEADER -> {
                if (leaderCheckbox != null) {
                    leaderCheckbox.setSelected(selected);
                }
            }
            case REBEL -> {
                if (rebelCheckbox != null) {
                    rebelCheckbox.setSelected(selected);
                }
            }
            case SURVIVOR -> {
                if (survivorCheckbox != null) {
                    survivorCheckbox.setSelected(selected);
                }
            }
            case FLIRT -> {
                if (flirtCheckbox != null) {
                    flirtCheckbox.setSelected(selected);
                }
            }
        }
    }
}
