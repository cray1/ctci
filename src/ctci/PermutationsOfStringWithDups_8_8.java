package ctci;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PermutationsOfStringWithDups_8_8 {

	static List<String> permute(String s){
		List<String> perms = new ArrayList<String>();
		permute(perms, s, "");
		return perms;
	}
	
	static void permute(List<String> perms, String s, String chosen) {
		if(s.length() ==0)  
			perms.add(chosen);  
		else {
			for(int i=0; i<s.length(); i++) {
				char c = s.charAt(i);
				String s_temp = new StringBuilder(s).deleteCharAt(i).toString();
				permute(perms, s_temp, chosen +c);
			}
		}
	}
	
	//helper stuff below
	public static BigInteger factorial(int value){
	    if(value < 0){
	        throw new IllegalArgumentException("Value must be positive");
	    }

	    BigInteger result = BigInteger.ONE;
	    for (int i = 2; i <= value; i++) {
	        result = result.multiply(BigInteger.valueOf(i));
	    }

	    return result;
	}

	public static void main(String[] args) {
		String s = "abc4";
		List<String> perms = permute(s);
		System.out.println("Length(s) = "+s.length());
		System.out.println("number of permutations (actual): " + perms.size());
		System.out.println("number of permutations (correct number): " + factorial(s.length()));
		for(String perm: perms) {
			System.out.println(perm);
		}

	}
}
