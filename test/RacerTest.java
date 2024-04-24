import java.io.File;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class RacerTest {

    private CanvasWindow canvas;
    private Car car;
    private double carAngle = 50.0;
    private final double scale = 0.5;

    public static void main(String[] args) {
        mechanicsTesting game = new mechanicsTesting();
        game.gameStart();
    }

    public RacerTest(){
        canvas = new CanvasWindow("PROJECT TEST", 1240,700);

    }

    public void gameStart(){
        final double carPositionX = canvas.getWidth() / 2;
        final double carPositionY = canvas.getHeight() / 2;
        Engine engine = new Engine(null, 200, 240, 30);
        Tire tire = new Tire(null, new File("res/images/WheelImages/tireSoft"), "images/WheelImages/tireSoft1.png",  carPositionX, carPositionY, .2, carAngle, scale, 50, 10);        
        Racer racer = new Racer(null, "images/driver-body1.png", 20, 15);
        
        Track track = new Track("Barcelona", new Image("images/TrackBaseImages/barcelona.jpg"), 70, 60, 20, 1);
        
        Car car = new Car(engine, tire, racer, carPositionX, carPositionY, carAngle, scale);

        track.addMaptoCanvas(canvas);
        car.addCarToCanvas(canvas);
        canvas.draw();

        canvas.animate(() -> {
            if(canvas.getKeysPressed().contains(Key.D)){
                car.turn();
            }
            if(canvas.getKeysPressed().contains(Key.A)){
                car.turn();
            }
            if(canvas.getKeysPressed().contains(Key.W)){
                car.speedUp();
            }
            if (canvas.getKeysPressed().contains(Key.S)){
                car.speedDown();
            }
        });

    }
}
