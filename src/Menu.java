import edu.macalester.graphics.*;
import java.io.File;

import java.util.*; 



public class Menu {
    CanvasWindow canvas;
    Track selectedTrack;
    Racer selectedRacer;
    Tyre selectedTires;
    Engine selectedEngine;
    ArrayList<MenuButton> trackButtons = new ArrayList<MenuButton>(); 
    ArrayList<MenuButton> racerButtons = new ArrayList<MenuButton>(); 
    ArrayList<MenuButton> tireButtons = new ArrayList<MenuButton>(); 
    ArrayList<MenuButton> engineButtons = new ArrayList<MenuButton>();
    MenuButton startButton;
    Image menuBackground;
    double imageScaleFactor;
    Map<String, Double> buttonLocations = new HashMap<String, Double>();;
    Point startButtonLocation;


    public Menu(CanvasWindow canvas){
        this.canvas = canvas;
        setupMenu();
    }

    private void setupMenu(){
        setupButtonLocations();
        setupBackground();
        setupStartButton();
        setupTrackButtons();
        setupRacerButtons();
        setupTireButtons();
        setupTrackButtons();
        setupEngineButtons();
        setupDefaultSelected();
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
            canvas);
        trackButtons.add(track3Button);
    }

    private void setupRacerButtons(){
        RacerButton racer1Button = new RacerButton(
            new Racer(new Image("images/driver-body1.png"), 3, 6), 
            "images/MenuImages/Max1.png", 
            "images/MenuImages/Max2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row1"), 
            this,
            canvas);
        racerButtons.add(racer1Button);

        RacerButton racer2Button = new RacerButton(
            new Racer(new Image("images/driver-body2.png"), 2, 0), 
            "images/MenuImages/Lewis1.png", 
            "images/MenuImages/Lewis2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row2"),  
            this,
            canvas);
        racerButtons.add(racer2Button);

        RacerButton racer3Button = new RacerButton(
            new Racer(new Image("images/driver-body3.png"), 4, 24), 
            "images/MenuImages/Yuki1.png", 
            "images/MenuImages/Yuki2.png", 
            imageScaleFactor,  
            buttonLocations.get("column2"), 
            buttonLocations.get("row3"),   
            this,
            canvas);
        racerButtons.add(racer3Button);
    }

    private void setupTireButtons(){ 
        TireButton tire1Button = new TireButton(
            new Tyre(new File("res/images/WheelImages/tireSoft"), 0.0, 0.0, 0.0, 0.0, 34, 4), 
            "images/MenuImages/Soft1.png", 
            "images/MenuImages/Soft2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row1"),   
            this,
            canvas);
        tireButtons.add(tire1Button);

        TireButton tire2Button = new TireButton(
            new Tyre(new File("res/images/WheelImages/tireMedium"), 0.0, 0.0, 0.0, 0.0, 4, 87), 
            "images/MenuImages/Medium1.png", 
            "images/MenuImages/Medium2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row2"),   
            this,
            canvas);
        tireButtons.add(tire2Button);

        TireButton tire3Button = new TireButton(
            new Tyre(new File("res/images/WheelImages/tireHard"), 0.0, 0.0, 0.0, 0.0, 32, 5), 
            "images/MenuImages/Hard1.png", 
            "images/MenuImages/Hard2.png", 
            imageScaleFactor,  
            buttonLocations.get("column3"), 
            buttonLocations.get("row3"),   
            this,
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
            canvas);
        engineButtons.add(engine3Button);
    }

    private void setupDefaultSelected(){
        trackButtons.get(0).pressed();
        racerButtons.get(0).pressed();
        tireButtons.get(0).pressed();
        engineButtons.get(0).pressed();
        setPreviewCar();
    }

    public void setPreviewCar(){
        selectedRacer.getRacerCar();

    }

    public void setPreviewTire(){
        selectedRacer.getRacerCar();
    }

    public Track getSelectedTrack() {
        return selectedTrack;
    }

    public void setSelectedTrack(Track selectedTrack) {
        this.selectedTrack = selectedTrack;
    }

    public Racer getSelectedRacer() {
        return selectedRacer;
    }

    public void setSelectedRacer(Racer selectedRacer) {
        this.selectedRacer = selectedRacer;
    }

    public Tyre getSelectedTires() {
        return selectedTires;
    }

    public void setSelectedTires(Tyre selectedTires) {
        this.selectedTires = selectedTires;
    }

    public Engine getSelectedEngine() {
        return selectedEngine;
    }

    public void setSelectedEngine(Engine selectedEngine) {
        this.selectedEngine = selectedEngine;
    }
    
    public ArrayList<MenuButton> getTrackButtons() {
        return trackButtons;
    }

    public ArrayList<MenuButton> getRacerButtons() {
        return racerButtons;
    }

    public ArrayList<MenuButton> getTireButtons() {
        return tireButtons;
    }

    public ArrayList<MenuButton> getEngineButtons() {
        return engineButtons;
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("MenuTester", 1280, 720);
        new Menu(canvas);
    }
}
