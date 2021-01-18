package exception;

public class PropogateAndCatchException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(reverse(""));
		}catch(Exception e) {
			System.out.println("The String was blank");
		}finally {
			System.out.println("All done!");
		}

	}

	public static String reverse(String string) throws Exception {
	
		if(string.length()==0) {
			throw new Exception();
	
	}
		String rs="";
		for(int i=string.length()-1;i>=0;--i) {
			rs+=string.charAt(i);
			
		}
		return rs;
	}

}
