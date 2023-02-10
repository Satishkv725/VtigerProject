 package arrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Array_List {

	public static void main(String[] args) {

		List<String> obj = new ArrayList<>();
		obj.add("satish");
		obj.add("suresh");
		obj.add("ramesh");
		obj.add("jignesh");
		obj.add("sam");

		List<String> ob = new ArrayList<String>();
		ob.add("suresh");
		ob.add("ramesh");
		ob.add("sumesh");
		ob.add("satish");

		//obj.addAll(ob);
		//obj.retainAll(ob);
		// obj.remove(5);
		// obj.removeAll(ob);
		//obj.clear(); 
	//	System.out.println(obj.size());

		Iterator itr = obj.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

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
