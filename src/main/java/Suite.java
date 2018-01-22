import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.util.*;
import java.util.stream.Collectors;

public class Suite extends HashSet<Flight> {

    private String suiteName;

    public Suite() {

    }

    public Suite(String suiteName, Flight... t) {
        this.suiteName = suiteName;
        for (Flight flight : t) addIfNotNull(flight);
    }

    public Suite(String suiteName, List<Flight> t) {
        this.suiteName = suiteName;
        for (Flight flight : t) addIfNotNull(flight);
    }


    public Suite(String suiteName, Suite suite) {
        this.suiteName = suiteName;
        for (Flight flight : suite.get()) addIfNotNull(flight);
    }

    private LinkedList<Flight> get() {
        return new LinkedList<>(this);
    }

    public String getName() {
        return suiteName;
    }

    public void addIfNotNull(Flight flight) {
        if (flight != null && !this.contains(flight))
            this.add(flight);
    }
        public boolean contains(Flight o) {
        for (Flight flight : this)
            if (o.equals(flight))
                return true;
        return false;
    }

    public Suite listSortedBy(String... propertyName) {
        ComparatorChain chain = new ComparatorChain();
        for (String pr : propertyName) {
            chain.addComparator(new BeanComparator(pr));
        }
        this.get().sort(chain);
        return this;
    }

    public List<Flight> getAllByCompany(String prop) {
       return this.stream().filter(flight -> flight.getCompany() == prop).collect(Collectors.toList());
    }

    public List<Flight> getAllByDestination(String prop) {
        return this.stream().filter(flight -> flight.getDestination() == prop).collect(Collectors.toList());
    }

    public List<Flight> getAllByDepartment(String prop) {
        return this.stream().filter(flight -> flight.getDeparture() == prop).collect(Collectors.toList());
    }

    public void removeByCompany(String prop) {
        this.removeIf(flight -> flight.getCompany() == prop);
    }

    public void removeById(String prop) {
        this.removeIf(flight -> flight.getId() == prop);
    }

    public void removeByDeparture(String prop) {
        this.removeIf(flight -> flight.getId() == prop);
    }

    public void removeByDestination(String prop) {
        this.removeIf(flight -> flight.getId() == prop);
    }

    public void removeByAirPlane(String prop) {
        this.removeIf(flight -> flight.getId() == prop);
    }


    public Flight getFlight(String flight_id) {
        return stream().filter(flight -> flight.getId() == flight_id).findFirst().orElse(null);
    }}




