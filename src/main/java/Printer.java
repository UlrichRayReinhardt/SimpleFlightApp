import java.util.NoSuchElementException;

public class Printer {

    public static void print(Suite suite) {
        print(suite, "");
    }

    public static void print(Suite suite, String message) {
        System.out.println("------------------\n" + suite.getName() + " " + message + "| total: " + suite.size());
        for (Flight flight : suite)
            print(flight, "");
    }

    public static void printContainsCondition(Suite suite, Flight flight) {
        if (suite.contains(flight))
            System.out.println("Suite:" + suite.getName() + " contains " + flight.getId());
        else System.err.println("Нізя роздрукувати те чого нема: " + flight.getId());
    }

    public static void printContainsCondition(Suite source, Suite check) {
        if (source.containsAll(check))
            System.out.println("Suite:" + source.getName() + " contains " + check.getName());
        else System.out.println("No matches " + source.getName() + " in " + check.getName());
    }

    public static void print(Flight flight, String message) {
        try {
            System.out.println(flight.toString() + " " + message);
        } catch (NullPointerException | NoSuchElementException e) {
            System.err.println("Нізя роздрукувати те чого нема: " +message);
        }
    }
}


