package itec220.labs;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackA<Item> implements StackInterface<Item> {

	Item[] arr;
	int index;
	
	@SuppressWarnings("unchecked")
	StackA(){
		arr = (Item[])new Object[10];
		index = 0;
	}
	
	@Override
	public void push(Item item) {
		if(index == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);
		}
		arr[index] = item;
		index++;
	}

	@Override
	public Item pop() {
		if(index == 0) {
			throw new EmptyStackException();
		}
		index--;
		return arr[index];
	}

	@Override
	public Item peek() {
		if(index == 0) {
			throw new EmptyStackException();
		}
		return arr[index - 1];
	}

	@Override
	public boolean isEmpty() {
		return (index == 0);
	}

	@Override
	public void makeEmpty() {
		index = 0;
	}

	@Override
	public int size() {
		return index;
	}

}
