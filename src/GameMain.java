import java.text.DecimalFormat;

import edu.macalester.graphics.*;
import edu.macalester.graphics.events.Key;
import edu.macalester.graphics.ui.TextField;

public class GameMain{

        private CanvasWindow canvas;
        private Menu menu;
        private RacingObjects carObjects;
        private double carAngle = -90.0;
        private final double scale = 0.2;
    
        public static void main(String[] args) {
            GameMain game = new GameMain();
            game.prepareGame();
        }
        
        public GameMain(){
            canvas = new CanvasWindow("MacF1", 1280, 720);
            menu = new Menu(canvas);
            carObjects = new RacingObjects();
        }

        private void prepareGame(){
            canvas.onClick(event -> {
                if (menu.getIfMenuOpen()){
                    if (menu.getButtonManager().getStartButton().getRestingImage().testHit(event.getPosition().getX(), event.getPosition().getY())){
                    menu.setIfMenuOpen(false);
                    canvas.removeAll();
                    gameStart();
                    }
                }
            });
        }

        private void gameStart(){
            final double carPositionX = canvas.getWidth()/2.34;
            final double carPositionY = canvas.getHeight()/4.7;

            // Track track = carObjects.getTracks().get(menu.getSelectedTrack().getKey());
            Track track = new Track("Suzuka", new Image("images/TrackBaseImages/trackTest.png"), 0, 0, 0, 9);
            
            // Speedometer Creation formatted to 2 places
            TextField speedHUD = new TextField();
            canvas.add(speedHUD);
            final DecimalFormat df = new DecimalFormat("000");

            Car car = new Car(
                carObjects.getEngines().get(menu.getSelectedEngine().getKey()),
                carObjects.getTires().get(menu.getSelectedTires().getKey()),
                carObjects.getRacers().get(menu.getSelectedRacer().getKey()),
                carPositionX, carPositionY, carAngle, scale);

            track.addMaptoCanvas(canvas);
            car.addCarToCanvas(canvas);
            canvas.draw();

            canvas.animate(() -> {
                if(canvas.getKeysPressed().contains(Key.D)){
                    car.turnRight();
                }
            
                if(canvas.getKeysPressed().contains(Key.A)){
                    car.turnLeft();
                }

                if(canvas.getKeysPressed().contains(Key.S)){
                    car.speedDown();
                }

                if(canvas.getKeysPressed().contains(Key.W)){
                    car.speedUp();
                } 
                
                if(!canvas.getKeysPressed().contains(Key.W)){
                    car.passiveSpeedDown();
                }                 

                track.moveMap(canvas, car.getVelocityX(), car.getVelocityY(), car);

                //Speedometer calculations
                speedHUD.setText(
                df.format((Math.sqrt
                (Math.pow(car.getVelocityX(),2)+
                Math.pow(car.getVelocityY(),2)))*8 
                )+ " KPH"
                );
                speedHUD.setPosition(canvas.getWidth()*2/3, canvas.getHeight()*2/3);

            });

        }
    }
    