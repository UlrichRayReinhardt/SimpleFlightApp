import java.util.Comparator;
import java.util.NoSuchElementException;

public class Printer {

    public static void print(Suite suite) {
        print(suite, "");
    }

    public static void print(Suite suite, String message) {
        System.out.println("------------------\n" + suite.getName() + " " + message);
        for (Flight flight : suite)
            print(flight);
        System.out.println("------------------");
    }

    public static void printContainsCondition(Suite suite, Flight flight) {
        if (suite.contains(flight))
            System.out.println("Suite:" + suite.getName() + " contains " + flight.getId());
        else System.err.println("Нізя роздрукувати те чого нема");
    }

    public static void printContainsCondition(Suite one, Suite two) {
        if (one.containsAll(two))
            System.out.println("Suite:" + one.getName() + " contains " + two.getName());
        else System.out.println("No matches " + one.getName() + " in " + two.getName());
    }

    public static void print(Flight flight) {
        try {
            System.out.println(flight.toString());
        } catch (NullPointerException | NoSuchElementException e) {
            System.err.println("Нізя роздрукувати те чого нема");
        }
    }
    }


