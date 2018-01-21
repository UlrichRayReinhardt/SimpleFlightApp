import java.util.Comparator;

public class Printer {

    public static void print(Suite suite) {
        System.out.println(suite.getName());
        suite.forEach(System.out::println);
        System.out.println("------------------");
    }

    public static void print(Suite suite, String message) {
        System.out.println(suite.getName() + " " + message + "\n------------------");
        suite.forEach(System.out::println);
        System.out.println("------------------");
    }

    public static void print(Suite suite, Comparator comparator) {
        System.out.print(suite.getName());
        suite.forEach((ele) -> System.out.print(ele + " , "));
        System.out.println("------------------");
    }

    public static void print(Flight flight) {
        System.out.println(flight.toString());

    }
}


