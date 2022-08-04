package project1;

import java.util.Random;

public class Project1 {

    static final int NUM_FLOORS = 4;
    static final int NUM_FLOOR_ROOMS = 10;
    static final int DAYS = 30;
    static Hotel hotel = new Hotel("HOTEL", NUM_FLOORS);

    public static void createHotel() {
        int numBeds = 0;
        int type = 0;
        int number;

        
        for (int i = 0; i < NUM_FLOORS; i++) {

            hotel.createFloors(i);
            hotel.setFloorRooms(i);

            for (int j = 0; j < NUM_FLOOR_ROOMS; j++) {

                number = (i + 1) * 100 + (j + 1);

                if (j == 0) { 
                    hotel.getFloor(i).setRoomData(number,2,1);
                } 
                else if(j == 1){
                    hotel.getFloor(i).setRoomData(number,2,2);
                }
                else if(j == 2){
                    hotel.getFloor(i).setRoomData(number,3,1);
                }
                else if(j == 3){
                    hotel.getFloor(i).setRoomData(number,3,2);
                }
                else if (j == 4) {
                    if (i == 0 || i == 1) {
                        numBeds = 2;
                        type = 1;
                    } else if (i == 2 || i == 3) {
                        numBeds = 3;
                        type = 1;
                    }
                    int min = number;
                    int max = number + 3;
                    hotel.getFloor(i).setRoomData(min, max, numBeds, type);
                    j = j + 3;
                } else if (j > 7) {
                    numBeds = hotel.getFloor(i).setTuxaiaKrevatia();
                    type = hotel.getFloor(i).setTuxaioTypo();
                    hotel.getFloor(i).setRoomData(number, numBeds, type);
                }
            }
        }

    }

    public static void runSimulation() {

        Random rnd = new Random();
        System.out.println();
        System.out.println("Welcome to hotel " + hotel.getName());

        for (int i = 1; i <= DAYS; i++) {
            System.out.println();
            System.out.println("---------DAY " + i + "----------");
            if (i > 1) {
                hotel.emptyRooms(i);
            }
            int numClients = rnd.nextInt(5) + 1;
            System.out.println("Hrthan " + numClients + " pelates shmera");
            for (int j = 0; j < numClients; j++) {
                System.out.println("---------PELATHS " + (j + 1) + "----------");
                Client c = new Client();
                int thelworofo = c.decideBooking(NUM_FLOORS, 2);
                System.out.print("Zhteitai dwmatio me " + c.getNumBeds() + " krevatia , ");
                if (c.getRoomType() == 1) {
                    System.out.print("aplo , ");
                } else if (c.getRoomType() == 2) {
                    System.out.print("megalo , ");
                }

                System.out.println("gia " + c.getNumDays() + " hmeres");

                if (thelworofo == 0) {

                    if(hotel.serviceClient(c.getNumBeds(), c.getRoomType(), -1, c.getClient(), c.getNumDays(), thelworofo, i)==0){
                        System.out.println("O pelaths me id " + c.getClient() + " anaxwrhse");
                    }

                } else if (thelworofo == 1) {

                    if(hotel.serviceClient(c.getNumBeds(), c.getRoomType(), c.getNumFloor(), c.getClient(), c.getNumDays(), thelworofo, i)==0)
                    System.out.println("O pelaths me id " + c.getClient() + " anaxwrhse");
                }
            }
        }
    }

    public static void main(String[] args) {

        createHotel();
        runSimulation();
    }

}
