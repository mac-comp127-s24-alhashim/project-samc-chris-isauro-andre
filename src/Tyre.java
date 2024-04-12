import edu.macalester.graphics.*;

public class Tyre{

    // private ArrayList<Image> wheels = new ArrayList<>();
    private Image wheel;
    private double turningValue;
    private String tireType;
    
    

    public Tyre(
    // String tireType, 
    // double turningValue, 
    Image wheel, 
    double wheelX, double wheelY,
    double angle
    )
    {
        // this.tireType = tireType;
        // this.turningValue = turningValue;
        // this.wheels = wheelImages;
        this.wheel = wheel;
        wheel.setPosition(wheelX, wheelY);
        wheel.setRotation(angle);
        wheel.setScale(.5);
        
    }

    public Image getWheelModel(){   
        return wheel;
    } 
}
