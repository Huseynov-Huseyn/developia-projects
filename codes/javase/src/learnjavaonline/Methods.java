package learnjavaonline;

import java.util.Iterator;
import java.util.Scanner;

public class Methods {
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] dizi = new String[3];
        for(int i=0;i<3;i++){
            dizi[i]=input.nextLine();
        }
        input.close();
        int x=1;
        for(int z=0;z<3;z++) {
        	System.out.println(x++ +" "+dizi[z]);
        }
}
}