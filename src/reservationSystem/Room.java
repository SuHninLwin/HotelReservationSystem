package reservationSystem;

public class Room implements Hotel 
{
	String roomID;
	String roomStatus;
	double roomPrice;
	
	public Room()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String roomID, String roomStatus, double d) 
	{
		super();
		this.roomID = roomID;
		this.roomStatus = roomStatus;
		this.roomPrice = d;
	}

	public String getRoomID()
	{
		return roomID;
	}

	public void setRoomID(String roomID) 
	{
		this.roomID = roomID;
	}

	public String getRoomStatus()
	{
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus)
	{
		this.roomStatus = roomStatus;
	}

	public double getRoomPrice()
	{
		return roomPrice;
	}

	public void setRoomPrice(float roomPrice) 
	{
		this.roomPrice = roomPrice;
	}

	@Override
	public String toString()
	{
		return "Room [roomID=" + roomID + ", roomStatus=" + roomStatus + ", roomPrice=" + roomPrice + "]";
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
	}
}
