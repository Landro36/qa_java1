import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;

public class ParamTest {

    @ParameterizedTest
    @CsvSource({
            "Самец, true",
            "Самка, false"
    })
    public void checkSex(String sex, boolean result) throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean hasMane = lion.doesHaveMane();
        assertEquals(result, hasMane);
    }
}