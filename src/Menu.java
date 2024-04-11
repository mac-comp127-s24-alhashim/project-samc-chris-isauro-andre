import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

import java.util.ArrayList;


public class Menu {
    CanvasWindow canvas;
    ArrayList<MenuButton> trackButtons;
    ArrayList<MenuButton> racerButtons;
    ArrayList<MenuButton> tireButtons;
    ArrayList<MenuButton> engineButtons;
    MenuButton startButton;
    Image menuBackground;
    double imageScaleFactor;


    public Menu(CanvasWindow canvas){
        this.canvas = canvas;
        setupMenu();
    }

    private void setImageScaleFactor(){
        imageScaleFactor = canvas.getWidth()/menuBackground.getImageWidth();
        System.out.println("scaleFactor:" + imageScaleFactor);
    }

    private void setupMenu(){
        createBackground();
        createStartButton();
        createTrackButtons();
        createRacerButtons();
        createTireButtons();
        createTrackButtons();
        createEngineButtons();
    }

    private void createBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        System.out.println(menuBackground.getHeight() + "    " + menuBackground.getWidth());
        setImageScaleFactor();
        menuBackground.setScale(imageScaleFactor);
        System.out.println(menuBackground.getHeight() + "    " + menuBackground.getWidth());
        menuBackground.setPosition(0, 0);
        canvas.add(menuBackground);
        
    }

    private void createStartButton(){

    }

    private void createTrackButtons(){

    }

    private void createRacerButtons(){

    }

    private void createTireButtons(){
        
    }

    private void createEngineButtons(){
        
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("MenuTester", 1600, 900);
        Menu menu = new Menu(canvas);
    }

}
