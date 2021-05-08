package com.binary_studio.dependency_detector;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class DependencyDetector {

    private DependencyDetector() {
    }

    public static boolean canBuild(DependencyList libraries) {

        int numberOfLibs = libraries.libraries.size();
        ArrayList<LinkedList<Integer>> dependencyStatistics = new ArrayList<>(numberOfLibs);

        for (int i = 0; i < numberOfLibs; i++)
            dependencyStatistics.add(new LinkedList<>());

        for (String[] dependency : libraries.dependencies) {
            int beginning = libraries.libraries.indexOf(dependency[0]);
            int goal = libraries.libraries.indexOf(dependency[1]);
            dependencyStatistics.get(beginning).add(goal);
        }

        for (int i = 0; i < numberOfLibs; i++)
            if (finedCycles(i, numberOfLibs, dependencyStatistics))
                return false;

        return true;
    }

    private static boolean finedCycles(int iteratorOfLibs,
                                     int numberOfLibs,
                                     ArrayList<LinkedList<Integer>> dependencyEdges) {

        boolean[] checkedLibraries = new boolean[numberOfLibs];
        boolean[] librariesCycle = new boolean[numberOfLibs];

        if (librariesCycle[iteratorOfLibs])
            return true;

        if (checkedLibraries[iteratorOfLibs])
            return false;

        checkedLibraries[iteratorOfLibs] = true;
        librariesCycle[iteratorOfLibs] = true;

        List<Integer> children = dependencyEdges.get(iteratorOfLibs);

        for (Integer c : children)
            if (finedCycles(c, numberOfLibs, dependencyEdges))
                return true;

        librariesCycle[iteratorOfLibs] = false;

        return false;
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        List<String[]> b = new ArrayList<>();

        a.add("foo.bar");
        a.add("foo.quax");
        a.add("foo.hit");
        a.add("foo.boo");
        b.add(new String[]{"foo.bar", "foo.hit"});
        b.add(new String[]{"foo.bar", "foo.quax"});
        b.add(new String[]{"foo.hit", "foo.quax"});
        b.add(new String[]{"foo.hit", "foo.boo"});
        b.add(new String[]{"foo.quax", "foo.boo"});
        b.add(new String[]{"foo.bar", "foo.boo"});

        DependencyList list = new DependencyList(a, b);

        System.out.println(canBuild(list));
    }
}