import java.util.*;
class Depth_of_forest{
	public static int calculate_depth(int[] arr){
		List<List<Integer>> result=new ArrayList<>();
		result.add(new ArrayList<>());
		Queue<Integer> queue=new LinkedList<>();
		for(int i=0;i<arr.length;i++)
			if(arr[i] == -1){
				queue.add(i);
				result.get(0).add(i);
			}
		while(!queue.isEmpty()){
			int size=queue.size();
			result.add(new ArrayList<>());
			for(int i=0;i<size;i++){
				int temp=queue.poll();
				for(int j=0;j<arr.length;j++)
					if(arr[j] == temp){
						result.get(result.size()-1).add(j);
						queue.add(j);
					}
			}
		}
		int ans=0;
		int max=0;
		for(int i=0;i<result.size();i++)
			if(max <= result.get(i).size()){
				max=result.get(i).size();
				ans=i;
			}
		return ans;
	}
		
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		int test_case=obj.nextInt();
		for(int t=0;t<test_case;t++){
			int size=obj.nextInt();
			int[] arr=new int[size];
			for(int i=0;i<size;i++)
				arr[i]=obj.nextInt();
			System.out.println(calculate_depth(arr));
		}
	}
}