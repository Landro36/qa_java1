package praktikum;

public class Feline {
    private AnimalSkills animalSkills;

    public Feline(AnimalSkills animalSkills) {
        this.animalSkills = animalSkills;
    }
    public void morning() {
        animalSkills.eat();
    }

    public void night() {
        animalSkills.sleep();
    }
}