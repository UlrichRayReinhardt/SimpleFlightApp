public class FlightBuilder {

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

    public FlightBuilder(String id, Company company, String departure, String destination, AirPlane airPlane, double distance, double ticketPrice) {
        this.id = id;
        this.company = company.name;
        this.departure = departure;
        this.destination = destination;
        this.airPlane = airPlane.name();
        this.distance = distance;
        this.ticketPrice = ticketPrice;
    }

    public Flight build() {
        try {
            if (departure.equals(destination))
                throw new Exception("departure and destination couldn't be the same. Flight " + id + " is not created");
            return new Flight(this);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
