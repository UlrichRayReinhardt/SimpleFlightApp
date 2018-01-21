import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.comparators.ComparatorChain;

import java.lang.reflect.Field;
import java.util.*;

public class Suite extends LinkedList<Flight> {

    String suiteName;

    public Suite(String suiteName) {
        this.suiteName = suiteName;
    }

    public Suite(String suiteName, Flight... t) {
        this.suiteName = suiteName;
        Collections.addAll(this, t);
    }

    public List<Flight> get() {
        return this;
    }

    public void add(Suite suite) {
        this.get().addAll(suite);
    }

    public String getName() {
        return suiteName;
    }

    public void sortByProperty(String propertyName) {
        Comparator/*<Flight>*/ comp = new BeanComparator(propertyName);
        Collections.sort(this.get(), comp);
    }

    public void sortByProperty(String... propertyName) {
        ComparatorChain chain = new ComparatorChain();
        for (String pr : propertyName) {
            chain.addComparator(new BeanComparator(pr));
        }
        Collections.sort(this.get(), chain);
    }





    public void removeById(String prop) {
        this.removeIf(flight -> flight.getId() == prop);
    }
    public void dosth(String prop) {
        try {
            Field field1 = Flight.class.getDeclaredField("id");
            field1.setAccessible(true);
            System.out.println(field1.getName());
           // this.stream().filter(flight -> field1.get(flight). == prop).forEach(System.out::println);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void removeByCompany(String prop) {
        this.removeIf(flight -> flight.getCompany() == prop);
    }

    public void removeByProperty(String propertyName, String property) {
        Comparator<Flight> comp = new BeanComparator(propertyName);
       // this.stream().allMatch(this.get(), comp);
    }
}




