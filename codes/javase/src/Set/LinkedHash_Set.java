package Set;

import java.util.LinkedHashSet;

public class LinkedHash_Set {
	public static void main(String[] args) {
//		tekrarlanan deyere icaze yoxdur,yazildigi
//		kimi cap edilir(hashsetde xususi olaraq capa gedir) 
//		ve null deyeri hashsetdeki kimi
//		birinci sirada olmur
		
		
		LinkedHashSet lh= new LinkedHashSet();
		
		lh.add("Bazar ertəsi");
		lh.add("Çərşənbə axşamı");
		lh.add("Çərşənbə");
		lh.add("Cümə axşamı");
		lh.add("Cümə");
		lh.add("Şənbə");
		lh.add("Bazar");
		
		lh.add(null);
		lh.add("Çərşənbə");
		lh.remove("Bazar");
		lh.forEach(Item -> System.out.println(Item +""));
	}
}
