public class Human implements LookActions, MovingActions {
    private String name;
    private States state;
    private Locations location = Locations.DEFAULT;
    private int x, y;
    private boolean hasRope = false;

    public Human(String name){
        this.name = name;
    }
    public Human(){
        this.name = "Безымянный коротышка";
    }

    public boolean getCanPull(Rope rope, Human human) {
        if (this.hasRope) {
            if ((Math.pow((double)(human.getCoordinates()[0] - this.getCoordinates()[0]) , 2) + Math.pow((double)(human.getCoordinates()[1] - this.getCoordinates()[1]) , 2)) <= Math.pow((double)rope.getLength(), 2)) {
                return true;
            }
            else return false;
        }
        else return false;
    }
    public void tryToFind(Human human, Locations location) {
        Human founded = this.lookIn(location, human);
        if (founded != null){
            this.setState(States.FIND_SMB);
            System.out.println("Коротышка " + this.getName() + " " + this.getState().getTitle() + " " + founded.getName());
        }
        else System.out.println("Коротышки " + human.getName() + " там нет");
        state = States.DEFAULT;
    }
    public void isKnow() {
        Human [] humans = new Human[100];
        int i = 0;
        for (int j = 0; j < World.getHCnt(); j++) {
            for (int k = 0; k < World.getRcnt(); k++) {
                if (World.humArray[j].getCanPull(World.ropeArray[k], this)) {
                    humans[i] = World.humArray[j];
                    i++;
                }
            }
        }
        if (humans.length != 0) {
            state = States.DONTFRIGHT;
            System.out.print(this.getName() + " " + state.getTitle());
            state = States.KNOW;
            System.out.print(", потому что " + state.getTitle());
            System.out.print("коротышки ");
            for (int s = 0; s < i; s++) {
                System.out.print(humans[s].getName() + " ");
            }
            System.out.println("в любой момент могут притянуть " + this.getName() + " к " + humans[0].getLocation().getTitle());
            state = States.DEFAULT;
        }
        else System.out.println(this.getName() + " испугался, потому что " + state.getTitle() + "коротышки не могут его притянуть");

    }

    public void setHasRope(boolean hasRope) {
        this.hasRope = hasRope;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int [] getCoordinates() {
        int [] c = new int[2];
        c[0] = x;
        c[1] = y;
        return c;
    }

    public String getName() {
        return name;
    }

    public States getState() {
        return state;
    }
    public void printState() {
        System.out.println(this.getName() + " " + state.getTitle());
    }

    public void setState(States state) {
        this.state = state;
    }

    public void setLocation() {
        if (getCoordinates()[0] >= Locations.NEARTHEHOUSE.getX1() && getCoordinates()[0] <= Locations.NEARTHEHOUSE.getX2() && getCoordinates()[1] >= Locations.NEARTHEHOUSE.getY1() && getCoordinates()[1] <= Locations.NEARTHEHOUSE.getY2()) {
            location = Locations.NEARTHEHOUSE;
        }
        else if (getCoordinates()[0] >= Locations.PAVILION.getX1() && getCoordinates()[0] <= Locations.PAVILION.getX2() && getCoordinates()[1] >= Locations.PAVILION.getY1() && getCoordinates()[1] <= Locations.PAVILION.getY2()) {
            location = Locations.PAVILION;
        }
        else if (getCoordinates()[0] >= Locations.ROOF.getX1() && getCoordinates()[0] <= Locations.ROOF.getX2() && getCoordinates()[1] >= Locations.ROOF.getY1() && getCoordinates()[1] <= Locations.ROOF.getY2()) {
            location = Locations.ROOF;
        }
        else {
            location = Locations.INTHEAIR;

        }
    }

    public Locations getLocation() {
        return location;
    }
    @Override
    public String toString() {
        return "Human {" + "name='" + name + "', canPull=" + "canPull" +
                ", state="+ state + ", location=" + location +
                ",hasRope=" + "hasRope" + "}";
    }


//    @Override
//    public boolean equals(Object o) {
//        if (o == this) return true;
//        if (o == null || o.getClass() != this.getClass()) return false;
//        Human shorty = (Human) o;
//        return Objects.equals(name, shorty.name)  &&
//                Objects.equals(location, shorty.location)  &&
//                Objects.equals(behaviour, shorty.behaviour)  &&
//                Objects.equals(canPull, shorty.canPull)  &&
//                Objects.equals(hasRope, shorty.hasRope);
//    }

    @Override
    public void lookAround(){
        System.out.println("Коротышка " + this.getName() + " огляделся по сторонам");
        for (int i = 0; i < World.getHCnt(); i++) {
            if (World.humArray[i].getLocation() == this.getLocation()) {
                if (World.humArray[i] != this) {
                    this.setState(States.FIND_SMB);
                    System.out.println("Коротышка " + this.getName() + this.getState().getTitle() + World.humArray[i].getName() + " в локации " + this.getLocation().getTitle());
                }
            }
        }
    }
    @Override
    public Human lookIn(Locations where, Human human){
        System.out.println("Коротышка " + this.getName() + " заглянул в " + where.getTitle());
        for (int i = 0; i < World.getHCnt(); i++) {
            if (World.humArray[i].getLocation() == where){
                if (World.humArray[i] == human) {
                    return World.humArray[i];
                }
            }
        }
        return null;
    }
    @Override
    public void jump(int x, int y) {
        Locations location = this.getLocation();
        setCoordinates(getCoordinates()[0]+x, getCoordinates()[1] + y);
        setLocation();
        if (location == this.getLocation()) {
            System.out.println("Коротышка " + this.name + " прыгает по локации " + getLocation().getTitle());
        }
        else System.out.println("Коротышка " + this.name + " одним прыжком достиг локации " + getLocation().getTitle());
    }
    @Override
    public void move(int x) {
        Locations location = this.getLocation();
        setCoordinates(getCoordinates()[0]+x, getCoordinates()[1]);
        setLocation();
        if (location == this.getLocation()) {
            System.out.println("Коротышка " + this.name + " перемещается по локации " + getLocation().getTitle());
        }
        else System.out.println("Коротышка " + this.name + " переместился из локации " + location.getTitle() + " в локацию " + getLocation().getTitle());
    }

    @Override
    public void climb(int y, MaterialObject materialObject) {
        if (materialObject.getCanInteract() == true) {
            Locations location = this.getLocation();
            if (y > 0) {
                if (materialObject.getCoordinates()[0] == this.getCoordinates()[0]) {
                    if (materialObject.getCoordinates()[3] >= this.getCoordinates()[1] + y){
                        setCoordinates(getCoordinates()[0], getCoordinates()[1] + y);
                        setLocation();
                        if (location == this.getLocation()) {
                            System.out.println("Коротышка " + this.name + " вскарабкался по " + materialObject.getName() + ", но всё ещё находится в локации " + getLocation().getTitle());
                        } else
                            System.out.println("Коротышка " + this.name + " вскарабклася по " + materialObject.getName() + " в локацию " + getLocation().getTitle());
                    } else
                    System.out.println("Длины " + materialObject.getName() + " не хватает, чтобы подняться так высоко...");
                }else System.out.println("Коротышка " + this.name + " не смог найти " + materialObject.getName() + " поблизости...");
            } else {
                if (materialObject.getCoordinates()[0] == this.getCoordinates()[0]) {
                    if (materialObject.getCoordinates()[1] <= this.getCoordinates()[1] + y) {
                        setCoordinates(getCoordinates()[0], getCoordinates()[1] + y);
                        setLocation();
                        if (location == this.getLocation()) {
                            System.out.println("Коротышка " + this.name + " спустился по " + materialObject.getName() + ", но всё ещё находится в локации " + getLocation().getTitle());
                        } else
                            System.out.println("Коротышка " + this.name + " спустился по " + materialObject.getName() + " в локацию " + getLocation().getTitle());
                    }
                }else
                    System.out.println("Длины " + materialObject.getName() + " не хватает, чтобы спуститься на такую высоту...");
            }
        }
    }
}
