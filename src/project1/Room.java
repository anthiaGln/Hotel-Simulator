
package project1;


public class Room {
    private int number;
    private int numBeds;
    private int type;
    private int client;    
    private int checkOutDate; 
    
    public Room(int number,int numBeds,int type){
        this.number=number;
        this.numBeds=numBeds;
        this.type=type;
    }
    
    public int getNumber(){
        return number;
    }

    public int getNumBeds(){
        return numBeds;
    }
    
    public int getType(){
        return type;
    }
    
    public int getClient(){
        return client;
    }
    
    public int getCheckOutDate(){
        return checkOutDate;
    }
    
    public void checkIn(int meres,int pelaths,int i){
        checkOutDate=meres+i;
        client=pelaths;
        System.out.println("The customer with id " + getClient() + " made a reservation for the room " + getNumber() +" for " + meres + " days and the will leave on day " + getCheckOutDate());
    }
    
    public void checkOut(){
        this.client=0;  
        this.checkOutDate=0;
    }
    
    public boolean isEmpty(){ 
    
        if(checkOutDate==0){
            return true;
        }
        else{
            return false;
        }
    }
  
    
}
