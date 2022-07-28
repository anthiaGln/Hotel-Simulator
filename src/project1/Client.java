
package project1;

import java.util.Random;

public class Client {
    private static int id;
    private int numBeds;
    private int roomType;
    private int numFloor;
    private int numDays;
    
    public Client(){
        id++;
    }
    
    
    public int decideBooking(final int NUM_FLOORS, int numRoomType){
        Random r=new Random();
        
        numBeds=r.nextInt(2)+2;
        roomType=r.nextInt(numRoomType)+1;
        numDays=r.nextInt(14)+1;
        
        int x=r.nextInt(2);
        
        
        if(x==0){ 
            System.out.println("O pelaths me id " + getClient() + " den dialekse sygkekrimeno orofo");
        }
        else if(x==1){ 
            numFloor=r.nextInt(NUM_FLOORS)+1;
            System.out.println("O pelaths me id " + getClient() + " thelei na meinei ston " + numFloor + " orofo");
        }
        
        return x;
        
    }
    
    public int getNumBeds(){
        return numBeds;
    }
    
    public int getRoomType(){
        return roomType;
    }
    
    public int getNumFloor(){
        return numFloor;
    }
    
    public int getNumDays(){
        return numDays;
    }
    
    public int getClient(){
        return id;
    }
    
    
}
