package com.java.streams.V2;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFAQ_V2 {

    public static void main(String[] args) {
        // Find out the count of male and female employees present in the organization
        Map<String, Long> maleAndFemaleEmployee = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println(maleAndFemaleEmployee);

        // print the names of all departments in the organization.
        Set<String> allDepartments = Employee.getEmployeeList().stream().map(Employee::getDepartment).collect(Collectors.toSet());
        System.out.println(allDepartments);

        // average age of all the employee
        double avgAge = Employee.getEmployeeList().stream().mapToInt(Employee::getAge).average().orElse(0);
        System.out.println(avgAge);

        // Find the average age of Male and Female Employees.
        Map<String, Double> avgAgeByGender = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeByGender);

    }
}
