package hash_table.employee_importance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return count(map, id);
    }

    private int count(Map<Integer, Employee> map, int id) {
        Employee one = map.get(id);
        if (one == null) {
            return 0;
        }
        int res = one.importance;
        if (one.subordinates == null || one.subordinates.size() == 0) {
            return res;
        }
        for (Integer sub : one.subordinates) {
            res += count(map, sub);
        }
        return res;
    }
}