import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void lionFoodIsMeat() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedResult, lion.getFood());
    }

    @Test
    public void herbivoreFoodIsHerb() throws Exception {
        Animal animal = new Animal();
        List<String> expectedResult = List.of("Трава", "Различные растения");
        assertEquals(expectedResult, animal.getFood("Травоядное"));
    }

    @Test
    public void incorrectFood() throws Exception   {
        Exception exception = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("Вода");
        });
        String expectedResult = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedResult, exception.getMessage());
    }
    @Test
    public void incorrectLionSex() throws Exception   {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("оно", new Feline());
        });
        String expectedResult = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expectedResult, exception.getMessage());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец", new Feline());
        int expectedResult = 1;
        assertEquals(expectedResult, lion.getKittens());
    }

    @Test
    public void lionGenderTrue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        boolean expectedHasMane = true;
        boolean actualHasMane = lion.doesHaveMane();
        assertEquals(expectedHasMane, actualHasMane);
    }

    @Test
    public void getLionDoNotHaveKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedGetKittens = 0;
        int actualGetKittens = lion.getKittens();
        assertEquals(expectedGetKittens, actualGetKittens);
    }
}