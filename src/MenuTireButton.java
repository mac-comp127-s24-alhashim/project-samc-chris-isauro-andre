import edu.macalester.graphics.*;

/**
 * The class represents all of the Tire Buttons in the menu. The objects made from this class store a Tire object as well as two images,
 * one for when the button is clicked and another for when the button is not clicked. When the button is clicked the selected tire in 
 * the Menu object is set to the tire stored in the clicked tire button.
 */
public class MenuTireButton implements MenuButton {
    private Image restingImage, pressedImage;
    private Tire tire;
    private CanvasWindow canvas;
    private MenuUIManager buttonManager;
    private Menu menu;
    private boolean selected;

    /**
     * When constructed, the object stores the references to canvas, buttonManager, and menu so that their methods can be referenced later.
     * If then takes the strings restingImageString and pressedImageString and converts them to Image objects, and then scales and 
     * positions them using the fed in x, y, and scalefactor variables. It then displays the restingImage and sets up a listen to 
     * listen for a click on the pressed image. It also stores the given Tire object.
     */
    public MenuTireButton(Tire tire, String restingImageString, String pressedImageString, 
            double scalefactor, double x, double y, MenuUIManager buttonManager, Menu menu, CanvasWindow canvas){
        this.tire = tire;
        this.canvas = canvas;
        this.buttonManager = buttonManager;
        this.menu = menu;

        this.restingImage = new Image(restingImageString);
        this.pressedImage = new Image(pressedImageString);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);

        canvas.add(this.restingImage);

        setupClickMechanic();
    }

    /**
     * Adds a listener to the canvas that listens for a click. If the menu is open and the click is over this objects resting image, 
     * this objects pressed() method runs.
     */
    public void setupClickMechanic(){
        canvas.onClick(
            event -> {
                if (menu.getIfMenuOpen() && this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
                        this.pressed();
                }
            }
        );
    }

    /**
     * If the TireButton that was pressed was this TireButton, selected is set to true, the image
     * that indicates that this button is selected (pressedImage) is displayed over the usual image, and the selectedTire in the 
     * Menu object is set to the tire stored in this object. For all of the TireButtons that were not selected, if they were selected 
     * previously then their deselected() method runs.   
     */
    public void pressed(){
        for (MenuTireButton button : buttonManager.getTireButtons()){
            if (button == this){
                selected = true;
                canvas.add(this.pressedImage);
                menu.setSelectedTires(this.tire);
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