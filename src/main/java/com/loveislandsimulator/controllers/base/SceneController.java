package com.loveislandsimulator.controllers.base;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import com.loveislandsimulator.models.AppController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class that manages the scenes of the application.
 */
public class SceneController {
    private final Stage stage;
    private final Map<String, Scene> scenes = new HashMap<>();

    public SceneController(Stage stage) {
        this.stage = stage;
    }

    /**
     * Adds a new scene to the application.
     *
     * @param name The unique name to identify the scene.
     * @param fxmlPath The path to the FXML file that defines the scene view.
     * @param app The main application instance.
     * @throws IOException Throws error if the FXML file cannot be loaded.
     */
    public void addScene(String name, String fxmlPath, LoveIslandSimulatorApp app) throws IOException {
        Scene scene = loadScene(fxmlPath, app);
        scenes.put(name, scene);
    }

    /**
     * Switches to a previously added scene by its name.
     *
     * @param name The unique name of the scene to display.
     */
    public void switchTo(String name) {
        stage.setScene(scenes.get(name));
    }

    /**
     * Shows the initial scene of the application.
     *
     * @param name The name of the scene to display.
     */
    public void showInitialScene(String name) {
        stage.setScene(scenes.get(name));
        stage.setWidth(1024);
        stage.setHeight(768);
        stage.show();
    }

    /**
     * Loads a scene from an FXML file.
     *
     * @param fxmlPath The path to the FXML file.
     * @param app      The main application instance.
     * @return The loaded Scene object.
     * @throws IOException Throws error if the FXML file cannot be loaded.
     */
    private Scene loadScene(String fxmlPath, LoveIslandSimulatorApp app) throws IOException {
        FXMLLoader loader = new FXMLLoader(app.getClass().getResource(fxmlPath));
        Scene scene = new Scene(loader.load(), 1024, 768);

        Object controller = loader.getController();
        if (controller instanceof AppController) {
            ((AppController) controller).setApp(app);
        }

        return scene;
    }
}
