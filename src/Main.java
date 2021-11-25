import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Runner de Loïcia");
        Group root = new Group();
        GameScene theScene = new GameScene(root,800,400,true);

        primaryStage.setScene(theScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}