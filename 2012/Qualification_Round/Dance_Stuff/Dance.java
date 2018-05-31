package Dancinggooglers;

import java.util.Scanner;

public class Dance {
	int numb;
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		new Dance();
	}
	public Dance() {
		numb=scan.nextInt();
		scan.nextLine();
 		for(int i =0;i<numb;i++) {

			String raw = scan.nextLine();
			raw = raw.trim();
			String[] rawSplit = raw.split(" ");
			int[] numbs = new int[rawSplit.length];
			int h =0;
			for(String a:rawSplit) {
				numbs[h]=Integer.parseInt(a);
				h++;
			}
			int[] scores = new int[numbs[0]];
			int suprise = numbs[1];
			int min = numbs[2];
			for(int s =3;s<numbs.length;s++) {
				scores[(s-3)]=numbs[s];
			}
			int yes=0;
			for(int check:scores) {
				boolean good = false;
				if(check==0) {
					good=false;
				}else {
				if(check/3<min) {	
					if(check>=3*(min)-2) {
						good=true;
					}else {
						if((check>=3*(min)-4)&&suprise>0) {
							suprise--;
							good=true;
						}
					}
				}else {
					good=true;
				}}
				if(good||min==0) {
					yes++;
				}
			}
			System.out.println("Case #"+(i+1)+": "+yes);
			scan.reset();
		}
	}
}
