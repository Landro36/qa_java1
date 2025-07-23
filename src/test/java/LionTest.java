import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class LionTest {

    @Test
    public void lionFoodIsMeat() throws Exception {
        Lion lion = new Lion("Самец");
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
    public void incorrectTest() throws Exception   {
        Exception exception = assertThrows(Exception.class, () -> {
            Animal animal = new Animal();
            animal.getFood("Вода");
        });
        String expectedResult = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        assertEquals(expectedResult, exception.getMessage());
    }
    @Test
    public void incorrectLionSexTest() throws Exception   {
        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("оно");
        });
        String expectedResult = "Используйте допустимые значения пола животного - самей или самка";
        assertEquals(expectedResult, exception.getMessage());
    }

    @Test
    public void getKittensTest() throws Exception {
        Lion lion = new Lion("Самец");
        int expectedResult = 1;
        assertEquals(expectedResult, lion.getKittens());
    }

}