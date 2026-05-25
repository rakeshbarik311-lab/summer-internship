 Defining the Interface
interface Calculator {
    // Abstract methods (no body)
    void add();
    void subtract(); // Spelled as "subastract" in your notes

    // Default method (introduced in Java 8)
    default void multiply() {
        System.out.println("Default multiply method from Interface");
    }

    // Static method (introduced in Java 8)
    static void div() {
        System.out.println("Static division method from Interface");
    }
}

 Class A implementing the Interface
class A implements Calculator {
    @Override
    public void add() {
        System.out.println("parent class implement");
    }

    @Override
    public void subtract() {
        System.out.println("Subtract method implemented in Class A");
    }
}
 Class B extending Class A (Inheritance)
class B extends A {
    // Overriding the add() method from Class A
    @Override
    public void add() {
        System.out.println("I have money no need parent money");
    }
}

 Main Demo Class to run the program
public class Demo {
    public static void main(String[] args) {
        // Creating an object of Class A
        A a1 = new A();
        System.out.println("--- Calling methods on object of A ---");
        a1.add();       // Calls Class A's implementation
        a1.subtract();
        
        System.out.println("\n--- Calling methods on object of B ---");
        // Creating an object of Class B
        B b1 = new B();
        b1.add();       // Calls Class B's overridden implementation
        b1.multiply();  // Calls the default method inherited from the interface
        
        System.out.println("\n--- Calling static interface method ---");
        // Static interface methods are called directly using the Interface name
        Calculator.div(); 
    }
}