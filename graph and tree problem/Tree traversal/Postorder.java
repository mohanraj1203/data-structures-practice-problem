import java.util.*;
class Postorder{
	static int index=-1;
	static Node buildtree(int[] arr){
		index++;
		if(arr[index] == -1)
			return null;
		
		Node newNode=new Node(arr[index]);
		newNode.left=buildtree(arr);
		newNode.right=buildtree(arr);
		
		return newNode;
	}
	static ArrayList<Integer> result=new ArrayList<>();
	static void generate(Node root){
		if(root == null)
			return;
		
		generate(root.left);
		generate(root.right);
		result.add(root.data);
	}
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		String[] str=obj.nextLine().split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(str[i]);
		Node root=buildtree(arr);
		
		generate(root);
		
		System.out.println(result);
	}
}
class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data=data;
		this.left=null;
		this.right=null;
	}
}