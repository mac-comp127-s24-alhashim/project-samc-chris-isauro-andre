import edu.macalester.graphics.*;

public class Track {
    Image map;
    double height, width;
    int startingX;
    int startingY;
    double startingAngle;
    
    public Track (Image map, int startingX, int startingY, double startingAngle){
        this.map = map;
        this.width = map.getImageWidth();
        this.height = map.getImageHeight();
        this.startingX = startingX;
        this.startingY = startingY;
        this.startingAngle = startingAngle;
    }

    public int getStartingX(){
        return startingX;
    }

    public int getStartingY(){
        return startingY;
    }

    public double getStartingAngle(){
        return startingAngle;
    }
}
