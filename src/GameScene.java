import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.geometry.Rectangle2D;

import java.util.ArrayList;

public class GameScene extends Scene {

    private static staticThing right;
    private static staticThing left;
    private static staticThing gameOver;
    private static Group group;

    private static int numberOfLives = 3;
    //private static staticThing heart1;
    //private static staticThing heart2;
    //private static staticThing heart3;
    //private static staticThing[] hearts;
    public static ArrayList<staticThing> hearts = new ArrayList();
    private Camera cam;
    private static Hero hero;
    private static ArrayList<Foe> foes = new ArrayList();
    //private static Foe foe;
    public static int saut;


    public GameScene(Group group, double width, double height, boolean b) {
        super(group, width, height, b);
        this.group = group;
        this.cam = new Camera(width, height);
        //Image heroSheet = new Image("C:\\_Travail\\2021_2022\\INFORMATIQUE\\Java\\Runner\\heros.png");
        //ImageView sprite = new ImageView(spriteSheet);
        //ImageView hero = new ImageView(heroSheet);
        //this.right = new staticThing(800,0,"C:\\_Travail\\2021_2022\\INFORMATIQUE\\Java\\Runner\\desert.png");
        this.right = new staticThing(800, 0, cam.getX(), cam.getY(), "desert");
        this.left = new staticThing(0, 0, cam.getX(), cam.getY(), "desert");
        this.gameOver = new staticThing(800, 0, cam.getX(), cam.getY(), "GameOver3");


        this.hero = new Hero(100, 245,0);

        for( int i=0; i<150;i++){
            Foe foe = new Foe(Foe.randBorne(0,500)+(i+1)*600,265+Foe.randBorne(-20,50));
            foes.add(foe);
        }
        //this.foe = new Foe(650, 265);


        /*this.heart1 = new staticThing(10,10, cam.getX(), cam.getY(),"heart");
        this.heart2 = new staticThing(60,10,cam.getX(),cam.getY(),"heart");
        this.heart3 = new staticThing(110,10,cam.getX(),cam.getY(),"heart");
        hearts.add(heart1);
        hearts.add(heart2);
        hearts.add(heart3);
        heart1.getImageView().setViewport(new Rectangle2D(170,10,50,50));
        heart2.getImageView().setViewport(new Rectangle2D(170,10,50,50));
        heart3.getImageView().setViewport(new Rectangle2D(170,10,50,50));*/

        for (int i = 0; i < numberOfLives; i++) {
            staticThing heart = new staticThing(i * 50 + 10, 10, cam.getX(), cam.getY(), "heart");
            hearts.add(heart);
            heart.getImageView().setViewport(new Rectangle2D(170, 10, 50, 50));
        }

        this.setOnMouseClicked((event) -> {
            System.out.println("Jump");
            //saut = 1;
            hero.attitude=1;
            //hero.setY(hero.getY()-125);
            //hero.jump(saut);
        });

        //this.hero = new Hero();
        //this.hero = new AnimatedThing(10,10,hero,1,1,1,6,1,0);
        //sprite.setViewport(new Rectangle2D(10,10,10,10));
        //hero.setViewport(new Rectangle2D(10,10,10,10));
        //hero.setX(100);
        //hero.setY(100);

        /*for(int i = 0; i<numberOfLives-1; i++){
            this.heart = new staticThing(10+i*50,10,cam.getX(), cam.getY(), "heart");
            heart.getImageView().setViewport(new Rectangle2D(170,10,50,50));
        }*/

        group.getChildren().add(left.getImageView());
        group.getChildren().add(right.getImageView());
        group.getChildren().add(hero.getImageView());
        for( Foe foe : foes){
            group.getChildren().add(foe.getImageView());
        }
        for (staticThing heart : hearts) {
            group.getChildren().add(heart.getImageView());
        }
        group.getChildren().add(gameOver.getImageView());

        final long startTime = System.nanoTime();

        AnimationTimer timer = new AnimationTimer() {
            private double lastupdate=0;
            @Override
            public void handle(long time) {
                double Temps = (time - startTime) / 100000000;
                double Temps2 = (time - lastupdate)/100000000;

                //System.out.println((time-startTime)/1000000000);
                hero.update(Temps,Temps2,200);
                for(Foe foe : foes){
                    foe.update(Temps);
                }
                cam.update(Temps, hero);
                GameScene.update(Temps);
                lastupdate = time ;
                //System.out.println(Temps2);
            }
        };

        timer.start();

    }

    /*    public void lives(Pane pane){
            for(int i = 0; i<numberOfLives;i++){
                this.heart = new staticThing(10,10,"heart");
                pane.getChildren().add(heart.getImageView());
            }
        }
    */
    public void setRight(staticThing right) {
        this.right = right;
    }

    public void setLeft(staticThing left) {
        this.left = left;
    }

    public staticThing getRight() {
        return right;
    }

    public staticThing getLeft() {
        return left;
    }

    public Hero getHero() {
        return hero;
    }

    //public staticThing getHeart1() {return heart1;}
    //public staticThing getHeart2() {return heart2;}
    //public staticThing getHeart3() {return heart3;}
    public staticThing getHeart() {
        for (staticThing heart : hearts) {
            return heart;
        }
        return null;
    }

    //public Foe getFoe() {
        //return foe;
    //}

    public static void update(double time) {
        double speed = 7;
        double x1 = left.getX();
        double x2 = x1 + 800;
        if (x2 > 15) {
            right.getImageView().setX(x2 - speed);
            right.setX(x2 - speed);
            left.getImageView().setX(x1 - speed);
            left.setX(x1 - speed);
        } else {
            right.getImageView().setX(800);
            right.setX(800);
            left.getImageView().setX(0);
            left.setX(0);
        }
        //System.out.println(hero.getHitBox());
        //System.out.println(right.getX());
        //System.out.println(hero.getX()+","+hero.getY()+","+foe.x_foe+","+foe.y_foe);
        //System.out.println(numberOfLives);
        //if(numberOfLives>0){
            //if((hero.getX()==foe.x_foe-50)||hero.getY()+100<foe.y_foe){
        for(Foe foe:foes){
            if(hero.getHitBox().intersects(foe.getHitBox())&&numberOfLives>0&&hero.getInvincibility()==0){
                System.out.println("Collision");
                hero.setInvincibility(10);
                //hero.attitude=4;
                numberOfLives-=1;
                hearts.get(numberOfLives).getImageView().setViewport(new Rectangle2D(10, 10, 50, 50));
            }
        }

        if(numberOfLives==0){
            for( staticThing heart : hearts){
                heart.getImageView().setViewport(new Rectangle2D(0,0,1,1));
            }
            System.out.println("GAMEOVER");
            hero.attitude=4;
            for( Foe foe :foes){
                foe.attitude=1;
            }
            gameOver.getImageView().setViewport(new Rectangle2D (0,0,800,400));
            gameOver.getImageView().setX(58);
            gameOver.getImageView().setY(20);
            System.out.println(gameOver.getX());
            //group.getChildren().add(gameOver.getImageView());
            }

        //}
        //else group.getChildren().addAll(GameOver.gameOver.getImageView());


        /*if (hero.getHitBox().intersects(foe.getHitBox()) && numberOfLives > 0) {
            numberOfLives -= 1;
            //hearts.remove(-1);
            hearts.get(numberOfLives).getImageView().setViewport(new Rectangle2D(100, 10, 50, 50));
            //if (numberOfLives==2) {
            //    for (staticThing heart : hearts) {
            //        heart.getImageView().setViewport(new Rectangle2D(170, 10, 50, 50));
            //    }
            //}
        }*/

    }
}


