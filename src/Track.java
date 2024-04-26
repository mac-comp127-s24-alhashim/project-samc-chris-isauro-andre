import edu.macalester.graphics.*;

public class Track {
    private String TRKey;
    private Image map;
    private double xBounds, yBounds, startingAngle;
    
    public Track (String trackKey, Image map, double startingX, double startingY, double startingAngle, double zoom){
        TRKey = trackKey;

        this.map = map;
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

    public void moveMap(CanvasWindow canvas, double dtX, double dtY){
        map.setPosition(map.getX() - dtX, map.getY() + dtY);
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
