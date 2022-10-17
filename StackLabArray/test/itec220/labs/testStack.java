package itec220.labs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import org.junit.jupiter.api.Test;

class testStack {

	@Test
	void testSizeOnEmptyStack() {
		
		StackA<Integer>  test = new StackA<Integer> ();
		int actual =  test.size();
		int expected = 0;
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSizeOnStackAfterPush() {
		
		StackA<Integer>  test = new StackA<Integer> ();
		test.push(0);
		int actual =  test.size();
		int expected = 1;
		assertEquals(expected, actual);
		
	}
	@Test
	void testSizeOnStackAfter2PushPop() {
		
		StackA<Integer>  test = new StackA<Integer> ();
		test.push(0);
		test.push(1);
		test.pop();
		int actual =  test.size();
		int expected = 1;
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testPeekOnEmptyStack() {
		
		StackA<Integer>  test = new StackA<Integer> ();
		
		assertThrows(EmptyStackException.class, () -> { test.peek();});	  		
		
		
	}
	
	
	@Test
	void testPeekOnStackAfter2PushPop() {		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		test.push(11);
		test.pop();
		int actual =  test.peek();
		int expected = 10;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPeekOnStackAfterPush() {
		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		int actual =  test.peek();
		int expected = 10;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPeekOnStackAfterPushPop() {
		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		test.pop();
		assertThrows(EmptyStackException.class, () -> { test.peek();});	  			
	}
	
	@Test
	void testPopOnEmptyStack() {
		
		StackA<Integer>  test = new StackA<Integer> ();
		
		assertThrows(EmptyStackException.class, () -> { test.pop();});		
		
	}
	
	@Test
	void testPopOnStackAfter2PushPop() {		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		test.push(11);
		test.pop();
		int actual =  test.pop();
		int expected = 10;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPopOnStackAfterPush() {
		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		int actual =  test.pop();
		int expected = 10;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPopOnStackAfterPushPop() {
		
		StackA<Integer> test = new StackA<Integer> ();
		test.push(10);
		test.pop();
		assertThrows(EmptyStackException.class, () -> { test.pop();});	  			
	}
	
	
	@Test
	void testPushUntilResize() {
		
		StackA<Integer> test = new StackA<Integer> ();
		for (int i = 10; i < 150; i++) {
			test.push(i);
			
		}	
		test.push(150);			
		int actual =  test.pop();
		int expected = 150;
		assertEquals(expected, actual);		
	}
	
	@Test
	void testPushPop2Stacksbye() {
		
		String test = "by the by time is Up";
		StackA<Character> letterStack = new StackA<Character>();
		StackA<Character> answer = new StackA<Character>();
		
		for (char letter : test.toCharArray()) {
		
			if(letter != ' ')
			{
				letterStack.push(letter);
			}
		}
		while (!letterStack.isEmpty() ) {
			if(letterStack.peek() < 'f' || letterStack.peek() > 'r' )
			{
				answer.push(letterStack.pop());
				
			}
			else
			{
			
				letterStack.pop();
			}
			
		}	
		StringBuilder testOut = new StringBuilder(); 
		while(!answer.isEmpty())
		{
			testOut.append(answer.pop());
		}
			assertEquals("bytebytesU",testOut.toString());	
	}
}
