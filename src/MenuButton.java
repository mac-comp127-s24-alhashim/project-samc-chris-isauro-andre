
/**
 * This is the interface that is used for all of the menu button classes other than the start button. This is just a set of uniform functions
 * across the four which I thought whould be useful in conceptualizing the classes.
 */
public interface MenuButton {
    public void setupClickMechanic();
    public void pressed();
    public void deselected();
    public boolean getSelectedBool();
}
