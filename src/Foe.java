import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Random;


public class Foe extends AnimatedThing {

    double x_foe;
    double y_foe;

    public Foe(int x_foe, int y_foe) {
        super(x_foe, y_foe, 0, 1, 2, Duration.millis(10), 10, 0, 40, "foe");
        this.x_foe = x_foe;
        this.y_foe = y_foe;
    }

    int counter = 0;

    public void update(double time) {
        //double x3 = sprite.getX();
        double speed = 5;
        i = (int) ((time % (4 * imax * duration)) / (4 * duration));
        if (i == 0) {
            sprite.setViewport(new Rectangle2D(3 * offset / 5, 0, 75, 50));
            //setHitbox(new Rectangle2D(3 * offset / 5, 0, 75, 50));
        }
        else {
            sprite.setViewport(new Rectangle2D(96, 0, 75, 50));
            //setHitbox(new Rectangle2D(96, 0, 75, 50));
        }
        //if (sprite.getX() < 0) {
            //sprite.setX(800);
            //setHitbox(new Rectangle2D(96, 0, 75, 50));
        sprite.setX(sprite.getX() - speed);
        x_foe = sprite.getX();


            //System.out.println(sprite.getX());

        setHitbox(new Rectangle2D(x_foe + 5, y_foe + 5, 10, 10));

        if (attitude == 1) {
            sprite.setViewport(new Rectangle2D(0, 0, 1, 1));
        }
        //sprite.setViewport(new Rectangle2D(0,0,250,120));
        //    counter +=1;
    }

    /*else{
        sprite.setY(245);
        sprite.setViewport(new Rectangle2D(i*85,0,85,100));
        counter =0;
        GameScene.saut =0;
    }*/
    public static int randBorne(int imin, int imax) {
        Random rand = new Random();
        int borne = imin + rand.nextInt(imax - imin);
        return borne;
    }


}
