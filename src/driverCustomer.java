//handle arraylist
//common methods to manipulate customers
//creating and searching
//return the int of the id for searching
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class driverCustomer {
    static ArrayList<customer> customerList = new ArrayList<customer>();

    public static void initializeC() {
        readCustomerFromCSV("customer.csv");
    }

    public static void close(){
        csvHandling.csvUpdateCustomer(customerList);
    }

    public static ArrayList<customer> exportList(){
        return customerList;
    }

    public static void importList(ArrayList<customer> customers){
        customerList = customers;
    }

    public static int getLastID() {
        int size = customerList.size();
        if (size == 0) return 0; // Check if the list is empty
        customer lastCustomer = customerList.get(size - 1);
        int lastID = lastCustomer.ID;
        return lastID;
    }

    public static void createNewCustomer(String firstName, String lastName, String address, String phoneNumber) {
        int newID = getLastID() + 1;
        customer newCustomer = new customer(newID, firstName, lastName, address, phoneNumber);
        customerList.add(newCustomer);
    }

    public static void printALL() {
        for (customer c : customerList) { // loops through array
            c.printC(); // prints the customer array
            System.out.println(); // Print an empty line between customers
        }
    }

    public static int findCustomerByPhone(String PhoneNumber) {
        int ID = -1;
        for (customer c : customerList) {
            if ((PhoneNumber).equals(c.phone)) {
                ID = c.ID;
                break; // Stop loop once the customer is found
            }
        }
        return ID;
    }

    public static void readCustomerFromCSV(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { // we can use this same function for customers
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) { // Assuming there are 5 fields in the CSV
                    customer newcustomer = new customer(
                            Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]); // all data is read in as a string
                    customerList.add(newcustomer);
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}