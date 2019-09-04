public class Main{
    public static void main(String[] args) {
        System.out.println("Deque: ");

        Deque<Integer> dq = new Deque<>();

        for(int i = 1; i <= 5; i++){
            dq.addFirst(i);
        }
        System.out.println(dq.toString());

        for(int i = 5; i >= 1; i--){
            dq.addLast(i);
        }
        System.out.println(dq.toString());

        System.out.println("First: " + dq.peekFirst() + "\nLast: " + dq.peekLast());

        for(int i = 0; i <= 5; i++){
            if(i%2==0){
                System.out.print(dq.peekFirst() + " ");
                dq.removeFirst();
            }else{
                System.out.print(dq.peekLast() + " ");
                dq.removeLast();
            }
            System.out.println(dq.toString());
        }

        System.out.println(dq.toString());

        System.out.println("\n\nVector Deque: ");

        DequeVec<Integer> dqv = new DequeVec<>(10);

        for(int i = 1; i <= 5; i++){
            dqv.addFirst(i);
        }
        System.out.println(dqv.toString());

        for(int i = 5; i >= 1; i--){
            dqv.addLast(i);
        }
        System.out.println(dqv.toString());

        System.out.println("First: " + dqv.peekFirst() + "\nLast: " + dqv.peekLast());

        for(int i = 0; i <= 5; i++){
            if(i%2==0){
                System.out.print(dqv.peekFirst() + " ");
                dqv.removeFirst();
            }else{
                System.out.print(dqv.peekLast() + " ");
                dqv.removeLast();
            }
            System.out.println(dqv.toString());
        }

        System.out.println(dqv.toString());

    }
}