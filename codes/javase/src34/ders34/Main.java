package ders34;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Integer[] massiv = { 1, 2, 45, 68, 12, 94, 24 };

		List<Integer> List = Arrays.asList(massiv);
		System.out.println(List);

//		for (Integer i : List) {
//			if (i % 2 == 0) {
//				System.out.println(i);
//			}
//		}
//		bu asagidaki ile eyni koddur
		List.stream().filter(e -> e % 2 == 0).forEach(System.out::println);

		java.util.List<Integer> result = List.stream().filter(e -> e % 2 == 0).map(e -> e * 5)
				.collect(Collectors.toList());
		System.out.println(result);

//		yuxaridaki kodda bu kod eynidir
//		Stream<Integer> stream = List.stream();
//		stream.filter(e -> e % 2 == 0).map(e -> e * 5).collect(Collectors.toList());

	}
}
