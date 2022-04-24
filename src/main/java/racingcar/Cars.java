package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cars {
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.validateCarName(cars);
        this.validateDuplicateName(cars);
        this.cars = cars;
    }

    public List<Car> getCars() {
        return this.cars;
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

    private void validateDuplicateName(List<Car> cars) {
        Set<String> setCars = new HashSet<>(this.getCarNames(cars));

        if (cars.size() != setCars.size()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> getCarNames(List<Car> cars) {
        List<String> names = new ArrayList<>();
        for (Car car : cars) {
            names.add(car.getName());
        }

        return names;
    }

    public void setMaxMoveCount(int maxMoveCount) {
        for (Car car : this.cars) {
            car.setMaxMoveCount(maxMoveCount);
        }
    }

    public void move() {
        for (Car car : this.cars) {
            car.move();
        }
    }

    public boolean validateArriveCar() {
        for (Car car : this.cars) {
            if (car.validateArrive()) {
                return true;
            }
        }

        return false;
    }
}
