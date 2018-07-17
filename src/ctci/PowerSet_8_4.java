package ctci;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.HashMap;

public class PowerSet_8_4 {
	
//	def p(l):
//	    if not l: return [[]]
//	    return p(l[1:]) + [[l[0]] + x for x in p(l[1:])]
	
	
	
	static <T> Set<T> convertIntToSubset(int num, Set<T> Set){
		Set<T> returnSet = new HashSet<T>();
		int i =num;
		Iterator<T> itr = Set.iterator();
		while(itr.hasNext()) {
			T next = (T) itr.next();
			if((i&1) ==1) {
				returnSet.add(next);
			}
			i >>= 1;
		}
		return returnSet;
	}
	
	static <T> Set<Set<T>> powerset(Set<T> Set) {
		  Set<Set<T>> SetOfSets = new HashSet<Set<T>>();
		  int max = (1 << Set.size())-1;
		  System.out.println("max: "+max);
		  for(int i=0; i<max; i++) {
			  Set<T> subsets = convertIntToSubset(i, Set);
			  SetOfSets.add(subsets);
		  }
		  return SetOfSets;
		  
		}
	
	static <T> String SetToString(Set<T> Set) {
		StringBuilder sb = new StringBuilder();
		for(T item: Set) {
			sb.append(item.toString() +","); 
		}
		return sb.toString();
	}
	
	static <T> void printSet(Set<Set<T>> Set) {
		for(Set<T> set: Set) {
			System.out.println(SetToString(set));
		}
	}

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		
		Set<Character> s1 = new HashSet<Character>();
		s1.add('a'); s1.add('b'); s1.add('c'); s1.add('d');
		s1.add('e'); s1.add('f'); s1.add('g'); s1.add('h');
		s1.add('i'); s1.add('j'); s1.add('k'); s1.add('l');
		s1.add('m'); s1.add('n'); s1.add('o'); s1.add('p');
		Set<Set<Character>> ps = powerset(s1);
		printSet(ps);
	}

}
