import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.util.*;

public class Suite extends HashSet<Flight> {

   private String suiteName;

    public Suite() {

    }

    public Suite(String suiteName) {
        this.suiteName = suiteName;
    }

    public Suite(String suiteName, Flight... t) {
        this.suiteName = suiteName;
        Collections.addAll(this, t);
    }

    private LinkedList<Flight> get() {
        return new LinkedList<>(this);
    }

    public void add(Suite suite) {
        this.get().addAll(suite);
    }

    public String getName() {
        return suiteName;
    }

    public void sortByProperty(String... propertyName) {
        ComparatorChain chain = new ComparatorChain();
        for (String pr : propertyName) {
            chain.addComparator(new BeanComparator(pr));
        }
        this.get().sort(chain);
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



}




