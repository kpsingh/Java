package com.java.string;

/*
To find all occurrences of the character 'a' or the substring "Java" in the string
 */
public class StringIndexOfExample {
    public static void main(String[] args) {
        String mainString = "Java is a popular programming language. Java is widely used in web development.";
        String searchString = "Java";
        // find the all occurences of string java
        int index = mainString.indexOf(searchString);
        while (index != -1) {
            System.out.print(index + ", ");
            index = mainString.indexOf(searchString, index + 1);
        }

    }
}
