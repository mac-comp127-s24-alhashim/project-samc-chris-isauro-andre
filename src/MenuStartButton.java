import edu.macalester.graphics.*;

public class MenuStartButton {
    Point location;
    Image restingImage, pressedImage;

    public MenuStartButton(String restingImage, double scalefactor, Point location, CanvasWindow canvas){
        this.location = location; 
        this.restingImage = new Image(restingImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.restingImage.setPosition(location);
        canvas.add(this.restingImage);
        // canvas.onClick(event -> {
        //     if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
        //     pressed(canvas);
        //     }
        // });
    }
    

    public Image getRestingImage(){
        return restingImage;
    }
    
    // public void pressed(CanvasWindow canvas){
    //     canvas.removeAll();
    //     new Game();
    // }
    
}