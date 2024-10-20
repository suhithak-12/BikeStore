import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;

public class driverTransaction {
    static ArrayList<transaction> currTransactions = new ArrayList<transaction>();
    static ArrayList<transaction> pastTransactions = new ArrayList<transaction>();

    // starting section

    public static void initialize(){
        fillTransactions("pastTrans.csv");
    }

    public static void close(){
        saveTransactions();
    }

    public static ArrayList<transaction> exportList(){
        return pastTransactions;
    }

    public static ArrayList<transaction> exportCurrList(){
        return currTransactions;
    }

    public static void importList(ArrayList<transaction> transactions){
        pastTransactions = transactions;
    }

    public static void saveTransactions(){
        concatTransactions();
        csvHandling.csvUpdateTransaction(pastTransactions);
        currTransactions.clear();
    }

    public static void concatTransactions(){
        pastTransactions.addAll(currTransactions);
    }

    public static void fillTransactions(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {          
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 9) { // number of columns present in CSV
                    transaction oldTransaction = new transaction(
                            Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]), data[3], Integer.parseInt(data[4]), 
                            data[5], Float.parseFloat(data[6]), Float.parseFloat(data[7]), Boolean.parseBoolean(data[8]));              
                    pastTransactions.add(oldTransaction);
                } else {
                    System.err.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // inputs 

    public static int findLastTranactionID(){
        int size = pastTransactions.size();
        transaction lastTransaction = pastTransactions.get(size-1);
        int lastID = lastTransaction.transID;
		return lastID;
    }

    // main new transaction
    public static void newTransaction(int customerID, int bikeID, String startDate, int estDays){
        bike checkBike = driverBike.searchIDNoArray(bikeID);
        if ((checkBike.stateBike).equals("Out")){
            return;
        }
        int newTransactionID = findLastTranactionID() + 1 + currTransactions.size();
        String endDate = "N/A";
        float due = 0;
        float paid = 0;
        boolean status = false;
        transaction newTransaction = new transaction(
            newTransactionID, customerID, bikeID, startDate, 
            estDays, endDate, due, paid, status);
        currTransactions.add(newTransaction);
    }
}