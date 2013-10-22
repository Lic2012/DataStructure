
public class BinaryTree {

	public static void main(String[] args) {
		 Tree tree = new Tree();
		 tree.insert("A1", 1);
		 tree.insert("A2", 3);
		 tree.insert("A3", 5);
		 tree.insert("A4", 8);
		 tree.insert("A5", 15);
		 tree.insert("A6", 3);
		 tree.insert("A7", 4);
		 tree.insert("A8", 6);
		 tree.insert("A9", 2);
		 if (tree.find(3)!=null) 
		 System.out.println(tree.find(3).id);
		 System.out.println();

	}
	
	

}

class NodeTree{
	int data;
	String id;
	NodeTree leftChild;
	NodeTree rightChild;
}

class Tree{
	private NodeTree root;
	
	public NodeTree find(int key){
		NodeTree current = root;
		while(current.data!=key){
			if(current.data<key) current = current.leftChild;
			else current = current.rightChild;
			if (current == null) return null;
		}
		return current;
	}
	
	public void insert(String id, int data){
		NodeTree newNode = new NodeTree();
		newNode.data = data;
		newNode.id = id;
		if( root == null) root = newNode;
		else{
			NodeTree current = root;
			NodeTree parent;
			while(true){
				parent = current;
				if(data < current.data){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}
						
	public boolean delete(int key){
		NodeTree current = root;
		NodeTree parent = root;
		boolean isLeftChild = true;
		
		while( current.data != key){
			parent  = current;
			if (key < current.data){
				isLeftChild = true;
				current = current.leftChild;
			}else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if ( current == null) return false;
		}
		//find node to delete
		//if no children, simply delete it
		if(current.leftChild == null && current.rightChild == null){
			if (current == root) root = null;
			else if(isLeftChild) parent.leftChild = null;
			else parent.rightChild = null;
		}
		//if 1 children,
		else if(current.rightChild == null){
			if(current == root) root = current.leftChild;
			else if(isLeftChild) parent.leftChild = current.leftChild;
			else parent.rightChild = current.leftChild;
		}
		else if(current.leftChild == null){
			if(current == root) root = current.rightChild;
			else if(isLeftChild) parent.leftChild = current.rightChild;
			else parent.rightChild = current.rightChild;
		}
		//if 2 children
		else{
			//get successor
			NodeTree successor = getSuccessor(current);
			if (current == root) root = successor;
			else if(isLeftChild) parent.leftChild = successor;
			else parent.rightChild = successor;		
			//connect successor's left to current's left
			successor.leftChild = current.leftChild;
		}
		return true;		
	}
	
	private NodeTree getSuccessor(NodeTree delNode){
		NodeTree successorParent = delNode;
		NodeTree successor = delNode;
		NodeTree current = delNode.rightChild;
		while(current != null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		if (successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
	/*
	 * other applications
	 */
	
	}