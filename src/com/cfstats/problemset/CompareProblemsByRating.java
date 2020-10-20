package com.cfstats.problemset;

import java.util.Comparator;

public class CompareProblemsByRating implements Comparator<Problem> {
    @Override
    public int compare(Problem pb1, Problem pb2) {
        return Long.compare(pb1.getRating(), pb2.getRating());
    }
}
