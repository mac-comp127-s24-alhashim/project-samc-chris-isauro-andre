import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.events.KeyboardEvent;

public class mechanicsTesting {

    private CanvasWindow canvas;
    private Car car;
    // private Key Wkey = "w";

    /** Added the main method to test adding the "car model" from a car object to the canvas.
     *  From there I will do rotation testing                    -Yours Truly Andre :D
     */

    public static void main(String[] args) {
        mechanicsTesting game = new mechanicsTesting();
        game.gameStart();
    }

    public mechanicsTesting(){
        canvas = new CanvasWindow("PROJECT TEST", 1080, 720);

    }

    public void gameStart(){
        car = new Car(
        new Image("images/driver-body2.png"),
        canvas.getWidth()/2, 
        canvas.getHeight()/2,
        90
        );
        car.addtoCanvas(canvas);
        canvas.draw();

        

        canvas.onKeyDown(KeyboardEvent -> {            
            if (KeyboardEvent.getKey() == Key.D){
                car.updateAngle(5);
            }
            if (KeyboardEvent.getKey() == Key.A){
                car.updateAngle(-5);
            }
        });
    
    }

    
}
