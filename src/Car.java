import edu.macalester.graphics.*;

public class Car{

private Engine engine;
private Tire tyre;
private Racer racer;
private Image carModel;

private int topSpeed;
private double currentSpeed, currentAngle, velocityX, velocityY;

private final double passiveDeceleration = .01;

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

        carModel.setRotation(angle);
        carModel.setPosition(centerX, centerY);
        tyre.getWheel().setPosition(centerX, centerY);
        tyre.getWheel().setRotation(angle);
        carModel.setScale(scale);
        
        currentAngle = angle;
        currentSpeed = 0;
        topSpeed = engine.getTopSpeed();
    }

    // Getter methods below important for the movement of the canvas based on the X and Y velocities of the car

    public double getVelocityX(){
        return velocityX;
    }

    public double getVelocityY(){
        return velocityY;
    }

    // puts the car physically in the canvas
    public void addCarToCanvas(CanvasWindow canvas){
        canvas.add(carModel);
        canvas.add(tyre.getWheel());
    }

    //rotates car Right
    public void turnRight(){
        if(currentSpeed > 0){
            double turningValue = -((tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight())));
            currentAngle = currentAngle + turningValue;
            carModel.rotateBy(turningValue);
            tyre.getWheel().rotateBy(turningValue);
            updateSpeed();
        }
    }

    //rotates car Left
    public void turnLeft(){
        if(currentSpeed > 0){
            double turningValue = (tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight()));
            currentAngle = currentAngle + turningValue;
            carModel.rotateBy(turningValue);
            tyre.getWheel().rotateBy(turningValue);
            updateSpeed();
        }
    }

    //speeds up car
    public void speedUp(){
        double accelaration;
        accelaration = engine.getTorque() - (tyre.getFriction() * ((racer.getWeight() + engine.getWeight()) * 9.8));

        if(currentSpeed < topSpeed){
            currentSpeed = currentSpeed + accelaration;
        }
        updateSpeed();
    }

    //speeds down car wtih brake
    public void speedDown(){
        if(currentSpeed > 0){
            currentSpeed = currentSpeed - racer.getBrakepower();
        }
        else if(currentSpeed <= 0){
            currentSpeed = 0;
        }
        updateSpeed();
    }

    //car speeds down passively due to friction
    public void passiveSpeedDown(){
        while(currentSpeed > 0){
            currentSpeed = currentSpeed - decelarate();
            if (currentSpeed < 0){
                currentSpeed = 0;
            }
            updateSpeed();

        }
    }

    //a car can only accelarate when its tyres are still durable

    // private double accelarate(){
    //     double accelaration;
    //     // if(tyre.getDurability() > 0){
    //     accelaration = engine.getTorque() - (tyre.getFriction() * ((racer.getWeight() + engine.getWeight()) * 9.8));
    //     return accelaration;
    //     // }
    //     // else{
    //     //     accelaration = 0;
    //     //     return accelaration;
    //     // }
    // }

    //car slows down
    private double decelarate(){
        double decelaration;
        decelaration = passiveDeceleration * (racer.getWeight() + engine.getWeight()) * 9.8;
        return decelaration;
    }
    
    //updates the x and y velocities of the car.
    private void updateSpeed(){
        velocityX = currentSpeed * Math.cos(Math.toRadians(currentAngle - 90));
        velocityY = currentSpeed * -Math.sin(Math.toRadians(currentAngle - 90));
    }
}
