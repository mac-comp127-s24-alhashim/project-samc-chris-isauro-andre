import edu.macalester.graphics.*;

public class MenuStartButton {
    Point location;
    Image restingImage, pressedImage;
    Game game;

    public MenuStartButton(String restingImage, double scalefactor, Point location, Game game, CanvasWindow canvas){
        this.location = location; 
        this.game = game;
        this.restingImage = new Image(restingImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.restingImage.setPosition(location);
        canvas.add(this.restingImage);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            pressed(canvas);
            }
        });
    }
    

    public Image getRestingImage(){
        return restingImage;
    }
    
    public void pressed(CanvasWindow canvas){
        game.prepareGame();
    }
    
}