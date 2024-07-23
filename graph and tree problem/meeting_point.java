import java.util.*;
class meeting_point{
	
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
		int max=0;
		int point1=obj.nextInt();
		int point2=obj.nextInt();
		ArrayList<Integer> c1=new ArrayList<>();
		ArrayList<Integer> c2=new ArrayList<>();
		int result=0;
		while(true){
			if(c1.contains(point2)){
				result=point2;
				break;
			}
			if(c2.contains(point1)){
				result=point1;
				break;
			}
			c1.add(point1);
			c2.add(point2);
			point1=edge.get(point1).get(0);
			point2=edge.get(point2).get(0);
			System.out.println(point1+" "+point2);
		}
		System.out.println(result);
	}
}