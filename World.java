public class World {
    private String name;
    private int sizex;
    private int sizey;
    static Human[] humArray = new Human[10];
    static MaterialObject[] materialObjectArray = new MaterialObject[10];
    static Rope[] ropeArray = new Rope[10];
    static Wind[] windArray = new Wind[10];
    private static int Hcnt = 0;
    private static int Mcnt = 0;
    private static int Rcnt = 0;
    private static int Wcnt = 0;
    public World(String name, int sizex, int sizey) {
        this.name = name;
        this.sizex = sizex;
        this.sizey = sizey;
    }
    public void addToWorld(Human human, int x, int y) {
        humArray[Hcnt] = human;
        Hcnt++;
        human.setCoordinates(x, y);
        human.setLocation();
        System.out.println("Коротышка " + human.getName() + " появился в " + name + " в локации " + human.getLocation().getTitle());
    }
    public void addToWorld(MaterialObject materialObject, int x1, int y1, int x2, int y2) {
        materialObjectArray[Mcnt] = materialObject;
        Mcnt++;
        materialObject.setCoordinates(x1, y1, x2, y2);
        materialObject.setLocation();
        System.out.println(materialObject.getName() + " появился в " + name +" в локации " + materialObject.getLocation().getTitle());
    }
    public void addToWorld(Rope rope, int x1, int y1, int x2, int y2) {
        ropeArray[Rcnt] = rope;
        Rcnt++;
        rope.setCoordinates(x1, y1, x2, y2);
        rope.setLocation();
        System.out.println(rope.getName() + " появился в " + name +" в локации " + rope.getLocation().getTitle());
    }
    public void addToWorld(Wind wind, int x1, int y1, int x2, int y2) {
        windArray[Wcnt] = wind;
        Wcnt++;
        wind.setCoordinates(x1, y1, x2, y2);
        wind.setLocation();
        System.out.println(wind.getName() + " появился в " + name +" в локации " + wind.getLocation().getTitle());
    }

    public static int getHCnt() {
        return Hcnt;
    }

    public static int getMcnt() {
        return Mcnt;
    }

    public static int getRcnt() {
        return Rcnt;
    }

    public static int getWcnt() {
        return Wcnt;
    }
}
