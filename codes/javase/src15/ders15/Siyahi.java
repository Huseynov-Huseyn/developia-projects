package ders15;

import java.util.Arrays;
import java.util.Iterator;

public class Siyahi {

	int[] massivim;
	int index = 0;
	int inc=0;
	public Siyahi(int initial,int increment) {
		massivim=new int[initial];
		this.inc=increment;		
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
		for(int i=0;i<index;i++) {
			if(index==i+1) {
				s=s+massivim[i];
			}else {
				s=s+massivim[i]+",";
			}			
		}
		return s + "]";

	}
	public int lazimOlan(int i) {
		for(int v=0;v<massivim.length;v++) {
			if (massivim[v]==i) {
				i=v;
			}
		}
		return i;
	}
	public void silmek(int x) {
		 for (int i = x; i < massivim.length - 1; i++) {
	            massivim[i] = massivim[i + 1];
	        }
	}
	
}
