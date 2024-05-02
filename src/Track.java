import edu.macalester.graphics.*;

public class Track {
    private String TRKey;
    private Image map;
    private double startingAngle, zoom;
    
    /**
     * This class is to create unique Track objects that is put in the menu for different Track objects with differing
     * attributes be selected in the menu. The class is mainly responsible for the creation of the race track where the
     * car is driving. It possess behaviors that reflects the car's movement in the canvas.
     * 
     * @param trackKey  a key string in a map to match a Track object with unique attributes
     * @param map       file path to the map image
     * @param startingX initial x coordinate of where the map is on the canvas
     * @param startingY initial y coordinate of where the map is on the canvas
     * @param startingAngle initial angle that the car is placed.
     * @param zoom      how big the map is relative to the car.
     */
    public Track (String trackKey, Image map, double startingX, double startingY, double startingAngle, double zoom){
        TRKey = trackKey;

        this.map = map;
        this.zoom = zoom;
        map.setScale(zoom);
        map.setPosition(startingX, startingY);

        this.startingAngle = startingAngle;
    }

    /**
     * add the map image to the canvas.
     * 
     * @param canvas where the image is added to
     * @return
     */

    public Image addMaptoCanvas(CanvasWindow canvas){
        canvas.add(map);
        return map;
    }

    /** Canvas will move specifically based on the conditions below 
     * 
     * @param dtX how much the map moves by in the x direction
     * @param dtY how much the map moves by in the y direction
     * @param car the car that is manipulated when it goes out of bounds
     */
    
    public void moveMap(double dtX, double dtY, Car car){
        
        /* Different variables used for easy readability. */       
        double leftBound = (map.getImageWidth() / 2) * (zoom - 1);
        double rightBound = ((map.getImageWidth() / 2) * (zoom - 1.5)) * 1.3;
        double topBound = (map.getImageHeight() / 2) * (zoom - 1);
        double bottomBound = (map.getImageHeight() / 2) * (zoom - 0.40625);

        /* Car will passively speed down if it collides with any side of the track. */
        if ((map.getX() - dtX) >= leftBound || (map.getY() + dtY) >= topBound) {
            car.setCurrentSpeed(0);         
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }
        else if (-(map.getX() - dtX) >= rightBound || -(map.getY() + dtY) >= bottomBound) {
            car.setCurrentSpeed(0);         
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }

        /* If none of the prior conditions are met, car moves normally. */
        map.setPosition((map.getX() - dtX), (map.getY() + dtY));
    }

    public String getKey(){
        return TRKey;
    }

    public Image getMap(){
        return map;
    }

    public double getStartingAngle(){
        return startingAngle;
    }
}
