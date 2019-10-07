import static org.junit.Assert.*;

import org.junit.Test;


public class LCATest {

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testNodeConstructor(){
		
		Node temp = new Node(1);
		assertNotNull("Testing Node constructor: ", temp);
	}
	
	@Test 
	public void testEmptyTree(){
		LCA isTreeEmpty = new LCA();
		assertNull("Find LCA when tree is empty: ",isTreeEmpty.findLCA(1, 2));
		assertEquals("Find LCA when tree is empty: ", null,isTreeEmpty.findLCA(1, 2));

	}
	
	@Test
	public void testTwoNodes(){

		LCA tree = new LCA();
		tree.root = new Node(1);
		tree.root.left = new Node(2);

		assertEquals("Find LCA of tree with only one root and one child: ", 1, tree.findLCA(1, 2));	
	}
}

