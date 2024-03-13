package edu.ucsd.xmlqueryprocessor.engine;

import java.util.*;

public class DisjointSet {
    private Map<String , String> parent = new HashMap<>();

    public String find(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
        }
        if (!parent.get(x).equals(x)) {
            parent.put(x, find(parent.get(x)));
        }
        return parent.get(x);
    }

    public void union(String x, String y) {
        String xRoot = find(x);
        String yRoot = find(y);
        if (! xRoot.equals(yRoot)) {
            parent.put(xRoot, yRoot);
        }
    }
}
