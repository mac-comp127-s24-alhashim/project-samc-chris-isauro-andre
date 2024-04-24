import edu.macalester.graphics.*;

public class MenuStartButton {
    private Image restingImage;
    private Game game;

    public MenuStartButton(String restingImage, double scalefactor, Point location, Game game, Menu menu, CanvasWindow canvas){
        this.game = game;
        this.restingImage = new Image(restingImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.restingImage.setPosition(location);
        canvas.add(this.restingImage);
        canvas.onClick(event -> {
            if (menu.getIfMenuOpen()){
                if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
                    this.pressed();
                }
            }
        });
    }
    

    public Image getRestingImage(){
        return restingImage;
    }
    
    public void pressed(){
        game.prepareGame();
    }
    
}