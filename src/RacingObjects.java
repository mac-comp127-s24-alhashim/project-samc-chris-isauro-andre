import java.util.*; 
import edu.macalester.graphics.*;

/**
 * This object creates and stores all of the Track, Racer, Tire, and Engine objects needed for the game in Maps which can then be
 * accessed using getter methods.
 */
public class RacingObjects {
    private Map<String, Track> tracks = new HashMap<String, Track>();
    private Map<String, Racer> racers = new HashMap<String, Racer>();
    private Map<String, Tire> tires = new HashMap<String, Tire>();
    private Map<String, Engine> engines = new HashMap<String, Engine>();

    /**
     * When the object is created all of the objects and maps are automatically created.
     */
    public RacingObjects(){
        createTracks();
        createRacers();
        createTires();
        createEngines();
    }

    /**
     * Creates all of the tracks. The key String to the Track objects are the same as the trackKey used to create the Track objects.
     */
    private void createTracks(){
        tracks.put("Suzuka", 
            new Track("Suzuka", new Image("images/TrackBaseImages/suzuka.png"), 5, 1000, 1000, 6));
        tracks.put("Watkins", 
            new Track("Watkins", new Image("images/TrackBaseImages/watkins.png"), 30, 30, 10, 1));
        tracks.put("Barcelona", 
            new Track("Barcelona", new Image("images/TrackBaseImages/barcelona.png"), 70, 60, 20, 1));
    }

    /**
     * Creates all of the racers. The key String to the Racer objects are the same as the racerKey used to create the Racer objects.
     */
    private void createRacers(){
        racers.put("Max",  new Racer("Max", "images/driver-body1.png", 5, 0.67));
        racers.put("Lewis", new Racer("Lewis", "images/driver-body2.png", 2, 0));
        racers.put("Yuki",  new Racer("Yuki", "images/driver-body3.png", 4, 24));
    }

    /**
     * Creates all of the tires. The key String to the Tire objects are the same as the tireKey used to create the Tire objects.
     */
    private void createTires(){
        tires.put("Soft", new Tire(
            "Soft",
            "images/WheelImages/tireSoft/tireSoft1.png",
            0.002, 3, 100));
        tires.put("Medium", new Tire(
            "Medium",
            "images/WheelImages/tireMedium/tireMedium1.png",
            0.4, 4, 150));
        tires.put("Hard", new Tire(
            "Hard",
            "images/WheelImages/tireHard/tireHard1.png", 
            0.6, 5, 200));
    }

    /**
     * Creates all of the engines. The key String to the Engine objects are the same as the engineKey used to create the Engine objects.
     */
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
