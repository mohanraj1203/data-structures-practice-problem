import java.util.*;
class LCA{
	static Node travel(Node root, Node p, Node q) {
        if (root == null || root.data == p.data || root.data == q.data)
            return root;
            
        Node left = travel(root.left, p, q);
        Node right = travel(root.right, p, q);
        if (left == null)
            return right;
        else if (right == null)
            return left;
        return root;
    }
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
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		String[] str=obj.nextLine().split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(str[i]);
		Node root=buildtree(arr);
		
		Node node1=new Node(obj.nextInt());
		Node node2=new Node(obj.nextInt());
		
		System.out.println(travel(root,node1,node2).data);
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