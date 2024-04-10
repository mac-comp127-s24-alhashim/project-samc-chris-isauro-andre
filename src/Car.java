public class Car {

private Engine engineType;
private Tyre tyreType;
private Racer racer;

private int acceleration, topSpeed, currentSpeed;
private final int friction = 0; // 0 is place holder

    public Car(Engine engine, Tyre tyre, Racer racer){
        engineType = engine;
        tyreType = tyre;
        this.racer = racer;
        acceleration = 0;
        currentSpeed = 0;
    }

    public void accelerate(){
        // currentSpeed;
    }

    public void decelerate(){

    }
}
