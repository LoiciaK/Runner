public class Camera {
    private double x;
    private double y;
    private double vx;
    private double vy;
    private double moment = 0;

// La caméra n'est pas utilisée

    public Camera(double x, double y){
        this.x = x;
        this.y = y;
    }

    public void update(double time, Hero hero){
        if (this.moment ==0){
            moment = time;
        }
        double deltaT = time - moment;
        double ax = hero.getX()-this.x+1.2*vx;
        vx+= ax*deltaT;
        x+= vx*deltaT;
        double ay = hero.getY()-this.y+1.2*vy;
        vy+= ay*deltaT;
        y+= vy*deltaT;
        moment = time;
    }

    public double getX() {return x;}
    public double getY() {return y;}


    @Override
    public String toString() {
        return x + "," + y;
    }

}
