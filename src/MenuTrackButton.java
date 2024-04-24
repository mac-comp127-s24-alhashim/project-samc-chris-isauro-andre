import edu.macalester.graphics.*;


public class MenuTrackButton implements MenuButton {
    private Image restingImage, pressedImage;
    private Track track;
    private CanvasWindow canvas;
    private MenuButtonManager buttonManager;
    private Menu menu;
    private boolean selected;


    public MenuTrackButton(Track track, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, MenuButtonManager buttonManager, Menu menu, CanvasWindow canvas){
        this.track = track;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        canvas.add(this.restingImage);
        this.buttonManager = buttonManager;
        this.menu = menu;
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuTrackButton button : buttonManager.getTrackButtons()){
            if (button == this){
                selected = true;
                canvas.add(pressedImage);
                menu.setSelectedTrack(track);
            }
            else{
                if (button.getSelectedBool() == true){
                    button.deselected();
                }
            }
        }
        
    }

    public void deselected(){
        canvas.remove(pressedImage);
        selected = false;
    }

    public boolean getSelectedBool(){
        return selected;
    }
}