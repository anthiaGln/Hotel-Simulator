
package project1;

import java.util.Random;
import static project1.Project1.NUM_FLOOR_ROOMS;


public class Floor {
    private int arithmosDwmatiwnOrofou;
    private int number;
    private Room[] rooms=new Room[NUM_FLOOR_ROOMS]; 
    
    Random r=new Random();  
    
    public Floor(int number,int arithmosDwmatiwnOrofou){
        this.number=number+1;
        this.arithmosDwmatiwnOrofou=arithmosDwmatiwnOrofou;
    }
    
    public void setRoomData(int number,int numBeds,int type){
        
        int j=roomIndexFromNumber(number);
        rooms[j]=new Room(number,numBeds,type);
        System.out.println("Number: " + rooms[j].getNumber() + " numBeds: " + rooms[j].getNumBeds() + " type:" + rooms[j].getType());
    }
    
    public void setRoomData(int min, int max,int numBeds,int type){
        
        for(int number=min; number<=max; number++){
            int j=roomIndexFromNumber(number);
            rooms[j]=new Room(number,numBeds,type);
            System.out.println("Number: " + rooms[j].getNumber() + " numBeds: " + rooms[j].getNumBeds() + " type:" + rooms[j].getType());
        }
    }


    public int getNumber(){
        return number;
    }
    
    
    
    public Room searchRoom(int numBeds, int type, int client,int meres,int i){ 
        int j=0;
        while(j<NUM_FLOOR_ROOMS){

            if((rooms[j].getNumBeds()==numBeds) && (rooms[j].getType()==type) && (rooms[j].isEmpty())){
                
                    System.out.println("To dwmatio einai eleythero");
                    return rooms[j]; 
            }
            else{
                j++;
            }
        }
        
        return null;
   
    }
    
    public void emptyRooms(int i){
       

        for(int j=0; j<NUM_FLOOR_ROOMS; j++){
            if((rooms[j]!=null) && (rooms[j].getCheckOutDate()==i)){
    
                rooms[j].checkOut();
                System.out.println("Eleutherwthhke to dwmatio " + rooms[j].getNumber());
            }
        }
    }
    
    private int roomIndexFromNumber(int number){
        
        if(number%100>0 && number%100<=15){
            return number%100-1;
        }
        else{
            return -1;
        }
    }
    
    public int getArithmosDwmatiwnOrofou(){
        return arithmosDwmatiwnOrofou;
    }
   
    public int setTuxaiaKrevatia(){
        int numBeds=r.nextInt(2)+2;
        return numBeds;
    }
            
    public int setTuxaioTypo(){
        int type=r.nextInt(2)+1;
        return type;
    }
    
    public void setArithmosDwmatiwnOrofou(int arithmosDwmatiwnOrofou){
        this.arithmosDwmatiwnOrofou=arithmosDwmatiwnOrofou;
    }
}
