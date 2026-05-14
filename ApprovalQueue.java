
public class ApprovalQueue {

    Approval[] data;
    int front, rear, size, max;
    int processCount = 0;

    public ApprovalQueue(int n) {
        max = n;
        data = new Approval[max];
        size = 0;
        front = rear = -1;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull() {
        if (size == max) {
            return true;
        } else {
            return false;
        }
    }

    void peek() {
        if (!isEmpty()) {
            System.out.println("Front data: ");
            data[front].print();
        } else {
            System.out.println("Queue is empty!!!");
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return;
        }
        int i = front;
        while (i != rear) {
            data[i].print();;
            i = (i + 1) % max;
        }
        data[i].print();
        System.out.println("Number of element: " + size);
    }

    void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("All data has been successfully removed!");
        } else {
            System.out.println("Queue is already empty!!!");
        }
    }

    void enqueue(Approval dt) {
        if (isFull()) {
            System.out.println("Queue is full!!!");
            return;
        }

        if (isEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % max;
        }

        data[rear] = dt;
        size++;
        System.out.printf("%s is successfully added at index %d\n", dt.name, rear);
    }

    void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!!");
            return;
        }

        int count = Math.min(2, size);

        System.out.println("Processing KRS Approval:");

        for (int i = 0; i < count; i++) {
            Approval dt = data[front];
            dt.print();

            front = (front + 1) % max;
            size--;
        }

        if (size == 0) {
            front = rear = -1;
        }

        processCount += count;

        if (processCount >= 30) {
            System.out.println("DPA limit reached!");
            return;
        }
    }

    void viewRear() {
        if (!isEmpty()) {
            System.out.println("Rear data: ");
            data[rear].print();
        } else {
            System.out.println("Queue is empty!!!");
        }
    }

    void viewFrontTwo() {
        if (size == 0) {
            System.out.println("Queue is empty!!!");
            return;
        }

        int count = Math.min(2, size);
        int i = front;

        for (int j = 0; j < count; j++) {
            data[i].print();
            i = (i + 1) % max;
        }
    }

    void countProcessed() {
        System.out.println("Processed: " + processCount);
    }

    void remaining() {
        System.out.println("Remaining in queue: " + size);
    }
}
