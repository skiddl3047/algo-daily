package org.D0809;

import java.util.Arrays;
import java.util.List;

public class NestedListWithWeightSumMaxDepth {

    int maxDepth = 0;
    int wightedSum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        getMaxDepth(nestedList, 0);
        helper(nestedList, maxDepth);
        return (int) wightedSum;
    }

    public void printNestedIntegers(List<NestedInteger> nestedIntegers) {
        System.out.println("Nested Integer List: " + nestedIntegers.toString());
    }

    void getMaxDepth(List<NestedInteger> nestedList, int depth) {
        printNestedIntegers(nestedList);
        depth++;
        boolean isEmpty = true;
        for (NestedInteger nl : nestedList) {
            System.out.println("IS Empty : "+isEmpty+" int or list check : "+nl.isInteger());
            isEmpty = false;
            if (!nl.isInteger()) {
                getMaxDepth(nl.getList(), depth);
            }
        }
        if (!isEmpty) {
            //System.out.print("Inside empty check");
            //printNestedIntegers(nestedList);
            maxDepth = Math.max(maxDepth, depth);
        }

    }

    void helper(List<NestedInteger> nestedList, int weight) {
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                wightedSum += weight * ni.getInteger();
            } else {
                helper(ni.getList(), weight - 1);
            }
        }
    }

    public static void main(String[] args) {
        NestedInteger ns1 = new NestedInteger();
        NestedInteger ns2= new NestedInteger(2);
        ns1.add(new NestedInteger(1)); //[ 1, 1 ]
        ns1.add(new NestedInteger(1));
        //ns2.add(ns2); //[ 2,2]
        System.out.println(new NestedListWithWeightSumMaxDepth().depthSumInverse(Arrays.asList(ns1,ns2,ns1)));
    }
}
