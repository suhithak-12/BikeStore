
public class customer {
    public int ID;//customer id
    public String fname;//customer first name
    public String lname;//customer last name
    public String address;//customer address
    public String phone;//customer phone
    
    //contructor
    public customer(int id, String fn, String ln, String add, String ph){
        this.ID = id;//keep it to three digits ex: 111
        this.fname = fn;
        this.lname = ln;
        this.address = add;
        this.phone = ph;

    }

    public void printC()
    {
        System.out.println("ID: "+this.ID);                              
        System.out.println("First Name: "+this.fname);                   
        System.out.println("Last Name: "+this.lname);                      
        System.out.println("Address: "+this.address);                        
        System.out.println("Phone: "+this.phone);                           
    }

    //set/get id
    public void setCID(int id){
        this.ID = id;
    }

    public int getCID(){
        return ID;
    }
    
    //set/get first name
    public void setFName(String fn){
        this.fname = fn;
    }

    public String getFName(){
        return fname;
    }

    //set/get last name
    public void setLName(String ln ){
        this.lname = ln;
    }

    public String getLName(){
        return lname;
    }

    //set/get address           
    public void setAddress(String add){
        this.address = add;
    }

    public String getAddress(){
        return address;
    }
    //set/get phone
    public void setPhone(String ph){
        this.phone = ph;
    }

    public String getPhone(){
        return phone;
    }

}