import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public abstract class AnimatedThing {

    protected double x;
    protected double y;
    protected double vx;
    protected double vy;
    protected double ax;
    protected double ay;
    public ImageView sprite;
    protected int attitude;
    public int i;
    public double duration;
    public final int imax;
    private int width;
    private int height;
    public final int offset;
    private String fileName;
    private Rectangle2D hitbox;


    public AnimatedThing(double x, double y,int attitude, int i,int imax,Duration duration, int width, int height, int offset, String fileName){
        this.x = x;
        this.y = y;
        Image spriteSheet_AT = new Image(fileName+".png");
        this.sprite = new ImageView(spriteSheet_AT);
        this.attitude = attitude;
        this.i = i;
        this.imax = imax;
        this.duration = duration.toSeconds();
        this.width = width;
        this.height = height;
        this.offset = offset;
        this.fileName = fileName;
        sprite.setX(x);
        sprite.setY(y);
        hitbox = new Rectangle2D(x,y,width,height);

    }

    public ImageView getImageView(){return sprite;}
    public double getX() {return x;}
    public double getY() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}


    public void setHitbox(Rectangle2D hitbox) {
        this.hitbox = hitbox;
    }

    public Rectangle2D getHitBox(){
        return hitbox;
    }
}
