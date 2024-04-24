import edu.macalester.graphics.*;


public class MenuEngineButton implements MenuButton {
    private Image restingImage, pressedImage;
    private Engine engine;
    private CanvasWindow canvas;
    private Menu menu;
    private boolean selected;
    private MenuButtonManager buttonManager;

    public MenuEngineButton(Engine engine, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, MenuButtonManager buttonManager, Menu menu,  CanvasWindow canvas){
        this.engine = engine;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        this.buttonManager = buttonManager;
        canvas.add(this.restingImage);
        this.menu = menu;
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuEngineButton button : buttonManager.getEngineButtons()){
            if (button == this){
                selected = true;
                canvas.add(this.pressedImage);
                menu.setSelectedEngine(this.engine);
            }
            else{
                if (button.getSelectedBool() == true){
                    button.deselected();
                }
            }
        }
        
    }

    public void deselected(){
        canvas.remove(pressedImage);
        selected = false;
    }

    public boolean getSelectedBool(){
        return selected;
    }
}
