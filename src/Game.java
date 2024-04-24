import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;

public class Game{

        private CanvasWindow canvas;
        private Menu menu;
        private RacingObjects carObjects;
        private double carAngle = 50.0;
        private final double scale = 0.5;
    
        public static void main(String[] args) {
            Game game = new Game();
            game.prepareGame();
        }
        
        public Game(){
            canvas = new CanvasWindow("MacF1", 1280, 720);
            menu = new Menu(canvas);
            carObjects = new RacingObjects();

        }

        public void prepareGame(){
            canvas.onClick(event -> {
                if (menu.buttonManager.getStartButton().getRestingImage().testHit(event.getPosition().getX(), event.getPosition().getY())){
                canvas.removeAll();
                gameStart();
                }
            });
        }

        public void gameStart(){
            final double carPositionX = canvas.getWidth()/3;
            final double carPositionY = canvas.getHeight()/3;

            Car car = new Car(
                carObjects.getEngines().get(menu.getSelectedEngine().getKey()),
                carObjects.getTires().get(menu.getSelectedTires().getKey()),
                carObjects.getRacers().get(menu.getSelectedRacer().getKey()),
                carPositionX, carPositionY, carAngle, scale);


            Track track = carObjects.getTracks().get(menu.getSelectedTrack().getKey());

            car.addCarToCanvas(canvas);
            track.addMaptoCanvas(canvas);
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
    