package praktikum;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    @Mock
    AnimalSkills animalSkills;

    @Spy
    Lion inca = new Lion();

    Feline f;

    @BeforeEach
    public void setup() {
        f = new Feline(animalSkills);
    }

    @Test
    public void morning() {
        f.morning();

        Mockito.verify(animalSkills).eat();
    }

    @Test
    public void realMorning() {
        var f = new Feline(inca);

        f.morning();

        Mockito.verify(inca).eat();
    }

    @Test
    public void night() {
        f.night();

        Mockito.verify(animalSkills).sleep();
    }

    @Test
    public void realNight() {
        var f = new Feline(inca);

        f.night();

        Mockito.verify(inca).sleep();
    }
}
