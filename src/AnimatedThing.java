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
        //sprite.setViewport(new Rectangle2D(85*this.i,0,85,100));
        hitbox = new Rectangle2D(x,y,width,height);

    }

    public ImageView getImageView(){return sprite;}
    public double getX() {return x;}
    public double getY() {return y;}
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}

/*    int counter = 0;
    public void update(double time){
        double x3 = sprite.getX();
        i = (int) ((time%(4*imax*duration))/(4*duration));
        if(GameScene.saut == 1 & counter<70){

            sprite.setViewport(new Rectangle2D(0,163,85,100));
            counter +=1;
        }
        else{
            sprite.setY(245);
            sprite.setViewport(new Rectangle2D(i*85,0,85,100));
            counter =0;
            GameScene.saut =0;
        }*/

        //int index = 0;
        /*if(index == imax) {
            index = 1;
        }
        else {
            index++;
        }*/
        //int indexmax = (int) ((time%(i*duration))/duration);

        //sprite.setX((x3+2)%800);
        //sprite.setY(245);


            //sprite.setX(sprite.getX()+85);
        //this.sprite.setViewport(new Rectangle2D( time%(i*85*duration)%510/duration, 0, 85, 100));
        //sprite.setX(100);
        //sprite.setY(245);
            //this.x = sprite.getX();

        // code qui marche mais présente que les 3 positions du personnage pour i = 3 dans la création du héro)

        /*final int indexmax = (int) ((time%(imax*duration))/duration);
        sprite.setX(100);
        sprite.setY(245);
        sprite.setViewport(new Rectangle2D((indexmax%imax)*85, 0, 85, 100));
*/


    /*public void jump(int saut){
        if(saut == 1) {
            sprite.setY(sprite.getY() - 125);
            //y=y-125;
        }
        else{
            sprite.setY(245);
        }
        //sprite.setViewport(new Rectangle2D(0, 100, 85, 100))
    }
*/
    public void setHitbox(Rectangle2D hitbox) {
        this.hitbox = hitbox;
    }

    public Rectangle2D getHitBox(){
        return hitbox;
    }
}
