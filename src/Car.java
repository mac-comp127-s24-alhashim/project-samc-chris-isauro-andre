import edu.macalester.graphics.*;

/**
 * This class is responsible for all behaviors and attributes of the car.
 * The class translates the inputs of the user into methods that control the car.
 * 
 * @param engineType    Engine object that possess the attributes of the selected engine from the menu
 * @param tyreType      Tyre object that possess the attributes of the selected tyre from the menu
 * @param racerType     racer object that possess the attributes of the selected racer from the menu
 * @param centerX       X position of the car
 * @param centerY       Y position of the car
 * @param angle         the initial angle in which the car is rotated by
 * @param scale         the size of the car
 */

public class Car{

private Engine engine;
private Tire tyre;
private Racer racer;
private Image carModel;

private int topSpeed;
private double friction;
private double currentSpeed, currentAngle, velocityX, velocityY;

private final double frictionConstant = .002;

    public Car(
        Engine engineType, 
        Tire tyreType, 
        Racer racerType,
        double centerX,
        double centerY,
        double angle,
        double scale){

        engine = engineType;
        tyre = tyreType;
        racer = racerType;
        carModel = racer.getRacerCar();
        topSpeed = engine.getTopSpeed();

        carModel.setRotation(angle);
        carModel.setPosition(centerX, centerY);
        carModel.setScale(scale);

        tyre.getWheel().setPosition(centerX, centerY);
        tyre.getWheel().setRotation(angle);
        tyre.getWheel().setScale(scale);

        currentAngle = angle;
        currentSpeed = 0;

        friction = frictionConstant * (racer.getWeight() + engine.getWeight()) * 9.8;
    }

    /** 
     * Getter methods below important for the movement of the canvas based on the X and Y velocities of the car
    */ 

    public double getVelocityX(){
        return velocityX;
    }

    public double getVelocityY(){
        return velocityY;
    }

    /**
     * sets the speed of the car
     * @param newSpeed the speed the car is set to.
     */

    public void setCurrentSpeed(double newSpeed){
        currentSpeed = newSpeed;
    }

    /**
     * adds the car image and the wheel image to the canvas.
     * @param canvas the canvas that the car is added to.
     */

    public void addCarToCanvas(CanvasWindow canvas){
        canvas.add(carModel);
        canvas.add(tyre.getWheel());
    }

    /**
     * creates a turning value that is based of the attributes of the direction the car is going.
     * car turns right if the user inputs the key to turn right.
     * car turns left if the user inputs the key to turn left.
     * 
     * The value is calculated based on tyre grip and total weight of the car to mimic pseudo physics.
     * turningValue is a local variable it cannot be manipulated properly by canvas.animate().
     */

    public void turnRight(){
        double turningValue = -((tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight())));
        turn(turningValue);
    }

    public void turnLeft(){
        double turningValue = (tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight()));
        turn(turningValue);
    }

    /**
     * Accelarates the car, increasing its speed. Accelaration is calculated based on the engine torque (how much force a engine is applying to the car),
     * and friction force which is takes in the normal force of the car. (Pseudo Physics).
     * 
     * The car is accelarates if and only if the tires are still durable, and that is less than the top speed of the selected engine.
     * It calls updateSpeed() to update velocities based on the new speed.
     */

    public void speedUp(){
        double accelaration;
        accelaration = engine.getTorque() - (tyre.getFriction() * ((racer.getWeight() + engine.getWeight()) * 9.8));

        if(currentSpeed <= topSpeed && tyre.getDurability() > 0){
            currentSpeed += accelaration;
        } 
        updateSpeed();
    }

    /**
     * Slows the down the car, decreasing its speed. Decreases the speed only if the car is still moving (speed not 0).
     * If the user is not reversing, then the car stops.
     * 
     * It calls updateSpeed() to update velocities based on the new speed.
     */

    public void speedDown(){
        if(currentSpeed > 0){
            currentSpeed -= racer.getBrakepower();
        }
        else if(!isReversing()){
            currentSpeed = 0;
        }
        updateSpeed();
    }

    /**
     * is a boolean that dictates whether the car is going backwards.
     * The speed is subtracted into the negatives up to a certain limit less than 0 and greater than -5.
     * 
     * It calls updateSpeed() to update velocities based on the new speed.
     * 
     * @return true if the car IS going backwards. False if otherwise.
     */

    public boolean isReversing(){
        if (currentSpeed <= 0 && currentSpeed >= -5) {
            currentSpeed -= 0.32;
            if(currentSpeed < -5){
                currentSpeed = -5;
            }
            updateSpeed();
            return true;
        } 
        else {
            return false;
        }
    }

    /**
     *  slows down the car due to friction if the user is not accelarating.
     */

    public void passiveSpeedDown(){
        if (currentSpeed > 0){
            currentSpeed = currentSpeed - friction;
            if (currentSpeed < 0){
                currentSpeed = 0;
            }
            updateSpeed();
        }
    }

    /**
     * If the car is in reverse, it slows down the car reversing when the user is not reversing.
     */

    public void passiveSpeedUp(){
        if (currentSpeed < 0){
            currentSpeed = currentSpeed + friction;
            if (currentSpeed > 0){
                currentSpeed = 0;
            }
            updateSpeed();
        }
    }

    
    /**
     * updates the X and Y velocities of the car and reflects it the canvas.
     * The X and Y velocities are dependent on the speed of the car and its current angle.
     */

    private void updateSpeed(){
        velocityX = currentSpeed * Math.cos(Math.toRadians(currentAngle - 90));
        velocityY = currentSpeed * -Math.sin(Math.toRadians(currentAngle - 90));
    }
    
    /**
     * turns the car in opposite directions depending whether the car is reversing or not
     * 
     * @param turning the value how much the car turns by
     */

    private void turn(double turning){
        if(currentSpeed > 1){
            updateAngle(turning);
        }
        else if (currentSpeed < 0 && currentSpeed >= -10){
            updateAngle(-turning);
        }
    }
    
     /**
     * updates the angle of the car and reflects it on the canvas.
     * when updating the angle, the durability of the tires degrade whenever the car turns.
     * 
     * @param turning the value how much the angle change is relfected by
     */

    private void updateAngle(double turning){
        currentAngle += turning;
        carModel.rotateBy(turning);
        tyre.getWheel().rotateBy(turning);
        tyre.degradeTires();
        updateSpeed(); 
    }
}
