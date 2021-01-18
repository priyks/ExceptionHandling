package exception;

import java.util.Scanner;

public class Loging_App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user_Name;
		String password;
		int attemp=0;
		Scanner sc=new Scanner(System.in);
		
		try {
			do {
			System.out.println("Enter User Name :");
			user_Name=sc.next();
			System.out.println("Enter Password :");
			password=sc.next();
			Credentials c=new Credentials(user_Name,password);
			c.checkUserEmail(user_Name);
			c.checkLengthPass(password);
			if(c.finalCheck())
			break;
			c.CheckAttempts();
			attemp+=1;
			}while(attemp<=5);
			
		}catch(Exception e) {
			
			e.printStackTrace();	
		}

	}

}

/*
 * output 1:
 
Enter User Name :
priyanka@gmail.com
Enter Password :
xyzxyz
Try once again...
Enter User Name :
priyanka@gmail.com
Enter Password :
abcabc
Try once again...
Enter User Name :
priyanka@gmail.com
Enter Password :
htmla
Password Length must be less than and equal to 12 and greater than equal to 6 
exception.PasswordLengthException
	at exception.Credentials.checkLengthPass(Credentials.java:71)
	at exception.Loging_App.main(Loging_App.java:22)
	
output 2:
Enter User Name :
priyanka@gmail.com
Enter Password :
abcabc
Try once again...
Enter User Name :
priyanka@gmail.com
Enter Password :
html@123
Try once again...
Enter User Name :
priyanka@gmail.com
Enter Password :
dmtlama
Try once again...
exception.TryLostException
you have lost your 3 attempts ...
 please try after some time..
	at exception.Credentials.CheckAttempts(Credentials.java:61)
	at exception.Loging_App.main(Loging_App.java:25)	
	
output 3
Enter User Name :
priyanka@
Enter Password :
xtmlaa
User Name must contain @gmail.com
exception.InvalidUserNameException
	at exception.Credentials.checkUserEmail(Credentials.java:53)
	at exception.Loging_App.main(Loging_App.java:21)	

*/