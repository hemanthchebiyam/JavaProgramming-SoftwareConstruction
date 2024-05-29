/*
 * This code is written by Hemanth Chebiyam
 * Email: hc3746@rit.edu
 */

package Homework;

import java.util.NoSuchElementException;

public class MyLinkedList<E> extends MyAbstractList<E> {
	  private Node<E> head, tail;

	  /** Create a default list */
	  public MyLinkedList() {
	  }

	  /** Create a list from an array of objects */
	  public MyLinkedList(E[] objects) {
	    super(objects);
	  }

	  /** Return the head element in the list */
	  public E getFirst() {
		// COMPLETE THIS METHOD
		if (size == 0) {
        	return null;
        }
        return head.element;
	  }

	  /** Return the last element in the list */
	  public E getLast() {
		// COMPLETE THIS METHOD
		if (size == 0) {
            return null;
        }
        return tail.element;
	  }

	  /** Add an element to the beginning of the list */
	  public void addFirst(E e) {
		// COMPLETE THIS METHOD
		Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null) {
            tail = head;
        }
	  }

	  /** Add an element to the end of the list */
	  public void addLast(E e) {
		// COMPLETE THIS METHOD
		Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
	  }


	  @Override /** Add a new element at the specified index 
	   * in this list. The index of the head element is 0 */
	  public void add(int index, E e) {
		// COMPLETE THIS METHOD
		checkIndex(index);

        if (index == 0) {
            addFirst(e);
        } else if (index >= size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
	  }

	  /** Remove the head node and
	   *  return the object that is contained in the removed node. */
	  public E removeFirst() {
		// COMPLETE THIS METHOD
		if (size == 0) {
            return null;
        }

        E temp = head.element;
        head = head.next;
        size--;

        if (head == null) {
            tail = null;
        }

        return temp;
	  }

	  /** Remove the last node and
	   * return the object that is contained in the removed node. */
	  public E removeLast() {
		// COMPLETE THIS METHOD
		if (size == 0) {
            return null;
        } else if (size == 1) {
            E temp = head.element;
            head = tail = null;
            size = 0;
            return temp;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            E temp = tail.element;
            tail = current;
            tail.next = null;
            size--;
            return temp;
        }
	  }

	  @Override /** Remove the element at the specified position in this 
	   *  list. Return the element that was removed from the list. */
	  public E remove(int index) {
		// COMPLETE THIS METHOD
		checkIndex(index);

        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;

            return current.element;
        }
	  }

	  @Override /** Override toString() to return elements in the list */
	  public String toString() {
	    StringBuilder result = new StringBuilder("[");

	    Node<E> current = head;
	    for (int i = 0; i < size; i++) {
	      result.append(current.element);
	      current = current.next;
	      if (current != null) {
	        result.append(", "); // Separate two elements with a comma
	      }
	      else {
	        result.append("]"); // Insert the closing ] in the string
	      }
	    }

	    return result.toString();
	  }

	  @Override /** Clear the list */
	  public void clear() {
	    size = 0;
	    head = tail = null;
	  }

	  @Override /** Return true if this list contains the element e */
	  public boolean contains(E e) {
		// COMPLETE THIS METHOD
		Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) {
                return true;
            }
            current = current.next;
        }
        return false;
	  }

	  @Override /** Return the element at the specified index */
	  public E get(int index) {
		// COMPLETE THIS METHOD
		checkIndex(index);

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.element;
	  }

	  @Override /** Return the index of the head matching element in 
	   *  this list. Return -1 if no match. */
	  public int indexOf(E e) {
		// COMPLETE THIS METHOD
		Node<E> current = head;
    	for (int i = 0; i < size; i++) {
        	if (e.equals(current.element)) {
            	return i;
        	}
        	current = current.next;
    	}
    	return -1; // Element not found in the list
	  }

	  @Override /** Return the index of the last matching element in 
	   *  this list. Return -1 if no match. */
	  public int lastIndexOf(E e) {
		// COMPLETE THIS METHOD
		int lastIndex = -1;
        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            if (e.equals(current.element)) {
                lastIndex = i;
            }
            current = current.next;
        }
        return lastIndex;
	  }

	  @Override /** Replace the element at the specified position 
	   *  in this list with the specified element. */
	  public E set(int index, E e) {
		// COMPLETE THIS METHOD
		checkIndex(index);

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        E temp = current.element;
        current.element = e;
        return temp;
	  }

	  @Override /** Override iterator() defined in Iterable */
	  public java.util.Iterator<E> iterator() {
	    return new LinkedListIterator();
	  }

	  private void checkIndex(int index) {
	    if (index < 0 || index > size)
	      throw new IndexOutOfBoundsException
	        ("Index: " + index + ", Size: " + size);
	  }
	  
	  private class LinkedListIterator 
	      implements java.util.Iterator<E> {
	    private Node<E> current = head; // Current index 
		private Node<E> previous = null; // Previous node
	    
	    @Override
	    public boolean hasNext() {
	      return (current != null);
	    }

	    @Override
	    public E next() {
			
			if (!hasNext()) {
            	throw new NoSuchElementException();
        	}
			
			E e = current.element;
			previous = current;
			current = current.next;
	      	return e;
	    }

	    @Override
	    public void remove() {
			// COMPLETE THIS METHOD
			if (previous == null) {
				throw new IllegalStateException("remove() can only be called after next()");
			}
	
			if (previous == head) {
				// Removing the first element
				head = head.next;
			} else {
				// Removing non-first element
				previous.next = current;
			}
	
			if (previous == tail) {
				// If the last element is removed, update tail
				tail = previous;
			}
	
			previous = null; // Reset previous after removal
			size--;
			
	    }
	  }
	  
	  private static class Node<E> {
	    E element;
	    Node<E> next;

	    public Node(E element) {
	      this.element = element;
	    }
	  }
	}
