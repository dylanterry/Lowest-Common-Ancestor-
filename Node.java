import java.util.ArrayList;

public class Node {
		int data;
		Node left, right;
		ArrayList<Node> listNodes;
		int count;
		
		public Node ( int value){
			data = value;
			listNodes = new ArrayList<Node>();
			count=0;
			left = null;
			right=null;
		}
		public void addEdge (Node x){
			listNodes.add(x);
			count++;
		}
		public boolean EdgeExist(Node x){
			return x.listNodes.contains(this);
		}
		public int noEdges(){
			return count;
		}
		
	}
