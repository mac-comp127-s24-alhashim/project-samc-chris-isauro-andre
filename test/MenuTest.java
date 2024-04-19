import java.awt.Color;

import edu.macalester.graphics.*;


public class MenuTest {
    public static void main(String[] args) {
        Color color1 = Color.BLUE;
        Color color2 = Color.RED;

        Image car1 = new Image("images/driver-body1.png");
        Image car2 = new Image("images/driver-body2.png");

        CanvasWindow canvas = new CanvasWindow("testerWindow", 400, 400);

        car1.setScale(4);
        car1.setPosition(40, 40);
        canvas.add(car1);

        car2.setScale(4);
        car2.setPosition(150, 40);
        canvas.add(car2);

        canvas.onClick((event)-> {
            if (car1.testHit(event.getPosition().getX(), event.getPosition().getY())){
                canvas.setBackground(color1);
            }
            if (car2.testHit(event.getPosition().getX(), event.getPosition().getY())){
                canvas.setBackground(color2);
            }
        });
    }
}
