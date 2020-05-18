/*
ID: mjang
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.io.*;

public class dualpal{

	public static String convertTo(int x, int base){
		String ans = "";
		while(x>0){
			ans = (x % base) + ans;
			x /= base;
		}
		return ans;
	}
	public static String reverse(String s){
		String rev = "";
		for(int i = s.length()-1; i >= 0; i--){
			rev += s.charAt(i);
		}
		return rev;
	}

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new File("dualpal.out"));
		BufferedReader br = new BufferedReader(new FileReader("dualpal.in"));
		String[] l = br.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int s = Integer.parseInt(l[1]);
		int count = 0;
		o:
		for(int i = s + 1; i < 100000; i++){
			int c = 0;
			for(int j = 2; j < 11; j++){
				String k = convertTo(i,j);
				if(k.equals(reverse(k))){
					c++;
					if(c == 2){
						count++;
						System.out.println(i);
						pw.println(i);
						if(count == n)
							break o;
						else
							break;
					}
				}
			}
		}


		br.close();
		pw.close();
	}
}