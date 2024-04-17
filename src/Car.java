import edu.macalester.graphics.*;

public class Car{

private Engine engine;
private Tyre tyre;
private Racer racer;
private Image carModel;

private int topSpeed;
private double currentSpeed;
private double currentAngle;
private double velocityX, velocityY;

private final double passiveDeceleration = .3;

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
        
        currentAngle = angle;
        currentSpeed = 0;
    }

    // Getter methods belowimportant for the movement of the canvas based on the X and Y velocities of the car

    public double getVelocityX(){
        return velocityX;
    }

    public double getVelocityY(){
        return velocityY;
    }

    // puts the car physically in the canvas
    public void addtoCanvas(CanvasWindow canvas){
        canvas.add(carModel);
        canvas.add(tyre.getWheelModel());
    }

    //rotates car
    public void updateAngle(double angle){
        double rotationAngle = angle;
        carModel.rotateBy(rotationAngle);
        tyre.getWheelModel().rotateBy(rotationAngle);
        currentAngle = rotationAngle;
    }

    //speeds up car
    public void speedUp(){
        if(currentSpeed <= topSpeed){
            currentSpeed = currentSpeed + accelarate();
        }
        updateSpeed();
    }

    public void speedDown(){
        if(currentSpeed >= 0){
            currentSpeed = currentSpeed - racer.getBrakepower();
        }
        updateSpeed();
    }

    private double accelarate(){
        double accelaration;
        accelaration = engine.getTorque() - (tyre.getFriction() * (racer.getWeight() + engine.getWeight()) * 9.8);
        return accelaration;
    }
    
    private boolean updateSpeed(){
        velocityX = currentSpeed * Math.cos(Math.toRadians(currentAngle));
        velocityY = currentSpeed * -Math.sin(Math.toRadians(currentAngle));
        return true;
    }
}
