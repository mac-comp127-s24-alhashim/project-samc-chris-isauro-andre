import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Image;

import java.util.ArrayList;


public class Menu {
    CanvasWindow canvas;
    Track selectedTrack;
    Racer selectedRacer;
    Tyre selectedTires;
    Engine selectedEngine;
    ArrayList<MenuButton> trackButtons, racerButtons, tireButtons, engineButtons;
    MenuButton startButton;
    Image menuBackground;
    double imageScaleFactor;


    public Menu(CanvasWindow canvas){
        this.canvas = canvas;
        setupMenu();
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

    private void setImageScaleFactor(){
        imageScaleFactor = canvas.getWidth()/menuBackground.getImageWidth();
        System.out.println("scaleFactor:" + imageScaleFactor);
    }

    private void createBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        System.out.println(menuBackground.getHeight() + "    " + menuBackground.getWidth());

        setImageScaleFactor();

        menuBackground.setMaxWidth(imageScaleFactor * menuBackground.getWidth());
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

    public Track getSelectedTrack() {
        return selectedTrack;
    }

    public Racer getSelectedRacer() {
        return selectedRacer;
    }

    public Tyre getSelectedTires() {
        return selectedTires;
    }

    public Engine getSelectedEngine() {
        return selectedEngine;
    }
}
