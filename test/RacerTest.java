import java.io.File;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class RacerTest {

    private CanvasWindow canvas;
    private Car car;
    private double carAngle = 50.0;
    private final double scale = 0.5;
    private RacingObjects carObjects;

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
        
        Track track = carObjects.getTracks()getKey();
        
        Car car = new Car(
            carObjects.getEngines().getKey(),
            carObjects.getTires().getKey(),
            carObjects.getRacers().get(),
            carPositionX, carPositionY, carAngle, scale);

        track.addMaptoCanvas(canvas);
        Image workingTrack = track.addMaptoCanvas(canvas);
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
                
                //move the track image in the opposite direction to the front of the car.
                //move it faster depending on car speed.
                workingTrack.setPosition(
                car.getVelocityX() - 50,
                car.getVelocityY() - 50);
            }
            if (canvas.getKeysPressed().contains(Key.S)){
                car.speedDown();
            }
        });

    }
}