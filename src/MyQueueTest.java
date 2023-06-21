 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests

	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ = new MyQueue<Double>(5);
        doubleQ.enqueue(1.0);
        doubleQ.enqueue(2.0);
        doubleQ.enqueue(3.0);
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringQ.isEmpty());
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isEmpty());
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	 @Test
	    public void testDequeueStudent() {
	        try {
	            assertEquals(1.0, doubleQ.dequeue(), 0.001);
	            assertEquals(2.0, doubleQ.dequeue(), 0.001);
	            assertEquals(3.0, doubleQ.dequeue(), 0.001);
	            // Queue is empty, next statement should cause QueueUnderFlowException
	            doubleQ.dequeue();
	            fail("This should have caused a QueueUnderflowException");
	        } catch (QueueUnderflowException e) {
	            assertTrue("This should have caused a QueueUnderflowException", true);
	        } catch (Exception e) {
	            assertTrue("This should have caused a QueueUnderflowException", false);
	        }
	    }

	@Test
	public void testSize() {
		assertEquals(3, stringQ.size());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(4, stringQ.size());
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stringQ.dequeue();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(2, stringQ.size());
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
    public void testEnqueueStudent() {
        try {
            assertEquals(3, doubleQ.size());
            assertEquals(true, doubleQ.enqueue(4.0));
            assertEquals(4, doubleQ.size());
            assertEquals(true, doubleQ.enqueue(5.0));
            assertEquals(5, doubleQ.size());
            // Queue is full, next statement should cause QueueOverFlowException
            doubleQ.enqueue(6.0);
            fail("This should have caused a QueueOverflowException");
        } catch (QueueOverflowException e) {
            assertTrue("This should have caused a QueueOverflowException", true);
        } catch (Exception e) {
            assertTrue("This should have caused a QueueOverflowException", false);
        }
    }

	@Test
	public void testIsFull() {
		assertEquals(false, stringQ.isFull());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(true, stringQ.isFull());
	}

	@Test
	public void testToString() {
		assertEquals("abc", stringQ.toString());
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("abcd", stringQ.toString());
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("abcde", stringQ.toString());
	}
	
	@Test
    public void testToStringStudent() {
        assertEquals("1.02.03.0", doubleQ.toString());
        try {
			doubleQ.enqueue(4.0);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals("1.02.03.04.0", doubleQ.toString());
        try {
			doubleQ.enqueue(5.0);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assertEquals("1.02.03.04.05.0", doubleQ.toString());
    }

	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringQ.toString("%"));
		try {
			stringQ.enqueue(d);
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		assertEquals("a&b&c&d", stringQ.toString("&"));
		try {
			stringQ.enqueue(e);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		try {
			stringQ.fill(fill);
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(3,stringQ.size());
		try {
			assertEquals("apple", stringQ.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals("banana", stringQ.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			assertEquals("carrot", stringQ.dequeue());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
