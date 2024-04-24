import edu.macalester.graphics.*;

public class Track {
    private String TRKey;
    private Image map;
    private double xBounds, yBounds, startingAngle;
    private double mapPositionX, mapPositionY;
    
    public Track (String trackKey, Image map, double startingX, double startingY, double startingAngle, double zoom){
        TRKey = trackKey;

        this.map = map;
        map.setScale(zoom);
        map.setPosition(new Point(startingX,startingY));

        xBounds = map.getImageWidth();
        yBounds = map.getImageHeight();

        mapPositionX = startingX;
        mapPositionY = startingY;
        this.startingAngle = startingAngle;
    }

    public Image addMaptoCanvas(CanvasWindow canvas){
        canvas.add(map);
        return map;
    }

    public void moveMap(CanvasWindow canvas, double dtX, double dtY){
        map.setPosition(mapPositionX + dtX, mapPositionY + dtY);
    }

    public String getKey(){
        return TRKey;
    }

    public double getStartingX(){
        return mapPositionX;
    }

    public double getStartingY(){
        return mapPositionY;
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
