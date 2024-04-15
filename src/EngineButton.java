import edu.macalester.graphics.*;


public class EngineButton implements MenuButton {
    Image restingImage, pressedImage;
    Engine engine;

    public EngineButton(Engine engine, String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.engine = engine;
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
