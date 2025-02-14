package com.java.streams.V2;

import java.util.*;
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
        Map<String, Double> avgAgeByGender = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getGender,
                Collectors.averagingInt(Employee::getAge)));
        System.out.println(avgAgeByGender);

        // Get the Names of employees who joined after 2015.
        List<Employee> employeeAfter2015 = Employee.getEmployeeList().stream().filter(e -> e.yearOfJoining > 2015).collect(Collectors.toList());
        System.out.println(employeeAfter2015);

        // Count the number of employees in each department.
        Map<String, Long> employeeDepCount = Employee.getEmployeeList().stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println(employeeDepCount);
        System.out.println("*****");

        // Find out the average salary of each department
        Map<String, Double> averageSalByDepartment = Employee.getEmployeeList().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
        System.out.println(averageSalByDepartment);


        // Find out the oldest employee, his/her age and department?
        Employee olderEmployee = Employee.getEmployeeList().stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
        System.out.println("oldest employee : " + olderEmployee);

        // Find out the average and total salary of the organization.
        DoubleSummaryStatistics sumarry = Employee.getEmployeeList().stream().collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(sumarry);

        // Find out the highest experienced employees in the organization
        Optional<Employee> expericedMax = Employee.getEmployeeList().stream().min(Comparator.comparing(Employee::getYearOfJoining));
        System.out.println(expericedMax.get());

        //


    }
}
