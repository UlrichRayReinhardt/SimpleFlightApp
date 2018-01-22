import java.lang.reflect.Field;
import java.util.Objects;

public class Flight {
    private String id;
    private String company;
    private String departure;
    private String destination;
    private String airPlane;
    private double distance;
    private double ticketPrice;

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getAirPlane() {
        return airPlane;
    }

    public double getDistance() {
        return distance;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public Flight(FlightBuilder builder){
        this.id = builder.getId();
        this.company = builder.getCompany();
        this.departure = builder.getDeparture();
        this.destination = builder.getDestination();
        this.airPlane = builder.getAirPlane();
        this.distance = builder.getDistance();
        this.ticketPrice = builder.getTicketPrice();
    }



    @Override
    public String toString() {
        return id + " | " + company +
                " | " + departure + " -> " + destination +
                " | " + airPlane +
                " | " + distance + "km | " +
                ticketPrice + "$";
    }

    public boolean equals(Flight flight) {
        return Objects.equals(id, flight.id)
                && Objects.equals(company, flight.company);
    }
    /*public boolean predicate(String fieldname, String prop) {
        Field field;
        try {
            field = this.getClass().getDeclaredField(fieldname);
            field.setAccessible(true);
            Object value = field.get(this);
            if (value.equals(prop))
                return true;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }*/
}