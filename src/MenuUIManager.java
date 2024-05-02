import edu.macalester.graphics.*;
import java.util.*; 


/**
 * Starts off by creating three ArrayList<String>s for the within inputStrings. It then runs all of the methods that will create the menu
 * framework and add the buttons. 
 */
public class MenuUIManager {
    private ArrayList<MenuTrackButton> trackButtons = new ArrayList<MenuTrackButton>();
    private ArrayList<MenuRacerButton> racerButtons = new ArrayList<MenuRacerButton>();
    private ArrayList<MenuEngineButton> engineButtons = new ArrayList<MenuEngineButton>();
    private ArrayList<MenuTireButton> tireButtons = new ArrayList<MenuTireButton>();

    private ArrayList<ArrayList<String>> inputStrings = new ArrayList<ArrayList<String>>();
    private ArrayList<String> inputArray;

    private  Map<String, Double> buttonLocations = new HashMap<String, Double>();;

    private RacingObjects racingObjects = new RacingObjects();

    private MenuStartButton startButton;
    private Image menuBackground;

    private double imageScaleFactor;
    private Menu menu;
    private CanvasWindow canvas;

    /**
     * The visual menu manager.
     * 
     * @param menu      The specific menu being observed.
     * @param canvas    Where the following observation will take place.
     */
    public MenuUIManager(Menu menu, CanvasWindow canvas){
        this.canvas = canvas;
        this.menu = menu;
        setupMenuUI();
    }

    /**
     * Runs all of the methods that will create the menu framework, background, and buttons. 
     */
    public void setupMenuUI(){
        for (int i = 0; i < 3; i++){
            inputStrings.add(new ArrayList<String>());
        }
        setupButtonLocations();
        setupBackground();
        setupStartButton();

        setupInputStrings();

        setupTrackButtons();
        setupRacerButtons();
        setupTireButtons();
        setupEngineButtons();
    }

    /**
     * Sets image scale factor by dividing the size of the canvas vs the size of the background. The background will always stay the same 
     * size, but whatever the user might set the size of the canvas to might change, hence the need for this.
     */
    private void setImageScaleFactor(){
        imageScaleFactor = canvas.getWidth()/menuBackground.getImageWidth();
    }

    /**
     * Because the buttons are arranged in a 3x4 grid, I figured that it would be easiest to set up the row and column locations using maps
     * so that I could just reference them later. This method does just that.
     */
    private void setupButtonLocations(){
        buttonLocations.put("column1", canvas.getWidth() * (2.0/320.0));
        buttonLocations.put("column2", canvas.getWidth() * (62.0/320.0));
        buttonLocations.put("column3", canvas.getWidth() * (122.0/320.0));
        buttonLocations.put("column4", canvas.getWidth() * (182.0/320.0));
        buttonLocations.put("row1", canvas.getHeight() * (59.0/180.0));
        buttonLocations.put("row2", canvas.getHeight() * (97.0/180.0));
        buttonLocations.put("row3", canvas.getHeight() * (135.0/180.0));
    }

    /**
     * This method adds three ArrayList<String> to inputStrings so that they are there when the setup(Track/Racer/etc)Buttons methods run so
     * they can put stuff in them.
     */
    private void setupInputStrings(){
        for (int i = 0; i < 3; i++){
            inputStrings.add(new ArrayList<String>());
        }
    }

    /**
     * This method creates the background Image, scales it, positions it, and then adds it to the canvas.
     */
    private void setupBackground(){
        menuBackground = new Image("images/MenuImages/StaticMenu1.png");
        setImageScaleFactor(); //This is here because the next line needs a scale factor and this methods needs the background image.
        menuBackground.setMaxWidth(imageScaleFactor * menuBackground.getWidth());
        menuBackground.setPosition(0, 0);
        canvas.add(menuBackground);
    }

    /**
     * This method creates the start button. Literally just a declaration.
     */
    private void setupStartButton(){ 
        startButton = new MenuStartButton(
            "images/MenuImages/StartButton.png", 
            imageScaleFactor, 
            new Point(canvas.getWidth() * (244.0/320.0), canvas.getHeight() * (109.0/180.0)), 
            menu,
            canvas);
    }

    /**
     * This method helps the setup(Track/Racer/etc)Buttons methods a lot. The array at the place of arrayNumber in inputStrings
     * is modified so that the strings that are input into the method are placed  in the order that they are input. It is 
     * called many times with the same arrayNumber, and each time it overwrites previous arrayNumber array with new values.
     */
    private void inputStringSetup(int arrayNumber, String racingObjectName, 
        String restingImagePath, String pressedImagePath, String columnNumber, String rowNumber){
            inputStrings.get(arrayNumber).add(0, racingObjectName);
            inputStrings.get(arrayNumber).add(1, restingImagePath);
            inputStrings.get(arrayNumber).add(2, pressedImagePath);
            inputStrings.get(arrayNumber).add(3, columnNumber);
            inputStrings.get(arrayNumber).add(4, rowNumber);
    }

    /**
     * This method sets up inputStrings so that its array lists have all of the right values to be put through the for loop at the end of
     * this function. The for loop at the end of this function creates a track button and adds it to the array list of track buttons for
     * each array list of strings in inputStrings.
     */
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
                racingObjects.getTracks().get(inputArray.get(0)), //gets the track
                inputArray.get(1), // gets the filepath for restingImage
                inputArray.get(2), // gets the filepath for pressedImage
                imageScaleFactor, 
                buttonLocations.get(inputArray.get(3)), // gets the column placement
                buttonLocations.get(inputArray.get(4)), // gets the row placement
                this,
                menu, 
                canvas);
            trackButtons.add(trackButton);
        }
    }

    /**
     * This method sets up inputStrings so that its array lists have all of the right values to be put through the for loop at the end of
     * this function. The for loop at the end of this function creates a racer button and adds it to the array list of racer buttons for
     * each array list of strings in inputStrings.
     */
    private void setupRacerButtons(){
        inputStringSetup(0, "Max", "images/MenuImages/Max1.png", 
        "images/MenuImages/Max2.png","column2", "row1");

        inputStringSetup(1, "Lewis", "images/MenuImages/Lewis1.png", 
        "images/MenuImages/Lewis2.png","column2", "row2");
        
        inputStringSetup(2, "Yuki", "images/MenuImages/Yuki1.png", 
        "images/MenuImages/Yuki2.png","column2", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuRacerButton racerButton = new MenuRacerButton( //check setupTrackButtons for how this works
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

    /**
     * This method sets up inputStrings so that its array lists have all of the right values to be put through the for loop at the end of
     * this function. The for loop at the end of this function creates a tire button and adds it to the array list of tire buttons for
     * each array list of strings in inputStrings.
     */
    private void setupTireButtons(){ 
        inputStringSetup(0, "Soft", "images/MenuImages/Soft1.png", 
        "images/MenuImages/Soft2.png", "column3", "row1");

        inputStringSetup(1, "Medium", "images/MenuImages/Medium1.png", 
        "images/MenuImages/Medium2.png","column3", "row2");
        
        inputStringSetup(2, "Hard", "images/MenuImages/Hard1.png", 
        "images/MenuImages/Hard2.png", "column3", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuTireButton tireButton = new MenuTireButton( //check setupTrackButtons for how this works
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

    /**
     * This method sets up inputStrings so that its array lists have all of the right values to be put through the for loop at the end of
     * this function. The for loop at the end of this function creates a engine button and adds it to the array list of engine buttons for
     * each array list of strings in inputStrings.
     */
    private void setupEngineButtons(){ 
        inputStringSetup(0, "V6", "images/MenuImages/VSies1.png", 
        "images/MenuImages/VSies2.png","column4", "row1");
        
        inputStringSetup(1, "V10", "images/MenuImages/VTen1.png", 
        "images/MenuImages/VTen2.png","column4", "row2");
        
        inputStringSetup(2, "V12", "images/MenuImages/VTwelve1.png", 
        "images/MenuImages/VTwelve2.png","column4", "row3");

        for (int i = 0; i < 3; i++){
            inputArray = inputStrings.get(i);
            MenuEngineButton engineButton = new MenuEngineButton( //check setupTrackButtons for how this works
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

    public MenuStartButton getStartButton(){
        return startButton;
    }
    
    public double getImageScaleFactor() {
        return imageScaleFactor;
    }
    
}
