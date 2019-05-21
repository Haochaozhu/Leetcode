import java.util.*;

public class EmployeeImportance {
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }

    int total = 0;
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee emp : employees) {
            map.put(emp.id, emp);
        }
        for (Employee emp : employees) {
            if (emp.id == id) {
                dfs(emp.id, map);
            }
        }
        return total;
    }
    private void dfs(int id, Map<Integer, Employee> map) {
        Employee cur = map.get(id);
        total += cur.importance;
        for (int subId : cur.subordinates) {
            dfs(subId, map);
        }
    }
}
