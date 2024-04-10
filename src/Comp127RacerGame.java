import edu.macalester.graphics.CanvasWindow;

public class Comp127RacerGame {

    private CanvasWindow canvas;
    private Car car;


    /** Added the main method to test adding the "car model" from a car object to the canvas.
     *  From there I will do rotation testing                    -Yours Truly Andre :D
     */

    public static void main(String[] args) {
        Comp127RacerGame game = new Comp127RacerGame();
        game.gameStart();
    }

    public Comp127RacerGame(){
        canvas = new CanvasWindow("PROJECT TEST", 1080, 720);

    }

    public void gameStart(){
        car = new Car(null, canvas.getWidth()/2, canvas.getHeight()/2, 0);
        car.addtoCanvas(canvas);
        canvas.draw();
    }
}
