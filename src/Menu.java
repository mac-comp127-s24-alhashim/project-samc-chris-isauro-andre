import edu.macalester.graphics.*;
import edu.macalester.graphics.ui.Button;

import java.util.*; 



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
    Map<String, Point> buttonLocations;


    public Menu(CanvasWindow canvas){
        this.canvas = canvas;
        setupMenu();
    }

    private void setupMenu(){
        setupBackground();
        setupButtonLocations();
        setupStartButton();
        setupTrackButtons();
        setupRacerButtons();
        setupTireButtons();
        setupTrackButtons();
        setupEngineButtons();
    }

    private void setImageScaleFactor(){
        imageScaleFactor = canvas.getWidth()/menuBackground.getImageWidth();
        System.out.println("scaleFactor:" + imageScaleFactor);  
    }

    private void setupButtonLocations(){
        
    }

    private void setupBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        setImageScaleFactor();
        menuBackground.setMaxWidth(imageScaleFactor * menuBackground.getWidth());
        menuBackground.setPosition(0, 0);
        canvas.add(menuBackground);
    }

    private void setupStartButton(){ 
        Button startButton = new Button("Start");
        startButton.setPosition(canvas.getWidth()*6/7, canvas.getHeight()*5/7);
        startButton.setScale(3);
        canvas.add(startButton);
    }

    private void setupTrackButtons(){ 
        TrackButton track1Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/suzuka.jpg"), 0, 0, 0), 
            "images/MenuImages/Suzuka1.jpg", 
            "images/MenuImages/Suzuka2.jpg", 
            0, 
            0, 
            canvas);
        trackButtons.add(track1Button);
        TrackButton track2Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/watkins.jpg"), 0, 0, 0), 
            "images/MenuImages/Watkins1.jpg", 
            "images/MenuImages/Watkins2.jpg", 
            0, 
            0, 
            canvas);
        trackButtons.add(track2Button);
        TrackButton track3Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/barcelona.jpg"), 0, 0, 0), 
            "images/MenuImages/Barcelona1.jpg", 
            "images/MenuImages/Barcelona2.jpg", 
            0, 
            0, 
            canvas);
        trackButtons.add(track3Button);
    }

    private void setupRacerButtons(){
        RacerButton racer1Button = new RacerButton(
            new Racer(new Image("images/driver-body1.png"), 0, 0), 
            "images/MenuImages/Suzuka1.jpg", 
            "images/MenuImages/Suzuka2.jpg", 
            0, 
            0, 
            canvas);
        racerButtons.add(racer1Button);

        Button racer2Button = new Button("Racer 2");
        racer2Button.setPosition(canvas.getWidth()/4, canvas.getHeight()*3/5);
        canvas.add(racer2Button);

        Button racer3Button = new Button("Racer 3");
        racer3Button.setPosition(canvas.getWidth()/4, canvas.getHeight()*4/5);
        canvas.add(racer3Button);
    }

    private void setupTireButtons(){ 
        Button softButton = new Button("Soft");
        softButton.setPosition(canvas.getWidth()*5/11, canvas.getHeight()*2/5);
        canvas.add(softButton);

        Button mediumButton = new Button("Medium");
        mediumButton.setPosition(canvas.getWidth()*5/11, canvas.getHeight()*3/5);
        canvas.add(mediumButton);

        Button hardButton = new Button("Hard");
        hardButton.setPosition(canvas.getWidth()*5/11, canvas.getHeight()*4/5);
        canvas.add(hardButton);
    }

    private void setupEngineButtons(){ 
        Button engine1Button = new Button("Engine 1");
        engine1Button.setPosition(canvas.getWidth()*7/11, canvas.getHeight()*2/5);
        canvas.add(engine1Button);

        Button engine2Button = new Button("Engine 2");
        engine2Button.setPosition(canvas.getWidth()*7/11, canvas.getHeight()*3/5);
        canvas.add(engine2Button);

        Button engine3Button = new Button("Engine 3");
        engine3Button.setPosition(canvas.getWidth()*7/11, canvas.getHeight()*4/5);
        canvas.add(engine3Button);
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
