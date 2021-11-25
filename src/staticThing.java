import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class staticThing {
    static double x = 0;
    static double y = 0;
    private ImageView imageView;

    public staticThing(double x, double y, double camx, double camy, String fileName){
        Image image = new Image(fileName+".png");
        this.imageView = new ImageView(image);
        this.imageView.setX(x);
        this.imageView.setY(y);
        this.x = x;
        this.y = y;

    }

    public ImageView getImageView(){return imageView;}

    public void setX(double x){this.x = x;}
    public double getX(){return this.x;}
}
