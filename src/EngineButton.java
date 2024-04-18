import edu.macalester.graphics.*;


public class EngineButton implements MenuButton {
    Image restingImage, pressedImage;
    Engine engine;
    CanvasWindow canvas;
    Menu menu;

    public EngineButton(Engine engine, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, Menu menu, CanvasWindow canvas){
        this.engine = engine;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        canvas.add(this.restingImage);
        this.menu = menu;
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuButton button : menu.getEngineButtons()){
            if (button == this){
                canvas.add(this.pressedImage);
                menu.setSelectedEngine(this.engine);
            }
            else{
                button.deselected();
            }
        }
        
    }

    public void deselected(){
        canvas.remove(this.pressedImage);
    }
}
