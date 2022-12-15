package baseball.domain;

public class Validation {

    private static final String IS_NOT_INTEGER_ERROR_MESSAGE = "[ERROR] 숫자를 입력해주세요.";
    private static final String INPUT_SIZE_ERROR_MESSAGE = "[ERROR] 3자리 숫자를 입력해주세요.";
    private static final String INPUT_NUMBER_ERROR_MESSAGE = "[ERROR] 서로 다른 3자리 숫자를 입력해주세요.";
    private static final String INPUT_COMMAND_ERROR_MESSAGE = "[ERROR] 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(IS_NOT_INTEGER_ERROR_MESSAGE);
        }

        return true;
    }

    public void validateSize(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException(INPUT_SIZE_ERROR_MESSAGE);
        }
    }

    public void validateDifferentNumbers(String number) {
        if (number.charAt(0) == number.charAt(1) ||
                number.charAt(1) == number.charAt(2) ||
                number.charAt(0) == number.charAt(2)) {
            throw new IllegalArgumentException(INPUT_NUMBER_ERROR_MESSAGE);
        }
    }

    public void validateCommand(String command) {
        if (!(command.equals("1") || command.equals("2"))) {
            throw new IllegalArgumentException(INPUT_COMMAND_ERROR_MESSAGE);
        }
    }
}
