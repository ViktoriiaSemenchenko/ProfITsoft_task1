import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class PositiveTest {

    @Test
    void positive() {

        int [] array = Main.Positive(new int[]{9, -2, 6, -7, -4, 3, -1, 1, 8, -6});
        assertArrayEquals(new int[]{9, 8, 6, 3, 1}, array);

    }
}