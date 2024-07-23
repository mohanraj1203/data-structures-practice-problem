import java.util.*;
class max_cycle{
	static List<List<Integer>> edge;
	static ArrayList<Integer> result=new ArrayList<>();
	static int comp;
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		int N=obj.nextInt();
		int[] arr=new int[N];
		obj.nextLine();
		String[] str=obj.nextLine().split(" ");
		for(int i=0;i<N;i++)
			arr[i]=Integer.parseInt(str[i]);
		edge=new ArrayList<>();
		for(int i=0;i<N;i++)
			edge.add(new ArrayList<>());
		for(int i=0;i<N;i++)
			edge.get(i).add(arr[i]);
		
		for(int i=0;i<N;i++){
			int count=0;
			ArrayList<Integer> temp=new ArrayList<>();
			
			result.add(find_cycle(i,count,temp));
		}
			
		Collections.sort(result);
		System.out.println(result.get(result.size()-1));
	}
	static int find_cycle(int val,int count,ArrayList<Integer> temp){
		
		if(temp.size() > 1 && temp.get(0) == val){
			System.out.println(temp);
			return count;
		}
		
		if(temp.size() > 1 && temp.contains(val) || val == -1)
			return -1;
		
	
		temp.add(val);
		
		return find_cycle(edge.get(val).get(0),count+1,temp);
	}
}