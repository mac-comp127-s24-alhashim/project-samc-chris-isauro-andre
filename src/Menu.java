import edu.macalester.graphics.*;

public class Menu {
    private CanvasWindow canvas;
    private Track selectedTrack;
    private Racer selectedRacer;
    private Tire selectedTires;
    private Engine selectedEngine;
    private Image previewRacerCar;
    private Image previewRacerTires;
    private boolean previewRacerCarDisplayed;
    private boolean previewRacerTiresDisplayed;
    private boolean ifMenuOpen = true;
    public MenuUIManager buttonManager;


    public Menu(CanvasWindow canvas){
        buttonManager = new MenuUIManager(this, canvas);
        this.canvas = canvas;
        setupMenu();
    }

    /**
     * After the menu is created, sets the default selected and displays the preview tires and car.
     */
    private void setupMenu(){
        setupDefaultSelected();
        setPreviewCar();
        setPreviewTire();
    }

    /**
     * If previewRacerCarDisplayed is not true, which it is by default, then it is set to true and previewRacerCar is not removed
     * from the canvas. This is because if it is the first time it is pressed, there is no previewRacerCar displayed and if you try
     * and remove it makes things break. If previewRacerCarDisplayed then it removes the currently displayed previewRacerCar image 
     * from the canvas. Either way, it takes the selectedRacer car preview image, positions it, and adds it to the canvas.
     */
    public void setPreviewCar(){
        if (previewRacerCarDisplayed != true){
            previewRacerCarDisplayed = true;
        }
        else{
            canvas.remove(previewRacerCar);
        }

        previewRacerCar = selectedRacer.getRacerCarPreview();
        positionPreviewImage(previewRacerCar);
        canvas.add(previewRacerCar);
    }


    /**
     * If previewRacerTiresDisplayed is not true, which it is by default, then it is set to true and previewRacerTires is not removed
     * from the canvas. This is because if it is the first time it is pressed, there is no previewRacerTires displayed and if you try
     * and remove it makes things break. If previewRacerTiresDisplayed then it removes the currently displayed previewRacerTires image 
     * from the canvas. Either way, it takes the selectedTires wheel preview image, positions it, and adds it to the canvas.
     */
    public void setPreviewTire(){
        if (previewRacerTiresDisplayed != true){
            previewRacerTiresDisplayed = true;
        }
        else{
            canvas.remove(previewRacerTires);
        }

        previewRacerTires = selectedTires.getWheelPreview();
        positionPreviewImage(previewRacerTires);
        canvas.add(previewRacerTires);
    }

    /**
     * This function takes an image (either a tire image or car image) and sets it to the correct position, rotation,
     * and scale to be displayed as a preview of what is currectly selected in the preview window. It first scales the image, 
     * then it sets its postion, and then it rotates the image. 
     */
    private void positionPreviewImage(Image image){
        image.setMaxWidth(image.getWidth() * buttonManager.getImageScaleFactor() * 1.2);
        image.setPosition(
            canvas.getWidth() * (269.0/320.0), 
            canvas.getHeight() * (72.0/180.0) 
            - (image.getHeight()/2 - image.getWidth()/2)
            );
        image.rotateBy(90);
    }

    /**
     * Artificially selects the first option in all of the four catagories.
     */
    private void setupDefaultSelected(){
        buttonManager.getTrackButtons().get(0).pressed();
        buttonManager.getRacerButtons().get(0).pressed();
        buttonManager.getTireButtons().get(0).pressed();
        buttonManager.getEngineButtons().get(0).pressed();
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

    public MenuUIManager getButtonManager() {
        return buttonManager;
    }

    public boolean getIfMenuOpen() {
        return ifMenuOpen;
    }

    public void setIfMenuOpen(boolean bool) {
        this.ifMenuOpen = bool;
    }
}
