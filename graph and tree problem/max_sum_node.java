import java.util.*;
class max_sum_node{
	
	static List<List<Integer>> edge;
	
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
		int[] result=new int[N];
		int max=0;
		for(int i=0;i<N;i++){
			if(edge.get(i).get(0) != -1){
				result[edge.get(i).get(0)]+=i;
			}
			System.out.print(i+" ");
		}
		System.out.println();
		int x=0;
		for(int i=0;i<result.length;i++){
			if(max < result[i]){
				max=result[i];
				x=i;
			}
		}
		System.out.println(x);
	}
}