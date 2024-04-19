import edu.macalester.graphics.Image;

public class Racer {
    Image racerCar;
    int weight, brakepower;
    
    public Racer(Image racer, int weight, int brakepower){
        racerCar = racer;
        this.weight = weight; 
        this.brakepower = brakepower;
    }

    public Image getRacerCar(){
        return racerCar;
    }

    public int getWeight(){
        return weight;
    }

    public int getBrakepower(){
        return brakepower;
    }

}
