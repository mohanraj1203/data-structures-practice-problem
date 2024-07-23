import java.util.*;
class min_coin{
	static int calculate(int[] arr,int amount){
		int count=Integer.MAX_VALUE;
		Arrays.sort(arr);
		for(int j=arr.length-1;j>-1;j--){
			int count_temp = 0;
			int amount_temp = amount;
			for(int i=j;i>-1;i--){
				while(amount_temp >= arr[i]){
					amount_temp-=arr[i];
					count_temp++;
				}
					
					
				if(amount_temp == 0){
					count=Math.min(count,count_temp);
					break;
				}
			}
		}
		return count;
	}
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		String[] str=obj.nextLine().split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(str[i]);
		int amount=obj.nextInt();
		System.out.println(calculate(arr,amount));
	}
}
26 5
3 7 6 11 8