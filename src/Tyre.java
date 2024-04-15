import edu.macalester.graphics.*;

import java.io.File;
import java.util.ArrayList;

public class Tyre{

    private File imageFile = new File("WheelImages");
    private ArrayList<Image> wheels = new ArrayList<>();
    
    private Image wheel;
    private double turningValue, friction;
    private String tireType;
    private int grip, ability;    
    

    public Tyre(
    String tireType, 
    ArrayList<Image> wheelImages, 
    double wheelX, double wheelY, double friction, double angle, int grip, int ability
    )
    {

        this.wheel = wheel;
        wheel.setPosition(wheelX, wheelY);
        wheel.setRotation(angle);
        wheel.setScale(.5);
        
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

