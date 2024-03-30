package com.coderforcoder.problems;

import com.coderforcoder.*;

public class UnUsedPatternVariable {

    static void switchCase(Ball ball) {
        switch (ball) {
            case RedBall red   -> process(ball); // red never used
            case BlueBall blue  -> process(ball); // blue never used
            case GreenBall green -> stopProcessing(); // green never used
        }
    }


    public static void stopProcessing() {
    }

    public static void process(Ball ball) {
    }


    static void nestedTypePatternUnUsed( Box<? extends Ball> box) {
        switch (box) {
            case Box(RedBall   red)     -> processBox(box); // red never used
            case Box(BlueBall  blue)    -> processBox(box); // blue never used
            case Box(GreenBall green)   -> stopProcessing(); // green never used
            case Box(var itsNull) -> pickAnotherBox(); // itsNull never used
        }
    }

    public static void processBox(Box<? extends Ball> box) {
    }

    public static void pickAnotherBox() {
    }


    ////////////////// Unused nested patterns /////////////////

    static void unUsedNestedPatterns() {
        record Point(int x, int y) { }
        enum Color { RED, GREEN, BLUE }
        record ColoredPoint(Point p, Color c) { }

        ColoredPoint r =  new ColoredPoint(new Point(3,4), Color.GREEN);

        if (r instanceof ColoredPoint(Point p, Color c)) {
                p.x();
                p.y();
        }

        if (r instanceof ColoredPoint(Point(int x, int y), Color c)) {
            System.out.println(x);
            System.out.println(y);
        }
    }

}
