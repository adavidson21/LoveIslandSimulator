package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.observers.ChallengeLogObserver;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import com.loveislandsimulator.utilities.ControllerUtils;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

/**
 * Controller for the Challenge Results screen of the application.
 * Associated FXML: challenge-results.fxml
 */
public class ChallengeResultsController extends BaseController implements ChallengeLogObserver {
    //#region FXML Properties
    @FXML
    private VBox islandersContainer;

    @FXML
    private Text titleText;

    @FXML
    private Button endGameButton;

    @FXML
    private ListView<String> logListView;
    //#endregion

    @FXML
    public void initialize() {
        GameData.getInstance().addObserver(this);
        islandersContainer.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateIslanders();
                        updateChallengeTitle();
                        updateEndGameButton();
                    }
                });
            }
        });
    }

    @Override
    public void onLogUpdated(List<String> logs) {
        logListView.setItems(FXCollections.observableArrayList(logs));
    }

    public void onNextChallengeButtonClick() {
        GameData.getInstance().incrementCompleted();
        switchToView("assign-challenge");
    }

    public void onEndGameButtonClick(){
        switchToView("game-result");
    }

    /**
     * Populates the islanders in the islanders container on page load.
     */
    private void populateIslanders() {
        String path = "/com/loveislandsimulator/components/small-islander-component.fxml";
        List<Islander> islanders = GameData.getInstance().getIslanders();
        ControllerUtils.populateIslanders(islandersContainer, islanders, path, false);
    }

    /**
     * Updates the challenge title with the current challenge count.
     */
    private void updateChallengeTitle() {
        titleText.setText("Love Island Challenge #" + GameData.getInstance().getChallengeCount() + " Results");
    }

    /**
     * Updates the visibility of the "end game" button.
     * The button should only appear if at least 3 challenges have been completed.
     */
    private void updateEndGameButton() {
        endGameButton.setVisible(GameData.getInstance().getChallengeCount() >= 3);
    }
}

