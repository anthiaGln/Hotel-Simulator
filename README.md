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
