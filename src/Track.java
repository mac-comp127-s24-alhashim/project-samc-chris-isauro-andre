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

    public void moveMap(CanvasWindow canvas, double dtX, double dtY){
        if ((map.getX() - dtX) >= (map.getImageWidth() / 2) * (zoom - 1)) {
            map.setPosition(map.getX() + dtX, map.getY() + dtY);
        }
        else if (-(map.getX() - dtX) >= (map.getImageWidth() / 2) * (zoom - 1.5)) {
            map.setPosition(map.getX() + dtX, map.getY() + dtY);
        }
        if ((map.getY() + dtY) >= (map.getImageHeight() / 2) * (zoom - 1)) {
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }
        else if (-(map.getY() + dtY) >= (map.getImageHeight() / 2) * (zoom - 0.40625)) {
            map.setPosition(map.getX() + dtX, map.getY() - dtY);
        }
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

    public double getZoom() {
        return zoom;
    }
}
