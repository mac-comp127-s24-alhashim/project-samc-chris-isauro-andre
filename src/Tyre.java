import java.util.ArrayList;

import edu.macalester.graphics.*;

public class Tyre {

    private ArrayList<Image> wheels;
    private Image wheel;
    private double turningValue, friction;
    private String tireType;
    private int grip, ability;

    public Tyre(
    String tireType, 
    ArrayList<Image> wheelImages, 
    double wheelX, double wheelY, double friction, int grip, int ability
    )
    {
        // this.tireType = tireType;
        // this.turningValue = turningValue;
        this.wheels = wheelImages;
        
        this.wheel = wheelImages.get(0);
        this.wheel.setPosition(wheelX, wheelY);
    }

    public Image getWheelModel(){
        return wheel;
    }

    public double getFriction() {
        return friction;
    }

    public int getGrip() {
        return grip;
    }

} 
