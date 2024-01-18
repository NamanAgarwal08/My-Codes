import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Collections;
public class classroom{
    public static void main(String args[]) {
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        //to reverse the priority :
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3); // O(logn)
        pq.add(4);
        pq.add(1);
        pq.add(7);
        pq.add(7);
        pq.remove(1);

        while (!pq.isEmpty()) {
            System.out.println(pq.peek());
            pq.remove(); //pq.poll();
        }
        //output:
        // 1
        // 3
        // 4
        // 7
    }
        
}

// PriorityQueue for objects;
// public class classroom {
//     // Note:
//     // to define the priority in the class, we have to implement a special interface called Comparable<>. 
//     public static class Student implements Comparable<Student>{ // student class ne Comparable interface ko implement kr liya for comparing Student
//         String name;
//         int rank;

//         public Student(String name, int rank) {
//             this.name = name;
//             this.rank = rank;
//         }

//         //since we implemented Comparable interface so we have to override the function which is in comparable interface
//         // implementing:
//         @Override
//         public int compareTo(Student s2) {
//             return this.rank - s2.rank; // here we are comparing on the basis of the rank of the student

//             // if return 0 -> means both objects are same on the basis of the rank;
//             // if return -ive -> means object s2 is smaller than current object on the basis of rank;
//             // if return +ive -> means object s2 is larger than the current object on the basis of rank;
//         }
//     }
//     public static void main(String args[]) {
//         PriorityQueue<Student> pq = new PriorityQueue<>();

//         pq.add(new Student("A", 4));
//         pq.add(new Student("B", 5));
//         pq.add(new Student("C", 2));
//         pq.add(new Student("D", 12));

//         while (!pq.isEmpty()) {
//             System.out.println(pq.peek().name + " -> " + pq.peek().rank);
//             pq.remove();
//         }
//     }
// }
