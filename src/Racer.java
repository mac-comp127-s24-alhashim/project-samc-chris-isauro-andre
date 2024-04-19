import edu.macalester.graphics.Image;

public class Racer {
    String racerCarPath;
    Image racerCar;
    int weight, brakepower;
    
    public Racer(String racerCarPath, int weight, int brakepower){
        this.racerCarPath = racerCarPath;
        racerCar = new Image(racerCarPath);
        this.weight = weight; 
        this.brakepower = brakepower;
    }

    public Image getRacerCar(){
        return racerCar;
    }

    public String getRacerCarPath() {
        return racerCarPath;
    }

    public int getWeight(){
        return weight;
    }

    public int getBrakepower(){
        return brakepower;
    }

}
