import edu.macalester.graphics.*;

/**
 * This is a very simple class compared to the other button types. This button exists to have its image called for a click listener.
 */
public class MenuStartButton {
    private Image restingImage;

    /**
     * It takes in a String and uses it to create an image which is then scaled and positioned. It is then added to the canvas. Pretty self 
     * explanatory.
     * 
     * @param restingImageString        Image name of when the button is idle.
     * @param scalefactor               The size of the button in comparison of the menu.
     * @param location                  The position where the button is situated.
     * @param menu                      Where the button will be harbored
     * @param canvas                    Where the button will be located in.
     */
    public MenuStartButton(String restingImageString, double scalefactor, Point location, Menu menu, CanvasWindow canvas){
        this.restingImage = new Image(restingImageString);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.restingImage.setPosition(location);
        canvas.add(this.restingImage);
    }

    public Image getRestingImage(){
        return restingImage;
    }
}