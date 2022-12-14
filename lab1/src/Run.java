public class Run extends MoveStrategyBase implements MoveStrategyInterface {
    Run(int speed) {
        super(speed);
    }

    @Override
    public String toString() {
        return "RUN with speed: " + this.speed;
    }
}