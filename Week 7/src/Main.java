import java.util.Iterator;

public class Main {
	public static void main(String args[]){
		//testing add, remove, size, toArray, toString, iterator
		//for int and string values. Work perfectly, as displayed by running the code.
		//More tests below
		OccurrenceSet<Integer> intSet = new OccurrenceSet<Integer>();
		intSet.add(1);
		intSet.add(3);
		intSet.add(5);
		intSet.add(5);
		intSet.add(3);
		intSet.add(3);
		intSet.add(3);
		intSet.add(2);
		intSet.add(2);
		intSet.add(2);
		intSet.remove(1);
		System.out.println("String of intSet: "+intSet);
		System.out.println("Size of intSet:"+intSet.size());
		System.out.println("intSet Array values:");
		Object[] test=intSet.toArray();
		for(int i=0; i<test.length; i++){
			System.out.println(test[i].toString());
		}
		System.out.println("intSet Iterator values:");
		Iterator itr = (Iterator) intSet.iterator();
		while(itr.hasNext()) {
	         Object element = itr.next();
	         System.out.print(element + " ");
	      }
		System.out.println();
		
		OccurrenceSet<String> stringSet = new OccurrenceSet<String>();
		stringSet.add("hello");
		stringSet.add("there");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("world");
		stringSet.add("here");
		stringSet.add("there");
		stringSet.remove("here");

		System.out.println("String of stringset:"+stringSet);
		System.out.println("Size of stringSet:"+stringSet.size());
		System.out.println("stringSet Array values:");
		Object[] test2=stringSet.toArray();
		for(int i=0; i<test2.length; i++){
			System.out.println(test2[i].toString());
		}
		
		System.out.println("stringSet Iterator values:");
		Iterator itr2 = (Iterator) stringSet.iterator();
		while(itr2.hasNext()) {
	         Object element = itr2.next();
	         System.out.print(element + " ");
	      }
		System.out.println();
	
		//Testing addall
		OccurrenceSet<Integer> intSet2 = new OccurrenceSet<Integer>();
		intSet2.add(7);
		intSet2.addAll(intSet);
		System.out.println("After addall intSet2: "+intSet2);
		//Testing removeall, retainall, clear, isEmpty()
		OccurrenceSet<Integer> intSet3 = new OccurrenceSet<Integer>();
		intSet3.add(2);
		intSet3.add(3);
		intSet3.add(3);
		intSet2.removeAll(intSet3);
		System.out.println("After removal: "+intSet2);
		intSet3.clear();
		System.out.println("Empty after Clear:"+intSet3.isEmpty());
		
		//Test contains, containall
		System.out.println("Contains: "+intSet.contains(2));
		System.out.println("Contains all: "+intSet.containsAll(intSet2));
		
		

}
	
}
