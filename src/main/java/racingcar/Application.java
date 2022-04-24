package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Cars makeCars(String inputString) {
        List<String> carNames = Util.splitComma(inputString);
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            carList.add(car);
        }

        return new Cars(carList);
    }
}
