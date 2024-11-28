module com.example.loveislandsimulator {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires annotations;

    opens com.loveislandsimulator to javafx.fxml;
    exports com.loveislandsimulator;
    exports com.loveislandsimulator.controllers;
    opens com.loveislandsimulator.controllers to javafx.fxml;
    exports com.loveislandsimulator.controllers.base;
    opens com.loveislandsimulator.controllers.base to javafx.fxml;
    exports com.loveislandsimulator.controllers.components;
    opens com.loveislandsimulator.controllers.components to javafx.fxml;
    exports com.loveislandsimulator.observers;
    opens com.loveislandsimulator.observers to javafx.fxml;
}