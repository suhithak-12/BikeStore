import java.util.ArrayList;

public class initialReceipt {
    public ArrayList<transaction> currTransactions;
    public ArrayList<bike> bikesOut;
    public int customerID;
    public double total;
    
    public initialReceipt(ArrayList<transaction> currentTransactions){
        this.currTransactions = currentTransactions;
        customerID = initializeCustomerID(currentTransactions);
        bikesOut = initializeBikesOut(currentTransactions);
        total = initialCost(currentTransactions);
    }

    public int initializeCustomerID(ArrayList<transaction> currentTransactions){
        int ID = -1;
        for (transaction i : currentTransactions){
            ID = i.custID;
        }
        return ID;
    }

    public ArrayList<bike> initializeBikesOut(ArrayList<transaction> currentTransactions){
        ArrayList<bike> newList = new ArrayList<bike>();
        for (transaction i : currentTransactions){
            bike addingBike = driverBike.searchIDNoArray(i.bikeID);
            addingBike.setstateBike("Out");
            newList.add(addingBike);
        }
        return newList;
    }

    public static double initialCost(ArrayList<transaction> currentTransactions){
        float total = 0;
        for (transaction i : currentTransactions){
            int duration = i.estDuration;
            double deposit = (driverBike.searchIDNoArray(i.bikeID)).deposit;
            double rate = (driverBike.searchIDNoArray(i.bikeID)).rate;
            i.paid = (float) ((duration * rate) + deposit);
            i.due = (float) ((duration * rate));
            total += (duration * rate) + deposit;
        }
        return total;
    }

    // getters

    public ArrayList<bike> getBikesOut(){
        return this.bikesOut;
    }

    public int getCustID(){
        return this.customerID;
    }

    public double getTotal(){
        return this.total;
    }
}
