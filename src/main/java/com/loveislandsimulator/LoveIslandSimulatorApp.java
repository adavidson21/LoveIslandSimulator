package com.loveislandsimulator;

import com.loveislandsimulator.controllers.base.SceneController;
import com.loveislandsimulator.factories.ChallengeFactory;
import com.loveislandsimulator.models.GameData;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class LoveIslandSimulatorApp extends Application {
    private static final String INITIAL_SCENE = "home";
    private SceneController sceneController;

    @Override
    public void start(Stage primaryStage) throws IOException {
        initializeGameData();
        initializeSceneController(primaryStage);
        sceneController.showInitialScene(INITIAL_SCENE);
    }

    /**
     * Getter for  the scene controller.
     *
     * @return The scene controller.
     */
    public SceneController getSceneController() {
        return sceneController;
    }

    public static void main(String[] args) {
        launch();
    }

    /**
     * Initializes the game data with predefined challenges.
     */
    private void initializeGameData() {
        GameData gameData = GameData.getInstance(); // eager instantiation of singleton
        gameData.addChallenge(ChallengeFactory.createChallenge("physical"));
        gameData.addChallenge(ChallengeFactory.createChallenge("social"));
        gameData.addChallenge(ChallengeFactory.createChallenge("trivia"));
    }

    /**
     * Initializes the scene controller and registers the screens of the application.
     *
     * @param primaryStage The primary stage.
     * @throws IOException If any FXML file fails to load.
     */
    private void initializeSceneController(Stage primaryStage) throws IOException {
        sceneController = new SceneController(primaryStage);
        registerScenes();
    }

    /**
     * Registers all scenes with the SceneController.
     *
     * @throws IOException If any FXML file fails to load.
     */
    private void registerScenes() throws IOException {
        sceneController.addScene("home", "home-view.fxml", this);
        sceneController.addScene("help", "help-view.fxml", this);
        sceneController.addScene("islander-setup", "islander-setup-view.fxml", this);
        sceneController.addScene("islanders-view", "islanders-view.fxml", this);
        sceneController.addScene("assign-challenge", "assign-challenge.fxml", this);
        sceneController.addScene("challenge-results", "challenge-results.fxml", this);
        sceneController.addScene("game-result", "game-result.fxml", this);
        sceneController.addScene("new-islander", "components/new-islander-component.fxml", this);
        sceneController.addScene("islander", "components/islander-component.fxml", this);
    }
}