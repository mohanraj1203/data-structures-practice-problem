import java.util.*;
class Merge_sorted{
	
    static ArrayList<Integer> ans=new ArrayList<>();
    static void addList(Node head){
        while(head!=null){
            ans.add(head.data);
            head=head.next;
        }
    }
    static Node addFirst(){
        if(ans.size() == 0)
            return null;

        Node head=new Node(ans.remove(0));
        head.next=addFirst();

        return head;
    }
    static Node mergeKLists(ArrayList<Node> lists) {
        for(Node i:lists)
            addList(i);

        Collections.sort(ans);

        return addFirst();
    }
	
	static Node build(int[] arr,int index){
		index++;
		if(index == arr.length)
			return null;
		
		Node newNode=new Node(arr[index]);
		newNode.next=build(arr,index);
		
		return newNode;
	}
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		int size=obj.nextInt();
		obj.nextLine();
		ArrayList<Node> arr=new ArrayList<>();
		for(int i=0;i<size;i++){
			String[] str=obj.nextLine().split(" ");
			int[] arr_temp=new int[str.length];
			for(int j=0;j<arr_temp.length;j++)
				arr_temp[j]=Integer.parseInt(str[j]);
			arr.add(build(arr_temp,-1));
		}
		Node head=mergeKLists(arr);
		System.out.println(ans);
		while(head != null){
			System.out.print(head.data+" ");
			head=head.next;
		}
	}
}
class Node{
	int data;
	Node next;
	public Node(int data){
		this.data=data;
		this.next=null;
	}
}