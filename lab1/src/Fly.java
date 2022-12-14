public class Fly extends MoveStrategyBase implements MoveStrategyInterface {
    Fly(int speed) {
        super(speed);
    }

    @Override
    public String toString() {
        return "FLY with speed: " + this.speed;
    }
}