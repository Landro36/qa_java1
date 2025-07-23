import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CatTest {
    @Mock
    Feline feline;
    @Spy
    Feline inca = new Feline();
    Cat cat;
    @BeforeEach
    public void setup() {
        cat = new Cat(feline);
    }

    @Test
    public void getFood() throws Exception {
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFoodSpy() throws Exception {
        var cat = new Cat(inca);
        cat.getFood();
        Mockito.verify(inca).eatMeat();
    }

    @Test
    public void catGetSoundMeow() {
        String expectedResult = "Мяу";
        assertEquals(cat.getSound(), expectedResult);
    }

    @Test
    public void catGetSoundNegative() {
        String expectedResult = "Кря";
        assertNotEquals(cat.getSound(), expectedResult);
    }

    @Test
    public void catEatMeatFood () throws Exception {
        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = cat.getFood();
        assertEquals(expectedResult, actualResult);
    }
}