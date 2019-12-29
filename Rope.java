public class Rope extends MaterialObject implements  RopeActions {
    private int length;

    public Rope(String name, int length) {
        super(name);
        this.length = length;
        super.setCanInteract(true);
    }

    public void pullSmb(Human human) {
        Human [] humans = new Human[100];
        int i = 0;
        for (int j = 0; j < World.getHCnt(); j++) {
            if (World.humArray[j].getCanPull(this, human)) {
                humans[i] = World.humArray[j];
                if (i != 0 && (humans[i].getCoordinates()[0] != humans[0].getCoordinates()[0] || humans[i].getCoordinates()[1] != humans[0].getCoordinates()[1])) {
                    humans[i].setCoordinates(humans[0].getCoordinates()[0], humans[0].getCoordinates()[1]);
                    System.out.println("Коротышка " + humans[i].getName() + " подошёл к коротышке " + humans[0].getName() + ", чтобы потянуть за верёвку");
                }
                i++;
            }
        }
        if (humans.length != 0) {
            human.setCoordinates(humans[0].getCoordinates()[0], humans[0].getCoordinates()[1]);
            human.setLocation();
            System.out.print("Коротышки ");
            for (int j = 0; j < i; j++) {
                System.out.print(humans[j].getName() + " ");
            }
            System.out.println("притянули  " + human.getName() + " к " + human.getLocation().getTitle());
        }
    }

    public int getLength() {
        return length;
    }
}
