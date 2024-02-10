package myTestCasesExam;

import java.util.Random;

public class Parameters {

	String TheUrl="https://magento.softwaretestingboard.com/";
	String TheLogoutUrl="https://magento.softwaretestingboard.com/customer/account/logout/";
	String TheUrl7="https://magento.softwaretestingboard.com/men/tops-men/jackets-men.html";

	Random rand = new Random();

	String[] FirstNames = {"Aiden", "Sophia", "Ethan", "Isabella", "Liam", "Olivia", "Mason", "Ava", "Noah", "Emma"};

	String[] LastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};

	String CommonPassword = "Abcd123!#$";
	
	int RandomIndex = rand.nextInt(10);
	int RandomEmailId = rand.nextInt(1000); 
	
	String EmailID = FirstNames[RandomIndex]+LastNames[RandomIndex]+RandomEmailId+"@"+"gmail.com"; 
	
	

}
