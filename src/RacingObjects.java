import java.util.*; 
import edu.macalester.graphics.*;
import java.io.File;



public class RacingObjects {
    private Map<String, Track> tracks = new HashMap<String, Track>();
    private Map<String, Racer> racers = new HashMap<String, Racer>();
    private Map<String, Tire> tires = new HashMap<String, Tire>();
    private Map<String, Engine> engines = new HashMap<String, Engine>();


    public RacingObjects(){
        createTracks();
        createRacers();
        createTires();
        createEngines();
    }

    private void createTracks(){
        tracks.put("Suzuka", 
            new Track("Suzuka", new Image("images/TrackBaseImages/suzuka.jpg"), 5, 2, 6, 8));
        tracks.put("Watkins", 
            new Track("Watkins", new Image("images/TrackBaseImages/watkins.jpg"), 30, 30, 10, 1));
        tracks.put("Barcelona", 
            new Track("Barcelona", new Image("images/TrackBaseImages/barcelona.jpg"), 70, 60, 20, 1));
    }

    private void createRacers(){
        racers.put("Max",  new Racer("Max", "images/driver-body1.png", 5, 0.67));
        racers.put("Lewis", new Racer("Lewis", "images/driver-body2.png", 2, 0));
        racers.put("Yuki",  new Racer("Yuki", "images/driver-body3.png", 4, 24));
    }

    private void createTires(){
        tires.put("Soft", new Tire(
            "Soft",
            new File("res/images/WheelImages/tireSoft"), "images/WheelImages/tireSoft/tireSoft1.png",
            0.0, 0.0, 0.002, 0.0, 0.2, 3, 100));
        tires.put("Medium", new Tire(
            "Medium",
            new File("res/images/WheelImages/tireMedium"), "images/WheelImages/tireMedium/tireMedium1.png",
            0.0, 0.0, 0.4, 0.0, 0.4, 4, 100));
        tires.put("Hard", new Tire(
            "Hard",
            new File("res/images/WheelImages/tireHard"), "images/WheelImages/tireHard/tireHard1.png", 
            0.0, 0.0, 0.6, 0.0, 0.4, 5, 100));
    }

    private void createEngines(){
        engines.put("V6", new Engine("V6", 0.57, 32, 1));
        engines.put("V10", new Engine("V10", 0.85, 40, 5));
        engines.put("V12", new Engine("V12", 1.1, 45, 8));
    }

    public Map<String, Track> getTracks() {
        return tracks;
    }

    public Map<String, Racer> getRacers() {
        return racers;
    }

    public Map<String, Tire> getTires() {
        return tires;
    }

    public Map<String, Engine> getEngines() {
        return engines;
    }
    
    
}
