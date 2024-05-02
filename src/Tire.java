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
    

    /**
     * The identification and stats of a track.
     * 
     * @param tireKey                   The key of the selected tire.
     * @param path                      The file representation of the selected tire.
     * @param wheelPreviewImagePath     The visual representation of the selected tire.
     * @param friction                  The selected tire's friction.
     * @param angle                     The starting angle of the selected tires.
     * @param scale                     The scaling of the selected tires.
     * @param grip                      The grip of the selected tires.
     * @param durability                The selected tire's durability.
     */
    public Tire(
        String tireKey,
        File path, 
        String wheelPreviewImagePath,
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

    public Image animateWheel(){
        for (int i = 0; i < wheels.size() - 1;i++ ){
            if (i < wheels.size() - 1){
                wheel = wheels.get(i);
                return getWheel();
            } else {
                i = 0;
            }
        }
        return getWheel();
    }

    private static Image loadImages(File file){
        String imagePath = file.getPath();
        imagePath = imagePath.substring(4, imagePath.length());
        Image image = new Image(imagePath);
        return image;
    }

}
 

