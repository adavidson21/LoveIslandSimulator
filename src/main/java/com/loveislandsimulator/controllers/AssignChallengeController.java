package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.factories.ChallengeFactory;
import com.loveislandsimulator.models.ChallengeCommand;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.utilities.ChallengeUtils;
import com.loveislandsimulator.utilities.ControllerUtils;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Controller for the Assign Challenge screen of the application.
 * Associated FXML: assign-challenge.fxml
 */
public class AssignChallengeController extends BaseController {
    //#region FXML Properties
    @FXML
    private VBox islandersContainer;

    @FXML
    private ComboBox<String> challengeComboBox;

    @FXML
    private Text selectedChallengeName;

    @FXML
    private Text selectedChallengeDescription;

    @FXML
    private Text titleText;
    //#endregion

    /**
     * Initializes methods on scene load.
     * Initializes the scene listeners and the challenges combo box.
     */
    @FXML
    public void initialize() {
        initializeSceneListeners();
        initializeChallengeComboBox();
    }

    /**
     * Initializes listeners for scene change, and populates islanders and challenge information on load.
     * Allows for methods to be called when the scene is opened (not only on initial load).
     */
    private void initializeSceneListeners() {
        String path = "/com/loveislandsimulator/components/small-islander-component.fxml";

        islandersContainer.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        ControllerUtils.populateIslanders(islandersContainer, GameData.getInstance().getIslanders(), path, true);
                        titleText.setText(ControllerUtils.getChallengeTitle());
                        displaySelectedChallenge();
                    }
                });
            }
        });
    }

    /**
     * Initializes the challenge combo box with available challenges
     * and adds listener to the combobox to listen to changes.
     */
    private void initializeChallengeComboBox() {
        ChallengeFactory.getAvailableChallenges().forEach(challenge -> challengeComboBox.getItems().add(challenge));
        challengeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> updateSelectedChallenge(newVal));
    }

    /**
     * Updates the UI with the details of the selected challenge.
     *
     * @param challengeName The name of the selected challenge.
     */
    private void updateSelectedChallenge(String challengeName) {
        ChallengeCommand selectedChallenge = ChallengeFactory.findChallengeByName(challengeName);
        if (selectedChallenge != null) {
            selectedChallengeName.setText(selectedChallenge.getName());
            selectedChallengeDescription.setText(selectedChallenge.getDescription());
        }
    }

    /**
     * Handles the button click action of the "random" button.
     */
    public void onRandomButtonClick() {
        List<ChallengeCommand> challenges = GameData.getInstance().getChallenges();
        challengeComboBox.setValue(ChallengeUtils.getRandomChallenge(challenges).getName());
    }

    /**
     * Handles the button click action of the "simulate challenge" button.
     * Each islander has the selected roles applied, then participates in the challenge,
     * then the page is navigated to the results screen of that challenge.
     */
    public void onSimulateButtonClick() {
        if (challengeComboBox.getValue() == null) {
            ControllerUtils.showErrorPopup("Field validation failed. Please be sure to select a challenge from the dropdown.");
            return;
        }

        GameData.getInstance().clearChallengeLog(); // clear previous logs
        ChallengeCommand challenge = ChallengeFactory.findChallengeByName(challengeComboBox.getValue()); // get selected challenge
        ChallengeUtils.decorateAndPerformChallenge(islandersContainer, GameData.getInstance().getIslanders(), challenge);
        switchToView("challenge-results");
    }

    /**
     * Displays the selected challenge on the UI.
     * Changes the value of the challenge details whenever the selected ComboBox value changes.
     */
    private void displaySelectedChallenge() {
        challengeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                ChallengeCommand selectedChallenge = ChallengeFactory.findChallengeByName(newVal);

                if (selectedChallenge != null) {
                    selectedChallengeName.setText(selectedChallenge.getName());
                    selectedChallengeDescription.setText(selectedChallenge.getDescription());
                }
            }
        });
    }
}
