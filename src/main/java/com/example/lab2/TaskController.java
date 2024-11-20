package com.example.lab2;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    // Task 1: Date and Time
    @GetMapping("/datetime")
    public String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "Current date and time: " + now.format(formatter);
    }

    // Task 2: Loop Example
    @GetMapping("/sum")
    public String calculateSum(@RequestParam int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return "The sum of numbers from 1 to " + n + " is: " + sum;
    }

    // Task 3: Reverse String
    @GetMapping("/reverse")
    public String reverseString(@RequestParam String input) {
        StringBuilder reversed = new StringBuilder(input).reverse();
        return "Original: " + input + ", Reversed: " + reversed;
    }

    // Task 4: Data Types Example
    @PostMapping("/datatype")
    public String checkDataType(@RequestBody Object value) {
        if (value instanceof Integer) {
            return "Data type is Integer.";
        } else if (value instanceof String) {
            return "Data type is String.";
        } else if (value instanceof Double) {
            return "Data type is Double.";
        } else {
            return "Unknown data type.";
        }
    }

    // Task 5: Algorithm Example (Fibonacci)
    @GetMapping("/fibonacci")
    public List<Integer> generateFibonacci(@RequestParam int count) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < count; i++) {
            fibonacci.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return fibonacci;
    }
}
/*
1) http://localhost:8080/api/tasks/datetime
2) http://localhost:8080/api/tasks/sum?n=10
3) http://localhost:8080/api/tasks/reverse?input=example
4) http://localhost:8080/api/tasks/datatype
5) http://localhost:8080/api/tasks/fibonacci?count=5
 */