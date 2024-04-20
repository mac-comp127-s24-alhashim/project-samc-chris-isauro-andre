import edu.macalester.graphics.*;


public class RacerButton implements MenuButton {
    Image restingImage, pressedImage, carBody;
    Racer racer;
    CanvasWindow canvas;
    MenuButtonManager buttonManager;
    Menu menu;
    boolean selected;

    public RacerButton(Racer racer, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, MenuButtonManager buttonManager, Menu menu, CanvasWindow canvas){
        this.racer = racer;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        canvas.add(this.restingImage);
        this.buttonManager = buttonManager;
        this.menu = menu;
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
                this.pressed();
            }
        });
    }

    public void pressed(){
        for (RacerButton button : buttonManager.getRacerButtons()){
            if (button == this){
                selected = true;
                canvas.add(this.pressedImage);
                menu.setSelectedRacer(racer);
                menu.setPreviewCar();
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
