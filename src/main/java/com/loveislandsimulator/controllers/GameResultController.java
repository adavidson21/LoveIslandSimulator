package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.util.List;

public class GameResultController implements AppController {
    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    private VBox container;

    @FXML
    private Text firstPlace;

    @FXML
    private Text secondPlace;

    @FXML
    private Text thirdPlace;

    @FXML
    public void initialize() {
        container.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateResults();
                    }
                });
            }
        });
    }

    public void onNewGameButtonClick(){
        GameData.getInstance().reset();
        app.getSceneController().switchTo("islander-setup");
    }

    public void onQuitButtonClick(){
        app.getSceneController().switchTo("home");
    }

    private void populateResults() {
        List<Islander> islanders = GameData.getInstance().getIslanders();

        // Order islanders by score in descending order
        islanders = islanders.stream()
                .sorted((i1, i2) -> Integer.compare(i2.getScore(), i1.getScore()))
                .toList();

        Islander first = islanders.get(0);
        Islander second = islanders.get(1);
        Islander third = islanders.get(2);

        firstPlace.setText(first.getName() + " Score: " + first.getScore());
        secondPlace.setText(second.getName() + " Score: " + second.getScore());
        thirdPlace.setText(third.getName() + " Score: " + third.getScore());
    }
}
