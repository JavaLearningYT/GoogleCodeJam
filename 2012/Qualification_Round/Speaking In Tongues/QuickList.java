//The purpose of this file was to create all the pairs using the sample input provided by google

package a_smale_practice;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.util.Pair;

public class QuickList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Pair> stuff = new ArrayList<Pair>();
		while(true) {
			System.out.println("go");
			scan.reset();
			String start = scan.nextLine().replaceAll(" ", "");
			if(start.equals("done")) {break;}
			scan.reset();
			String end = scan.nextLine().replaceAll(" ", "");
			if(start.length()!=end.length())System.exit(0);
			
			for(int i=0;i<start.length();i++) {
				System.out.println(start.charAt(i)+","+end.charAt(i));
				Pair pair = new Pair(start.charAt(i),end.charAt(i));
				if(!stuff.contains(pair)) {
					stuff.add(pair);
				}
			}

		}
		for(int i =0; i<stuff.size();i++) {
			System.out.println("{\""+stuff.get(i).getKey()+"\",\""+stuff.get(i).getValue()+"\"},");
		}
	}
}
