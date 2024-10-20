 public class transaction {
    public int transID;         // transaction id
    public int custID;          // cust id
    public int bikeID;          // bike id
    public String startDate;    // day the rental begins
    public int estDuration;     // day the rental is supposed to end
    public String endDate;      // day the rental actually ends
    public float due;           // amount due
    public float paid;          // amount paid
    public boolean status;      // open/close status

    // objects attached to the transaction such that customer ID and bike Deposit are reachable and dynamic
    public transaction(int newTransID, int newCustID, int newBikeID, String newStartDate, int newEstDuration, String newEndDate, float newDue, float newPaid, boolean newStatus){
        this.transID = newTransID;
        this.custID = newCustID;
        this.bikeID = newBikeID;
        this.startDate = newStartDate;
        this.estDuration = newEstDuration;
        this.endDate = newEndDate;
        this.due = newDue;
        this.paid = newPaid;
        this.status = newStatus;
    }

    // setter section
    public void setTransId(int newTransId){
        this.transID = newTransId;
    }
    public void setCustId(int newCustId){
        this.custID = newCustId;
    }
    public void setBikeId(int newBikeId){
        this.bikeID = newBikeId;
    }
    public void setStartDate(String date){
        this.startDate = date;
    }
    public void setEndDate(String date){
        this.endDate = date;
    }
    public void setDuration(int days){
        this.estDuration = days;
    }
    public void setAmountDue(float money){
        this.due = money;
    }
    public void setAmountPaid(float money){
        this.paid = money;
    }
    public void setStatus(boolean newStatus){
        this.status = newStatus;
    }

    //getters
    public int getTransId(){
        return this.transID;
    }
    public int getCustId(){
        return this.custID;
    }
    public int getBikeId(){
        return this.bikeID;
    }
    public String getStartDate(){
        return this.startDate;
    }
    public String getEndDate(){
        return this.endDate;
    }
    public int getEstimateDate(){
        return this.estDuration;    
    }
    public float getAmountDue(){
        return this.due;
    }
    public float getAmountPaid(){
        return this.paid;
    }
    public boolean getStatus(){
        return this.status;
    }

    // print section
    public void printTransId(){
        System.out.println("Transaction ID: "+this.transID);    
    }
    public void printCustId(){
        System.out.println("Customer ID: "+this.custID);
    }
    public void printBikeId(){
        System.out.println("Bike ID: "+this.bikeID);
    }
    public void printStartDate(){
        System.out.println("Start Date: "+this.startDate);
    }
    public void printEndDate(){
        System.out.println("End Date: "+this.endDate);
    }
    public void printEstimateDate(){
        System.out.println("Est Date: "+this.estDuration);
    }
    public void printAmountDue(){
        System.out.println("Amount Due: "+this.due);
    }
    public void printAmountPaid(){
        System.out.println("Amount Paid: "+this.paid);
    }
    public void printStatus(){
        System.out.println("Transaction Finished: "+this.status);
    }

    // display all function
    // for past transactions ONLY
    public void printAllInfo(){
        System.out.println("");
        printTransId();
        printCustId();
        printBikeId();
        printStartDate();
        printEstimateDate();
        printEndDate();
        printAmountDue();
        printAmountPaid();
        printStatus();
    }
}
