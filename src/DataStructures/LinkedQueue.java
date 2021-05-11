package DataStructures;


import Exceptions.EmptyCollectionException;
import ADTs.QueueADT;

/**
 * Linked list implementation of Queues. 
 * 
 * @author ITSC 2214
 *
 * @version 1.0
 * @param <T> 
 */
public class LinkedQueue<T> implements QueueADT<T> {
    /* front: the beginning of the queue */
    private SinglyLinkedNode<T> front;
    
    /* rear: the end of the queue */
    private SinglyLinkedNode<T> rear;
    
    /* size: the number of elements in the queue */
    private int size;
    
    /**
     * Constructor
     */
    public LinkedQueue() {
        //TODO Instantiate the linked list-based data 
        //collection
        front = null;
        rear = null;
        size = 0;
    }
    
    /**
     * Insert an element in the end of the queue
     * @param target input element
     */
    @Override
    public void enqueue(T target) {
        /** TODO if queue is empty, insert new node
         * and change the rear and front references
         * 
         * if queue is not empty, insert new node in 
         * the rear of the queue
        **/
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();
        temp.setElement(target);
        if (isEmpty()) {
            front = temp;
            rear = temp;
        }
        else {
            rear.setNext(temp);
            rear = temp;
        }
        size++;
    }
    
    /**
     * Remove from the beginning of the queue
     * @return the removed element
     * @throws EmptyCollectionException 
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        /** TODO if queue is empty, throw an exception.
        * Then remove the data item from the queue
        * Do not forget to change the size
        **/
        if (isEmpty()) {
            throw new EmptyCollectionException();
        }
        SinglyLinkedNode<T> temp = new SinglyLinkedNode<T>();
        temp = front;
        front = front.getNext();
        if (isEmpty()) {
            rear = null;
        }
        size--;
        return (temp.getElement());

    }
    
    /**
     * Examine whether the queue is empty
     * @return true: if the queue is empty
     *         false: if the queue is not empty
     */
    @Override
    public boolean isEmpty() {
        //TODO Evaluate whether the queue is empty
        if (this.size == 0) {
            return true;
        } 
        else {
            return false;
        }
    }
    
    /**
     * Retrieve the front
     * @return the element in the beginning of the queue
     * @throws EmptyCollectionException 
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException(
                    "Remove item from empty queue");
        }

        /**TODO return element in the front most position of the array **/
        return (front.getElement());
        
    }
    
    /**
     * Retrieve the size
     * @return number of elements in the queue
     */
    @Override
    public int size() {
        //TODO return the size of the Queue
        return (this.size);

    }
}

