import edu.macalester.graphics.*;


public class RacerButton implements MenuButton {
    Image restingImage, pressedImage, carBody;
    Racer racer;

    public RacerButton(Racer racer, String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.racer = racer;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        canvas.add(this.restingImage);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
                this.pressed();
            }
        });
    }

    public void pressed(){
        
    }
    
}
