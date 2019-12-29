abstract class WorldObject {
    private String name;
    protected int x1, y1, x2, y2;
    private Locations location = Locations.DEFAULT;

    public WorldObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setCoordinates(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }

    public int[] getCoordinates() {
        int[] c = new int [4];
        c[0] = this.x1;
        c[1] = this.y1;
        c[2] = this.x2;
        c[3] = this.y2;
        return  c;
    }
    public Locations getLocation() {
        return location;
    }

    public void setLocation() {
        if (getCoordinates()[0] >= Locations.PAVILION.getX1() && getCoordinates()[0] <= Locations.PAVILION.getX2() && getCoordinates()[1] >= Locations.PAVILION.getY1() && getCoordinates()[1] <= Locations.PAVILION.getY2()) {
            location = Locations.PAVILION;
        }
        if (getCoordinates()[0] >= Locations.NEARTHEHOUSE.getX1() && getCoordinates()[0] <= Locations.NEARTHEHOUSE.getX2() && getCoordinates()[1] >= Locations.NEARTHEHOUSE.getY1() && getCoordinates()[1] <= Locations.NEARTHEHOUSE.getY2()) {
            location = Locations.NEARTHEHOUSE;
        }
        if (getCoordinates()[0] >= Locations.INTHEAIR.getX1() && getCoordinates()[0] <= Locations.INTHEAIR.getX2() && getCoordinates()[1] >= Locations.INTHEAIR.getY1() && getCoordinates()[1] <= Locations.INTHEAIR.getY2()) {
            location = Locations.INTHEAIR;
        }
        if (getCoordinates()[0] >= Locations.ROOF.getX1() && getCoordinates()[0] <= Locations.ROOF.getX2() && getCoordinates()[1] >= Locations.ROOF.getY1() && getCoordinates()[1] <= Locations.ROOF.getY2()) {
            location = Locations.ROOF;
        }
    }
}
