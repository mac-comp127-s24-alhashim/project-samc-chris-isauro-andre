import edu.macalester.graphics.*;

public class Car{

private Engine engine;
private Tire tyre;
private Racer racer;
private Image carModel;

private int topSpeed;
private double currentSpeed, currentAngle, velocityX, velocityY;

private final double passiveDeceleration = .001;

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
    }

    // Getter methods below important for the movement of the canvas based on the X and Y velocities of the car

    public double getVelocityX(){
        return velocityX;
    }

    public double getVelocityY(){
        return velocityY;
    }

    public void setCurrentSpeed(double dt){
        currentSpeed = dt;
    }

    // puts the car physically in the canvas
    public void addCarToCanvas(CanvasWindow canvas){
        canvas.add(carModel);
        canvas.add(tyre.getWheel());
    }

    //rotates car Right
    public void turnRight(){
        double turningValue = -((tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight())));

        if(currentSpeed > 1){
            updateAngle(turningValue);
        }
        else if (currentSpeed < 0 && currentSpeed >= -10){
            updateAngle(-turningValue);
        }

    }

    //rotates car Left
    public void turnLeft(){
        double turningValue = (tyre.getGrip()/currentSpeed) - (.2 * (racer.getWeight() + engine.getWeight()));

        if(currentSpeed > 1){
            updateAngle(turningValue);
        }
        else if (currentSpeed < 0 && currentSpeed >= -10){
            updateAngle(-turningValue);
        }

    }

    //speeds up car
    public void speedUp(){
        double accelaration;
        accelaration = engine.getTorque() - (tyre.getFriction() * ((racer.getWeight() + engine.getWeight()) * 9.8));

        if(currentSpeed <= topSpeed && tyre.getDurability() > 0){
            currentSpeed += accelaration;
        } else {
            passiveSpeedDown();
        }
        updateSpeed();
    }

    //speeds down car wtih brake
    public void speedDown(){
        if(currentSpeed > 0){
            currentSpeed -= racer.getBrakepower();
        }
        else if(currentSpeed <= 0 && !isreverseCar()){
            currentSpeed = 0;
        }
        updateSpeed();
    }

    public boolean isreverseCar(){
        if (currentSpeed <= 0 && currentSpeed >= -10) {
            currentSpeed -= 0.43;
            updateSpeed();
            return true;
            
        } else {
            return false;
        }

    }

    //car speeds down passively due to friction
    public void passiveSpeedDown(){
        double decelaration;
        decelaration = passiveDeceleration * (racer.getWeight() + engine.getWeight()) * 9.8;

        if (currentSpeed > 0){
            currentSpeed = currentSpeed - decelaration;
            if (currentSpeed < 0){
                currentSpeed = 0;
            }
            updateSpeed();
        }
    }
    
    //updates the x and y velocities of the car.
    private void updateSpeed(){
        velocityX = currentSpeed * Math.cos(Math.toRadians(currentAngle - 90));
        velocityY = currentSpeed * -Math.sin(Math.toRadians(currentAngle - 90));
    }
    
    //updates the angle of the car and reflects it on the canvas.
    //when updating the angle, the durability of the tires degrade whenever the car turns.
    private void updateAngle(double turning){
        currentAngle += turning;
        carModel.rotateBy(turning);
        tyre.getWheel().rotateBy(turning);
        tyre.degradeTires();
        updateSpeed(); 
    }

    public void animateTyres(){
        if(currentSpeed > 0){
            tyre.animateWheel();
            tyre.getWheel();
        }
    }
}
