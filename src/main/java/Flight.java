import java.lang.reflect.Field;

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

    public Flight(String id, Company company, String departure, String destination, AirPlane airPlane, double distance, double ticketPrice) {
        this.id = id;
        this.company = company.name();
        this.departure = departure;
        this.destination = destination;
        this.airPlane = airPlane.name();
        this.distance = distance;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id='" + id + '\'' +
                ", company=" + company +
                ", departure='" + departure + '\'' +
                ", destination='" + destination + '\'' +
                ", airPlane=" + airPlane +
                ", distance=" + distance +
                ", ticketPrice=" + ticketPrice +
                '}';
    }


    public boolean predicate(String fieldname, String prop) {
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
    }}