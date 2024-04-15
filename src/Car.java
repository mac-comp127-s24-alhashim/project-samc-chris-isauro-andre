import edu.macalester.graphics.*;

public class Car{

private Engine engine;
private Tyre tyre;
private Racer racer;
private Image carModel;

private int topSpeed;
private double currentSpeed = 0;
private double velocityX, velocityY;

private final double decelarationFriction = .3;

    public Car(
        Image carModel,
        Engine engineType, 
        Tyre tyreType, 
        Racer racerType,
        double centerX,
        double centerY,
        double angle){

        engine = engineType;
        tyre = tyreType;
        racer = racerType;
        this.carModel = carModel;
        carModel.setRotation(angle);
        carModel.setPosition(centerX, centerY);
        tyre.getWheelModel().setPosition(centerX, centerY);
        carModel.setScale(.5);
        
        
        this.velocityX = currentSpeed * Math.cos(Math.toRadians(angle));
        this.velocityY = currentSpeed * -Math.sin(Math.toRadians(angle));
    }

    public void addtoCanvas(CanvasWindow canvas){
        canvas.add(carModel);
        canvas.add(tyre.getWheelModel());
        
    }

    public void updateAngle(double angle){
        double rotationAngle = angle + 1;
        carModel.rotateBy(rotationAngle);
        tyre.getWheelModel().rotateBy(rotationAngle);
    }

    void updateSpeed(double dt){
        currentSpeed += dt;
    }

    public void decelerate(){
    }

}
