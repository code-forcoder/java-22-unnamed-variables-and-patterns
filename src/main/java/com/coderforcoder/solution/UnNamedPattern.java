package com.coderforcoder.solution;

import com.coderforcoder.*;

import static com.coderforcoder.problems.UnUsedPatternVariable.*;

public class UnNamedPattern {

    static void unNamedPattern() {
        record Point(int x, int y) { }
        enum Color { RED, GREEN, BLUE }
        record ColoredPoint(Point p, Color c) { }

        ColoredPoint r =  new ColoredPoint(new Point(3,4), Color.GREEN);

        if (r instanceof ColoredPoint(Point p, _)) {
            p.x();
            p.y();
        }

        if (r instanceof ColoredPoint(_, Color c)) {
            c.name();
        }

        if (r instanceof ColoredPoint(Point(int x, _), _)) {
            System.out.println(x);
        }
    }

   // Revisiting the Box and Ball example, we can further simplify its final case label by using the unnamed pattern instead of var _:

    static void multiplePatternsInCaseLabels(Box<? extends Ball> box) {
        switch (box) {
            case Box(RedBall _), Box(BlueBall _) -> processBox(box);
            case Box(GreenBall _)                -> stopProcessing();
            case Box(_)                      -> pickAnotherBox();
        }
    }
}
