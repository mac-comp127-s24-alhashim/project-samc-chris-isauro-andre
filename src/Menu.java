import edu.macalester.graphics.*;
// import java.io.File;

import java.util.*; 



public class Menu {
    CanvasWindow canvas;
    Track selectedTrack;
    Racer selectedRacer;
    Tire selectedTires;
    Engine selectedEngine;
    Image previewRacerCar;
    Image previewRacerTires;
    MenuButtonManager buttonManager;


    public Menu(CanvasWindow canvas){
        buttonManager = new MenuButtonManager(this, canvas);
        this.canvas = canvas;
        setupMenu();
    }

    private void setupMenu(){
        buttonManager
        setupDefaultSelected();
        setPreviewCar();
        setPreviewTire();
    }

    public void setPreviewCar(){
        previewRacerCar = selectedRacer.getRacerCarPreview();
        positionPreviewImage(previewRacerCar);
    }

    public void setPreviewTire(){
        previewRacerTires = selectedTires.getWheelPreview();
        positionPreviewImage(previewRacerTires);
    }

    private void positionPreviewImage(Image image){
        image.setMaxWidth(image.getWidth() * buttonManager.getImageScaleFactor() * 1.2);
        image.setPosition(
            canvas.getWidth() * (269.0/320.0), 
            canvas.getHeight() * (72.0/180.0) 
            - (image.getHeight()/2 - image.getWidth()/2)
            );
        image.rotateBy(90);
        canvas.add(image);
    }

    public Track getSelectedTrack() {
        return selectedTrack;
    }

    public void setSelectedTrack(Track selectedTrack) {
        this.selectedTrack = selectedTrack;
    }

    public Racer getSelectedRacer() {
        return selectedRacer;
    }

    public void setSelectedRacer(Racer selectedRacer) {
        this.selectedRacer = selectedRacer;
    }

    public Tire getSelectedTires() {
        return selectedTires;
    }

    public void setSelectedTires(Tire selectedTires) {
        this.selectedTires = selectedTires;
    }

    public Engine getSelectedEngine() {
        return selectedEngine;
    }

    public void setSelectedEngine(Engine selectedEngine) {
        this.selectedEngine = selectedEngine;
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("MenuTester", 1280, 720);
        new Menu(canvas);
    }

    private void setupDefaultSelected(){
        buttonManager.getTrackButtons().get(0).pressed();
        buttonManager.getRacerButtons().get(0).pressed();
        buttonManager.getTireButtons().get(0).pressed();
        buttonManager.getEngineButtons().get(0).pressed();
    }

}
