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
        this.canvas = canvas;
        this.buttonManager = buttonManager;
        this.menu = menu;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);

        canvas.add(this.restingImage);

        setupClickMechanic();
    }

    public void setupClickMechanic(){
        canvas.onClick(
            event -> {
                if (menu.getIfMenuOpen()){
                    if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
                        this.pressed();
                    }
                }
            }
        );
    }

    /**
     * If the TireButton that was pressed was this TireButton, selected is set to true, the image
     * that indicates that this button is selected (pressedImage) is displayed over the usual image, and the selectedTire in the 
     * Menu object is set to the tire stored in this object. For all of the TireButtons that were not selected, if they were selected 
     * previously then their deselected method runs.   
     */
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

    /**
     * Removes the image displayed when the button is pressed to reveal the normal image underneath. Then sets selected to false.
     */
    public void deselected(){
        canvas.remove(pressedImage);
        selected = false;
    }

    public boolean getSelectedBool(){
        return selected;
    }
}