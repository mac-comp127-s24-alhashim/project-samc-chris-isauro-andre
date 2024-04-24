import edu.macalester.graphics.Image;

public class Racer {
    private String racerCarPreview, Rkey;
    private Image racerCar;
    private int weight, brakepower;
    
    public Racer(String racerKey, String racerCarImagePath, int weight, int brakepower){
        racerCar = new Image(racerCarImagePath);
        racerCarPreview = racerCarImagePath;
        this.weight = weight; 
        this.brakepower = brakepower;
        Rkey = racerKey;
    }

    public Image getRacerCarPreview(){
        return new Image(racerCarPreview);
    }

    public String getKey(){
        return Rkey;
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
