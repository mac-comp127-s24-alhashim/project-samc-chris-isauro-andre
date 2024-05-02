import edu.macalester.graphics.*;

public class Track {
    private String TRKey;
    private Image map;
    private double startingAngle, zoom;
    
    /**
     * The identification and stats of the track.
     * 
     * @param trackKey          The key of the selected track.
     * @param map               The visual representation of the selected track.
     * @param startingX         The starting horizontal position of the selected track on the canvas.
     * @param startingY         The starting vertical position of the selected track on the canvas.
     * @param startingAngle     The starting angle of thhe selected track.
     * @param zoom              The zoom of the selected trqack in comparison to the canvas window.
     */
    public Track (String trackKey, Image map, double startingX, double startingY, double startingAngle, double zoom){
        TRKey = trackKey;

        this.map = map;
        this.zoom = zoom;
        map.setScale(zoom);
        map.setPosition(startingX, startingY);

        this.startingAngle = startingAngle;
    }

    public Image addMaptoCanvas(CanvasWindow canvas){
        canvas.add(map);
        return map;
    }

    /* Canvas will move specifically based on the conditions below */
    public void moveMap(CanvasWindow canvas, double dtX, double dtY, Car car){
        
        /* Different variables used for easy readability. */       
        double rightBound = (map.getImageWidth() / 2) * (zoom - 1);
        double leftBound = (map.getImageWidth() / 2) * (zoom - 1.5);
        double topBound = (map.getImageHeight() / 2) * (zoom - 1);
        double bottomBound = (map.getImageHeight() / 2) * (zoom - 0.40625);

        /* Car will passively speed down if it collides with any side of the track. */
        if ((map.getX() - dtX) >= rightBound || (map.getY() + dtY) >= topBound) {
            car.setCurrentSpeed(0);         
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }
        else if (-(map.getX() - dtX) >= leftBound || -(map.getY() + dtY) >= bottomBound) {
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
