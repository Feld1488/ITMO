public class MaterialObject extends WorldObject {
    private boolean canInteract = false;
    public MaterialObject(String name) {
        super(name);
    }

    public void setCanInteract(boolean canInteract) {
        this.canInteract = canInteract;
    }

    public boolean getCanInteract() {
        return canInteract;
    }
}
