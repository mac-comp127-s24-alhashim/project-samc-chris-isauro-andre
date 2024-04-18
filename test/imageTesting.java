import java.io.File;
import java.util.ArrayList;

import edu.macalester.graphics.*;

public class imageTesting {

public static void main(String[] args) {
    File pathFile = new File("res/images/WheelImages/tireSoft");
    ArrayList<Image> wheels = new ArrayList<>();
    File[] files = pathFile.listFiles();
    for (int i = 0; i < files.length; i++){
        if(files[i].isFile()){
            wheels.add(loadImages(files[i]));
        }
    }
}

public static Image loadImages(File file){
        String imagePath = file.toString();
        imagePath.replace("res/", "");
        Image image = new Image(imagePath);
        return image;
    }

}
