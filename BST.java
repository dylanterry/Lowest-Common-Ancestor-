
import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
	private Node root;             // root of BST

	/**
	 * Private node class.
	 */
	private class Node {
		private Key key;           // sorted by key
		private Value val;         // associated data
		private Node left, right;  // left and right subtrees
		private int N;             // number of nodes in subtree

		public Node(Key key, Value val, int N) {
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
	//find the lowest common ancestor of two nodes 
	public Node LCA(Node root, Node a, Node b) {
		   if ((root == null) ||( a==null)||(b==null)) {
		       return null;
		   }

		   // If the root is one of a or b, then it is the LCA
		   if (root == a || root == b) {
		       return root;
		   }

		   Node left = LCA(root.left, a, b);
		   Node right = LCA(root.right, a, b);

		   // If both nodes lie in left or right then their LCA is in left or right,
		   // Otherwise root is their LCA
		   if (left != null && right != null) {
		      return root;
		   }

		   return (left != null) ? left : right; 
		}

	// is the symbol table empty?
	public boolean isEmpty() { return size() == 0; }

	// return number of key-value pairs in BST
	public int size() { return size(root); }

	// return number of key-value pairs in BST rooted at x
	private int size(Node x) {
		if (x == null) return 0;
		else return x.N;
	}

	/**
	 *  Search BST for given key.
	 *  Does there exist a key-value pair with given key?
	 *
	 *  @param key the search key
	 *  @return true if key is found and false otherwise
	 */
	public boolean contains(Key key) {
		return get(key) != null;
	}

	/**
	 *  Search BST for given key.
	 *  What is the value associated with given key?
	 *
	 *  @param key the search key
	 *  @return value associated with the given key if found, or null if no such key exists.
	 */
	public Node get(Key key) { return get(root, key); }

	private Node get(Node x, Key key) {
		if (x == null) return null;
	
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x;
	}

	/**
	 *  Insert key-value pair into BST.
	 *  If key already exists, update with new value.
	 *
	 *  @param key the key to insert
	 *  @param val the value associated with key
	 */
	public void put(Key key, Value val) {
		root = put(root, key, val);
	}

	private Node put(Node x, Key key, Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
}