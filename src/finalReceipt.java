
public class finalReceipt {
    public int customerID;
    public double total;
    
    public finalReceipt(transaction close, bike out){
        customerID = close.custID;
        total = finalCost(close, out);
    }

    public static double finalCost(transaction close, bike out){
        double total = 0;
        int duration = close.estDuration;
        double rate = out.rate;
        total = (duration * rate) - out.getdeposit();
        close.setAmountPaid((float) total);
        return total;
    }

    // getters

    public int getCustID(){
        return this.customerID;
    }

    public double getTotal(){
        return this.total;
    }
}
