package notepad;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = new FXMLLoader(new File("src/notepad/Main.fxml").toURI().toURL()).load();
        Scene scene = new Scene(root);
        stage.setTitle("Notepad--");
        Image icon = new Image(new File("src/notepad/icon.png").toURI().toString());
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.show();
    }
    
}
