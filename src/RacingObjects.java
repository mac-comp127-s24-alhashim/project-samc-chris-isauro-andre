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
            new Track(new Image("images/TrackBaseImages/suzuka.jpg"), 5, 2, 6));
        tracks.put("Watkins", 
            new Track(new Image("images/TrackBaseImages/watkins.jpg"), 30, 30, 10));
        tracks.put("Barcelona", 
            new Track(new Image("images/TrackBaseImages/barcelona.jpg"), 70, 60, 20));
    }

    private void createRacers(){
        racers.put("Max",  new Racer("images/driver-body1.png", 3, 6));
        racers.put("Lewis", new Racer("images/driver-body2.png", 2, 0));
        racers.put("Yuki",  new Racer("images/driver-body3.png", 4, 24));
    }

    private void createTires(){
        tires.put("Soft", new Tire (
            new File("res/images/WheelImages/tireSoft"), "images/WheelImages/tireSoft/tireSoft1.png",
            0.0, 0.0, 0.0, 0.0, 0.5, 34, 4));
        tires.put("Medium", new Tire(
            new File("res/images/WheelImages/tireMedium"), "images/WheelImages/tireMedium/tireMedium1.png",
            0.0, 0.0, 0.0, 0.0, 0.5, 4, 87));
        tires.put("Hard", new Tire(
            new File("res/images/WheelImages/tireHard"), "images/WheelImages/tireHard/tireHard1.png", 
            0.0, 0.0, 0.0, 0.0, 0.5, 5, 42));
    }

    private void createEngines(){
        engines.put("V6", new Engine(4, 0, 2));
        engines.put("V10", new Engine(3, 4, 1));
        engines.put("V12", new Engine(4, 5, 5));
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
