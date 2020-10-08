import java.util.*;

public class Solution{

	public static class LinkedListNode{
		public int value;
		public LinkedListNode next;
		
		public LinkedListNode(int value){
			this.value = value;
		}
		
	}
	
	public static void deleteNode(LinkedListNode nodeToDelete){
		LinkedListNode nextNode = nodeToDelete;
		if(nextNode != null){
			nodeToDelete.next = nextNode.next;
			nodeToDelete.value = nextNode.value;
		} else{
			throw new IllegalArgumentException("WrongNode");
		}
	}
	
	public static LinkedListNode appendNode(final LinkedListNode previousNode, int nodeToAppend){
		LinkedListNode currentNode = previousNode;
		while(currentNode.next != null){
			currentNode = currentNode.next;
		}
		currentNode.next = new LinkedListNode(nodeToAppend);
		return currentNode.next;
	}

	public static void main(String args[]){
		LinkedListNode l1 = new LinkedListNode(1);
		LinkedListNode nodeToDelete = appendNode(l1,2);
		appendNode(l1,3);
		deleteNode(nodeToDelete);
		appendNode(l1,5);
	}

}