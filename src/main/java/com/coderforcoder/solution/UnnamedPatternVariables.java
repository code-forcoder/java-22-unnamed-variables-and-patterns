package com.coderforcoder.solution;

import com.coderforcoder.*;

import static com.coderforcoder.problems.UnUsedPatternVariable.*;

public class UnnamedPatternVariables {
    static void switchCase(Ball ball) {
        switch (ball) {
            case RedBall _   -> process(ball);          // Unnamed pattern variable
            case BlueBall _  -> process(ball);          // Unnamed pattern variable
            case GreenBall _ -> stopProcessing();       // Unnamed pattern variable
        }
    }

    static void nestedTypePatternUnUsed( Box<? extends Ball> box) {
        switch (box) {
            case Box(RedBall _)   -> processBox(box);   // Unnamed pattern variable
            case Box(BlueBall _)  -> processBox(box);   // Unnamed pattern variable
            case Box(GreenBall _) -> stopProcessing();  // Unnamed pattern variable
            case Box(var _)       -> pickAnotherBox();  // Unnamed pattern variable
        }
    }

    static void multiplePatternsInCaseLabels(Box<? extends Ball> box) {
        switch (box) {
            case Box(RedBall _), Box(BlueBall _) -> processBox(box);
            case Box(GreenBall _)                -> stopProcessing();
            case Box(var _)                      -> pickAnotherBox();
        }
    }
}
