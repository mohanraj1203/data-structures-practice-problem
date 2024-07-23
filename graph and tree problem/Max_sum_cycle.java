import java.util.*;
class Max_sum_cycle{
	public static int find_sum_cycle(int[] arr){
		ArrayList<Integer> result=new ArrayList<>();
		int size=arr.length;
		for(int i=0;i<size;i++){
			ArrayList<Integer> temp=new ArrayList<>();
			int sum=0;
			int j=i;
			while(j != -1 && !temp.contains(j)){
				sum+=j;
				temp.add(j);
				j=arr[j];
			}
			if(temp.get(0) == j)
				result.add(sum);
		}
		return Collections.max(result);
	}
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		int size=obj.nextInt();
		int[] arr=new int[size];
		for(int i=0;i<size;i++)
			arr[i]=obj.nextInt();
		System.out.println(find_sum_cycle(arr));
	}
}