package com.java.streams.V2;

import org.w3c.dom.ls.LSOutput;

import java.awt.desktop.SystemEventListener;
import java.util.*;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPIPractice {
    public static void main(String[] args) {

        List<Employee> employeeList = Employee.getEmployeeList();
        /// Find out the highest experienced employees in the organization
        employeeList.stream().min(Comparator.comparing(Employee::getYearOfJoining)).ifPresent(System.out::println);


    }


    private static boolean isPrime(int a) {
        if (a <= 1) return false; // number less than 2 are not prime as they do not have the two dividers
        for (int i = 2; i < Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
