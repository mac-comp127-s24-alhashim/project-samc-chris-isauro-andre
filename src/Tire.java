import edu.macalester.graphics.*;

/**
 * This class is to create unique Racer objects that is put in the menu for different Racer objects with differing
 * attributes be selected in the menu. The class is responsible for slightly impacting how fast the car speeds and up,
 * but is mainly responsible for how much the car turns.
 * 
 * @param tireKey               a key string in a map to match a Tire object with unique attributes.
 * @param wheelPreviewImagePath file path to the image of the wheel.
 * @param friction              value that affects how fast the car speeds up.
 * @param grip                  value that affects how much the car turns.
 * @param durability            how long the tire can last before not being able to accelarate.
 */

public class Tire{
    private String TIKey;
    private String wheelPreview;
    private Image wheel;
    private double friction, durability;
    private int grip;    
    

    public Tire(
        String tireKey,
        String wheelPreviewImagePath,
        double friction, 
        int grip, 
        double durability){

        TIKey = tireKey;
        wheelPreview = wheelPreviewImagePath;

        this.friction = friction;
        this.durability = durability;
        this.grip = grip;

        wheel = new Image(wheelPreviewImagePath);

    }

    public Image getWheelPreview(){   
        return new Image(wheelPreview);
    }

    public String getKey(){
        return TIKey;
    }

    public double getFriction() {
        return friction;
    }

    public int getGrip() {
        return grip;
    }

    public double getDurability(){
        return durability;
    }

    public void degradeTires(){
        durability -= .008;
    }

    public Image getWheel() {
        return wheel;
    }

}
 

