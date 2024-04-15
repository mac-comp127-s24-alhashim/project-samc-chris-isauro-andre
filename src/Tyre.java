import edu.macalester.graphics.*;

import java.io.File;
import java.util.ArrayList;

public class Tyre{

    private File imageFile = new File("WheelImages");
    private ArrayList<Image> wheels = new ArrayList<>();
    
    private Image wheel;
    private double turningValue;
    private String tireType;
    
    

    public Tyre(
    String tireType, 
    
    Image wheel, 
    double wheelX, double wheelY,
    double angle
    )
    {

        // for (int i = 0; )
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
