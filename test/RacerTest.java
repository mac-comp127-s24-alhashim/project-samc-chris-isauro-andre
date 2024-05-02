// import edu.macalester.graphics.*;
// import edu.macalester.graphics.events.Key;

// public class RacerTest{

//         private CanvasWindow canvas;
//         private Menu menu;
//         private RacingObjects carObjects;
//         private double carAngle = 90.0;
//         private final double scale = 0.25;
    
//         public static void main(String[] args) {
//             RacerTest game = new RacerTest();
//             game.prepareGame();
//         }
        
//         public RacerTest(){
//             canvas = new CanvasWindow("MacF1", 1280, 720);
//             menu = new Menu(canvas);
//             carObjects = new RacingObjects();
//         }

//         private void prepareGame(){
//             canvas.onClick(event -> {
//                 if (menu.getIfMenuOpen()){
//                     if (menu.buttonManager.getStartButton().getRestingImage().testHit(event.getPosition().getX(), event.getPosition().getY())){
//                     canvas.removeAll();
//                     gameStart();
//                     }
//                 }
//             });
//         }

//         private void gameStart(){
//             final double carPositionX = canvas.getWidth()/2.34;
//             final double carPositionY = canvas.getHeight()/4.7;

//             // Track track = carObjects.getTracks().get(menu.getSelectedTrack().getKey());
//             Track track = new Track("Suzuka", new Image("images/TrackBaseImages/trackTest.png"), 0, 0, 0, 10);

//             Car car = new Car(
//                 carObjects.getEngines().get(menu.getSelectedEngine().getKey()),
//                 carObjects.getTires().get(menu.getSelectedTires().getKey()),
//                 carObjects.getRacers().get(menu.getSelectedRacer().getKey()),
//                 carPositionX, carPositionY, carAngle, scale);

//             track.addMaptoCanvas(canvas);
//             car.addCarToCanvas(canvas);
//             canvas.draw();

//             canvas.animate(() -> {
//                 if(canvas.getKeysPressed().contains(Key.D)){
//                     car.turnRight();
//                 }
            
//                 if(canvas.getKeysPressed().contains(Key.A)){
//                     car.turnLeft();
//                 }

//                 if(canvas.getKeysPressed().contains(Key.S)){
//                     car.speedDown();
//                 }

//                 if(canvas.getKeysPressed().contains(Key.W)){
//                     car.speedUp();
//                 } 
                
            //     if(!canvas.getKeysPressed().contains(Key.W)){
            //         car.passiveSpeedDown();
            //     }
            //     track.moveMap(car.getVelocityX(), car.getVelocityY(), car);
            // });

//         }
//     }
    