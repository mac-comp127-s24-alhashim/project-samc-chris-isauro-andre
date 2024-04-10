
import edu.macalester.graphics.*;


public class RacerButton implements MenuButton {
    Image restingImage, pressedImage, carBody;
    Racer racer;

    public RacerButton(Racer racer, String restingImage, String pressedImage){
        this.racer = racer;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);

    }

    public void pressed(){
        
    }

    
}
