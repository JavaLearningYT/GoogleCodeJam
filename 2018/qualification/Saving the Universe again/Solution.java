import java.util.Scanner;
import java.io.*;

public class Solution{
	Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    public static void main(String[] args){
    	new Solution();
    }
    public Solution() {
    	int inputs = scan.nextInt();
    	int[] output = new int[inputs];
		scan.nextLine();
    	for(int i=0; i<inputs;i++) {
    		String[] input = scan.nextLine().trim().split(" ");
    		int shield = Integer.parseInt(input[0]);
    		String sequence = input[1];
    		int moves = 0;
    		int check = sequence.length() - sequence.replace("S", "").length();
    		if(check==0) {output[i]=0;continue;}
    		if(check>shield&&!sequence.contains("C")) {
    			output[i]=-1;
    			continue;
    		}
    		boolean good= false;
    		while(sequence.lastIndexOf('S')>sequence.indexOf('C')) {
    			if(checkGood(sequence,shield)) {
    				output[i]=moves;
    				good = true;
    				break;
    			}
    			sequence = moveOne(sequence);
    			moves++;
    			if(checkGood(sequence,shield)) {
    				output[i]=moves;
    				good = true;
    				break;
    			}
    		}
    		if(output[i]==0&&!good) {
    		output[i]=-1;}
    	}
    	for(int i=0; i<output.length;i++) {
    		if(output[i]==-1) {
    			System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
    		}else {
    			System.out.println("Case #"+(i+1)+": "+output[i]);
    		}
    	}
    	System.out.flush();
    }
	private boolean checkGood(String sequence,int shield) {
		int multi=1;
		int damage=0;
		for(int i =0; i<sequence.length();i++ ) {
			if(sequence.charAt(i)=='S') {
				damage=damage+multi;
			}
			if(sequence.charAt(i)=='C') {
				multi=multi*2;
			}
		}

		return shield>=damage;
	}
	private String moveOne(String sequence) {
		int on=sequence.lastIndexOf('S');
		while(true) {
			if(sequence.charAt(on)=='S') {
				if(sequence.charAt(on-1)=='C') {
					char[] change = sequence.toCharArray();
					change[on-1]='S';
					change[on]='C';
					return new String(change);
					
					
				}
			}
			on--;
		}
		
		//return sequence;
	}
}
