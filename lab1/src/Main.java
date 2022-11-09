public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();

        hero.setMoveStrategy(new Run(1));
        System.out.println(hero); // RUN with speed: 1

        hero.setMoveStrategy(new Ride(2));
        System.out.println(hero); // RIDE with speed: 2

        hero.setMoveStrategy(new Fly(3));
        System.out.println(hero); // FLY with speed: 3
    }
}