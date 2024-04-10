import edu.macalester.graphics.*;

public class Racer {
    String name;
    int weight, brakepower;
    Image carBody;
    
    public Racer(String name, int weight, int brakepower){
        this.weight = weight;
        this.brakepower = brakepower;
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
