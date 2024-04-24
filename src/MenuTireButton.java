import edu.macalester.graphics.*;


public class MenuTireButton implements MenuButton {
    private Image restingImage, pressedImage;
    private Tire tyre;
    private CanvasWindow canvas;
    private MenuButtonManager buttonManager;
    private Menu menu;
    private boolean selected;

    public MenuTireButton(Tire tyre, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, MenuButtonManager buttonManager, Menu menu, CanvasWindow canvas){
        this.tyre = tyre;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        this.buttonManager = buttonManager;
        this.menu = menu;
        canvas.add(this.restingImage);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuTireButton button : buttonManager.getTireButtons()){
            if (button == this){
                selected = true;
                canvas.add(this.pressedImage);
                menu.setSelectedTires(this.tyre);
                menu.setPreviewTire();
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