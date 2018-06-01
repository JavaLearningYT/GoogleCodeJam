import java.util.Scanner;

public class RNumbers {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		new RNumbers();
	}
	public RNumbers() {
		int inputs = scan.nextInt();
		scan.nextLine();
		int[] output = new int[inputs];
		for(int i = 0; i<inputs; i++) {
			int numb =0;
			String[] snumbs = scan.nextLine().trim().split(" ");
			int start = Integer.parseInt(snumbs[0]);
			int end = Integer.parseInt(snumbs[1]);
			if(start<10) {
				output[i]=0;
				continue;
			}
			for(int a=start; a<=end;a++) {
				
				String testing = String.valueOf(a);
				
				for(int g=0;g<testing.length()-1;g++) {
					
					testing =(testing.substring(1)+testing.charAt(0));
					//&&!testing.equals(String.valueOf(a))
					if(Integer.parseInt(testing)<=end&&Integer.parseInt(testing)>a) {
						numb++;
					}else {
						if(Integer.parseInt(testing)==a) {
							break;
						}
					}
				
				}
			}
			output[i]=numb;
			//System.out.println(numb);
			
		}
		for(int i=0;i<output.length;i++) {
			System.out.println("Case #"+(i+1)+": "+output[i]);
		}
	}
}
