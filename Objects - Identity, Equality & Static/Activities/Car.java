package Activities;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private String VIN;

    private static int car_count;

    public Car(String make, String model, int year, String color, String VIN){
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.VIN = VIN;
        car_count++;
    }

    public String getMake() { return make; }

    public String getModel() { return model; }

    public int getYear() { return year; }

    public String getColor() { return color; }

    public String getVIN() { return VIN; }

    public void setColor() { this.color = color; }

    public static int getCar_count(){ return car_count; }

    @Override
    public String toString(){
        return "The car of the model: " + getModel() + " and make " + getMake() + " year: " + getYear() + " color: " + getColor() + " and VIN: " + getVIN();
    }

    @Override
    public boolean equals(Object c){
        if(c instanceof Car){
            Car car = (Car) c;
            return car.VIN == this.VIN;
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("Car count: " + getCar_count());
        Car c1 = new Car("Ford", "Escape", 2017, "Red", "1AD46HGT");
        System.out.println("Car count: " + getCar_count());

        Car c2 = new Car("Ford", "Escape", 2017, "Red", "1AD46HGT");
        System.out.println("Car count: " + getCar_count());

        Car c3 = c1;
        System.out.println("Car count: " + getCar_count());

        Car c4 = new Car("Dodge", "Arrive", 2010, "Blue", "YHL1547");
        System.out.println("Car count: " + getCar_count());

        System.out.println("c1: " + c1.toString());
        System.out.println("c2: " + c2.toString());
        System.out.println("c3: " + c3.toString());
        System.out.println("c4: " + c4.toString());


        System.out.println("c1 == c2: " + (c1==c2));
        System.out.println("c1 == c3: " + (c1==c3));

        System.out.println("c1.equals(c2): " + (c1.equals(c2)));
        System.out.println("c1.equals(c4): " + (c1.equals(c4)));

    }
}
