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
	 //Test LCA returns correct node 
	 @Test
	 public void testLCA(){
		 assertEquals(array.get(2), dag1.LCA(array.get(8), array.get(5)));
		 assertEquals(array.get(0), dag1.LCA(array.get(1), array.get(8)));
		 assertEquals(array.get(2), dag1.LCA(array.get(9), array.get(4)));

	 }
	 //Test a DAG with one node, should return null
	 @Test
	 public void TestLCA1Node(){
		 DAG<Node> dag2 = new DAG<Node>();
	     ArrayList<Node> array = new ArrayList<>();
	     array.add(new Node(1));
	     assertNull(dag2.LCA(array.get(0), array.get(0)));
	 }
	 //test we have correct number of edges in DAG
	 @Test
	 public void testNoEdges (){
		 int count=0;
		 for (int i=0; i<array.size();i++){
			 count=count+array.get(i).noEdges();
		 }
		 assertEquals(12,count);
	 }
	 //Test data from node is returned coorectly from LCA
	 @Test
	 public void testDataReturned(){
		 assertEquals(array.get(2).data, dag1.LCA(array.get(8), array.get(5)).data);
		 assertEquals(array.get(2).data, dag1.LCA(array.get(9), array.get(4)).data);
	 }
	
	
	

}
