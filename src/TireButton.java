import edu.macalester.graphics.*;


public class TireButton implements MenuButton {
    int x, y;
    Image restingImage, pressedImage;
    Tyre tyre;

    public TireButton(Tyre tyre, String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.x = x;
        this.y = y;
        this.tyre = tyre;
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