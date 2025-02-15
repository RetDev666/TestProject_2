import java.util.ArrayList;

// Базовий клас для всіх тварин
class Animal {
    private String name;
    private int age;
    private String species;
    private boolean isHungry;
    private String favoriteFood;

    public Animal(String name, int age, String species, String favoriteFood) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.isHungry = true;
        this.favoriteFood = favoriteFood;
    }

    // Геттери і сеттери
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecies() {
        return species;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    // Загальні методи для всіх тварин
    public void makeSound() {
        System.out.println(name + " видає звук!");
    }

    public void eat(String food) {
        if (isHungry) {
            if (food.equals(favoriteFood)) {
                System.out.println(name + " із задоволенням їсть " + food + "!");
                isHungry = false;
            } else {
                System.out.println(name + " неохоче їсть " + food + ".");
                isHungry = false;
            }
        } else {
            System.out.println(name + " зараз не голодний!");
        }
    }

    public void sleep() {
        System.out.println(name + " спить.");
        setHungry(true);
    }
}

// Клас для левів
class Lion extends Animal {
    private boolean isKing;

    public Lion(String name, int age) {
        super(name, age, "Лев", "м'ясо");
        this.isKing = true;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " гордо рикає: РРРРРР!");
    }

    public void hunt() {
        System.out.println(getName() + " вийшов на полювання!");
        setHungry(true);
    }
}

// Клас для слонів
class Elephant extends Animal {
    private double trunkLength; // довжина хобота в метрах

    public Elephant(String name, int age, double trunkLength) {
        super(name, age, "Слон", "банани");
        this.trunkLength = trunkLength;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " трубить: ТУУУУ!");
    }

    public void spray() {
        System.out.println(getName() + " бризкає водою зі свого хобота!");
    }
}

// Клас для пінгвінів
class Penguin extends Animal {
    private boolean canSwim;

    public Penguin(String name, int age) {
        super(name, age, "Пінгвін", "риба");
        this.canSwim = true;
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " пищить: Пік-пік!");
    }

    public void swim() {
        System.out.println(getName() + " плаває в басейні!");
    }
}

// Клас для управління зоопарком
class Zoo {
    private ArrayList<Animal> animals;
    private String name;

    public Zoo(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " (" + animal.getSpecies() + ") додано до зоопарку " + name + "!");
    }

    public void feedAllAnimals() {
        System.out.println("\nЧас годування в зоопарку " + name + "!");
        for (Animal animal : animals) {
            animal.eat(animal.getFavoriteFood());
        }
    }

    public void makeAllSounds() {
        System.out.println("\nВсі тварини в зоопарку " + name + " подають голос!");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    public void nightTime() {
        System.out.println("\nНіч у зоопарку " + name + "!");
        for (Animal animal : animals) {
            animal.sleep();
        }
    }
}

// Головний клас програми
public class Main {
    public static void main(String[] args) {
        // Створюємо новий зоопарк
        Zoo myZoo = new Zoo("Дивосвіт");

        // Створюємо тварин
        Lion simba = new Lion("Сімба", 5);
        Lion mufasa = new Lion("Муфаса", 10);
        Elephant dumbo = new Elephant("Дамбо", 3, 1.5);
        Penguin rico = new Penguin("Ріко", 2);

        // Додаємо тварин до зоопарку
        myZoo.addAnimal(simba);
        myZoo.addAnimal(mufasa);
        myZoo.addAnimal(dumbo);
        myZoo.addAnimal(rico);

        // Демонструємо різні дії
        myZoo.makeAllSounds();

        simba.hunt();
        dumbo.spray();
        rico.swim();

        myZoo.feedAllAnimals();
        myZoo.nightTime();
    }
}