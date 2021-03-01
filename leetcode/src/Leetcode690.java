import java.util.*;

public class Leetcode690 {
    public static void main(String[] args) {
        Solution690 s = new Solution690();
        s.run();
    }
}

class Solution690 {
    public void run() {

    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> emap = new HashMap<>();
        employees.forEach(e -> emap.put(e.id, e));
        if (!emap.containsKey(id)) {
            return 0;
        }
        int important = 0;
        Stack<Employee> stack = new Stack<>();
        stack.push(emap.get(id));
        while (!stack.empty()) {
            Employee e = stack.pop();
            important += e.importance;
            e.subordinates.forEach(
                    s -> stack.push(emap.get(s))
            );
        }
        return important;
    }

    // Employee info
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    };

}
