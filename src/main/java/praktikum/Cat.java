package praktikum;

public class Cat implements AnimalSkills{
    @Override
    public void eat() {
        System.out.println("Кот ест");
    }

    @Override
    public void sleep() {
        System.out.println("Кот спит");
    }
}