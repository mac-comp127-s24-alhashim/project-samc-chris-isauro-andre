

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class mechanicsTesting {

    private CanvasWindow canvas;
    private Menu menu;
    private RacingObjects carObjects;
    private double carAngle = 50.0;
    private final double scale = 0.5;

    public static void main(String[] args) {
        mechanicsTesting game = new mechanicsTesting();
        game.gameStart();
    }

    public mechanicsTesting(){
        canvas = new CanvasWindow("PROJECT TEST", 1240,700);
        // menu = new Menu(canvas);
        carObjects = new RacingObjects();
    }

    public void gameStart(){
        final double carPositionX = canvas.getWidth()/3;
        final double carPositionY = canvas.getHeight()/3;

        Car car = new Car(
            carObjects.getEngines().get(menu.getSelectedEngine().getKey()),
            carObjects.getTires().get(menu.getSelectedTires().getKey()),
            carObjects.getRacers().get(menu.getSelectedRacer().getKey()),
            carPositionX, carPositionY, carAngle, scale);

    
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
