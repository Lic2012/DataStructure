package itaquiz;

import java.util.Stack;

public class NoneRecursiveBSTraversal {

	public static void main(String[] args) {
		// build a tree
		BST bst = new BST();
		bst.insert("a", 5);
		bst.insert("b", 6);
		bst.insert("c", 3);
		bst.insert("d", 7);
		bst.insert("e", 1);
		bst.insert("f", 9);
		bst.insert("g", 8);
		//recursive BinarySearchTree Traversal
		//bst.recursiveTraversalInOrder(bst.getRoot());
		
		// non recursive BinarySearchTree Traversal
		bst.nonRecursiveTraversalInorder(bst.getRoot());
		
		

	}

}

class TreeNode{
	TreeNode leftChild;
	TreeNode rightChild;
	int data;
	String id;
	//print this node on the screen
}

class BST{
	private TreeNode root;// this is private, can't access out of class
	public void insert(String id, int data){
		//initialize new node
		TreeNode newNode = new TreeNode();
		newNode.id = id;
		newNode.data = data;
		if (root == null) root = newNode;
		else{
			TreeNode current = root; // current parent a good name
			TreeNode parent;
			while(true){
				parent = current;
				if (data < current.data){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode; // newNode not current, current is just a pointer
						return ;
					}
				}
				else{
					current = current.rightChild;
					if (current == null	){
						parent.rightChild = newNode;
						return ;
					}
				}
			}
		}
	}
	public TreeNode find(int value){
		TreeNode current = root;
		while(current.data != value){ // mention while condition
			if (current.data < value) current = current.rightChild;
			else current = current.leftChild; 
			if (current == null) return null; // a new if
		}
		return current; // always return current
	}
	public void delete(){
		
	}
	/*
	 * other application
	 */
	public TreeNode getRoot(){
		return this.root;
	}
	
	public void recursiveTraversalInOrder(TreeNode localRoot){
		if(localRoot!=null){ // Mention not while !! if!!
			recursiveTraversalInOrder(localRoot.leftChild);
			System.out.println(localRoot.id+" "+localRoot.data);
			recursiveTraversalInOrder(localRoot.rightChild);
		}
	}
	
	public void nonRecursiveTraversalInorder(TreeNode localRoot){
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (localRoot!=null || !stack.isEmpty()){
			while (localRoot != null){
				stack.push(localRoot);
				localRoot = localRoot.leftChild;
			}
			if (!stack.isEmpty()){
				localRoot = stack.peek();
				System.out.println(localRoot.id+" "+localRoot.data);
				stack.pop();
				localRoot = localRoot.rightChild;
			}
		}
	}
}

