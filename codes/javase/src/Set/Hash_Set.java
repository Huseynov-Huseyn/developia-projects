package Set;

import java.util.HashSet;
import java.util.Iterator;

public class Hash_Set {
	public static void main(String[] args) {

//		null deyeri her zaman birinci olur bu collectionda
//		sira yoxdur deye remove(index) yazaraq yox
//		remove(varaible) yazaraq silmek olur

		HashSet h = new HashSet();
		h.add(123);
		h.add("SALAM");
		h.add("C");
		h.add(123.3);
		h.add(123.3);
		h.add(123.3);
//		eyni tipde deyisenden eyni varaible yazila bilmez
//		burada da add metodundan gormek olur
		h.add(null);
		h.add(1234);
		h.remove(1234);
//		h.clear();
		System.out.println(h.size());

		Iterator itr = h.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("------------");
		System.out.println("buradasi foreach iledir:");

		h.forEach(Item -> System.out.println(Item + ""));
	}
}
