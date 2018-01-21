import java.lang.reflect.Field;

public class Contra {
    public static void main(String[] args) {
        Flight f1 = new Flight("F1", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4);
        Flight f2 = new Flight("F2", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4);
        Flight f3 = new Flight("F3", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4);
        Flight f4 = new Flight("F4", Company.Ukrainian, "Kyiv", "Vinnitsa", AirPlane.BOEING_777, 123.4, 23.4);
        Flight f5 = new Flight("F5", Company.Ukrainian, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4);

        Suite all = new Suite("all", f1, f2, f3, f4, f5);

        Contra contra = new Contra();
        for (Flight flight:all){
        contra.isAllowed(flight,"destination","Vinnitsa");
    }}
/*
        String fieldName = "id";
        String search = "F1";
        Field field;
        try {
            field = f1.getClass().getDeclaredField(fieldName);
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(f1);
            if (value.equals(search)) {
                System.out.println("true, search " + search + " : value " + value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
*/


    public void isAllowed(Flight flight, String fieldname, String prop) {
        Field field;
        try {
            field = flight.getClass().getDeclaredField(fieldname);
            field.setAccessible(true); // You might want to set modifier to public first.
            Object value = field.get(flight);
            if (value.equals(prop)) {
                System.out.println("true, search " + prop + " : value " + value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }    // this.stream().filter(flight -> field1.get(flight). == prop).forEach(System.out::println);
    }
}
