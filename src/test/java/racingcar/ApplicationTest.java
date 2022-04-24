package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자는 pobi 입니다.");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(
                () -> {
                    runException("pobi,javaji");
                    assertThat(output()).contains(ERROR_MESSAGE);
                }
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }


    @Test
    @DisplayName("전진_테스트")
    void 전진_테스트() {
        Car car = new Car("pobi");
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.READY);

        car.go();
        Assertions.assertEquals(car.getMoveCount(), 1);
        Assertions.assertEquals(car.getStatus(), CarStatus.GO);
    }

    @Test
    @DisplayName("멈춤_테스트")
    void 멈춤_테스트() {
        Car car = new Car("pobi");
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.READY);

        car.stop();
        Assertions.assertEquals(car.getMoveCount(), 0);
        Assertions.assertEquals(car.getStatus(), CarStatus.STOP);
    }

    @Test
    @DisplayName("입력_받은_값으로_차_생성")
    void 입력_받은_값으로_차_생성() {
        String input = "pobi,javajigi,woni";

        Cars cars = Application.makeCars(input);
        Assertions.assertEquals(cars.getSize(), 3);
    }
}
