import java.util.*;
import java.io.*;

public class ride{

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		int m = 1;
		int m2 = 1;
		String line = br.readLine();
		String[] l = line.split("");
		for(int i = 0; i < l.length; i++){
			int c = l[i].charAt(0) - 'A' + 1;
			m *= c;
		}
		line = br.readLine();
		String[] l2 = line.split("");
		for(int i = 0; i < l2.length; i++){
			int c = l2[i].charAt(0) - 'A' + 1;
			m2 *= c;
		}
		if (m % 47 == m2 % 47)
			System.out.println("GO");
		else
			System.out.println("STAY");
		br.close();
	}
}