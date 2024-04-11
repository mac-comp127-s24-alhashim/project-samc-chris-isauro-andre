import java.util.ArrayList;

import edu.macalester.graphics.*;

public class Tyre {

    private ArrayList<Image> wheels;
    private Image wheel;
    private double turningValue;
    private String tireType;


    public Tyre(
    // String tireType, 
    // double turningValue, 
    ArrayList<Image> wheelImages, 
    double wheelX, double wheelY
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

    public void turnWheels(){

    }

} 
