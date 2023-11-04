package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        if (isDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicateNumber(List<Integer> numbers) {
        List<Integer> removedDuplicateNumbers = numbers.stream()
                .distinct()
                .toList();

        return numbers.size() != removedDuplicateNumbers.size();
    }

    public WinningLotto compareWinningNumbers(List<Integer> winningNumbers, Integer bonus) {
        int matchWinningNumbersCount = this.countWinningNumbers(winningNumbers);
        int matchBonusCount = this.countBonusMatch(bonus);

        return Arrays.stream(WinningLotto.values())
                .filter(winningLotto -> winningLotto.getLottoRank(matchWinningNumbersCount, matchBonusCount))
                .findFirst()
                .orElse(WinningLotto.LAST_PLACE);
    }

    private int countWinningNumbers(List<Integer> winningNumbers) {
        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    private int countBonusMatch(Integer bonus) {
        if (this.numbers.contains(bonus)) {
            return 1;
        }

        return 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
