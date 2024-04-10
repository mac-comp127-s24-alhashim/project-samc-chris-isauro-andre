import edu.macalester.graphics.*;


public class RacerButton implements MenuButton {
    Image restingImage, pressedImage, carBody;
    Racer racer;

    public RacerButton(Racer racer, String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.racer = racer;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        canvas.add(this.restingImage, x, y);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        
    }
    
}
