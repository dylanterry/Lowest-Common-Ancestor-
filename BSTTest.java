import static org.junit.Assert.*;

import org.junit.Test;

public class BSTTest {

	@Test
	public void test1() {
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
		assertEquals(bst.get(7), bst.LCA(bst.get(7), bst.get(8), bst.get(3)));
	}

}
