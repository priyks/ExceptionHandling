package exception;

import java.util.Scanner;

public class TryWithResource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			String str;
			System.out.println("Enter any Input");
			String myStr = sc.next();
			
			if (isNumeric(myStr)) {
				
				System.out.println("We are trying to convert String into Integer ...!");
                int b=Integer.parseInt(myStr);
                System.out.println(b+" Successfully converted...");
                foo(null);
               
				//throw new NumberFormatException("String is not a Number");
			} else {
				myStr = null;
				System.out.println("Given String is : " + myStr.charAt(1));
			}
		} catch (NullPointerException | NumberFormatException e) {

			// try with resources by default closed by Autocloseable interface implemented
			// in Scanner class which closes scanner object
			System.out.println("Scanner is closed...");
			e.printStackTrace();

		} finally {
			System.out.println("I am always executed....");
		}

	}

	private static void foo(String s) {
		// TODO Auto-generated method stub
		try {
			System.out.println("First character: " + s.charAt(0));

		} catch (NullPointerException e) {

		}

	}

	public static boolean isNumeric(String str) {
		
		// TODO Auto-generated method stub
		for (char c : str.toCharArray()) {

			if (!Character.isDigit(c));
			return true;
		}

		return false;
		
		
	}

}

/*
 * 
case 1

Enter any Input
123
We are trying to convert String into Integer ...!
123 Successfully converted...
I am always executed....

case 2

Enter any Input
pink
We are trying to convert String into Integer ...!
java.lang.NumberFormatException: For input string: "pink"
Scanner is closed...
I am always executed....
	at java.base/java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
	at java.base/java.lang.Integer.parseInt(Integer.java:652)
	at java.base/java.lang.Integer.parseInt(Integer.java:770)
	at exception.TryWithResource.main(TryWithResource.java:17)

 * 
 */
