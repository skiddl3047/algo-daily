package org.D0814;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
A group of students are sitting in a circle playing musical-chair.
* The teacher sings a song while walking around the circle.
After the song is finished the student at which the teacher stopped is removed from the circle.
Starting at the student-next to the one that was just removed, the teacher- resumes singing and walking around the circle.
After the teacher is done singing, the next student-is removed. - The teacher repeats this until only one student is left.
* A song of length k will result in the teacher walking past k students on each round. The students are Numbered 1 to n. The teacher starts at student 1.
For example, suppose the song length is two (k=2). And there-are four students to start with (1,2,3,4).
The first student to go would be '2, after that 4, and after that 3.
Student 1 would be the next winner in this example.
1, P, 3, 4
@paramn the number of students sitting in a circle.
@param k the length (in students) of each song.
@return the number of the student who won.
 */
public class MusicalChairs {

    public int findWinner(int n, int k) {
        List<Integer> students = new ArrayList<>(IntStream.rangeClosed(1, n).boxed().toList());
        int index = 0; // Start from the first student
        // Repeat until only one student remains
        while (students.size() > 1) {
            // Determine the index of the next student to remove
            index = (index + k - 1) % students.size();
            // Remove the student at that index
            students.remove(index);
            System.out.println(" After removal "+students);
        }
        // The last remaining student is the winner
        return students.getFirst();
    }

    public static void main(String[] args) {
        MusicalChairs mc = new MusicalChairs();

        // Test the function with n=4 and k=2
        int winner = mc.findWinner(4, 2);
        System.out.println("The winner is student: " + winner); // Output should be 1
        winner = mc.findWinner(5, 2); //[1,2,3,4,5] [1,3,4,5]
        System.out.println("The winner is student: " + winner);
    }
}
