public class Demo {

    public Demo() {
        this.mainSuiteAllFlights = new Suite();
        this.all = new Suite();
        this.mySuite1 = new Suite();
        this.mySuite2 = new Suite();
    }

    public Suite mainSuiteAllFlights;
    private Suite all;
    private Suite mySuite1;
    private Suite mySuite2;
    public Flight f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f8_exc, f10_exc;


    public void createFlights() {
        Flight f1 = new FlightBuilder("LR_4868", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4).build();
        Flight f2 = new FlightBuilder("TM_4687", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4).build();
        Flight f3 = new FlightBuilder("NS_2121", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4).build();
        Flight f4 = new FlightBuilder("KT_4846", Company.Hawaian, "Kyiv", "Tokyo", AirPlane.BOEING_777, 123.4, 23.4).build();
        Flight f5 = new FlightBuilder("TV_3231", Company.JetBlue, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4).build();
        Flight f6 = new FlightBuilder("BB_1234", Company.British, "Beijing", "Boston", AirPlane.AIRBUS_A320, 98.6, 56.4).build();
        Flight f7 = new FlightBuilder("TM_8418", Company.British, "Tokyo", "Bratislava", AirPlane.BOEING_747, 89.6, 88.4).build();
        Flight f8 = new FlightBuilder("NS_4687", Company.American, "NY", "Magadan", AirPlane.BOEING_737, 327.1, 56.4).build();
        Flight f8_exc = new FlightBuilder("NS_4687", Company.American, "NY", "NY", AirPlane.BOEING_737, 327.1, 56.4).build();
        Flight f9 = new FlightBuilder("KT_6569", Company.Ukrainian, "Budapest", "Tel Aviv", AirPlane.BOEING_777, 656.4, 23.4).build();
        Flight f10 = new FlightBuilder("TV_8447", Company.Hawaian, "Boston", "Paris", AirPlane.BOEING_747, 193.4, 23.4).build();
        Flight f10_dupl = new FlightBuilder("TV_8447", Company.Hawaian, "Boston", "Paris", AirPlane.BOEING_747, 193.4, 23.4).build();
        mainSuiteAllFlights = new Suite("---all---", f1, f2, f3, f4, f5, f6, f7, f8, f8_exc, f9, f10, f10_dupl);
        Printer.print(mainSuiteAllFlights, "All flights");
        all = new Suite("copyAll", mainSuiteAllFlights);
    }

    public void show_1() {
        Printer.print(mainSuiteAllFlights.getFlight("LR_4868"));
        Printer.print(mainSuiteAllFlights.getFlight("LR_4845"));
    }

    public void show_2() {
        mainSuiteAllFlights.add(new FlightBuilder("NS_4689", Company.American, "NY", "Magadan", AirPlane.BOEING_737, 387.1, 56.4).build());

        mySuite1 = new Suite("mySuite1", mainSuiteAllFlights.getAllByCompany(Company.American.name));
        mySuite2 = new Suite("mySuite2", mainSuiteAllFlights.getAllByDepartment("Tokyo"));
        Printer.print(mySuite1);
        Printer.print(mySuite2);

        Printer.printContainsCondition(mySuite2, mainSuiteAllFlights.getFlight("TM_8418"));
        Printer.printContainsCondition(mySuite2, mainSuiteAllFlights.getFlight("BB_1234"));
        Printer.printContainsCondition(mySuite1, mySuite2);
        Printer.printContainsCondition(mainSuiteAllFlights, mySuite1);
    }

    public void show_3() {
        Suite s1 = Merge.newAndSortedById("id", mySuite1, mySuite2);
        Printer.print(s1, "//об'єднати два упорядкованих набори L1 і L2 в один впорядкований набір L (впорядкування за Вашим бажанням).");
        Suite s2 = Merge.withAll(mySuite1, mySuite2);//1 3 4 5 12
        Printer.print(s2, "//входять хоча б в один з наборів L1 і L2.");
        Suite s4 = Merge.withRepeated(mySuite1, mySuite2);
        Printer.print(s4, "// входять одночасно в обидва набори L1 і L2.");
    }

    public void show_must_go_on() {
        Printer.print(mySuite2, "with f1,f3,f4");
        mySuite2.add(f5);
        Printer.print(mySuite2, "with f1,f2,f3 + f5");

        Suite mySuite3 = new Suite("mySuite3", f3, f4);
        Printer.print(mySuite3, "with f3,f4");

        Suite tmp1 = Merge.withAll(mySuite3, mySuite2);
        Printer.print(tmp1, "| в кінець набору L1 всі елементи набору L2.");
    }

    public void show_5() {
        mainSuiteAllFlights.listSortedBy("ticketPrice");
        Printer.print(mainSuiteAllFlights, "sorted by ticket price");

        mainSuiteAllFlights.listSortedBy("distance");
        Printer.print(mainSuiteAllFlights, "sorted by distance");

        mainSuiteAllFlights.listSortedBy("company", "ticketPrice");
        Printer.print(mainSuiteAllFlights, "sorted by company and ticket price");

        mainSuiteAllFlights.listSortedBy("distance", "airPlane");
        Printer.print(mainSuiteAllFlights, "sorted by distance, airPlane");
    }

    public void show_6() {
        all.removeById("TM_8418");
        Printer.print(all);
        all.removeByCompany("Ukrainian");
        Printer.print(all);
    }
}
