package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ParamTest {
    @Mock
    AnimalSkills animalSkills;

    Feline f;

    @BeforeEach
    public void setup() {
        f = new Feline(animalSkills);
    }

    @ParameterizedTest
    @ValueSource(strings = {"alpha", "beta"})
    public void morningTest(String direction) {
        System.out.println(direction);
        f.morning();

        Mockito.verify(animalSkills).eat();
    }

    @ParameterizedTest
    @ValueSource(strings = {"gama", "delta"})
    public void nightTest(String direction) {
        System.out.println(direction);
        f.night();

        Mockito.verify(animalSkills).sleep();
    }
}