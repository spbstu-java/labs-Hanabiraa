public class Ride extends MoveStrategyBase implements MoveStrategyInterface {
    Ride(int speed) {
        super(speed);
    }

    @Override
    public String toString() {
        return "RIDE with speed: " + this.speed;
    }
}