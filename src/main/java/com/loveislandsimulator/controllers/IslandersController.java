package com.loveislandsimulator.controllers;

import com.loveislandsimulator.controllers.base.BaseController;
import com.loveislandsimulator.controllers.components.IslanderController;
import com.loveislandsimulator.models.GameData;
import com.loveislandsimulator.models.Islander;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.List;

/**
 * Controller for the Islanders View, which is the scene that is displayed after the islanders are initialized.
 * Associated FXML: islanders-view.fxml
 */
public class IslandersController extends BaseController {
    //#region FXML Properties
    @FXML
    private HBox islandersContainer;
    //#endregion

    @FXML
    public void initialize() {
        islandersContainer.sceneProperty().addListener((observable, oldScene, newScene) -> {
            if (newScene != null) {
                newScene.windowProperty().addListener((winObservable, oldWindow, newWindow) -> {
                    if (newWindow != null) {
                        populateIslanders(); // run method when scene is set (on load)
                    }
                });
            }
        });
    }

    /**
     *  Populates the islanders in pairs in a grid layout.
     */
    private void populateIslanders() {
        List<Islander> islanders = GameData.getInstance().getIslanders();

        if (!islanders.isEmpty()) {
            try {
                GridPane gridPane = new GridPane();
                gridPane.setHgap(20);
                gridPane.setVgap(20);

                // Add 10 components in pairs of 2
                for (int i = 0; i < islanders.size(); i++) {
                    Islander islander = islanders.get(i);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/loveislandsimulator/components/islander-component.fxml"));
                    GridPane islanderComponent = loader.load();

                    // Access the controller to set the avatar
                    IslanderController controller = loader.getController();

                    controller.setAvatar(islander.getAvatar());
                    controller.setName(islander.getName());
                    controller.setStrategyField(islander.getBehaviorStrategy());

                    int row = i / 2;  // Each row has 2 items
                    int col = i % 2;  // Alternates between 0 (left) and 1 (right)

                    gridPane.add(islanderComponent, col, row);
                }

                islandersContainer.getChildren().add(gridPane);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Controls the Continue button on the GUI.
     * Changes the scene to the next scene to assign challenge.
     */
    public void onContinueButtonClick() {
        switchToView("assign-challenge");
    }
}