package racingcar;

import java.util.List;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.validateCarName(cars);
        this.cars = cars;
    }

    public int getSize() {
        return this.cars.size();
    }

    private void validateCarName(List<Car> cars) {
        for (Car car : cars) {
            if (car.getName().length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
