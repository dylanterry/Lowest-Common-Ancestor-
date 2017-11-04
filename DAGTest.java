import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;

import org.junit.Test;

public class DAGTest {
	DAG<Node> dag1 = new DAG<Node>();
    ArrayList<Node> array;
    
	 @Before
	    public void createDAG(){
	        array = new ArrayList<>();
	        for (int i = 0; i < 100; i++) {
	            array.add(new Node(i));
	        }
	        dag1.setRoot(array.get(0));
	        array.get(0).addEdge(array.get(1));
	        array.get(0).addEdge(array.get(2));
	        array.get(1).addEdge(array.get(3));
	        array.get(1).addEdge(array.get(4));
	        array.get(2).addEdge(array.get(4));
	        array.get(2).addEdge(array.get(5));
	        array.get(2).addEdge(array.get(6));
	        array.get(5).addEdge(array.get(8));
	        array.get(6).addEdge(array.get(8));
	        array.get(6).addEdge(array.get(7));
	        array.get(6).addEdge(array.get(9));
	        array.get(7).addEdge(array.get(9));
	        
	    }
	
	

}
