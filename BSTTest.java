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

	@Test
	public void testSimple() {
		
		BST <Integer, Integer> bst = newBST();
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(8), bst.get(3)));
		assertEquals(bst.get(1), bst.LCA(bst.get(7), bst.get(1), bst.get(2)));
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(2), bst.get(9)));


	}
	@Test
	public void testNullNode(){
		BST<Integer, Integer> bst = newBST();
		
		assertEquals(null, bst.LCA(bst.get(7), bst.get(3), bst.get(22))); //testing out of bounds node
	}
	
	@Test 
	public void testNullRoot(){
		BST <Integer, Integer> bst = new BST <Integer, Integer>();
		
		bst.put(null, null);
		bst.put(1, 1);
		bst.put(3, 2);
		
		assertEquals(null, bst.LCA(bst.get(2), bst.get(1),bst.get(3) ));
	}

}
