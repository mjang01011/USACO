/*
ID: mjang
LANG: JAVA
TASK: barn1
*/

import java.util.*;
import java.io.*;

public class barn1{

	public static void swap(int[] x, int i, int j){
		int tmp = x[i];
		x[i] = x[j];
		x[j] = tmp;
	}

	public static void insertionSort(int[] x, int[] y){
		for(int i = 0; i < x.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(x[j+1] < x[j]) {
					swap(x,j+1,j);
					swap(y,j+1,j);
				}
				else
					break;
			}
		}
	}

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new File("barn1.out"));
		BufferedReader br = new BufferedReader(new FileReader("barn1.in"));
		
		String[] l = br.readLine().split(" ");
		int m = Integer.parseInt(l[0]);
		int s = Integer.parseInt(l[1]);
		int c = Integer.parseInt(l[2]);
		int[] a = new int[c];
		int[] b = new int[c];
		int[] o = new int[c];
		int[] ans = new int[m+1];
		for(int i = 0; i < c; i++){
			a[i] = Integer.parseInt(br.readLine());
			o[i] = i;
		}
		insertionSort(a,b);
		for(int i = 1; i < c; i++)
			b[i] = a[i] - a[i-1];
		if(m == 1){
			insertionSort(a,o);
			int n = a[a.length-1] - a[0] + 1;
			System.out.println(n);
			pw.println(n);
			br.close();
			pw.close();
		}
		if(m >= c){
			System.out.println(c);
			pw.println(c);
			br.close();
			pw.close();
		}
		else{
			insertionSort(b,o);
			for(int i = 1; i < m+1; i++)
				ans[i] = o[c-i]-1;
			ans[m] = c-1;
			insertionSort(ans,o);
			int n = a[1]-a[0];
			for(int i = 0; i < m; i++)
				n += a[ans[i+1]] - a[ans[i]+1] + 1;
			System.out.println(n);
			pw.println(n);
			br.close();
			pw.close();
		}
	}
}