import edu.macalester.graphics.*;

import java.util.*; 

public class MenuButtonManager {
    ArrayList<TrackButton> trackButtons = new ArrayList<TrackButton>(); 
    ArrayList<RacerButton> racerButtons = new ArrayList<RacerButton>(); 
    ArrayList<TireButton> tireButtons = new ArrayList<TireButton>(); 
    ArrayList<EngineButton> engineButtons = new ArrayList<EngineButton>();
    MenuButton startButton;
    CanvasWindow canvas;
    double imageScaleFactor;
    Map<String, Double> buttonLocations = new HashMap<String, Double>();;
    Point startButtonLocation;
    Image menuBackground;
    Menu menu;


    public MenuButtonManager(Menu menu, CanvasWindow canvas){
        setupMenuButtons();
    }

    private void setupMenuButtons(){
        setupButtonLocations();
        setupBackground();
        setupStartButton();
        setupTrackButtons();
        setupRacerButtons();
        setupTireButtons();
        setupTrackButtons();
        setupEngineButtons();
    }

private void setImageScaleFactor(){
        imageScaleFactor = canvas.getWidth()/menuBackground.getImageWidth();
    }

    private void setupButtonLocations(){
        buttonLocations.put("column1", canvas.getWidth() * (2.0/320.0));
        buttonLocations.put("column2", canvas.getWidth() * (62.0/320.0));
        buttonLocations.put("column3", canvas.getWidth() * (122.0/320.0));
        buttonLocations.put("column4", canvas.getWidth() * (182.0/320.0));
        buttonLocations.put("row1", canvas.getHeight() * (59.0/180.0));
        buttonLocations.put("row2", canvas.getHeight() * (97.0/180.0));
        buttonLocations.put("row3", canvas.getHeight() * (135.0/180.0));
        System.out.println("column3: " + buttonLocations.get("column3"));
        startButtonLocation = new Point(
            canvas.getWidth() * (244.0/320.0), 
            canvas.getHeight() * (109.0/180.0)
            );
    }

    private void setupBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        setImageScaleFactor();
        menuBackground.setMaxWidth(imageScaleFactor * menuBackground.getWidth());
        menuBackground.setPosition(0, 0);
        canvas.add(menuBackground);
    }

    private void setupStartButton(){ 
        new StartButton("images/MenuImages/StartButton.png", imageScaleFactor, startButtonLocation, canvas);
    }

    private void setupTrackButtons(){ 
        TrackButton track1Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/suzuka.jpg"), 5, 2, 6), 
            "images/MenuImages/Suzuka1.png", 
            "images/MenuImages/Suzuka2.png",
            imageScaleFactor,  
            buttonLocations.get("column1"), 
            buttonLocations.get("row1"),
            this,
            menu, 
            canvas);
        trackButtons.add(track1Button);
        TrackButton track2Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/watkins.jpg"), 30, 30, 10), 
            "images/MenuImages/Watkins1.png", 
            "images/MenuImages/Watkins2.png", 
            imageScaleFactor,  
            buttonLocations.get("column1"), 
            buttonLocations.get("row2"),
            this,
            menu,
            canvas);
        trackButtons.add(track2Button);
        TrackButton track3Button = new TrackButton(
            new Track(new Image("images/TrackBaseImages/barcelona.jpg"), 70, 60, 20), 
            "images/MenuImages/Barcelona1.png", 
            "images/MenuImages/Barcelona2.png", 
            imageScaleFactor,  
            buttonLocations.get("column1"), 
            buttonLocations.get("row3"), 
            this,
            menu,
            canvas);
        trackButtons.add(track3Button);
    }

    private void setupRacerButtons(){
        RacerButton racer1Button = new RacerButton(
            new Racer("images/driver-body2.png", 3, 6), 
            "images/MenuImages/Max1.png", 
            "images/MenuImages/Max2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row1"), 
            this,
            menu,
            canvas);
        racerButtons.add(racer1Button);

        RacerButton racer2Button = new RacerButton(
            new Racer("images/driver-body1.png", 2, 0), 
            "images/MenuImages/Lewis1.png", 
            "images/MenuImages/Lewis2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row2"),  
            this,
            menu,
            canvas);
        racerButtons.add(racer2Button);

        RacerButton racer3Button = new RacerButton(
            new Racer("images/driver-body3.png", 4, 24), 
            "images/MenuImages/Yuki1.png", 
            "images/MenuImages/Yuki2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row3"),   
            this,
            menu,
            canvas);
        racerButtons.add(racer3Button);
    }

    private void setupTireButtons(){ 
        TireButton tire1Button = new TireButton(
            new Tire("images/WheelImages/tireSoft/tireSoft1.png", 
                0.0, 0.0, 0.0, 0.0, 34, 4), 
            "images/MenuImages/Soft1.png", 
            "images/MenuImages/Soft2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row1"),   
            this,
            menu,
            canvas);
        tireButtons.add(tire1Button);

        TireButton tire2Button = new TireButton(
            new Tire("images/WheelImages/tireMedium/tireMedium1.png",
                0.0, 0.0, 0.0, 0.0, 4, 87), 
            "images/MenuImages/Medium1.png", 
            "images/MenuImages/Medium2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row2"),   
            this,
            menu,
            canvas);
        tireButtons.add(tire2Button);

        TireButton tire3Button = new TireButton(
            new Tire("images/WheelImages/tireHard/tireHard1.png", 
                0.0, 0.0, 0.0, 0.0, 32, 5), 
            "images/MenuImages/Hard1.png", 
            "images/MenuImages/Hard2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row3"),   
            this,
            menu,
            canvas);
        tireButtons.add(tire3Button);
    }

    private void setupEngineButtons(){ 
        EngineButton engine1Button = new EngineButton(
            new Engine(4, 0, 2), 
            "images/MenuImages/VSies1.png", 
            "images/MenuImages/VSies2.png", 
            imageScaleFactor,  
            buttonLocations.get("column4"), 
            buttonLocations.get("row1"),   
            this,
            menu,
            canvas);
        engineButtons.add(engine1Button);

        EngineButton engine2Button = new EngineButton(
            new Engine(3, 4, 1), 
            "images/MenuImages/VTen1.png", 
            "images/MenuImages/VTen2.png", 
            imageScaleFactor,  
            buttonLocations.get("column4"), 
            buttonLocations.get("row2"),   
            this,
            menu,
            canvas);
        engineButtons.add(engine2Button);

        EngineButton engine3Button = new EngineButton(
            new Engine(4, 5, 5), 
            "images/MenuImages/VTwelve1.png", 
            "images/MenuImages/VTwelve2.png", 
            imageScaleFactor,  
            buttonLocations.get("column4"), 
            buttonLocations.get("row3"), 
            this,
            menu,
            canvas);
        engineButtons.add(engine3Button);
    }

    public ArrayList<TrackButton> getTrackButtons() {
        return trackButtons;
    }

    public ArrayList<RacerButton> getRacerButtons() {
        return racerButtons;
    }

    public ArrayList<TireButton> getTireButtons() {
        return tireButtons;
    }

    public ArrayList<EngineButton> getEngineButtons() {
        return engineButtons;
    }

    public double getImageScaleFactor() {
        return imageScaleFactor;
    }
    
}
