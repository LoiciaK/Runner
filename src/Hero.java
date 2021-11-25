import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Hero extends AnimatedThing {


    double invincibility = 0;

    public Hero(double x, double y,int attitude) {
        super(x, y, attitude, 1, 6,Duration.millis(10), 10, 0, 0, "heros");
        this.attitude = attitude;
        this.x=x;
        this.y=y;


    }

    int counter = 0;

    public void update(double Temps,double Temps2, double v) {
        double x3 = sprite.getX();
        i = (int) ((Temps % (4 * imax * duration)) / (4 * duration));
        vy = v;
        System.out.println(invincibility);
        //invincibility-=Temps2;
        if (this.attitude == 1) {
        //if(GameScene.saut == 1 && y>160 ){
            if(y>120){
                System.out.println("Jump up");
                sprite.setViewport(new Rectangle2D(0, 163, 85, 100));
                //counter += 1;
                ay = -9.81;
                vy=vy+ay*Temps2*Math.pow(10,-0.9);
                y=y-vy*Temps2*Math.pow(10,-0.9);
                System.out.println(vy+","+y);
                sprite.setY(y);
                //setHitbox(new Rectangle2D(0, 163, 85, 100));
            }
            else{attitude=2;}
        }
        //else if(GameScene.saut==1 && y<160 ){
        if(attitude==2){
            if(y<245){
                sprite.setViewport(new Rectangle2D(85, 163, 85, 100));
                ay = -9.81;
                vy=vy+ay*Temps2*Math.pow(10,-0.7);
                y=y+vy*Temps2*Math.pow(10,-0.7);
                sprite.setY(y);
                //setHitbox(new Rectangle2D(85, 163, 85, 100));
                //System.out.println(vy+","+y);
            }
            else{attitude=0;}
        }
        //if(this.attitude == 2){
        //    sprite.setViewport(new Rectangle2D(85,163,85,100));
        //}
        if(attitude==0){
            if(invincibility>0) {
                invincibility -= Temps2;
            }
            else{invincibility=0;}

            sprite.setY(245);
            sprite.setViewport(new Rectangle2D(i * 85, 0, 85, 100));
            counter = 0;
            GameScene.saut = 0;
            //setHitbox(new Rectangle2D(i * 85, 0, 85, 100));
        }

        if(attitude==4){
            sprite.setViewport(new Rectangle2D(150,150,10,10));
        }



        setHitbox(new Rectangle2D(x,y+4,65,95));
    }

    public void setInvincibility(double invincibility) {
        this.invincibility = invincibility;
    }


    public double getInvincibility() {
        return invincibility;
    }

}