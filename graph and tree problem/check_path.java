import java.util.*;
class check_path{
	static int size=5;
	static boolean[][] check;
	static int[][] arr;
	static int[] row={1,0,-1,0};
	static int[] col={0,1,0,-1};
	
	static boolean generate_path(int[][] arr,int[] start,int[] end){
		Queue<pair> queue=new LinkedList<>();
		check[start[0]][start[1]]=true;
		queue.add(new pair(start[0],start[1]));
		while(queue.size() != 0){
			int size1=queue.size();
			for(int j=0;j<size1;j++){
				for(int i=0;i<4;i++){
					int r=row[i]+queue.peek().r;
					int c=col[i]+queue.peek().c;
					
					if(r > -1 && c < size && c > -1 && r < size){
						if(arr[r][c] == 0 && check[r][c] == false){
							if(r == end[0] && c == end[1])
								return true;
							check[r][c]=true;
							queue.add(new pair(r,c));
							
						}
					}
			
				}
				queue.poll();
			}
		}
		return false;
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
		
		System.out.print(generate_path(arr,start,end));
	}
}
class pair{
	int r;
	int c;
	public pair(int r,int c){
		this.r=r;
		this.c=c;
	}
}