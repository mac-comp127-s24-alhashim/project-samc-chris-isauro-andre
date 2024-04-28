import edu.macalester.graphics.*;

/**
 * The class represents all of the Engine Buttons in the menu. The objects made from this class store an Engine object as well as two images,
 * one for when the button is clicked and another for when the button is not clicked. When the button is clicked the selected engine in 
 * the Menu object is set to the engine stored in the clicked engine button.
 */
public class MenuEngineButton implements MenuButton {
    private Image restingImage, pressedImage;
    private Engine engine;
    private CanvasWindow canvas;
    private Menu menu;
    private boolean selected;
    private MenuButtonManager buttonManager;

    /**
     * When constructed, the object stores the references to canvas, buttonManager, and menu so that their methods can be referenced later.
     * If then takes the strings restingImageString and pressedImageString and converts them to Image objects, and then scales and 
     * positions them using the fed in x, y, and scalefactor variables. It then displays the restingImage and sets up a listen to 
     * listen for a click on the pressed image.
     */
    public MenuEngineButton(Engine engine, String restingImageString, String pressedImageString, 
            double scalefactor, double x, double y, MenuButtonManager buttonManager, Menu menu,  CanvasWindow canvas){
        this.engine = engine;
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
     * Adds a listener to the canvas that listens for a click. If the menu is open and the click is over this object's resting image, 
     * this object's pressed() method runs.
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
     * If the EngineButton that was pressed was this EngineButton, selected is set to true, the image
     * that indicates that this button is selected (pressedImage) is displayed over the usual image, and the selectedEngine in the 
     * Menu object is set to the engine stored in this object. For all of the EngineButtons that were not selected, if they were selected 
     * previously then their deselected() method runs.   
     */
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
