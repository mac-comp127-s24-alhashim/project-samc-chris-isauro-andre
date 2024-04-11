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
        this.wheel.setPosition(wheelX, wheelY);
        this.wheel.setRotation(angle);

    }

    public Image getWheelModel(){   
        return wheel;
    } 
}
