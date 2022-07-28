
package project1;

import static project1.Project1.NUM_FLOORS;
import static project1.Project1.NUM_FLOOR_ROOMS;


public class Hotel {
    private String name;
    private Floor[] floors = new Floor[NUM_FLOORS];
    private int numFloors;
    
    public Hotel(String name,int numFloors){
        this.numFloors=numFloors;
        this.name=name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setFloorRooms(int i){
        floors[i].setArithmosDwmatiwnOrofou(NUM_FLOOR_ROOMS);
        System.out.println("O orofos " + (i+1) + " exei " + floors[i].getArithmosDwmatiwnOrofou() + " dwmatia" );
    }
    
    public void createFloors(int i){
        floors[i] = new Floor(i,NUM_FLOOR_ROOMS);
    }
    
    
    public Floor getFloor(int i){
        return floors[i];
    }
    
    private Room searchRoom(int numBeds, int type, int numFloor, int client,int meres , int i){
        Room r;
        
        numFloor=numFloor-1;
        r=floors[numFloor].searchRoom(numBeds,type,client,meres, i);
        if(r==null){
           System.out.println("To dwmatio den einai eleythero");

            return null;
        }
        else{
            return r;
        }
    }
    
    private Room searchRoom(int numBeds,int type, int client, int meres, int j){
        int i;
        
        Room r;
        for(i=0; i<NUM_FLOORS; i++){
            r=floors[i].searchRoom(numBeds,type, client,meres , j);
            
            
            if(r!= null){
                return r;
            }
        }
       System.out.println("To dwmatio den einai eleythero");
        return null;
    }
    
    private void bookRoom(Room r,int pelaths,int meres,int i){
        r.checkIn(meres,pelaths,i);
    }
    
    public void emptyRooms(int i){
        for(int k=0; k<NUM_FLOORS; k++){
            floors[k].emptyRooms(i);
        }
    }
    
    public int serviceClient(int numBeds,int type,int numFloor,int client,int meres,int thelworofo,int i){
        Room r;
                

        if(thelworofo==0){

            r=searchRoom(numBeds,type,client,meres,i);

            
            if(r==null){
                System.out.println("Den yparxei to dwmatio poy zhthsate !");
                return 0;
            }
            else{
                System.out.println("Yparxei to dwmatio poy zhthsate");
                bookRoom(r,client,meres,i);
                return 1;
            }
        }
        else if(thelworofo==1){
      
            
            r=searchRoom(numBeds,type,numFloor,client,meres,i);

            if(r==null){
                System.out.println("Den yparxei to dwmatio poy zhthsate !");
                return 0;
            }
            else{
                System.out.println("Yparxei to dwmatio poy zhthsate");
                bookRoom(r,client,meres,i);
            }
        }
        return 1;
    }
}
