import java.util.Scanner;

public class PriorityQueue {

    static class priorityQ {
        private int[] queue;
        private int size;
        private int maxSize;

        public priorityQ(int maxSize) { 
            this.maxSize = maxSize;
            this.queue = new int[maxSize];
            this.size = 0;
        }

        public void insert(int value) {
            if (isFull()) { System.out.println("Queue is full"); return; }
            int i;
            for (i = size - 1; i >= 0 && queue[i] > value; i--) {
                queue[i + 1] = queue[i];
            }
            queue[i + 1] = value;
            size++;
        }

        public void remove() {
            if (isEmpty()) { System.out.println("Queue empty"); return; }
            for (int i = 0; i < size - 1; i++) queue[i] = queue[i + 1];
            size--;
        }

        public boolean isEmpty() { return size == 0; }
        public boolean isFull() { return size == maxSize; }
        public void printQueue() {
            System.out.print("Queue: ");
            for (int i = 0; i < size; i++) System.out.print(queue[i] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the priority queue: ");
        int size = scanner.nextInt();
        scanner.nextLine(); 
        priorityQ pq = new priorityQ(size);

        System.out.println("Enter integers or REMOVE to remove:");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                pq.insert(scanner.nextInt());
            } else {
                String cmd = scanner.next();
                if (cmd.equalsIgnoreCase("REMOVE")) pq.remove();
                else break;
            }
        }

        pq.printQueue();
        scanner.close();
    }
}

