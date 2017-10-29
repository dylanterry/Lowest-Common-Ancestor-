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
	
	public int size(){
		return listNodes.length;
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

}
