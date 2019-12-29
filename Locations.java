public enum Locations {

    NEARTHEHOUSE("Около дома", 0, 0, 4, 4),
    PAVILION("Беседка", 6, 0, 8, 2),
    ROOF("На крыше", 0, 5, 4, 5),
    INTHEAIR("Над землёй", 5, 2, 8, 5),
    DEFAULT("Вне этого мира", 5, 0, 5, 2);

    private String title;
    private int x1, y1, x2, y2;

    Locations(String title, int x1, int y1, int x2, int y2) {
        this.title = title;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public String getTitle() {
        return title;
    }

    public int getY1() {
        return y1;
    }

    public int getX1() {
        return x1;
    }

    public int getY2() {
        return y2;
    }

    public int getX2() {
        return x2;
    }


}
