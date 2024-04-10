public class Car {

private Engine engineType;
private Tyre tyreType;
private Racer racer;

private double centerX;
private double centerY;
private int acceleration;
private int topSpeed;
private double currentSpeed = 0;
private double velocityX;
private double velocityY;

private final int friction = 0; // 0 is place holder

    public Car(
        Engine engine, 
        Tyre tyre, 
        Racer racer,
        double centerX,
        double centerY,
        double angle){

        engineType = engine;
        tyreType = tyre;
        this.racer = racer;
        this.centerX = centerX;
        this.centerY = centerY;
        this.velocityX = currentSpeed * Math.cos(Math.toRadians(angle));
        this.velocityY = currentSpeed * -Math.sin(Math.toRadians(angle));
    }

    public void updateAngle(double angle){
        
    }

    public boolean updateSpeed(double dt){
        return true;
    }
    
    public void accelerate(){
        // currentSpeed;
    }

    public void decelerate(){

    }
}
