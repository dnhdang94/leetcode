package vn.dangdnh;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    Solution solution;

    private static Stream<Arguments> inputOutputProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1}, 2),
                Arguments.of(new int[]{1, 2, 0}, 3),
                Arguments.of(new int[]{3, 4, -1, 1}, 2),
                Arguments.of(new int[]{7, 8, 9, 11, 12}, 1)
        );
    }

    @BeforeEach
    public void init() {
        solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource("inputOutputProvider")
    void test(int[] nums, int expected) {
        int val = solution.firstMissingPositive(nums);
        Assertions.assertEquals(expected, val);
    }
}
