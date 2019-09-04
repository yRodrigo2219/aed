public class Main{
    public static void main(String[] args) {
        System.out.println("Queue: ");

        Queue<Integer> q = new Queue<Integer>();
        
        for(int i = 1; i <= 5; i++){
            q.add(i);
        }
        System.out.println(q.toString());

        for(int i = 0; i < 5; i++){
            System.out.print(q.peek() + " ");
            q.poll();
            System.out.println(q.toString());
        }

        System.out.println("\n\nVector Queue: ");

        QueueVec<Integer> qv = new QueueVec<>(5);

        for(int i = 1; i <= 6; i++){
            qv.add(i);
        }

        System.out.println(qv);

        for(int i = 0; i < 5; i++){
            System.out.print(qv.peek() + " ");
            qv.poll();
            System.out.println(qv.toString());
        }
    }
}