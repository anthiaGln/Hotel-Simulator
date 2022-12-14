# Hotel Simulator
This project simulates a hotel. 

Every day 1 to 5 clients come to the hotel. Every client asks for a room with specific features - number of beds (2 or 3), type (standard/std or superior/sup) and possibly which floor the room will be - for a specific number of days. If there is a room with the required features then it is reserved. For an example if the reservation happens on day 3 for 4 days then the room will be free on day 7. If the client doesn't ask for a specific floor the program searches for a room with the other requested features. If there are no rooms available that can accomondate the requested features the client leaves the hotel.

When clients leave the rooms the rooms are free for the next clients. The rooms are free before new clients come to the hotel.
classes:

*Client*

This class represents a client. A client has the features:
- id
- all the details about their reservation : number of beds, type of room, floor (not necessary), days of stay.

- When a client is created their id is automatically created. If they are the first the id is 1, if they are the second the id is 2 etc.
- It has a method called decideBooking() which "decides" (randomly) the details of the client's reservation. The parameters of this method are the number of floors and the number of the different types of rooms.
- It offers methods that can access the reservation.

*Room*

This class represents a room. It includes:
- room number (*number*)
- number of beds (*numBeds*)
- type of room (integer, 1 for std and 2 for sup) (*type*)
- the client who (probably) stays in the room (*client*)
- client's (if they stay in the room) check out date (*checkOutDate*)

- when a room is created the room number, the number of beds and the type of the room are created. In the start it is empty (no clients). 
- it has methods to access the class' fields. (set/get functions)
- it has methods in which check in or check out happens and it displays a message based on that (*checkIn()*) (*checkOut()*).
- it has a method that checks whether a room is available or not (*isEmpty()*) 

*Floor*

It represents a floor at the hotel.

This class has the fields:
- floor number (*number*)
- a single dimension array of rooms (*rooms*)

- When a floor is created the floor number and the number of rooms are also created.
- In order to define the details of the rooms the class has two methods (*setRoomData()*):
- The one takes the room number (e.g. 207), number of beds and room type and all these values are assigned to the element of the array as a room with these features.
- The othertakes a range of number of rooms (e.g. 207, 212), number of beds and room type and assigns to the right elements of the array the new rooms with these features.
- The class has a method (*searchRoom()*) which searches for a room from the specific floor with specific features (number of beds and type. If the room is found (or not) the method returns a reference to it.
- The class has a method (*emptyRooms()*) which checks all the rooms and sets free the ones that the stay has ended.
- The class has a method  (*roomIndexFromNumber()*) which takes a room number (e.g. 302) and returns the position of the room at the array (e.g. 1 for room 302). The method returns value -1 if the number that is given is not valid for the floor.

*Hotel*
- This class represents the hotel's simulation. It's the base class which handles the hotel.

This class has the fields:
- hotel's name (name)
- a single dimension array of floors (floors)

- When the hotel is created its name and the number of floors are created too.
- The method setFloorRooms() assigns to a specific floor -the floor's number is given- the number of its rooms.
- In order to handle the floors there is a method (*getFloor()*) that returns a reference of the floor that its number is given (note: not the pointer of the array but the actual floor number). With this reference, method main() will get the type of the rooms of each floor.
- It has two searchRoom() methods that will be called to search for rooms if the client wants a specific floor or not.
- It has the method bookRoom() which books a specific room and the data is the room, the client that is going to stay and the check out date. The start of stay begins when the method is called so the rooms is reserved imediately for the client.
- It has the method emptyRooms() that searches all the floors and sets free the rooms in which the stay has ended on a specific day (the day is a parameter)
- It has a method serviceClient() which handes the required reservation of a client.

*Main (Project1)*

This class actualizes the simulation in the main() method.
- It creates the hotel and defines the floors and the rooms (*createHotel()*). At least one room has to have every combination about the number of beds (2/3), the room type (std/sup).
- There is a loop to simulate the days (*(runSimulation()*). So, every day:

- Rooms get empty because of check out.
- ?? random number of clients is created and they ask for rooms with random features. That includes clients asking for a spcific floor or not.

This loop is automatic and it runs 30 times (30 days).
The main class includes static variables which are the number of the floors (*NUM_FLOORS*) and the number of the rooms of each floor (it is the same for all the floors) (*NUM_FLOOR_ROOMS*)
