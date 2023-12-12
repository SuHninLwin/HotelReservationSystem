package reservationSystem;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Receptionist implements Hotel 
{
	private String recepID;
	private String recepName;
	
	private static List<Room>room = new ArrayList <Room>(); 
	private List<Booking>booking = new ArrayList<Booking>(); 
	private List<Transaction>transaction = new ArrayList<Transaction>(); 
	public static Scanner sc = new Scanner (System.in); 
	
	public Receptionist() 
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public Receptionist(String recepID, String recepName) 
	{
		super();
		this.recepID = recepID;
		this.recepName = recepName;
	}

	public String getRecepID() 
	{
		return recepID;
	}

	public void setRecepID(String recepID)
	{
		this.recepID = recepID;
	}

	public String getRecepName()
	{
		return recepName;
	}

	public void setRecepName(String recepName) 
	{
		this.recepName = recepName;
	}

	@Override
	public String toString() 
	{
		return "Receptionist [recepID=" + recepID + ", recepName=" + recepName + "]";
	}

	@Override
	public void show()
	{
		// TODO Auto-generated method stub
		
		int count=0; 
		for(Room r : room)
		{
			if(r.getRoomStatus().equals("Free")) 
			{
				System.out.println(r);
				count++; 
			}
		}
		System.out.println("The number of available room >> "+count);
	}
	
	private void addingBooking()
	{
		Customer customer = new Customer();
		
		System.out.println();
		System.out.println("FILLING CUSTOMER INFORMATION");
		System.out.println("=============================");
		System.out.println("Customer name");
		customer.setCustomerName(sc.next());
		System.out.println("Customer phone number");
		customer.setCustomerPh(sc.next());
		System.out.println("Customer age");
		customer.setCustomerAge(sc.nextInt());
		
		System.out.println();
		System.out.println("AVAILABLE ROOMS");
		System.out.println("===============");
		show();
		
		System.out.println();
		System.out.println("RENTING ROOM INFORMATION");
		System.out.println("========================");
		System.out.println("Enter your room number >> ");
		String roomid = sc.next();
		Room bookedroom = new Room();
		for (Room ro :room)
		{
			if(ro.getRoomID().equals(roomid) && ro.getRoomStatus()=="Free") 
			{
				bookedroom = ro;
				bookedroom.setRoomStatus("Awaiting");
			}
		}
		
		System.out.println();
		System.out.println("BOOKING ADDING INFORMATION");
		System.out.println("==========================");
		System.out.println("Enter booking ID >> ");
		String bookingid = sc.next(); 
		System.out.println("Enter booking date >> ");
		String bookingdate = sc.next(); 
		
		Booking book=new Booking(bookingid, bookingdate, customer, bookedroom);
		booking.add(book);
		System.out.println("Booking processing...." + bookedroom);
		System.out.println("Booking information"+book);
		for(Room ro :room) 
		{
			System.out.println(ro);
		}
	}
	
	private void cancellingBooking()
	{
		Booking bkg = new Booking();
		int count= 0;
		
		System.out.println("BOOKING CANCELLING INFORMATION");
		System.out.println("==============================");
		System.out.println("Enter Booking ID >> ");
		String bookingid= sc.next();
		for(Booking book:booking)
		{
			if(book.getBookingID().equalsIgnoreCase(bookingid))
			{
				bkg = book;
				count++;
				break;
			}
		}
		booking.remove(count-1); 
		System.out.println("Booking Cancelled");
		for(Room r:room)
		{
			if(r.getRoomID().equalsIgnoreCase((bkg.getRoom().getRoomID())))
			{
				r.setRoomStatus("Free");
			}
		}
		show();
	}
	
	private void checkIn() 
	{
		// TODO Auto-generated method stub
		String confirm = "N";
		String bname ;
		boolean flag = false;
		Booking b = new Booking();
		System.out.println("DO YOU HAVE BOOKING >> ");
		confirm = sc.next();
		if(confirm.equalsIgnoreCase("Y")) {
			System.out.println("ENTER YOUR BOOKING NAME >> ");
			bname = sc.next();
			System.out.println("Name " + bname);
			for(Booking bk:booking) {
				if(bk.getCustomer().getCustomerName().equals(bname)) {
					b =bk;
					b.getRoom().setRoomStatus("Stay");
					flag = true;
				}
				
			}
			if(flag) 
			{
				
				System.out.println("ENTER CHECK IN DATE >> ");
				String cki = sc.next();
				
				Transaction t = new Transaction("Transaction - 1", b.getRoom(), b.getCustomer(), cki, null);
				transaction.add(t);
				System.out.println("Finished check in transaction....");
			}
			else {
				System.out.println("Pls try again...");
			}
			
			
		}
		else {
			System.out.println("CUSTOMER INFORMATION");
		
			System.out.println("ENTER CUSTOMER NAME >> ");
			String customerName = sc.next(); 
			
			System.out.println("ENTER CUSTOMER PHONE NUMBER >> ");
			String customerphno = sc.next();
			
			System.out.println("ENTER CUSTOMER AGE >> ");
			int customerage = sc.nextInt(); 
			
			Customer cus = new Customer(customerName, customerphno, customerage);
			
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("||                           AVAILABLE ROOM LIST                            ||");
			System.out.println("------------------------------------------------------------------------------");
			show();
			
			System.out.println("ENTER ROOM NUMBER >> ");
			String rno = sc.next();
			Room br = new Room();
			for (Room r :room) 
			{
				if(r.getRoomID().equals(rno)) 
				{
					br = r;
					br.setRoomStatus("Stay");
				}
			}
			Transaction t = new Transaction("Transaction - 1", br, cus, "2/2/2020", null);
			transaction.add(t);
			System.out.println("Finished check in transaction....");
		}
	}
	
	private void checkOut() throws Exception 
	{
		// TODO Auto-generated method stub
	 
		System.out.println("Enter check out room...");
		String couRoom = sc.next();
		
		for(Transaction tr:transaction)
		{
			if(tr.getRoom().roomID.equalsIgnoreCase(couRoom)) 
			{
				System.out.println(tr);
				System.out.println("Enter check out date .");
				tr.setCheckOut(sc.next());
				String s = tr.getCheckIn();
				Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(s); 
				Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(tr.getCheckOut());
				long diffInMillies = Math.abs(date2.getTime() - date1.getTime());
			    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
			    System.out.println("Number of stay in hotel " + diff);
			    double payment = tr.getRoom().getRoomPrice()*diff;
			    System.out.println("Payment ..."+ payment);
			    tr.getRoom().setRoomStatus("Free");
			}
		}
	}
	
	public static void main(String[]args)throws Exception
	{
		{
			Room r1 = new Room("SingleR-100", "Stay", 30.4);
			Room r2 = new Room("SingleR-101", "Free", 30.4);
			Room r3 = new Room("SingleR-102", "Free", 30.4);
			
			Room r4 = new Room("QueenR-103", "Stay", 60.3);
			Room r5 = new Room("QueenR-104", "Free", 60.3);
			
			Room r6 = new Room("KingR-105", "Stay", 80.9);
			Room r7 = new Room("KingR-106", "Free", 80.9);
			
			room.add(r1);
			room.add(r2);
			room.add(r3);
			room.add(r4);
			room.add(r5);
			room.add(r6);
			room.add(r7);
			
			Receptionist receptionist = new Receptionist("Rep-1", "Susan");
			
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("||                       WELCOME TO ROSE GARDEN HOTEL                       ||");
			System.out.println("------------------------------------------------------------------------------");
		 
			System.out.println();
			System.out.println("AVAILABLE ROOM LIST");
			System.out.println("===================");
			receptionist.show();
			
			String loadAgain; 
		
			do
			{
				Scanner sc= new Scanner (System.in); 
				System.out.println();
				System.out.println("Sign in as administrator >> ");
				String key = sc.nextLine();
			
				if(key.equals("admin123"))
				{
					System.out.println("Admin# Vaild Access!");
					System.out.println();
				
					System.out.println("Choose your function (#no.)");
					System.out.println("1) >> Adding Booking");
					System.out.println("2) >> Cancelling Booking");
					System.out.println("3) >> Check In");
					System.out.println("4) >> Check Out");
					System.out.println("5) >> Available Room");
					System.out.println("6) >> Exit");
				
					System.out.println("Enter here >> ");
					int function = sc.nextInt(); 
				
					if(function == 1)
					{
						receptionist.addingBooking(); 
					}
				
					if(function == 2)
					{
						receptionist.cancellingBooking();
					}
					
					if(function == 3)
					{
						receptionist.checkIn();
					}
					
					if(function == 4)
					{
						receptionist.checkOut();
					}
					
					if(function == 5)
					{
						receptionist.show(); 
					}
				
					if(function == 6)
					{
						System.out.println();
						System.out.println("Thank you for trying Rose Garden Hotel Reservation System.");
						System.out.println();
						System.out.println("------------------------------------------------------------------------------");
						System.out.println("www.RoseGardenHotelMM.com <-- Contact Me --> rosegardenhotel.myanmar@gmail.com");
						System.out.println("------------------------------------------------------------------------------");
						System.exit(0);
					}
				}
				
				Scanner scanner= new Scanner (System.in); 
				System.out.println("Do you want to load this function again? (Enter 'yes' for loading function. ");
				System.out.println("Enter here >> ");
				loadAgain = scanner.nextLine(); 
			
			}while(loadAgain.equalsIgnoreCase("yes")); 
			
			System.out.println();
			System.out.println("Thank you for trying Rose Garden Hotel Reservation System.");
			System.out.println();
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("www.RoseGardenHotelMM.com <-- Contact Me --> rosegardenhotel.myanmar@gmail.com");
			System.out.println("------------------------------------------------------------------------------");
		}
	}
}
