package baseball.view;

import baseball.domain.Validation;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private final Validation validation;

    public InputView() {
        validation = new Validation();
    }

    public int inputNumber() {
        String number = Console.readLine();
        if (validation.isInteger(number)) {
            validation.validateSize(number);
            validation.validateDifferentNumbers(number);
        }

        return Integer.parseInt(number);
    }

    public int inputRetryCommand() {
        String retryCommand = Console.readLine();
        if (validation.isInteger(retryCommand)) {
            validation.validateCommand(retryCommand);
        }

        return Integer.parseInt(retryCommand);
    }
}
