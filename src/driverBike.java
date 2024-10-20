// creating bikes
// updating bikes
// handling arraylist
// searching by id
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class driverBike{  
    static ArrayList<bike> driverBikes = new ArrayList<bike>();   

    public static void initialize(){
        readBikesFromCSV("bikes.csv");
    }

    public static void close(){
        csvHandling.csvUpdateBike(driverBikes);
    }

    public static ArrayList<bike> exportList(){
        return driverBikes;
    }

    public static void importList(ArrayList<bike> bikes){
        driverBikes = bikes;
    }

    public static void updateBike(bike updateBike, boolean Out){
        if (Out){
            updateBike.setstateBike("Out");
        } else {
            updateBike.setstateBike("In");
        }
    }

    public static bike searchID(int ID, ArrayList<bike> bikes) {
        for (bike Bike: bikes) {
            if ((int) Bike.getID() == ID){
                return Bike; //returning the bike if found by id.
            }
        }
        return null; //if no bike found.
    }

    public static bike searchIDNoArray(int ID) {
        for (bike Bike: driverBikes) {
            if ((int) Bike.getID() == ID){
                return Bike; //returning the bike if found by id.
            }
        }
        return null; //if no bike found.
    }

    public static void print(ArrayList<bike> printingBikes){
        for (bike c : printingBikes) {       //loops through array
            c.print();              //prints the bikes array
            System.out.println(); // Print an empty line between customers
        } 
    }
    
    public static boolean bikeIDValid(int bikeID, ArrayList<bike> bike){
        boolean DNE = false;
        bike checkBike = searchID(bikeID, bike);
        if (checkBike == null){
            DNE = false;
        }
        return DNE;
    }

    public static void readBikesFromCSV(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {           //we can use this same function for customers
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) { // Assuming there are 9 fields in the CSV
                    bike newBike = new bike(
                            Integer.parseInt(data[0]), data[1], data[2], data[3], data[4], Float.parseFloat(data[5]),       //this will change for number of fields
                            Float.parseFloat(data[6]), data[7], data[8]);                                 //all data is read in as a string
                    driverBikes.add(newBike);
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
