
import edu.macalester.graphics.*;


public class RacerButton implements MenuButton {
    Image restingImage, pressedImage;
    Racer racer;
    Image carBody;

    public RacerButton(Racer racer, String restingImage, String pressedImage){
        this.racer = racer;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);

    }

    public void pressed(){
        
    }

    
}
