import edu.macalester.graphics.*;

public class Car{

private Engine engineType;
private Tyre tyreType;
private Racer racer;
private Image carModel;

private int topSpeed;
private double currentSpeed = 0;
private double velocityX;
private double velocityY;

private final int friction = 0; // 0 is place holder

    public Car(
        Image carModel,
        // Engine engine, 
        // Tyre tyre, 
        // Racer racer,
        double centerX,
        double centerY,
        double angle){

        // engineType = engine;
        // tyreType = tyre;
        // this.racer = racer;
        this.carModel = carModel;
        carModel.setRotation(angle);

        this.velocityX = currentSpeed * Math.cos(Math.toRadians(angle));
        this.velocityY = currentSpeed * -Math.sin(Math.toRadians(angle));
    }

    public void addtoCanvas(CanvasWindow canvas){
        canvas.add(carModel);
    }

    public void updateAngle(double angle){
        carModel.rotateBy(angle);
    }

    void updateSpeed(double dt){
        currentSpeed += dt;
    }

    public void decelerate(){

    }
}
