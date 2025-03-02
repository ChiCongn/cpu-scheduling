package scheduling.utilities;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.stage.Stage;
import scheduling.Simulator;

import java.io.IOException;

public class SceneManager {

    public static final String FCFS_PATH = "/scheduling/fxml/fcfs.fxml";
    public static final String PREEMPTIVE_SJF = "/scheduling/fxml/preemptive-sjf.fxml";
    public static final String NON_PREEMPTIVE_SJF = "/scheduling/fxml/nonpreemptive-sjf.fxml";
    public static final String ROUND_ROBIN = "/scheduling/fxml/round-robin.fxml";
    public static final String PREEMPTIVE_PRIORITY = "";
    public static final String NON_PREEMPTIVE_PRIORITY = "";
    public static final String MULTILEVEL_QUEUE = "";
    public static final String MULTILEVEL_FEEDBACK_QUEUE = "";
    public static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        SceneManager.primaryStage = primaryStage;
    }

    public static <Controller> Controller switchScene(String fxmlFilePath) {
        try {
            FXMLLoader loader = new FXMLLoader(Simulator.class.getResource(fxmlFilePath));
            Parent root = loader.load();

            Scene newScene = new Scene(root);
            primaryStage.setScene(newScene);
            primaryStage.show();

            return loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
