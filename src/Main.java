
public class Main {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {   
        driverBike.initialize();
        driverCustomer.initializeC();
        driverTransaction.initialize();
        new LoginGUI();
    }                                                                           // end of menu
}