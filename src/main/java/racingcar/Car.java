package racingcar;

public class Car {
    private final String name;
    private int moveCount;
    private int maxMoveCount;
    private CarStatus status;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
        this.status = CarStatus.READY;

    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public CarStatus getStatus() {
        return this.status;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    public void go() {
        this.setStatus(CarStatus.GO);
    }

    public void stop() {
        this.setStatus(CarStatus.STOP);
    }

    private void setStatus(CarStatus status) {
        this.status = status;
        this.moveCount = this.moveCount + status.getMoveCount();
    }
}
