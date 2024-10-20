
public class bike 
{
    public int ID; //bike id
    public String type; //byke type
    public String size; //bike size (big, small, adult, child etc)
    public String make; // bike make (company of the bike ex:honda, toyota)
    public String model; //bike model (different models like ex: mountain bike, ebike etc)
    public float rate; //the cost of the bike
    public float deposit; //deposit set for each bike id
    public String stateBike; // state of the bike, (is it good to rent our or is it for repairs?)
    public String notes; // speacial notes set for unique bike id form the mechanic.

    //constructers
    public bike(int ID, String type, String size, String make, String model, float rate, float deposit, String stateBike, String notes)
    {
        this.ID = ID;
        this.type = type;
        this.size = size;
        this.make = make;
        this.model = model;
        this.rate = rate;
        this.deposit = deposit;
        this.stateBike = stateBike;
        this.notes = notes;
    }

    public void print()
    {
        System.out.println("ID: "+this.ID);                              
        System.out.println("Type: "+this.type);                   
        System.out.println("Size: "+this.size);                      
        System.out.println("Make: "+this.make);                        
        System.out.println("Model: "+this.model);                           
        System.out.println("Rate: "+this.rate);                                 
        System.out.println("Deposit: "+this.deposit);                           
        System.out.println("State of bike: "+this.stateBike);                            
        System.out.println("Notes: "+this.notes);                                  
    }

    //getters
    public int getID() {
        return ID;
    }

    public String gettype() {
        return type;
    }

    public String getsize() {
        return size;
    }

    public String getmake() {
        return make;
    }

    public String getmodel() {
        return model;
    }

    public float getrate() {
        return rate;
    }

    public float getdeposit() {
        return deposit;
    }

    public String getstateBike() {
        return stateBike;
    }

    public String getnotes() {
        return notes;
    }

    //setters
     public void setID(int ID) {
        this.ID = ID;
    }

    public void setype(String type) {
        this.type = type;
    }

    public void setsize(String size) {
        this.size = size;
    }

    public void setmake(String make) {
        this.make = make;
    }

    public void setmodel(String model) {
        this.model = model;
    }

    public void setrate(float rate) {
        this.rate = rate;
    }

    public void setdeposit(float deposit) {
        this.deposit = deposit;
    }

    public void setstateBike(String stateBike) {
        this.stateBike = stateBike;
    }

    public void setnotes(String notes) {
        this.notes = notes;
    }
}