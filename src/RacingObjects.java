import java.util.*; 
import edu.macalester.graphics.*;
import java.io.File;



public class RacingObjects {
    Map<String, Track> tracks = new HashMap<String, Track>();
    Map<String, Racer> racers = new HashMap<String, Racer>();
    Map<String, Tire> tires = new HashMap<String, Tire>();
    Map<String, Engine> engines = new HashMap<String, Engine>();


    public RacingObjects(){
        createTracks();
        createRacers();
        createTires();
        createEngines();
    }

    private void createTracks(){
        tracks.put("Suzuka", 
            new Track("Suzuka", new Image("images/TrackBaseImages/suzuka.jpg"), 5, 2, 6, 1));
        tracks.put("Watkins", 
            new Track("Watkins", new Image("images/TrackBaseImages/watkins.jpg"), 30, 30, 10, 1));
        tracks.put("Barcelona", 
            new Track("Barcelona", new Image("images/TrackBaseImages/barcelona.jpg"), 70, 60, 20, 1));
    }

    private void createRacers(){
        racers.put("Max",  new Racer("Max", "images/driver-body1.png", 3, 6));
        racers.put("Lewis", new Racer("Lewis", "images/driver-body2.png", 2, 0));
        racers.put("Yuki",  new Racer("Yuki", "images/driver-body3.png", 4, 24));
    }

    private void createTires(){
        tires.put("Soft", new Tire(
            "Soft",
            new File("res/images/WheelImages/tireSoft"), "images/WheelImages/tireSoft/tireSoft1.png",
            0.0, 0.0, 0.0, 0.0, 0.5, 34, 4));
        tires.put("Medium", new Tire(
            "Medium",
            new File("res/images/WheelImages/tireMedium"), "images/WheelImages/tireMedium/tireMedium1.png",
            0.0, 0.0, 0.0, 0.0, 0.5, 4, 87));
        tires.put("Hard", new Tire(
            "Hard",
            new File("res/images/WheelImages/tireHard"), "images/WheelImages/tireHard/tireHard1.png", 
            0.0, 0.0, 0.0, 0.0, 0.5, 5, 42));
    }

    private void createEngines(){
        engines.put("V6", new Engine("V6", 4, 0, 2));
        engines.put("V10", new Engine("V10", 3, 4, 1));
        engines.put("V12", new Engine("V12", 4, 5, 5));
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
