package reservationSystem;

public class Customer implements Hotel 
{
	String customerName;
	String customerPh; 
	int customerAge; 
	
	public Customer() 
	{
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String customerName, String customerPh, int customerAge) 
	{
		super();
		this.customerName = customerName;
		this.customerPh = customerPh;
		this.customerAge = customerAge;
	}

	public String getCustomerName() 
	{
		return customerName;
	}

	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}

	public String getCustomerPh()
	{
		return customerPh;
	}

	public void setCustomerPh(String customerPh) 
	{
		this.customerPh = customerPh;
	}

	public int getCustomerAge() 
	{
		return customerAge;
	}

	public void setCustomerAge(int customerAge)
	{
		this.customerAge = customerAge;
	}
	
	@Override
	public String toString()
	{
		return "Customer [customerName=" + customerName + ", customerPh=" + customerPh + ", customerAge=" + customerAge
				+ "]";
	}

	@Override
	public void show() 
	{
		// TODO Auto-generated method stub
		
	} 
}
