package praktikum;

public class Lion implements AnimalSkills{
    @Override
    public void eat() {
        System.out.println("Лев ест");
    }

    @Override
    public void sleep() {
        System.out.println("Лев спит");
    }
}