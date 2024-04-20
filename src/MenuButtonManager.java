import edu.macalester.graphics.*;
import java.util.*; 

public class MenuButtonManager {
    ArrayList<TrackButton> trackButtons = new ArrayList<TrackButton>();
    ArrayList<RacerButton> racerButtons = new ArrayList<RacerButton>();
    ArrayList<EngineButton> engineButtons = new ArrayList<EngineButton>();
    ArrayList<TireButton> tireButtons = new ArrayList<TireButton>();
    MenuButton startButton;
    CanvasWindow canvas;
    double imageScaleFactor;
    Map<String, Double> buttonLocations = new HashMap<String, Double>();;
    Point startButtonLocation;
    Image menuBackground;
    Menu menu;
    RacingObjects racingObjects = new RacingObjects();
    ArrayList<ArrayList<String>> inputStrings = new ArrayList<ArrayList<String>>();



    public MenuButtonManager(Menu menu, CanvasWindow canvas){
        this.canvas = canvas;
        this.menu = menu;
        setupMenuButtons();
    }

    public void setupMenuButtons(){
        for (int i = 0; i < 3; i++){
            inputStrings.add(new ArrayList<String>());
        }
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

    private void inputStringSetup(int arrayNumber, String racerObjectName, 
        String restingImagePath, String pressedImagePath, String columnNumber, String rowNumber){
            inputStrings.get(arrayNumber).add(racerObjectName);
            inputStrings.get(arrayNumber).add(restingImagePath);
            inputStrings.get(arrayNumber).add(pressedImagePath);
            inputStrings.get(arrayNumber).add(columnNumber);
            inputStrings.get(arrayNumber).add(rowNumber);

    }

    private void setupTrackButtons(){
        inputStringSetup(0, "Suzuka", 
        "images/MenuImages/Suzuka1.png", 
        "images/MenuImages/Suzuka2.png",
        "column1", "row1");

        inputStringSetup(1, "Watkins", 
        "images/MenuImages/Watkins1.png", 
        "images/MenuImages/Watkins2.png",
        "column1", "row2");
        
        inputStringSetup(2, "Barcelona", 
        "images/MenuImages/Barcelona1.png", 
        "images/MenuImages/Barcelona2.png",
        "column1", "row3");

        for (ArrayList<String> inputArray : inputStrings){
            TrackButton trackButton = new TrackButton(
            racingObjects.getTracks().get(inputArray.get(0)), 
            inputArray.get(1), 
            inputArray.get(2),
            imageScaleFactor,
            buttonLocations.get(inputArray.get(3)), 
            buttonLocations.get(inputArray.get(4)),
            this,
            menu, 
            canvas);
            trackButtons.add(trackButton);
        }

        // TrackButton track1Button = new TrackButton(
        //     racingObjects.getTracks().get("Suzuka"), 
        //     "images/MenuImages/Suzuka1.png", 
        //     "images/MenuImages/Suzuka2.png",
        //     imageScaleFactor,  
        //     buttonLocations.get("column1"), 
        //     buttonLocations.get("row1"),
        //     this,
        //     menu, 
        //     canvas);
        // trackButtons.add(track1Button);
        // TrackButton track2Button = new TrackButton(
        //     racingObjects.getTracks().get("Watkins"), 
        //     "images/MenuImages/Watkins1.png", 
        //     "images/MenuImages/Watkins2.png", 
        //     imageScaleFactor,  
        //     buttonLocations.get("column1"), 
        //     buttonLocations.get("row2"),
        //     this,
        //     menu,
        //     canvas);
        // trackButtons.add(track2Button);
        // TrackButton track3Button = new TrackButton(
        //     racingObjects.getTracks().get("Barcelona"), 
        //     "images/MenuImages/Barcelona1.png", 
        //     "images/MenuImages/Barcelona2.png", 
        //     imageScaleFactor,  
        //     buttonLocations.get("column1"), 
        //     buttonLocations.get("row3"), 
        //     this,
        //     menu,
        //     canvas);
        // trackButtons.add(track3Button);
    }

    private void setupRacerButtons(){
        RacerButton racer1Button = new RacerButton(
            racingObjects.getRacers().get("Max"), 
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
            racingObjects.getRacers().get("Lewis"), 
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
            racingObjects.getRacers().get("Yuki"), 
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
            racingObjects.getTires().get("Soft"), 
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
            racingObjects.getTires().get("Medium"), 
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
            racingObjects.getTires().get("Hard"), 
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
            racingObjects.getEngines().get("V6"), 
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
            racingObjects.getEngines().get("V10"), 
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
            racingObjects.getEngines().get("V12"), 
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
