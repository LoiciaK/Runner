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
        //Pane pane = new Pane(root);
        GameScene theScene = new GameScene(root,800,400,true);

        //pane.getChildren().add(theScene.getLeft().getImageView());
        //pane.getChildren().add(theScene.getRight().getImageView());
        //pane.getChildren().add(theScene.getHero().getImageView());
        //pane.getChildren().add(theScene.getHeart1().getImageView());
        //pane.getChildren().add(theScene.getHeart2().getImageView());
        //pane.getChildren().add(theScene.getHeart3().getImageView());
        //pane.getChildren().add(theScene.getHeart().getImageView());
        //pane.getChildren().add(theScene.getFoe().getImageView());

        primaryStage.setScene(theScene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}