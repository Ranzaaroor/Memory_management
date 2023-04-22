//package MMS;
/*
           Assignment number :10
           File Name : List.java
           Name: Ran Zaaroor
           Student ID : 209374040
           Email : Ran.zaaroor@gmail.com
       */
/**
 * Represents a list of Nodes. Each node holds a reference to a memory block. 
 * <br> (Part of Homework 10 in the Intro to CS course, Efi Arazi School of CS)
 */
public class List {

	private Node first = null; // The first (dummy) node of this list
	private Node last = null;  // The last node of this list
	private int  size = 0;     // Number of elements (nodes) in this list
	
	/**
	 * Constructs a new list of Node objects, each holding a memory block (MemBlock object)
	 */ 
	public List() {
		// Creates a dummy node and makes first and last point to it.
		first = new Node(null);
		last = first;
	}

	/**
	 * @return The size of the list.
	 */
	public int getSize(){
		return size;
	}
    /**
	 * Adds the given memory block to the end of this list. 
     * Executes efficiently, in O(1).
	 * @param block The memory block that is added at the list's end
     */
    public void addLast(MemBlock block) {
        Node newNode = new Node(block);
        last.next = newNode;
        last = newNode;
        size++;
    }
    /** 
	 * Adds the given memory block at the beginning of this list.
     * Executes efficiently, in O(1).
	 * @param block The memory block that is added at the list's beginning
     */
    public void addFirst(MemBlock block) {
		Node newNode = new Node(block);
		newNode.next = first.next;
		first.next = newNode;
		if(size == 0){
			last = newNode;
		}
		size++;		
    }
	/**
	 * Gets the node located at the given index in this list. 
	 * @param index The index of the node to get, between 0 and size - 1
	 * @return The node at the given index
	 * @throws IllegalArgumentException
	 *         If index is negative or greater than size - 1
	 */		
	public Node getNode(int index) {
		if (index < 0 || index > size - 1)
			throw new IllegalArgumentException("Illegal argument. Index must be between 0 and (size)");
		Node current = first.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		return current;
	}

   /**
	 * Gets the memory block located at the given index in this list. 
	 * @param index The index of the memory block to get, between 0 and size - 1
	 * @return The memory block  at the given index
	 * @throws IllegalArgumentException
	 *         If index is negative or greater than size - 1
	 */	
	public MemBlock getBlock(int index) {
		if (index < 0 || index > size - 1)
			throw new IllegalArgumentException("Illegal argument. Index must be between 0 and (size)");
		Node current = first.next;
		for(int i = 0; i < index; i++){
			current = current.next;
		}
		MemBlock ret = current.block;
		return ret;
	}	

	/**
	 * Gets the index of the node containing the given memory block.
	 * @param block The given memory block
	 * @return The index of the memory block, or -1 if the memory block is not in this list
	 */
	public int indexOf(MemBlock block) {
		ListIterator current = iterator();
		int index = 0;
		while(current.hasNext()){
			if(current.next().equals(block)){
				return index;
			}
			index++;
		}
		return -1;
	}

	/**
	 * Adds a new node to this list, as follows:
     * Creates a new node containing the given memory block, 
	 * and inserts the node at the given index in this list.
     * For example, if this list is   (m7, m3, m1, m6), then
     * add(2,m5) will make this list  (m7, m3, m5, m1, m6).
	 * If the given index is 0, the new node becomes the first node in this list.
	 * If the given index equals the list's size, the new node becomes the last node in this list.
     * If the new element is added at the beginning or at the end of this list,
     * the addition's runtime is O(1). Othewrise is it O(size).
	 * @param block The memory block to add
	 * @param index Where to insert the memory block
	 * @throws IllegalArgumentException
	 *         If index is negative or greater than the list's size - 1
	 */
	public void add(int index, MemBlock block) {
		if(size == 0){
			return;
		}
        if (index < 0 || ((size > 0) && index > size)) {
            throw new IllegalArgumentException("index must be between 0 and (size)");
        }
		if(index == size){
			addLast(block);
		}
		else if(index == 0){
			addFirst(block);
		}
		else{
			Node newNode = new Node(block);
			Node current = getNode(index - 1);
			newNode = current.next;
			current = newNode;
		}
    }

    /**
	 * Removes the first memory block from this list.
     * Executes efficiently, in O(1).
     * @throws IllegalArgumentException
	 *         If trying to remove from an empty list
     */
    public void removeFirst() {
		if(first.next == null){
			throw new IllegalArgumentException("unable to remove a node from an empty list.");
		}
		Node temp = first.next;
		first.next = temp.next;
		temp = temp.next;
    }

    /** Removes the given memory block from this list.
     * @param block The memory block to remove
     */
    public void remove(MemBlock block) {
		Node current = first.next;
		Node temp = first;
		while(current.next != null){
			if(current.block.equals(block)){
				temp.next = current.next;
			}
			temp = current;
			current = current.next;
		}	
    }

	/**
	 * Returns an iterator over this list, starting with the first element.
	 * @return A ListIterator object
	 */
	public ListIterator iterator() {
		return new ListIterator(first.next);
	}
	/**
	 * A textual representation of this list.
	 * @return A string representing this list
	 */
	public String toString() {
		StringBuilder st = new StringBuilder();
		st.append("[ ");
		Node current = first.next;  // Skips the dummy
		while (current != null) {
			st.append(current.block + " ");
			current = current.next;
		}
		st.append("]");		
		return st.toString();
	}
}
