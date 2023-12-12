package reservationSystem;

public class Booking 
{
	private String bookingID;
	private String bookingDate;
	private Customer customer;
	private Room room;
	
	public Booking() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(String bookingID, String bookingDate, Customer customer, Room room) 
	{
		super();
		this.bookingID = bookingID;
		this.bookingDate = bookingDate;
		this.customer = customer;
		this.room = room;
	}

	public String getBookingID() 
	{
		return bookingID;
	}

	public void setBookingID(String bookingID) 
	{
		this.bookingID = bookingID;
	}

	public String getBookingDate() 
	{
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) 
	{
		this.bookingDate = bookingDate;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public Room getRoom() 
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	@Override
	public String toString()
	{
		return "Booking [bookingID=" + bookingID + ", bookingDate=" + bookingDate + ", customer=" + customer + ", room="
				+ room + "]";
	}
}
