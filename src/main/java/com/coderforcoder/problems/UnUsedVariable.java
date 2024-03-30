package com.coderforcoder.problems;

import com.coderforcoder.Order;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class UnUsedVariable {

    static int total(Iterable<Order> orders) {
        int total = 0;
        for (Order order : orders)    // order is unused
            total++;
        return total;
    }

    static void processQueue(Queue<Integer> q) {
       while (q.size() >= 3) {
            int x = q.remove();
            int y = q.remove();
            int z = q.remove();   // z is unused
            new Point(x, y);
        }
    }

    static void tryWithResourcesUnusedVaribale() {
        try (var acquiredContext = ScopedContext.acquire()) {
          //  acquiredContext not used
        }
    }

    static void exceptionUnUsedVariable() {
        String s = "Un Used exception variable";
        try {
            int i = Integer.parseInt(s);
        } catch (NumberFormatException ex) {
            System.out.println("Bad number: " + s);
        }
    }

    static void lambdaUnUsedVariable() {
        List<String> list = new ArrayList<>();
        list.add("dummy");
        list.stream().collect(Collectors.toMap(String::toUpperCase,
                v -> "NODATA")); // v never used
    }

}
