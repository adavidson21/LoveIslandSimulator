package com.loveislandsimulator.controllers.components;

import com.loveislandsimulator.strategies.IslanderBehaviorStrategy;
import com.loveislandsimulator.utilities.Utils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

/**
 * Controller for the New Islander component of the application. This is used when the game is first being initialized.
 * Associated FXML: new-islander-component.fxml
 */
public class NewIslanderController {
    private Image image;

    //#region FXML Properties
    @FXML
    private ComboBox<String> strategyComboBox;

    @FXML
    private ImageView avatarImage;

    @FXML
    private TextField nameField;
    //#endregion

    @FXML
    public void initialize() {
        // Initialize strategies for combobox
        for (IslanderBehaviorStrategy strategy : Utils.getAllStrategies()) {
            strategyComboBox.getItems().add(strategy.getStrategyName());
        }
    }

    /**
     * Populates the avatar image for the islander.
     * @param avatarFileName The avatar file name.
     */
    public void setAvatar(String avatarFileName) {
        String filePath = "/com/loveislandsimulator/images/" + avatarFileName;
        InputStream inputStream = getClass().getResourceAsStream(filePath);

        if(inputStream != null){
            this.image = new Image(inputStream);
            avatarImage.setImage(this.image);
        }
    }

    //#region Getters & Setters
    public TextField getNameField() {
        return nameField;
    }

    public Image getAvatar() {
        return this.image;
    }

    public ComboBox<String> getStrategyComboBox() {
        return strategyComboBox;
    }
    //#endregion
}
