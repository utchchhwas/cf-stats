package com.cfstats.problemset;

import java.util.Comparator;

public class CompareProblemsBySolvedCount implements Comparator<Problem> {
    @Override
    public int compare(Problem pb1, Problem pb2) {
        return Integer.compare(pb1.getSolvedCount(), pb2.getSolvedCount());
    }
}


