import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
// common methods to update our csv's
// take in arraylist and string
// reinput all values to specified string file
// example: csvUpdateCustomer(Arraylist<customer> customers, "customer.csv")
public class csvHandling{ 
    public static void csvUpdateCustomer(ArrayList<customer> inputCustomer){
        File c = new File("customer.csv");
        FileWriter cust = null;
        BufferedWriter cF = null;
        
        try {
                int j = 0;
                cust = new FileWriter(c, false);
                cF = new BufferedWriter(cust);
                for (customer i : inputCustomer){
                        j++;
                        cF.write(i.getCID() + "," + i.getFName() + "," + i.getLName() + "," + i.getAddress() + "," + i.getPhone());
                        if (j != inputCustomer.size()){
                                cF.write("\n");
                        }
                }

        } catch (IOException e){
                e.printStackTrace();
        } finally {
                try{
                        cF.close();
                        cust.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
    }

    public static void csvUpdateBike(ArrayList<bike> inputBike){
        File b = new File("bikes.csv");
        FileWriter bike = null;
        BufferedWriter bF = null;
        try {
                int j = 0;
                bike = new FileWriter(b, false);
                bF = new BufferedWriter(bike);
                for (bike i : inputBike){
                        j++;
                        bF.write(i.getID() + "," + i.gettype() + "," + i.getsize() + "," +
                        i.getmake() + "," + i.getmodel() + "," + i.getrate() + "," + 
                        i.getdeposit() + "," + i.getstateBike() + "," + i.getnotes());
                        if (j != inputBike.size()){
                                bF.write("\n");
                        }
                }

        } catch (IOException e){
                e.printStackTrace();
        } finally {
                try{
                        bF.close();
                        bike.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
    }
    
    public static void csvUpdateTransaction(ArrayList<transaction> inputTransactions){
        File t = new File("pastTrans.csv");
        FileWriter trans = null;
        BufferedWriter tF = null;
        try {
                int j = 0;
                trans = new FileWriter(t, false);
                tF = new BufferedWriter(trans);
                for (transaction i : inputTransactions){
                        j++;
                        tF.write(i.getTransId() + "," + i.getCustId() + "," + i.getBikeId() + "," +
                        i.getStartDate() + "," + i.getEstimateDate() + "," + i.getEndDate() + "," + 
                        i.getAmountDue() + "," + i.getAmountPaid() + "," + i.getStatus());
                        if (j != inputTransactions.size()){
                                tF.write("\n");
                        }
                }
        } catch (IOException e){
                e.printStackTrace();
        } finally {
                try{
                        tF.close();
                        trans.close();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        }
    }