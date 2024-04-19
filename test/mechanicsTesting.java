import java.io.File;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class mechanicsTesting {

    private CanvasWindow canvas;
    private Car car;
    private double carAngle = 50.0;
    private final double scale = 0.5;

    public static void main(String[] args) {
        mechanicsTesting game = new mechanicsTesting();
        game.gameStart();
    }

    public mechanicsTesting(){
        canvas = new CanvasWindow("PROJECT TEST", 1240,700);

    }

    public void gameStart(){
        final double carPositionX = canvas.getWidth()/3;
        final double carPositionY = canvas.getHeight()/3;

        car = new Car(
            new Engine(200, 240, 30),
            new Tire(new File("res/images/WheelImages/tireSoft"), carPositionX, carPositionY, .2, carAngle, scale, 50, 10),
            new Racer("images/driver-body1.png", 20, 15),
            carPositionX, carPositionY,
            carAngle, scale
        );
    
        car.addtoCanvas(canvas);
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
