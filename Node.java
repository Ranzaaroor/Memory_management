package MMS;
/*
           Assignment number :10
           File Name : Node.java
           Name: Ran Zaaroor
           Student ID : 209374040
           Email : Ran.zaaroor@gmail.com
       */
/**
 * Represents a node in a list of memory blocks.
 * A node points to a memory block, and to a node. 
 * <br> (Part of Homework 10 in the Intro to CS course, Efi Arazi School of CS)
 */
public class Node {
	// The memory block that this node points at
	MemBlock block;
	// The next node that this node points at
	Node next = null;

	/**
	 * Constructs a new node containing a memory block.
	 * 
	 * @param block The given memory block
	 */
	public Node(MemBlock block) {
		this.block = block;
	}
	
	/**
	 * A textual representation of this node, useful for debugging.
	 */
	public String toString() {
		return "{" + block + "}";
	}
}