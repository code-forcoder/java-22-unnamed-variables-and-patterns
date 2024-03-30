package com.coderforcoder.solution;

import com.coderforcoder.Order;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class UnnamedVariables {

    // An enhanced for loop with side effects:

    static int count(Iterable<Order> orders) {
        int total = 0;
        for (Order _ : orders)    // Unnamed variable
            total++;
        return total;
    }

   // The initialization of a simple for loop can also declare unnamed local variables:

    static void anotherExample() {
        for (int i = 0, _ = sideEffect(); i < 10; i++) {

        }
    }

    private static int sideEffect() {
        return 10;
    }

    static void processQueue(Queue<Integer> q) {
        while (q.size() >= 3) {
            int x = q.remove();
            int y = q.remove();
            int _ = q.remove();  // Unnamed variable
            new Point(x, y);
        }
    }

    static void processQueue2(Queue<Integer> q) {
        while (q.size() >= 3) {
            int x = q.remove();
            int _ = q.remove();  // Unnamed variable
            int _ = q.remove();  // Unnamed variable
            new Point(x, 0);
        }
    }

    static void tryWithResourcesUnNamedVariable() {
        try (var _ = ScopedContext.acquire()) { // Unnamed variable

        }
    }

    static void exceptionUnNamedVariable() {
        String s = "Un Used exception variable";
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException _) {
            System.out.println("Bad number: " + s);
        }
    }

    static void lambdaUnUsedVariable() {
        List<String> list = new ArrayList<>();
        list.add("dummy");
        list.stream().collect(Collectors.toMap(String::toUpperCase,
                _ -> "NODATA")); // Unnamed variable
    }

}
