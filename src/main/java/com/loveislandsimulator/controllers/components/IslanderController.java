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
    private CheckBox doubleFacedCheckbox;

    @FXML
    private CheckBox flirtCheckbox;

    @FXML
    private CheckBox outsiderCheckbox;

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

        if (outsiderCheckbox.isSelected()) {
            roles.add(Role.OUTSIDER);
        }

        if (doubleFacedCheckbox.isSelected()) {
            roles.add(Role.DOUBLE_FACED);
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

            if (outsiderCheckbox != null) {
                outsiderCheckbox.setSelected(false);
            }

            if (doubleFacedCheckbox != null) {
                doubleFacedCheckbox.setSelected(false);
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

            if (role.equals(Role.OUTSIDER)) {
                outsiderCheckbox.setSelected(true);
            }

            if (role.equals(Role.DOUBLE_FACED)) {
                doubleFacedCheckbox.setSelected(true);
            }

            if (role.equals(Role.FLIRT)) {
                flirtCheckbox.setSelected(true);
            }
        }
    }

    /**
     * Gets the name from the name field.
     */
    public String getName() {
        return nameField.getText();
    }
}
