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
		assertEquals("LCA is empty: ",-1,isTreeEmpty.findLCA(0, 0));
	}
}

