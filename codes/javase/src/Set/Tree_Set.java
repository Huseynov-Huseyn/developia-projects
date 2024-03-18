package Set;

import java.util.TreeSet;

public class Tree_Set {
	public static void main(String[] args) {
//		Treeler yazilan datalari artan sira ile
//		siralayir ve null deyeri qebul etmir

		TreeSet tree = new TreeSet();

		tree.add(123);
		tree.add(3);
		tree.add(13);
		tree.add(12);
		tree.add(23);
//		tree.add(null);

		tree.forEach(Item -> System.out.println(Item + ""));
	}
}
