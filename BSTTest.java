import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {
	
	private BST <Integer, Integer> newBST (){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \	 \
		bst.put(2, 2);   // 1       6	  9
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
		bst.put(9, 9);	//         5
		
		
		return bst;
	}
	//test that LCA() is returning correct nodes
	@Test
	public void testSimple() {
		
		BST <Integer, Integer> bst = newBST();
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(8), bst.get(3)));
		assertEquals(bst.get(1), bst.LCA(bst.get(7), bst.get(1), bst.get(2)));
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(2), bst.get(9)));


	}
	//testing nodes that dont exist 
	@Test
	public void testNullNode(){
		BST<Integer, Integer> bst = newBST();
		
		assertEquals(null, bst.LCA(bst.get(7), bst.get(3), bst.get(22))); 
	}
	//testing a root that does not exist 
	@Test 
	public void testNullRoot(){
		BST <Integer, Integer> bst = newBST();
		
		assertEquals(null, bst.LCA(bst.get(0), bst.get(1),bst.get(3) ));
	}
	//Test if one of the nodes is root LCA shout be root
	@Test 
	public void testRootNode(){
		BST <Integer, Integer> bst = newBST();
		
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(7), bst.get(1)));
		
	}
	@Test
	public void testPut(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();

		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);
		bst.put(14, 9);
		bst.put(14, 10);
		bst.put(10, 11);
		bst.put(11, null);
		
		bst.contains(1);
	}
	@Test 
	public void testGet(){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		bst.put(7, 7);   //        _7_
		bst.put(8, 8);   //      /     \
		bst.put(3, 3);   //    _3_      8
		bst.put(1, 1);   //  /     \
		bst.put(2, 2);   // 1       6
		bst.put(6, 6);   //  \     /
		bst.put(4, 4);   //   2   4
		bst.put(5, 5);   //        \
						//         5
		assertEquals(Integer.valueOf(6),bst.getValue(6));
		assertEquals(Integer.valueOf(8),bst.getValue(8));

		assertEquals(null,bst.getValue(22));

	}
	
}
