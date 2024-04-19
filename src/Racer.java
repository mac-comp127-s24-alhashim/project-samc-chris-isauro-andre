import edu.macalester.graphics.Image;

public class Racer {
    String racerCarPreview;
    Image racerCar;
    int weight, brakepower;
    
    public Racer(String racerCarImagePath, int weight, int brakepower){
        racerCar = new Image(racerCarImagePath);
        racerCarPreview = racerCarImagePath;
        this.weight = weight; 
        this.brakepower = brakepower;
    }

    public Image getRacerCarPreview(){
        return new Image(racerCarPreview);
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
