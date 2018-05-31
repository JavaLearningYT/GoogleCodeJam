package a_smale_practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.util.Pair;

public class Tongues {
	String[] words;
	String[] output;
	int tCase = 0;
	Scanner scan = new Scanner(System.in);
	char[][] code = {
			{'a','y'},
			{'z','q'},
			{'e','o'},
			{'q','z'},
			{'e','o'},
			{'j','u'},
			{'p','r'},
			{'m','l'},
			{'y','a'},
			{'s','n'},
			{'l','g'},
			{'c','e'},
			{'k','i'},
			{'d','s'},
			{'x','m'},
			{'v','p'},
			{'n','b'},
			{'r','t'},
			{'i','d'},
			{'b','h'},
			{'t','w'},
			{'h','x'},
			{'w','f'},
			{'f','c'},
			{'o','k'},
			{'u','j'},
			{'g','v'},	
			{'y','a'}
	};
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.println("Enter number of lines");
			int length = scan.nextInt();
			Tongues a = new Tongues(length);
		}
	}
	public Tongues(int length) {

		words = new String[length];
		output = new String[length];
		for(int i =0; i<length; i++) {
			words[i]=scan.nextLine();
			scan.reset();
		}
		System.out.println();
		System.out.println("Output");
		for(int i = 0; i<length; i++) {
			List<Pair> word = new ArrayList<Pair>();
			for(int a=0;a<words[i].length();a++) {
				word.add(new Pair(words[i].charAt(a),false));
			}
			
			for(int z=0;z<code.length;z++) {
				String temp =words[i];
				if(code[z][0]!=code[z][1]) {
					temp = temp.replace(code[z][1], '0');
				}
				temp = temp.replaceAll(code[z][0]+"", code[z][1]+"");
				while(temp.contains(code[z][1]+"")) {
					int g = temp.indexOf(code[z][1]);
					temp = temp.replaceFirst(code[z][1]+"", "0");
					word.set(g, new Pair(code[z][1]+"",true));
				}
			}
			String c ="";
			for(int d=0;d<word.size();d++) {
				c=c+word.get(d).getKey();
			}
			output[i]=c;
			
		}
		for(int i=0;i<length;i++) {
			System.out.println("Case #"+(i+1)+": "+output[i]);
		}
	}
}
