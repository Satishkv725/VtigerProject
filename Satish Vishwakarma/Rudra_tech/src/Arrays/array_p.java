package Arrays;

import java.util.ArrayList;
import java.util.List;

public class array_p {

	public static void main(String[] args) {

		List<Integer> ob = new ArrayList<Integer>();
		ob.add(12);
		ob.add(5);
		ob.add(45);
		ob.add(25);

		List<Integer> obj = new ArrayList<Integer>();
		obj.add(22);
		obj.add(55);
		obj.add(75);
		obj.add(35);

		obj.addAll(ob);
System.out.println(obj);
		
		
		
		
		
// obj.retainAll(ob);
// obj.remove(5);
// obj.removeAll(ob);
//obj.clear(); 
		// obj.add ();
		// bbj.size ();
		// obj.remove(int index);
		// obj.removeAll(Collection c);
		// obj.iterator();
		// obj.retainAll(Collection c);
		// obj.clear();
		// Iterator itr = obj.iterator();
		// itr.hasNext();
		// itr.next();

	}

}
