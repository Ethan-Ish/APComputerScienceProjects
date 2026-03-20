
/**
 * Write a description of class mainTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class mainTester
{
    public static void print(Object input)
    {
        System.out.println(input);
    }
    
    public static void main(String[] args){
        Person bob = new Person("Bob");
        Person bobTwin = new Person("Bob");
        Person alice = new Person("Alice");
        String fraudBob = "Bob";
        print(alice.toString()); // Name: Alice
        print(bob.equals(bobTwin)); // True
        print(bob.equals(fraudBob)); // False
        Vehicle car = new Vehicle("Tesla", 4, bob);
        Truck truck = new Truck("Cybertruck", 20, alice, 3.1, 400);
        truck.setLoadCapacity(1.5);
        truck.setTowCapacity(500);
        print(car.toString());
        print(truck.toString());
        truck.setLoadCapacity(1.2);
        truck.setTowCapacity(300);
        print(truck.toString());
        print(truck.getName());
        print(truck.getCylinders());
        print(truck.getOwner());
        truck.setName("Ford Offroader");
        truck.setCylinders(4);
        truck.setOwner(alice);
        print(truck.toString());
        print(truck.getName());
        print(truck.getCylinders());
        print(truck.getOwner());
        alice.setName("Alyce");
        print(alice.getName());
        Person aliceTwin = new Person(alice);
        print(aliceTwin.toString());
        Person slenderman = null;
        print(alice.equals(slenderman));
    }
}
