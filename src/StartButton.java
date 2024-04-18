import edu.macalester.graphics.*;

public class StartButton implements MenuButton {
    Point location;
    Image restingImage, pressedImage;

    public StartButton(String restingImage, String pressedImage, Point location, CanvasWindow canvas){
        this.location = location; 
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setPosition(location);
        this.pressedImage.setPosition(location);
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