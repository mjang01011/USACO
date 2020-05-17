/*
ID: mjang
LANG: JAVA
TASK: billboard
*/

import java.util.*;
import java.io.*;

public class billboard{

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new File("billboard.out"));
		BufferedReader br = new BufferedReader(new FileReader("billboard.in"));
		String[] l1 = br.readLine().split(" ");
		int x1 = Integer.parseInt(l1[0]);
		int y1 = Integer.parseInt(l1[1]);
		int x2 = Integer.parseInt(l1[2]);
		int y2 = Integer.parseInt(l1[3]);
		String[] l2 = br.readLine().split(" ");
		int x3 = Integer.parseInt(l2[0]);
		int y3 = Integer.parseInt(l2[1]);
		int x4 = Integer.parseInt(l2[2]);
		int y4 = Integer.parseInt(l2[3]);
		String[] l3 = br.readLine().split(" ");
		int x5 = Integer.parseInt(l3[0]);
		int y5 = Integer.parseInt(l3[1]);
		int x6 = Integer.parseInt(l3[2]);
		int y6 = Integer.parseInt(l3[3]);
		int area1 = (x2-x1)*(y2-y1);
		int area2 = (x4-x3)*(y4-y3);
		int areaT1 = 0;
		int areaT2 = 0;
		int xLength1 = Math.min(x2,x6)-Math.max(x1,x5);
		int yLength1 = Math.min(y2,y6)-Math.max(y1,y5);
		int xLength2 = Math.min(x4,x6)-Math.max(x3,x5);
		int yLength2 = Math.min(y4,y6)-Math.max(y3,y5);
		if(xLength1 > 0 && yLength1 > 0)
			areaT1 = area1 - xLength1*yLength1;
		else
			areaT1 = area1;
		if(xLength2 > 0 && yLength2 > 0)
			areaT2 = area2 - xLength2*yLength2;
		else
			areaT2 = area2;
		pw.println(areaT1+areaT2);
		System.out.println(areaT1+areaT2);
		br.close();
		pw.close();
	}
}