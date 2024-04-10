import edu.macalester.graphics.CanvasWindow;

public class Comp127RacerGame {

    private CanvasWindow canvas;

    public static void main(String[] args) {
        Comp127RacerGame game = new Comp127RacerGame();
        game.gameStart();
    }

    public Comp127RacerGame(){
        canvas = new CanvasWindow("PROJECT TEST", 1080, 720);

    }

    public void gameStart(){
        canvas.draw();
    }
}
