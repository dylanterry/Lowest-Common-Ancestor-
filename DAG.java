import java.util.Arrays;

public class DAG <Value> {
	
	
	private class Node {
		private Node [] sucessors;
		private Value value;
		
		public Node ( Value value){
			this.value = value;
		}
	}
	
	private Node [] listNodes = new DAG.Node[0];
	
	public boolean isEmpty (){
		if (size()==0) return true;
		else return false;
	}
	
	public boolean contains (Value v ){
		boolean contains = false;
		int length = size();
		for(int i=0;i<length;i++){
			
			if (listNodes[i].value == v){
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	public int size(){
		return listNodes.length;
	}
	
	public void put (Value v, Value prevVal, Value nextVal){
		Node node = new Node (v);
		Node prev = getNodeFromVal(prevVal);
		Node next = getNodeFromVal (nextVal);
		
		if (nextVal != null){
			node.sucessors = arrayBigger(node.sucessors);
			node.sucessors[node.sucessors.length-1] = next;
			//if prev is not in graph
			if (next.value == null){
				addToListNodes(next);
			}
		}
		
		if (prevVal != null){
			prev.sucessors = arrayBigger(prev.sucessors);
			prev.sucessors[prev.sucessors.length-1] = node;
			//if to node is not in graph
			if (prev.value == null){
				addToListNodes(prev);
			}
		}
		
		addToListNodes(node);
	}
	
	public Node[] arrayBigger (Node[] Array) {
		Node[] copyArray = new DAG.Node[Array.length+1];
		System.arraycopy(Array, 0, copyArray, 0, Array.length);
		return copyArray;
	}
	public void addToListNodes (Node n) {
		listNodes = arrayBigger(listNodes);
		listNodes[listNodes.length-1] = n;
	}
	
	public Node getNodeFromVal (Value v ){
		Node returnNode = new Node (null);
		for (int i=0; i<size();i++){
			if (listNodes[i].value == v){
				returnNode = listNodes[i];
				break;
			}
		}
		return returnNode;
	}
	
	

}
