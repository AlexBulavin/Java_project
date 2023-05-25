package Lesson4;

import java.lang.System.Logger;
import java.util.LinkedList;

public class CustomQueue<T> {
        private LinkedList<T> items;
    
        public CustomQueue(java.util.logging.Logger LOGGER, boolean debugMode, LinkedList<T> elements ) {
            this.items = new LinkedList<>();
            this.items = elements;
            if (debugMode)
            LOGGER.info("this.items = " + this.items);
        }
    
        public void enqueue(T item) {
            this.items.addLast(item);
        }
    
        public LinkedList<T> dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            this.items.removeFirst();
             
            return this.items;
        }
    
        public T first() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return this.items.getFirst();
        }
    
        public boolean isEmpty() {
            return this.items.isEmpty();
        }
    }

