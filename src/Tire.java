import edu.macalester.graphics.*;

import java.io.File;
import java.util.ArrayList;

public class Tire{
    private String TIKey;
    private File pathFile;
    private ArrayList<Image> wheels = new ArrayList<>();
    private String wheelPreview;
    private Image wheel;
    private double friction, durability;
    private int grip;    
    

    public Tire(
        String tireKey,
        File path, 
        String wheelPreviewImagePath,
        double wheelX, double wheelY, 
        double friction, 
        double angle,
        double scale, 
        int grip, 
        double durability){

        TIKey = tireKey;
        wheelPreview = wheelPreviewImagePath;
        pathFile = path;

        this.friction = friction;
        this.durability = durability;
        this.grip = grip;


        File[] files = pathFile.listFiles();
        for (int i = 0; i < files.length; i++){
            if(files[i].isFile()){
                wheels.add(loadImages(files[i]));
            }
        }
        
        wheel = wheels.get(0);
        wheel.setPosition(wheelX, wheelY);
        wheel.setRotation(angle);
        wheel.setScale(scale);
        
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

    public Image getWheel() {
        return wheel;
    }

    public void degradeTires(){
        durability -= .02;
    }

    public static Image loadImages(File file){
        String imagePath = file.getPath();
        imagePath = imagePath.substring(4, imagePath.length());
        Image image = new Image(imagePath);
        return image;
    }

}
 

