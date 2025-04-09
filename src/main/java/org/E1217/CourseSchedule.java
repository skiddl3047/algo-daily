package org.E1217;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.


Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */
public class CourseSchedule {

    /*
    Time Complexity
Building the Graph: 𝑂(𝐸) where 𝐸 is the number of prerequisites.
DFS Traversal: 𝑂(𝑉+𝐸), where 𝑉 is the number of courses.
Total: 𝑂( 𝑉 + 𝐸 )

Space Complexity :
Graph Storage:  𝑂( 𝑉 + 𝐸 ) for the adjacency list.
State Array: 𝑂( 𝑉 )
Recursion Stack: 𝑂( 𝑉 ) in the worst case.
Total: 𝑂(𝑉 + 𝐸)
*/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer> > graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int [] prerequisite:prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }
        int[] start=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(start[i]==0 && hasCycle(graph,start,i)){
                return false;
            }
        }
        return true;
    }
    private boolean hasCycle(List<List<Integer>> graph, int [] start, int course){
         if(start[course]==1)
            return true;
        if(start[course]==2)
            return false;

        start[course]=1;
        for(int neighbour:graph.get(course)){
            if(hasCycle(graph,start,neighbour)){
                return true;
            }
        }
        start[course]=2;
        return false;
    }

    public boolean canFinishLeetcodeOptimal(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> nextCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            nextCourses.add(new ArrayList<>());
        for (int[] prerequisite: prerequisites){
            inDegrees[prerequisite[0]]++;
            nextCourses.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses;i++)
            if (inDegrees[i] == 0)
                queue.add(i);
        int count = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            count++;
            for (int nextCourse : nextCourses.get(course)){
 
                
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinishLeetcodeOptimal(2,new int[][] { {1,0} }));
        //https://leetcode.com/problems/course-schedule/description/comments/1968461
        System.out.println(new CourseSchedule().canFinish(5,new int[][] { {1,2},{2,3},{3,4} }));
        System.out.println(new CourseSchedule().canFinish(4,new int[][] { {0,1},{1,2},{2,0},{3,2} }));
        System.out.println(new CourseSchedule().canFinish(6,new int[][] { {1,0},{2,0},{3,1},{4,2},{5,3},{5,4} }));

        System.out.println(new CourseSchedule().canFinishTopologicalSorting(5,new int[][] { {1,2},{2,3},{3,4} }));
        System.out.println(new CourseSchedule().canFinishTopologicalSorting(4,new int[][] { {0,1},{1,2},{2,0},{3,2} }));
        System.out.println(new CourseSchedule().canFinishTopologicalSorting(6,new int[][] { {1,0},{2,0},{3,1},{4,2},{5,3},{5,4} }));

        System.out.println(new CourseSchedule().canFinish(6,new int[][] { {1,0},{1,2},{2,3},{2,4},{2,5},{3,1},{4,5} }));
        System.out.println(new CourseSchedule().canFinishTopologicalSorting(6,new int[][] { {1,0},{1,2},{2,3},{2,4},{2,5},{3,1},{4,5} }));

        System.out.println(new CourseSchedule().canFinish(4,new int[][] { {1,0},{2,3} }));
        System.out.println(new CourseSchedule().canFinish(4,new int[][] { {1,2},{2,3} }));
        System.out.println(new CourseSchedule().canFinish(2,new int[][] { {1,0} }));
    }

    public boolean canFinishTopologicalSorting(int numCourses, int[][] prerequisites) {
        int inDegree[] = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            graph.get(prerequisite[1]).add(prerequisite[0]);
            inDegree[prerequisite[0]] += 1;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses; i++){
            if (inDegree[i] == 0)
                queue.offer(i);
        }
        int visited =0;

        while(!queue.isEmpty()){
            int course = queue.poll();
            visited++;
            for(int neighbour : graph.get(course)){
                inDegree[neighbour] -= 1;
                if(inDegree[neighbour] == 0)
                    queue.offer(neighbour);
            }
        }
        return visited == numCourses;
    }

}
