import edu.macalester.graphics.Image;

public class Racer {
    String racerCarImagePath;
    Image racerCarImage;
    int weight, brakepower;
    
    public Racer(String racerCarImagePath, int weight, int brakepower){
        this.racerCarImage = new Image(racerCarImagePath);
        this.racerCarImagePath = racerCarImagePath;
        this.weight = weight; 
        this.brakepower = brakepower;
    }

    public Image getRacerCarPreview(){
        return new Image(racerCarImagePath);
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
