import java.util.ArrayList;
import java.util.Stack;

public class DAG <Value> {
	
	
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
	
	public void setRoot(Node node){
		this.root=node;
	}
	public Node getRoot(){
		return this.root;
	}
	
	

}
