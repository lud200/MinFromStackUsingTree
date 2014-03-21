package MinFromStack;
import java.util.*;
public class MinFromStack {

	public static void main(String args[]){
		Stack s=new Stack<Integer>();
		s.push(4);
		s.push(2);
		s.push(5);
		s.push(20);
		s.push(9);
		s.push(3);
		BinaryTree t=new BinaryTree();
		for(int i=0;i<s.size();i++){
			t.insert((int) s.get(i));
		}
		t.minimum();
	}
}

class BinaryTree{
	private class Node{
		Node left;
		Node right;
		int data;
		Node(int newdata){
			left=null;
			right=null;
			data=newdata;
		}
	}
	private Node root;
	public void BinaryTree(){
		root=null;
	}
	//Insert
	public void insert(int data){
		Node temp=root;
		Node newnode=new Node(data);
		newnode.left=null;
		newnode.right=null;
		newnode.data=data;
		root=insert(root, newnode);
	}
	public Node insert(Node temp, Node newnode){
		int data;
		if(temp==null){
			temp=newnode;
		}
		else{
			if(temp.data<=newnode.data){
				insert(temp.right, newnode);
				if(temp.right==null)
					temp.right=newnode;
			}
			else{
				insert(temp.left, newnode);
				if(temp.left==null)
					temp.left=newnode;
			}
		}
		return temp;
	}
	public void minimum(){
		minimum(root);
	}
	public void minimum(Node node){
		while(node.left!=null){
			node=node.left;
		}
		System.out.print("Minimum value of the tree is:");
		System.out.println(node.data);
	}
	public String preorder(){
		return preorder(root);
	}
	String s1=" ";

	public String preorder(Node node){
		if(node==null)
		{
			return null;
		}
			System.out.print(node.data+"\t");
			s1=s1+node.data;
			String pre=s1;
			preorder(node.left);
			preorder(node.right);
			return pre;
	}


}