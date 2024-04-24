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
    public MenuButtonManager buttonManager;


    public Menu(CanvasWindow canvas){
        buttonManager = new MenuButtonManager(this, canvas);
        this.canvas = canvas;
        setupMenu();
    }

    private void setupMenu(){
        setupDefaultSelected();
        setPreviewCar();
        setPreviewTire();
    }

    public void setPreviewCar(){
        if (previewRacerCarDisplayed == true){
            canvas.remove(previewRacerCar);
        }
        previewRacerCar = selectedRacer.getRacerCarPreview();
        positionPreviewImage(previewRacerCar);
        canvas.add(previewRacerCar);
        previewRacerCarDisplayed = true;
    }

    public void setPreviewTire(){
        if (previewRacerTiresDisplayed == true){
            canvas.remove(previewRacerTires);
        }
        previewRacerTires = selectedTires.getWheelPreview();
        positionPreviewImage(previewRacerTires);
        canvas.add(previewRacerTires);
        previewRacerTiresDisplayed = true;
    }

    private void positionPreviewImage(Image image){
        image.setMaxWidth(image.getWidth() * buttonManager.getImageScaleFactor() * 1.2);
        image.setPosition(
            canvas.getWidth() * (269.0/320.0), 
            canvas.getHeight() * (72.0/180.0) 
            - (image.getHeight()/2 - image.getWidth()/2)
            );
        image.rotateBy(90);
    }

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

    public boolean getIfMenuOpen() {
        return ifMenuOpen;
    }

    public void setIfMenuOpen(boolean bool) {
        this.ifMenuOpen = bool;
    }
}
