import edu.macalester.graphics.*;

public class StartButton implements MenuButton {
    int x, y;
    Image restingImage, pressedImage;

    public StartButton(String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.x = x;
        this.y = y;
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