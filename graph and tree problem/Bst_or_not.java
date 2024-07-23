import java.util.*;
class Bst_or_not{
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
		result.add(root.data);
		generate(root.right);
	}
	static boolean isValidBST(Node root) {
        generate(root);
        for(int i=0;i<result.size()-1;i++){
            if(result.get(i)>=result.get(i+1))
                return false;
        }
        return true;
    }
	public static void main(String[] arg){
		Scanner obj=new Scanner(System.in);
		String[] str=obj.nextLine().split(" ");
		int[] arr=new int[str.length];
		for(int i=0;i<arr.length;i++)
			arr[i]=Integer.parseInt(str[i]);
		Node root=buildtree(arr);
		
		System.out.println(isValidBST(root));
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