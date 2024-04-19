import edu.macalester.graphics.*;

// import java.io.File;
// import java.util.ArrayList;

public class Tire{
    // private File pathFile;
    // private ArrayList<Image> wheels = new ArrayList<>();
    private String wheelPreviewImagePath;
    private Image wheel;
    private double friction;
    private int grip, durability;    
    

    public Tire(
        // File path, 
        String wheelPreviewImagePath,
        double wheelX, double wheelY, 
        double friction, 
        double angle, 
        int grip, 
        int durability){

        this.wheel = new Image(wheelPreviewImagePath);
        this.wheelPreviewImagePath = wheelPreviewImagePath;

        // pathFile = path;

        // File[] files = pathFile.listFiles();
        // for (int i = 0; i < files.length; i++){
        // if(files[i].isFile()){
        //     wheels.add(loadImages(files[i]));
        // }
        // }
        
        // wheel = wheels.get(0);
        // wheel.setPosition(wheelX, wheelY);
        // wheel.setRotation(angle);
        // wheel.setScale(.5);
        
    }

    public Image getWheelPreview(){   
        return new Image(wheelPreviewImagePath);
    }

    public double getFriction() {
        return friction;
    }

    public int getGrip() {
        return grip;
    }

    public int getDurability(){
        return durability;
    }

    public Image getWheel() {
        return wheel;
    }

    // private Image loadImages(File file){
    //     Image image = new Image(file.toString());
    //     return image;
    // }

} 
