/**
 * 
 */
package itec220.labs;

/**
 * @author Robert Ward
 *
 */
public interface StackInterface <Item> {
	
	/**
	 * Insert a new item into the stack.
	 * @param item the item to insert.
	 */
	public void push(Item item);
	
	/**
	 * Remove the most recently inserted item from the stack.
	 */
	public Item pop();
	
	/**
	 * Looks at the object at the top of this stack without removing it from the stack.
	 * 
	 */
	public Item peek();
	
	
	/**
	 * Test if the stack is logically empty.
	 *  @return true if empty, false otherwise.
	 */
	public boolean isEmpty();
	/**
	 *Make the stack logically empty.
	 */
	public void makeEmpty();

	/**
	 * Return the number of items currently on the stack.
	 *  @return number of items currently on the stack.
	 */
	int size();
	
}


