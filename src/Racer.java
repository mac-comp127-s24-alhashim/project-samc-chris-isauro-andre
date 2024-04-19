import edu.macalester.graphics.Image;

public class Racer {
    Image racerCarImage;
    int weight, brakepower;
    
    public Racer(Image racerCar, int weight, int brakepower){
        this.racerCarImage = racerCar;
        this.weight = weight; 
        this.brakepower = brakepower;
    }

    public Image getRacerCar(){
        return racerCarImage;
    }

    public int getWeight(){
        return weight;
    }

    public int getBrakepower(){
        return brakepower;
    }

}
