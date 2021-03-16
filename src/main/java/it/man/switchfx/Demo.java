package it.man.switchfx;

import it.man.switchfx.constants.SwitchButtonStyle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Demo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        HBox vBox = new HBox();

        SwitchButton switchButton1 = new SwitchButton(SwitchButtonStyle.ANDROID);
        switchButton1.setPadding(new Insets(10));
        SwitchButton switchButton2 = new SwitchButton(SwitchButtonStyle.APPLE);
        switchButton2.setPrefSize(30,20);
        vBox.getChildren().addAll(switchButton1, switchButton2);
        Scene scene = new Scene(vBox);
        stage.setScene(scene);
        stage.show();
    }
}
