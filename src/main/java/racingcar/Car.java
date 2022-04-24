package racingcar;

public class Car {
    private final String name;
    private int moveCount;
    private int maxMoveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        this.maxMoveCount = maxMoveCount;
    }

    public void go() {
        this.moveCount++;
    }
}
