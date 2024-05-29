public class Dog {
    private String name;
    private String breed;
    private int age;

    // Default constructor
    public Dog() {
        this.name = "Tah";
        this.age = 8;
        this.breed = "Default breed";
    }

    // Initializing constructor
    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Dog(String name, int age, String breed){
        this("Foxen", 4);
        this.breed = breed;
    }

    public Dog(String n) {
        name = n;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void birthday(){
        this.age++;
        System.out.println("Happy Birthday " + this.name + ". You are " + this.age + " years old!");;
    }

    public void breedSwap(String newBreed){
        this.breed = newBreed;
        System.out.println(this.name + " is now a" + this.breed + "!");
    }

    @Override
    public String toString(){
        return "Dog[Name: " + this.name + " | Breed: " + this.breed + " | Age: " + this.age +"]"; 
    }

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        Dog dog2 = new Dog("Spot", 6);
        Dog dog3 = new Dog("Thomas");
        System.out.println(dog1.name);
        System.out.println(dog1.age);
        System.out.println(dog2.name);
        System.out.println(dog2.age);
        System.out.println(dog3.name);
        System.out.println(dog3.age);


        System.out.println(dog2.toString());
        System.out.println(dog3.toString());
    }
}
