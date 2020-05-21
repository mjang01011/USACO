/*
ID: mjang
LANG: JAVA
TASK: family
*/

import java.util.*;
import java.io.*;

public class family{

	static HashMap<String, String> parent;
	static HashMap<String, HashSet<String>> child;
	static String relation;


	public static boolean isSiblings(String a, String b){
		String parentA = parent.get(a);
		if(parentA != null)
			return child.get(parentA).contains(b);
		return false;

	}

	public static boolean isParent(String a, String b){
		String parentA = parent.get(a);
		boolean related = false;
		int depth = 0;
		while(parentA != null){
			if(parentA.equals(b)){
				related = true;
				break;
			}
			parentA = parent.get(parentA);
			depth++;
		}
		relation = "mother";
		for(int i = 1; i <= depth; i++){
			if(i == 1)
				relation = "grand-mother";
			else
				relation = "great-" + relation; 
		}
		return related;
	}

	public static boolean isCousins(String a, String b){
		HashSet<String> ancestors = new HashSet<String>();
		String pa = a;
		while(pa != null){
			ancestors.add(pa);
			pa = parent.get(pa);
		}
		String pb = b;
		while(pb != null){
			if(ancestors.contains(pb))
				return true;
			pb = parent.get(pb);
		}
		return false;
	}

	public static boolean isAunt(String a, String b){
		String parentA = parent.get(a);
		boolean related = false;
		int depth = 0;
		while(parentA != null){
			if(isSiblings(parentA,b)){
				related = true;
				break;
			}
			parentA = parent.get(parentA);
			depth++;
		}
		relation = "aunt";
		for(int i = 0; i < depth; i++){
			relation = "great-" + relation;
		}
		return related;
	}

	public static void main(String[] args) throws IOException{
		PrintWriter pw = new PrintWriter(new File("family.out"));
		BufferedReader br = new BufferedReader(new FileReader("family.in"));
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		String a = s[1];
		String b = s[2];
		parent = new HashMap<String, String>();
		child = new HashMap<String, HashSet<String>>();
		for(int i = 0; i < n; i++){
			String[] s2 = br.readLine().split(" ");
			String c = s2[0];
			String d = s2[1];
			parent.put(d, c);
			if(!child.containsKey(c)){
				child.put(c, new HashSet<String>());
			}
			child.get(c).add(d);

		}

		String output = "";
		if(isSiblings(a,b)){
			output = "SIBLINGS";
		}
		else if(isParent(a,b)){
			output = b + " is the " + relation + " of " + a;
		}
		else if(isParent(b, a)){
			output = a + " is the " + relation + " of " + b;
		}
		else if(isAunt(a,b)){
			output = b + " is the " + relation + " of " + a;
		}
		else if(isAunt(b, a)){
			output = a + " is the " + relation + " of " + b;
		}
		else if(isCousins(a,b))
			output = "COUSINS";
		else
			output = "NOT RELATED";

		System.out.println(output);
		pw.println(output);


		
		br.close();
		pw.close();
	}
}