public class Lab3 {
    public static void main(String[] args) {
        World world1 = new World("Бренный мир", 10, 10);
        Human human0 = new Human("Знайка");
        world1.addToWorld(human0, 0, 0);
        Human human1 = new Human();
        world1.addToWorld(human1, 4, 0);
        human1.setHasRope(true);
        Human human2 = new Human();
        world1.addToWorld(human2, 4,0);
        human2.setHasRope(true);
        Human human3 = new Human("Винтик");
        world1.addToWorld(human3, -1, -1);
        MaterialObject waterPipe = new MaterialObject("Водосточная труба");
        world1.addToWorld(waterPipe, 4,0,4,5);
        waterPipe.setCanInteract(true);
        Rope rope1 = new Rope("Верёвка", 100);
        world1.addToWorld(rope1, 0, 0, 0, 0);
        Wind wind1 = new Wind("Порыв ветра");
        world1.addToWorld(wind1, 0, 5, 5, 8);
        System.out.println("-----------------------------------------------------------------------");
        human0.move(4);
        human0.jump(2, 0);
        human0.tryToFind(human3, Locations.PAVILION);
        rope1.pullSmb(human0);
        human0.climb(5, waterPipe);
        human0.setState(States.WANTTOLOOK);
        human0.printState();
        wind1.blow();
        human0.isKnow();
    }
}
