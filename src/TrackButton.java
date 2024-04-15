import edu.macalester.graphics.*;


public class TrackButton implements MenuButton {
    Image restingImage, pressedImage, carBody;
    Track track;

    public TrackButton(Track track, String restingImage, String pressedImage, int x, int y, CanvasWindow canvas){
        this.track = track;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        canvas.add(this.restingImage, x, y);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        
    }
}