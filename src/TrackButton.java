import edu.macalester.graphics.*;


public class TrackButton implements MenuButton {
    Image restingImage, pressedImage;
    Track track;
    CanvasWindow canvas;
    Menu menu;


    public TrackButton(Track track, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, Menu menu, CanvasWindow canvas){
        this.track = track;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        canvas.add(this.restingImage);
        this.menu = menu;
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuButton button : menu.getTrackButtons()){
            if (button == this){
                canvas.add(this.pressedImage);
                menu.setSelectedTrack(this.track);
            }
            if (button != this){
                button.deselected();
            }
        }
        
    }

    public void deselected(){
        canvas.remove(this.pressedImage);
    }
}