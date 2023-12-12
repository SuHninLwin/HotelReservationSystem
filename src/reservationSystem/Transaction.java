package reservationSystem;

public class Transaction 
{
	String transactionID;
	Room room;
	Customer customer;
	String checkIn;
	String checkOut;
	
	public Transaction()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionID, Room room, Customer customer, String checkIn, String checkOut) 
	{
		super();
		this.transactionID = transactionID;
		this.room = room;
		this.customer = customer;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public String getTransactionID()
	{
		return transactionID;
	}

	public void setTransactionID(String transactionID)
	{
		this.transactionID = transactionID;
	}

	public Room getRoom() 
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public String getCheckIn()
	{
		return checkIn;
	}

	public void setCheckIn(String checkIn) 
	{
		this.checkIn = checkIn;
	}

	public String getCheckOut()
	{
		return checkOut;
	}

	public void setCheckOut(String checkOut)
	{
		this.checkOut = checkOut;
	}

	@Override
	public String toString()
	{
		return "Transaction [transactionID=" + transactionID + ", room=" + room + ", customer=" + customer
				+ ", checkIn=" + checkIn + ", checkOut=" + checkOut + "]";
	} 
}
