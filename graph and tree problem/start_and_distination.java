import java.util.*;
class start_and_distination{
	static int size=5;
	static boolean[][] check;
	static int[][] arr;
	static List<int[]> ans=new ArrayList<>();
	static int[] row={1,0,-1,0};
	static int[] col={0,1,0,-1};
	
	static void generate_path(int[][] arr,int[] start,int[] end){
		
		if(start[0] == end[0] && start[1] == end[0]){
			load_result();
			return;
		}
		for(int i=0;i<4;i++){
			int r=row[i]+start[0];
			int c=col[i]+start[1];
			
			
			if(r > -1 && c < size && c > -1 && r < size){
				
				check[start[0]][start[1]] = true;
				if(arr[r][c] == 0 && check[r][c] == false){
					 display();
					generate_path(arr,new int[]{r,c},end);
					
					check[start[0]][start[1]] = false;
				}
			}
			
		}
	}
	static void load_result(){
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				if(check[i][j])
					ans.add(new int[]{i,j});
		
	}
	static void display(){
		for(int i=0;i<size;i++){
			for(int j=0;j<size;j++)
				System.out.print(check[i][j]+" ");
			System.out.println();
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		arr=new int[size][size];
		check=new boolean[size][size];
		for(int i=0;i<size;i++)
			for(int j=0;j<size;j++)
				arr[i][j]=obj.nextInt();
		int[] start=new int[2];
		int[] end=new int[2];
		for(int i=0;i<2;i++)
			start[i]=obj.nextInt();
		
		for(int i=0;i<2;i++)
			end[i]=obj.nextInt();
		
		generate_path(arr,start,end);
		
		for(int[] i:ans)
			System.out.print("("+i[0]+","+i[1]+") ");
	}
}