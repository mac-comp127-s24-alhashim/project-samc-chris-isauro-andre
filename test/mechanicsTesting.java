import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class mechanicsTesting {

    private CanvasWindow canvas;
    private Car car;
    private double carAngle; 


    public static void main(String[] args) {
        mechanicsTesting game = new mechanicsTesting();
        game.gameStart();
    }

    public mechanicsTesting(){
        canvas = new CanvasWindow("PROJECT TEST", 1240,700);

    }

    public void gameStart(){
        final double carPositionX = canvas.getWidth()/2;
        final double carPositionY = canvas.getHeight()/2;
        carAngle = 50;

        car = new Car(
        new Image("images/driver-body1.png"),
        new Tyre(new Image("images/WheelImages/tireSoft1.png"), carPositionX, carPositionY, carAngle),
        carPositionX, carPositionY, carAngle);

        car.addtoCanvas(canvas);
        canvas.draw();

        

        canvas.animate(() -> {
            if(canvas.getKeysPressed().contains(Key.D)){
                car.updateAngle(5);
            }
            if(canvas.getKeysPressed().contains(Key.A)){
                car.updateAngle(-5);
            }
            if(canvas.getKeysPressed().contains(Key.W)){
                //accelarate
            }
            if (canvas.getKeysPressed().contains(Key.S)){
                //brake
            }
        });

    }
}
