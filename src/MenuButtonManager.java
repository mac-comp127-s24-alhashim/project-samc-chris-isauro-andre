import edu.macalester.graphics.*;
import java.util.*; 

public class MenuButtonManager {
    ArrayList<MenuTrackButton> trackButtons = new ArrayList<MenuTrackButton>();
    ArrayList<MenuRacerButton> racerButtons = new ArrayList<MenuRacerButton>();
    ArrayList<MenuEngineButton> engineButtons = new ArrayList<MenuEngineButton>();
    ArrayList<MenuTireButton> tireButtons = new ArrayList<MenuTireButton>();

    ArrayList<ArrayList<String>> inputStrings = new ArrayList<ArrayList<String>>();
    ArrayList<String> inputArray;

    Map<String, Double> buttonLocations = new HashMap<String, Double>();;

    RacingObjects racingObjects = new RacingObjects();

    MenuStartButton startButton;
    Image menuBackground;

    double imageScaleFactor;
    Menu menu;
    CanvasWindow canvas;

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
    }

    private void setupBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        setImageScaleFactor();
        menuBackground.setMaxWidth(imageScaleFactor * menuBackground.getWidth());
        menuBackground.setPosition(0, 0);
        canvas.add(menuBackground);
    }

    private void setupStartButton(){ 
        startButton = new MenuStartButton(
            "images/MenuImages/StartButton.png", 
            imageScaleFactor, 
            new Point(canvas.getWidth() * (244.0/320.0), canvas.getHeight() * (109.0/180.0)), 
            canvas);
    }

    private void inputStringSetup(int arrayNumber, String racingObjectName, 
        String restingImagePath, String pressedImagePath, String columnNumber, String rowNumber){
            inputStrings.get(arrayNumber).add(0, racingObjectName);
            inputStrings.get(arrayNumber).add(1, restingImagePath);
            inputStrings.get(arrayNumber).add(2, pressedImagePath);
            inputStrings.get(arrayNumber).add(3, columnNumber);
            inputStrings.get(arrayNumber).add(4, rowNumber);
    }

    private void setupTrackButtons(){
        inputStringSetup(0, "Suzuka", "images/MenuImages/Suzuka1.png", 
        "images/MenuImages/Suzuka2.png","column1", "row1");

        inputStringSetup(1, "Watkins", "images/MenuImages/Watkins1.png", 
        "images/MenuImages/Watkins2.png","column1", "row2");
        
        inputStringSetup(2, "Barcelona", "images/MenuImages/Barcelona1.png", 
        "images/MenuImages/Barcelona2.png","column1", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuTrackButton trackButton = new MenuTrackButton(
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
    }

    private void setupRacerButtons(){
        inputStringSetup(0, "Max", "images/MenuImages/Max1.png", 
        "images/MenuImages/Max2.png","column2", "row1");

        inputStringSetup(1, "Lewis", "images/MenuImages/Lewis1.png", 
        "images/MenuImages/Lewis2.png","column2", "row2");
        
        inputStringSetup(2, "Yuki", "images/MenuImages/Yuki1.png", 
        "images/MenuImages/Yuki2.png","column2", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuRacerButton racerButton = new MenuRacerButton(
                racingObjects.getRacers().get(inputArray.get(0)), 
                inputArray.get(1), 
                inputArray.get(2), 
                imageScaleFactor,  
                buttonLocations.get(inputArray.get(3)), 
                buttonLocations.get(inputArray.get(4)), 
                this,
                menu,
                canvas);
            racerButtons.add(racerButton);
        }
    }

    private void setupTireButtons(){ 
        inputStringSetup(0, "Soft", "images/MenuImages/Soft1.png", 
        "images/MenuImages/Soft2.png", "column3", "row1");

        inputStringSetup(1, "Medium", "images/MenuImages/Medium1.png", 
        "images/MenuImages/Medium2.png","column3", "row2");
        
        inputStringSetup(2, "Hard", "images/MenuImages/Hard1.png", 
        "images/MenuImages/Hard2.png", "column3", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuTireButton tireButton = new MenuTireButton(
                racingObjects.getTires().get(inputArray.get(0)), 
                inputArray.get(1), 
                inputArray.get(2), 
                imageScaleFactor,  
                buttonLocations.get(inputArray.get(3)), 
                buttonLocations.get(inputArray.get(4)),   
                this,
                menu,
                canvas);
            tireButtons.add(tireButton);
        }
    }

    private void setupEngineButtons(){ 
        inputStringSetup(0, "V6", "images/MenuImages/VSies1.png", 
        "images/MenuImages/VSies2.png","column4", "row1");
        
        inputStringSetup(1, "V10", "images/MenuImages/VTen1.png", 
        "images/MenuImages/VTen2.png","column4", "row2");
        
        inputStringSetup(2, "V12", "images/MenuImages/VTwelve1.png", 
        "images/MenuImages/VTwelve2.png","column4", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuEngineButton engineButton = new MenuEngineButton(
                racingObjects.getEngines().get(inputArray.get(0)), 
                inputArray.get(1), 
                inputArray.get(2), 
                imageScaleFactor,  
                buttonLocations.get(inputArray.get(3)), 
                buttonLocations.get(inputArray.get(4)),   
                this,
                menu,
                canvas);
            engineButtons.add(engineButton);
        }
    }

    public ArrayList<MenuTrackButton> getTrackButtons() {
        return trackButtons;
    }

    public ArrayList<MenuRacerButton> getRacerButtons() {
        return racerButtons;
    }

    public ArrayList<MenuTireButton> getTireButtons() {
        return tireButtons;
    }

    public ArrayList<MenuEngineButton> getEngineButtons() {
        return engineButtons;
    }

    public double getImageScaleFactor() {
        return imageScaleFactor;
    }
    
}
