import java.util.*;
class remove_construct{
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		String str=obj.nextLine().toLowerCase();
		String temp="juspay";
		int i=0,j=0;
		while(i < temp.length() && j < str.length()){
			if(temp.charAt(i) == str.charAt(j))
				i++;
			j++;
		}
		if(i == temp.length())
			System.out.println(str.length() - temp.length());
		else
			System.out.println(-1);
	}
}
