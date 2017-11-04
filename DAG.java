import java.util.ArrayList;
import java.util.Stack;

public class DAG <Value> {
	
	private class Node {
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
	private Node root;
	
	private ArrayList <Node> add (Node node, Node target, ArrayList <Node> list, Stack <Node> stack){
		stack.push(node);
		for (Node nextNode:node.listNodes){
			if (nextNode.equals(target)){
				list.addAll(stack);
				return list;
			}
			add(nextNode, target, list, stack);
		}
		stack.pop();
		return list;
	}
	
	

}
