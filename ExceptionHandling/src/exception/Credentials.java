package exception;


class PasswordLengthException extends  Exception {
	
	PasswordLengthException(){
		
		System.out.println("Password Length must be less than and equal to 12 and greater than equal to 6 ");
	}
	
}

class InvalidUserNameException extends RuntimeException{
	
	InvalidUserNameException(String msg){
		
		System.out.println(msg);
	}
}

class TryLostException extends Exception {
	
	TryLostException(){
		System.out.println("you have lost your 3 attempts ...\n please try after some time..");
	}
}

public class Credentials {
  private String user_Name="priyanka@gmail.com";
  private String password="abcabcabc";
  private String uStr1;
  private String passStr2;
  private static int count =0;
  
 
  
  public Credentials(String str1, String str2) {
	  
	  uStr1=str1;
	  passStr2=str2;
	  count+=1;
}

public void checkUserEmail(String uStr1) {
	  
     if(uStr1==null){
		  
		  throw new NullPointerException("User Name must not be kept blank..!");
	  }
     else if(!uStr1.contains("@gmail.com"))
    	     {
		  
		        throw new InvalidUserNameException("User Name must contain @gmail.com");   
	 }
  }
  
  public void  CheckAttempts() throws TryLostException {
	  
	 if(count>=3) {
		 
			throw new TryLostException();
	 }
	 
  }
  
  public void checkLengthPass(String password) throws PasswordLengthException {
	  int pass_len=password.length();
	  
	  if(!(pass_len>=6) || !(pass_len<=12)) {
		  
		  throw new PasswordLengthException();
		  
	  }
	  
	  }
  public boolean finalCheck() {
	  boolean status=false;
	  if((uStr1.equals("priyanka@gmail.com")) && (passStr2.equals("abcabcabc"))) {
		  
		  System.out.println("Welcome..");
		  System.out.println("You have Successfully logged in...");
		  status=true;
	  }
	  else {
		  System.out.println("Try once again...");
		  status=false;
	  }
	  return status;
  }
  
}
