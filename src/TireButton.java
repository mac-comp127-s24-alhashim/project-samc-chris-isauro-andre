import edu.macalester.graphics.*;


public class TireButton implements MenuButton {
    double x, y;
    Image restingImage, pressedImage;
    Tyre tyre;
    CanvasWindow canvas;
    Menu menu;


    public TireButton(Tyre tyre, String restingImage, String pressedImage, 
            double scalefactor, double x, double y, Menu menu, CanvasWindow canvas){
        this.x = x;
        this.y = y;
        this.tyre = tyre;
        this.restingImage = new Image(restingImage);
        this.pressedImage = new Image(pressedImage);
        this.restingImage.setMaxWidth(this.restingImage.getWidth() * scalefactor);
        this.pressedImage.setMaxWidth(this.pressedImage.getWidth() * scalefactor);
        this.restingImage.setPosition(x, y);
        this.pressedImage.setPosition(x, y);
        this.canvas = canvas;
        this.menu = menu;
        canvas.add(this.restingImage);
        canvas.onClick(event -> {
            if (this.restingImage.testHit(event.getPosition().getX(), event.getPosition().getY())){
            this.pressed();
            }
        });
    }

    public void pressed(){
        for (MenuButton button : menu.getTireButtons()){
            if (button == this){
                canvas.add(this.pressedImage);
                menu.setSelectedTires(this.tyre);
            }
            else{
                button.deselected();
            }
        }
        
    }

    public void deselected(){
        canvas.remove(this.pressedImage);
    }
}