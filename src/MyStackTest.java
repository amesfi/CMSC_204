 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	
	@Before
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringS.isEmpty());
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		try {
			stringS.push(d);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stringS.push(e);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringS.isFull());
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
	    doubleS = new MyStack<Double>(5);
	    try {
			doubleS.push(1.0);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doubleS.push(2.0);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			doubleS.push(3.0);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    
	    try {
	        assertEquals(3.0, doubleS.pop(), 0.001);
	        assertEquals(2.0, doubleS.pop(), 0.001);
	        assertEquals(1.0, doubleS.pop(), 0.001);
	        
	        // Stack is empty, next statement should cause StackUnderflowException
	        doubleS.pop();
	        fail("This should have caused a StackUnderflowException");
	    } catch (StackUnderflowException e) {
	        // Exception caught, test passes
	        assertTrue("This should have caused a StackUnderflowException", true);
	    } catch (Exception e) {
	        // Unexpected exception caught, test fails
	        fail("Unexpected exception: " + e.getMessage());
	    }
	}
	@Test
	public void testTop() {
		try {
			assertEquals(c, stringS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.push(d);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(d, stringS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals(b, stringS.top());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Test
	public void testSize() {
		assertEquals(3, stringS.size());
		try {
			stringS.push(d);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, stringS.size());
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringS.pop();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, stringS.size());
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() throws StackOverflowException {
	    doubleS = new MyStack<Double>(5);
	    
	    assertTrue(doubleS.push(1.0));
	    assertTrue(doubleS.push(2.0));
	    assertTrue(doubleS.push(3.0));

	    try {
	        assertEquals(3.0, doubleS.pop(), 0.001);
	        assertEquals(2.0, doubleS.pop(), 0.001);
	        assertEquals(1.0, doubleS.pop(), 0.001);
	    } catch (StackUnderflowException e1) {
	        e1.printStackTrace();
	    }

	    try {
	        // Stack is empty, next statement should cause StackUnderflowException
	        doubleS.pop();
	        fail("This should have caused a StackUnderflowException");
	    } catch (StackUnderflowException e) {
	        assertTrue("This should have caused a StackUnderflowException", true);
	    } catch (Exception e) {
	        assertTrue("This should have caused a StackUnderflowException", false);
	    }
	}

	@Test
	public void testToStringStudent() {
	    doubleS = new MyStack<Double>(5);
	    try {
			doubleS.push(1.0);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doubleS.push(2.0);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			doubleS.push(3.0);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    assertEquals("[1.0, 2.0, 3.0]", doubleS.toString());
	}
	
	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringS.toString("%"));
		try {
			stringS.push(d);
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("a&b&c&d", stringS.toString("&"));
		try {
			stringS.push(e);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		try {
			stringS.fill(fill);
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3,stringS.size());
		try {
			assertEquals("carrot", stringS.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals("banana", stringS.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals("apple", stringS.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
