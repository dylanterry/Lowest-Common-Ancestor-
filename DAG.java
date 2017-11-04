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
	public Node LCA(Node node1, Node node2) {
        if(getRoot() == null || node1 == null || node2 == null) return null;
        return LCA(getRoot(), node1, node2);
    }
    
    private Node LCA(Node node, Node node1, Node node2) {
        
        ArrayList<Node> list1, list2, smallList, largeList, group;
        list1 = add(node, node1, new ArrayList<>(), new Stack<>());
        list2 = add(node, node2, new ArrayList<>(), new Stack<>());
        
        
        if ( list2.size()>=list1.size()) {
            smallList = list1;
            largeList = list2;
        } 
        else {
        	smallList = list2;
            largeList = list1;
        }
        
        group = new ArrayList<>();
        for (Node n : smallList) {
            group.add(n);
        }
        for (int i = largeList.size() - 1; i >= 0; i--) {
            if (group.contains(largeList.get(i))) {
                return largeList.get(i);
            }
        }
        return null;
    }
	
	

}
