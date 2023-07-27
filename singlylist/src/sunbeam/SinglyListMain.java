
package sunbeam;
import java.util.Scanner;

class SinglyList {
	static class Node {
		private int data;
		private Node next;
		public Node() {
			data = 0;
			next = null;
		}
		public Node(int val) {
			data = val;
			next = null;
		}
	}

	private Node head;
	private Node tail;
	
	public SinglyList() {
		head = null;
		tail = null;
	}
	void display() {
		System.out.println("List : ");
		Node trav = head;
		while(trav != null) {
			System.out.println(trav.data);
			trav = trav.next;
		}
		System.out.println("");
	}
	void addFirst(int val) {
		Node newNode = new Node(val);
		if(head == null)
			tail = newNode;
		newNode.next = head;
		head = newNode;
	}
	void addLast(int val) {
		Node newNode = new Node(val);

		if(head == null) {
			head = newNode;
			tail = newNode;
		}
		else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	public void addAtPos(int val, int pos) {
		if(head == null || pos <= 1)
			addFirst(val);
		else {
			Node newNode = new Node(val);
			Node trav = head;
			for(int i=1; i < pos-1; i++) {
				if(trav.next == null)
					break;
				trav = trav.next;
			}
			newNode.next = trav.next;
			trav.next = newNode;
		}
	}
	public void delFirst() {
		if(head == null)
			throw new RuntimeException("List is empty.");
		head = head.next;
	}
	public void delAll() {
		head = null;
	}
	public void delAtPos(int pos) {
		if(pos == 1)
			delFirst();
		if(head == null || pos < 1)
			throw new RuntimeException("List is empty or Invalid position.");
		Node temp = null, trav = head;
		for(int i = 1; i < pos; i++) {
			if(trav == null)
				throw new RuntimeException("Invalid position.");
			temp = trav;
			trav = trav.next;
		}
		temp.next = trav.next;
	}
	
	public void delLast() {
		if(head == null)
			throw new RuntimeException("List is empty.");
		if(head.next == null)
			head = null;
		else {
			Node temp=null, trav=head;
			while(trav.next != null) {
				temp = trav;
				trav = trav.next;
			}
			temp.next = null;
		}
	}
}

public class SinglyListMain {
	public static void main(String[] args) {
		int choice, val, pos;
		SinglyList list = new SinglyList();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("\n0. Exit\n1. Display\n2. Add First\n3.  Add Last\n4. Add At Pos\n5. Del First\n6.  Del Last\n7. Del At Pos\n8. Del All\nEnter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1: // Display
				list.display();
				break;
			case 2: // Add First
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addFirst(val);
				break;
			case 3: // Add Last
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				list.addLast(val);
				break;
			case 4: // Add At Pos
				System.out.print("Enter new element: ");
				val = sc.nextInt();
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				list.addAtPos(val, pos);				
				break;
			case 5: // Del First
				try {
					list.delFirst();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 6: // Del Last
				try {
					list.delLast();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 7: // Del At Pos
				System.out.print("Enter element position: ");
				pos = sc.nextInt();
				try {
					list.delAtPos(pos);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 8: // Del All
				list.delAll();
				break;
			}
		} while(choice!=0);
		sc.close();
	}
}

