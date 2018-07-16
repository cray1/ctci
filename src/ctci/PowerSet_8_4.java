package ctci;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PowerSet_8_4 {
	
//	def p(l):
//	    if not l: return [[]]
//	    return p(l[1:]) + [[l[0]] + x for x in p(l[1:])]
	
	
	
	static <T> List<T> convertIntToSubset(int num, List<T> list){
		List<T> returnList = new ArrayList<T>();
		int i =num;
		Iterator<T> itr = list.iterator();
		while(itr.hasNext()) {
			T next = (T) itr.next();
			if((i&1) ==1) {
				returnList.add(next);
			}
			i >>= 1;
		}
		return returnList;
	}
	
	public static <T> List<List<T>> powerset(List<T> list) {
		  List<List<T>> listOfSets = new ArrayList<List<T>>();
		  int max = (1 << list.size())-1;
		  for(int i=0; i<max; i++) {
			  List<T> subsets = convertIntToSubset(i, list);
			  listOfSets.add(subsets);
		  }
		  return listOfSets;
		  
		}
	
	static <T> String listToString(List<T> list) {
		StringBuilder sb = new StringBuilder();
		for(T item: list) {
			sb.append(item.toString() +","); 
		}
		return sb.toString();
	}
	
	static <T> void printList(List<List<T>> list) {
		for(List<T> set: list) {
			System.out.println(listToString(set));
		}
	}

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Character> s1 = new ArrayList<Character>();
		s1.add('a'); s1.add('b'); s1.add('c'); s1.add('d');
		
		List<List<Character>> ps = powerset(s1);
		printList(ps);
	}

}
