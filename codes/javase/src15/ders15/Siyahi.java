package ders15;

import java.util.ArrayList;

public class Siyahi extends ArrayList<Integer> {

	int[] massivim;
	int index = 0;
	int inc = 0;

	public Siyahi(int initial, int increment) {
		massivim = new int[initial];
		this.inc = increment;
	}

	public void yenisi(int i) {
		if (index == massivim.length) {
			int[] yeniMassiv = new int[massivim.length + inc];
			for (int j = 0; j < massivim.length; j++) {
				yeniMassiv[j] = massivim[j];
			}
			massivim = yeniMassiv;
		}

		massivim[index] = i;
		index++;

	}

	public String hamisiniQaytar() {
		String s = "[";
		for (int i = 0; i < index; i++) {
			if (index == i + 1) {
				s = s + massivim[i];
			} else {
				s = s + massivim[i] + ",";
			}
		}
		return s + "]";

	}

	public int lazimOlan(int l) {
		for (int v = 0; v < massivim.length; v++) {
			if (massivim[v] != l) {

			} else {
				l = v;
			}
		}
		return l;

	}

	public void silmek(int x) {
		for (int z = x; z < massivim.length - 1; z++) {
			massivim[z] = massivim[z + 1];
		}
	}

}
