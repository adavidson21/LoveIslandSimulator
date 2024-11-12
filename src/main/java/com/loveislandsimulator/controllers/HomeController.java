package com.loveislandsimulator.controllers;

import com.loveislandsimulator.LoveIslandSimulatorApp;
import javafx.fxml.FXML;

public class HomeController {

    private LoveIslandSimulatorApp app;

    public void setApp(LoveIslandSimulatorApp app) {
        this.app = app;
    }

    @FXML
    protected void onStartButtonClick() {
        if (app != null) {
            app.showGameScene();
        }
    }

    @FXML
    protected void onHelpButtonClick() {
        if (app != null) {
            app.showHelpScene();
        }
    }
}
