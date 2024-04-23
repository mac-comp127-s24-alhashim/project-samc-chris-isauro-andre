import java.io.File;

    import edu.macalester.graphics.*;
    import edu.macalester.graphics.events.Key;

public class Game{

        private CanvasWindow canvas;
        private Menu menu;
        private double carAngle = 50.0;
        private final double scale = 0.5;
    
        public static void main(String[] args) {
            Game game = new Game();
            game.prepareGame();
            game.gameStart();
        }
        
        public Game(){
            canvas = new CanvasWindow("MacF1", 1280, 720);
            menu = new Menu(canvas);
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
                new Engine(200, 240, 30),
                new Tire(new File("res/images/WheelImages/tireSoft"),
                "images/WheelImages/tireSoft1.png", 
                    carPositionX, carPositionY, 
                    .2, carAngle, scale, 50, 10),
                new Racer("images/driver-body1.png", 20, 15),
                carPositionX, carPositionY,
                carAngle, scale
            );

            Track track = new Track(new Image("images/TrackBaseImages/barcelona.jpg"), 
                carPositionY, carPositionX, 
                carPositionY, 1);
        
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
    