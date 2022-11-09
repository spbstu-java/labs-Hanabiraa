public class Hero {
    private MoveStrategyInterface move_type = null;

    public Hero() {
    }

    void setMoveStrategy(MoveStrategyInterface new_strategy) {
        move_type = new_strategy;
    }

    @Override
    public String toString() {
        return move_type.toString();
    }
}
