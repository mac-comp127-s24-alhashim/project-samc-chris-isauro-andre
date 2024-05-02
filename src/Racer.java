import edu.macalester.graphics.Image;


public class Racer {
    private String racerCarPreview, Rkey;
    private Image racerCar;
    private double brakepower;
    private int weight;
    
    /**
     * The identification and stats of a racer.
     * 
     * @param racerKey              The key of the selected racer.
     * @param racerCarImagePath     The visual representation of the selected racer.
     * @param weight                The weight of the selected racer
     * @param brakepower            The selected racer's brakepower
     */
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
