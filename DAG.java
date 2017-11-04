import java.util.ArrayList;
import java.util.Stack;

public class DAG <Value> {
	
	
	private class Node {
		private Node [] sucessors;
		private Value value;
		
		public Node ( Value value){
			this.value = value;
		}
	}
	private Node root;
	
	private ArrayList <Node> DFS (Node node, Node target, ArrayList <Node> list, Stack <Node> stack){
		stack.push(node);
		for (Node theNode:node.nodeList){
			if (theNode.equals(target)){
				list.addAll(stack);
				return list;
			}
			DFS(theNode, target, list, stack);
		}
		stack.pop();
		return list;
	}
	
	

}
