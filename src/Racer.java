import edu.macalester.graphics.Image;

/**
 * This class is to create unique Racer objects that is put in the menu for different Racer objects with differing
 * attributes be selected in the menu. The class is responsible for the how the car looks and how fast the car can
 * break (decrease speed).
 * 
 * @param racerKey          a key string to a map to match a Racer object with unique attributes.
 * @param racerCarImagePath file path to the image of the car.
 * @param weight            value that is used in calculations in the car class.
 * @param brakepower        how fast the car brakes (slows down).
 * 
 */
public class Racer {
    private String racerCarPreview, Rkey;
    private Image racerCar;
    private double brakepower;
    private int weight;
    
    public Racer(String racerKey, String racerCarImagePath, int weight, double brakepower){
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

    public double getBrakepower(){
        return brakepower;
    }

}
