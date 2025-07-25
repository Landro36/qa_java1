import com.example.Animal;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
public class FelineTest {
    Feline feline = new Feline();

    @Test
    public void felineGetFamilyPositive() {
        String expected = "Кошачьи";
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals(expected, actual);
    }

    @Test
    public void felineFoodIsMeat() throws Exception {
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(feline.eatMeat(), expectedResult);
    }

    @Test
    public void getFamily() {
        Animal animal = new Animal();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(animal.getFamily(), expectedResult);
    }
}
