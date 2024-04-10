import java.util.ArrayList;

import edu.macalester.graphics.*;

public class Racer {
    String name;
    int weight, brakepower;
    Image carBody;
    ArrayList<Image> wheelImages;
    
    public Racer(String name, int weight, int brakepower){

    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public int getBrakepower(){
        return brakepower;
    }

    public Image getCarBody(){
        return carBody;
    }
}
