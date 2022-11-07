public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero();
        System.out.println(hero); // current move_type is: null

        hero.changeMoveStrategy(MoveStrategy.WALK);
        System.out.println(hero); // current move_type is: WALK

        hero.changeMoveStrategy(MoveStrategy.HORSE_RIDE);
        System.out.println(hero); // current move_type is: HORSE_RIDE

        hero.changeMoveStrategy(MoveStrategy.FLY);
        System.out.println(hero); // current move_type is: FLY
    }
}