import edu.macalester.graphics.*;

public class Track {
    private String TRKey;
    private Image map;
    private double xBounds, yBounds, startingAngle, zoom;
    
    public Track (String trackKey, Image map, double startingX, double startingY, double startingAngle, double zoom){
        TRKey = trackKey;

        this.map = map;
        this.zoom = zoom;
        map.setScale(zoom);
        map.setPosition(startingX, startingY);

        xBounds = map.getImageWidth();
        yBounds = map.getImageHeight();

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
            car.speedDown();           
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }
        else if (-(map.getX() - dtX) >= leftBound || -(map.getY() + dtY) >= bottomBound) {
            car.speedDown();           
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }

        /* Car will passively stop if it collides with any corner of the track. */
        if ((map.getX() - dtX) >= rightBound && (map.getY() + dtY) >= topBound) {
            car.speedDown();
            map.setPosition((map.getX() + dtX), (map.getY() - dtY));
        }
        else if ((map.getX() - dtX) >= rightBound && -(map.getY() + dtY) >= bottomBound) {
            car.speedDown();
            map.setPosition((map.getX() + dtX), (map.getY() - dtY));
        }
        if (-(map.getX() - dtX) >= leftBound && (map.getY() + dtY) >= topBound) {
            car.speedDown();
            map.setPosition((map.getX() + dtX), (map.getY() - dtY));
        } 
        else if (-(map.getX() - dtX) >= leftBound && -(map.getY() + dtY) >= bottomBound) {
            car.speedDown();
            map.setPosition((map.getX() + dtX), (map.getY() - dtY));
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

    public double getXBounds(){
        return xBounds;
    }

    public double getYBounds(){
        return yBounds;
    }

    public double getStartingAngle(){
        return startingAngle;
    }
}
