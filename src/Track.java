import edu.macalester.graphics.*;

public class Track {
    Image map;
    double height;
    double width;
    Point startingPoint;
    double startingAngle;
    
    public Track (Image map, Point startingPoint, double startingAngle){
        this.map = map;
        this.width = map.getImageWidth();
        this.height = map.getImageHeight();
        this.startingPoint = startingPoint;
        this.startingAngle = startingAngle;
    }
}
