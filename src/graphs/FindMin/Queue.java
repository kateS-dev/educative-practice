package graphs.FindMin;

import java.util.*;

class Queue<T> {
    private T[] queueArray;
    private int front;
    private int rear;
    private int capacity;

    @SuppressWarnings("unchecked")

    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = 0;
        this.rear = -1;
        this.queueArray = (T[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return rear < front;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public T front() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queueArray[front];
    }

    public T rear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return queueArray[rear];
    }

    public int size() {
        return rear - front + 1;
    }

    public void enqueue(T value) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        queueArray[++rear] = value;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        T frontValue = queueArray[front++];
        if (isEmpty()) {
            // Reset front and rear when the queue becomes empty
            front = 0;
            rear = -1;
        }
        return frontValue;
    }
}