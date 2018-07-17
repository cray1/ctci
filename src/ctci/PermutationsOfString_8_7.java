package ctci;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;  

public class PermutationsOfString_8_7 {
	
	static Set<String> permute(String s){
		Set<String> perms = new HashSet<String>();
		permute(perms, s, "");
		return perms;
	}
	
	static void permute(Set<String> perms, String s, String chosen) {
		if(s.length() ==0)  
			perms.add(chosen);  
		else 
			for(char c: s.toCharArray() )
				permute(perms, s.replace(""+c, ""), chosen +c);
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
		String s = "abcd";
		Set<String> perms = permute(s);
		System.out.println("Length(s) = "+s.length());
		System.out.println("number of permutations (actual): " + perms.size());
		System.out.println("number of permutations (correct number): " + factorial(s.length()));
		for(String perm: perms) {
			System.out.println(perm);
		}

	}

}
