/*
ID: mjang
LANG: JAVA
TASK: blocks
*/

import java.util.*;
import java.io.*;

public class blocks{

	public static int[] count(String s){
		int[] c = new int[26];
		for(int i = 0; i < s.length(); i++){
			int k = s.charAt(i) - 'a';
			c[k]++; 
		}
		return c;
	}

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new File("blocks.out"));
		BufferedReader br = new BufferedReader(new FileReader("blocks.in"));
		
		int n = Integer.parseInt(br.readLine());
		int[] chars = new int[26];
		for(int i = 0; i < n; i++){
			String[] pair = br.readLine().split(" ");
			int[] p1 = count(pair[0]);
			int[] p2 = count(pair[1]);
			for(int j = 0; j < 26; j++){
				chars[j] += Math.max(p1[j],p2[j]);
			}
		}
		for(int i = 0; i < 26; i++){
			System.out.println(chars[i]);
			pw.println(chars[i]);
		}
		
		br.close();
		pw.close();
	}
}