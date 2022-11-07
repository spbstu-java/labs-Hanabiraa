public class Hero {
    private MoveStrategy move_type = null;

    public Hero() {
    }

    void changeMoveStrategy(MoveStrategy new_stratagy) {
        move_type = new_stratagy;
    }

    @Override
    public String toString() {
        return "current move_type is: " + move_type;
    }
}
