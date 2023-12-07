	package ders14;

public class Extra {
	public int giveArrayElement(int[] array, int index) throws Exceptionclass{
		int result = 0;
		if (index >= array.length) {
			throw new Exceptionclass("Olmayan elemente muraciet etdiniz");
		}else {
			System.out.println("Arrayin uzunluğu kifayətdir");
		}
		result = array[index];

		return result;
	}
}
