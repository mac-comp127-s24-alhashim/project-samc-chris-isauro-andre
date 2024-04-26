import edu.macalester.graphics.*;

public class MenuStartButton {
    private Image restingImage;

    public MenuStartButton(String restingImage, double scalefactor, Point location, Menu menu, CanvasWindow canvas){
        this.restingImage = new Image(restingImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.restingImage.setPosition(location);
        canvas.add(this.restingImage);
    }

    public Image getRestingImage(){
        return restingImage;
    }
}