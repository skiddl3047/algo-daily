package basics;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeOperations {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee(1, 500L));
        employeeList.add(new Employee(2, 1500L));
        employeeList.add(new Employee(3, 2500L));
        employeeList.add(new Employee(4, 3500L));
        employeeList.add(new Employee(5, 4500L));
        employeeList.add(new Employee(6, 5500L));
        employeeList.add(new Employee(7, 6500L));
        employeeList.add(new Employee(8, 6500L));

        List<Employee> employeeList1 = employeeList.stream().sorted((e1, e2) -> Math.toIntExact(e2.getSalary() - e1.getSalary()))
                .collect(Collectors.toList());
        System.out.println(employeeList1);

        List<Employee> employeeList2 = employeeList.stream().sorted((e1, e2) -> Math.toIntExact(e2.getSalary() - e1.getSalary()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(employeeList2);

        List<Employee> employeeList3 = employeeList.stream().sorted((e1, e2) -> Math.toIntExact(e2.getSalary() - e1.getSalary()))
                .skip(3)
                .collect(Collectors.toList());
        System.out.println(employeeList3);

        List<Integer> salary = employeeList.stream().map(emp -> Math.toIntExact(emp.getSalary()))
                .collect(Collectors.toList());
        System.out.println(salary.stream().mapToInt(x -> x).summaryStatistics().getCount());
        System.out.println(salary.stream().mapToInt(x -> x).summaryStatistics().getMax());

        System.out.println(employeeList.stream().map(emp -> emp.getSalary().toString()).collect(Collectors.joining(", ")));

        Set<String> set = new HashSet<>();
        System.out.println(employeeList.stream().filter(employee -> !set.add(employee.getSalary().toString())).collect(Collectors.toSet()));

        Map<Long, Long> map = employeeList.stream().map(e -> e.getSalary()).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);
    }
}
