import org.apache.commons.collections.CollectionUtils;

import static java.util.Collections.addAll;

public class Merge {

    private static Suite L(boolean added) {
        return new Suite();
    }

    //сформувати набір L, включивши в нього по одному разу елементи, які входять хоча б в один з наборів L1 і L2.
    public static Suite withAll(Suite one, Suite two) {
        Suite suite = new Suite();
        suite.addAll(CollectionUtils.union(one, two));
        return suite;
    }

    //сформувати набір L, включивши в нього по одному разу елементи, які входять одночасно в обидва набори L1 і L2.
    public static Suite withRepeated(Suite one, Suite two) {
        Suite suite = new Suite();
        suite.addAll(CollectionUtils.intersection(one, two));
        return suite;
    }

    // об'єднати два упорядкованих набори L1 і L2 в один впорядкований набір L (впорядкування за Вашим бажанням).
    public static Suite newAndSortedById(String prop, Suite one, Suite two) {
        Suite suite = new Suite();
        suite.addAll(CollectionUtils.union(one, two));
        return suite.listSortedBy("id");
    }
}
