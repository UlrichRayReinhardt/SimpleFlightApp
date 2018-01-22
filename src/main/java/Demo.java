public class Demo {

    public Suite mainSuiteAllFlights;
    private Suite all_copy;
    private Suite mySuite1;
    private Suite mySuite2;
    private Suite mySuite3;
    private Suite mySuite4;
    public Flight f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f8_exc, f10_dupl;

    public Demo() {
        this.mainSuiteAllFlights = new Suite();
    }

    public void createFlights() {
        System.out.println("============ demo_init ===============");
        f1 = new FlightBuilder("LR_4868", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4).build();
        f2 = new FlightBuilder("TM_4687", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4).build();
        f3 = new FlightBuilder("NS_2121", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4).build();
        f4 = new FlightBuilder("KT_4846", Company.Hawaian, "Kyiv", "Tokyo", AirPlane.BOEING_777, 123.4, 23.4).build();
        f5 = new FlightBuilder("TV_3231", Company.JetBlue, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4).build();
        f6 = new FlightBuilder("BB_1234", Company.British, "Beijing", "Boston", AirPlane.AIRBUS_A320, 98.6, 56.4).build();
        f7 = new FlightBuilder("TM_8418", Company.British, "Tokyo", "Bratislava", AirPlane.BOEING_747, 89.6, 88.4).build();
        f8 = new FlightBuilder("NS_4687", Company.American, "NY", "Magadan", AirPlane.BOEING_737, 327.1, 56.4).build();
        f8_exc = new FlightBuilder("NS_4687", Company.American, "NY", "NY", AirPlane.BOEING_737, 327.1, 56.4).build();
        f9 = new FlightBuilder("KT_6569", Company.Ukrainian, "Budapest", "Tel Aviv", AirPlane.BOEING_777, 656.4, 23.4).build();
        f10 = new FlightBuilder("TV_8447", Company.Hawaian, "Boston", "Paris", AirPlane.BOEING_747, 193.4, 23.4).build();
        f10_dupl = new FlightBuilder("TV_8447", Company.Hawaian, "Boston", "Paris", AirPlane.BOEING_747, 193.4, 23.4).build();

        mainSuiteAllFlights = new Suite("---all---", f1, f2, f3, f4, f5, f6, f7, f8, f8_exc, f9, f10, f10_dupl);
        all_copy = new Suite("copyAll", mainSuiteAllFlights);
        mySuite1 = new Suite("mySuite1", f1, f2, f3, f4, f8);
        mySuite2 = new Suite("mySuite2", f1, f3, f4, f5);
        mySuite3 = new Suite("mySuite3", f3, f4, f9);

        Printer.print(mainSuiteAllFlights, "mainSuiteAllFlights");
        System.out.println("============ demo_init end ===============");
    }

    public void show_0() {
        Printer.print(mySuite3, "before adding");
        mySuite3.add(f7);
        Printer.print(mySuite3, "after adding");
    }


    public void show_1() {
        System.out.println("============ demo_show1 ===============");
        Printer.print(mainSuiteAllFlights.getFlight("LR_4868"), "");
        Printer.print(mainSuiteAllFlights.getFlight("LR_4845"), "LR_4845 is absent");
        System.out.println("============ demo_show1 end ===============");
    }

    public void show_2() {
        System.out.println("============ demo_show2 ===============");
        mainSuiteAllFlights.add(new FlightBuilder("NS_4689", Company.American, "NY", "Magadan", AirPlane.BOEING_737, 387.1, 56.4).build());

        Suite s1 = new Suite("mySuite1", mainSuiteAllFlights.getAllByCompany(Company.American.name));
        Suite s2 = new Suite("mySuite2", mainSuiteAllFlights.getAllByDepartment("Tokyo"));
        Printer.print(s1);
        Printer.print(s2);

        Printer.printContainsCondition(mySuite2, mainSuiteAllFlights.getFlight("TM_8418"));
        Printer.printContainsCondition(mySuite2, mainSuiteAllFlights.getFlight("BB_1234"));
        Printer.printContainsCondition(mySuite1, mySuite2);
        Printer.printContainsCondition(mainSuiteAllFlights, mySuite1);
        System.out.println("============ demo_show2 end ===============");
    }

    public void show_3() {
        System.out.println("============ demo_show3 ===============");
        Printer.print(mySuite1);
        Printer.print(mySuite2);
        Suite s1 = Merge.newAndSortedById("id", mySuite1, mySuite2);
        Printer.print(s1, "//об'єднати два упорядкованих набори L1 і L2 в один впорядкований набір L (впорядкування за Вашим бажанням)");
        Suite s2 = Merge.withAll(mySuite1, mySuite2);
        Printer.print(s2, "//входять хоча б в один з наборів L1 і L2");
        Suite s3 = Merge.withRepeated(mySuite1, mySuite2);
        Printer.print(s3, "// входять одночасно в обидва набори L1 і L2");
        System.out.println("============ demo_show3 end ===============");
    }

    public void show_4() {
        System.out.println("============ demo_show4 ===============");
        Printer.print(mySuite2);
        Printer.print(mySuite3);
        mySuite4 = new Suite("mySuite4", Merge.withAll(mySuite3, mySuite2));
        Printer.print(mySuite4, "| в кінець набору L1 всі елементи набору L2.");
        System.out.println("============ demo_show4 end ===============");
    }

    public void show_5() {
        System.out.println("============ demo_show5 ===============");
        mainSuiteAllFlights.listSortedBy("ticketPrice");
        Printer.print(mainSuiteAllFlights, "sorted by ticket price");

        mainSuiteAllFlights.listSortedBy("distance");
        Printer.print(mainSuiteAllFlights, "sorted by distance");

        mainSuiteAllFlights.listSortedBy("company", "ticketPrice");
        Printer.print(mainSuiteAllFlights, "sorted by company and ticket price");

        mainSuiteAllFlights.listSortedBy("distance", "airPlane");
        Printer.print(mainSuiteAllFlights, "sorted by distance, airPlane");
        System.out.println("============ demo_show5 end ===============");
    }

    public void show_6() {
        System.out.println("============ demo_show6 ===============");
        all_copy.removeById("TM_8418");
        Printer.print(all_copy);
        all_copy.removeByCompany("Ukrainian");
        Printer.print(all_copy);
        System.out.println("============ demo_show6 end ===============");
    }
}
