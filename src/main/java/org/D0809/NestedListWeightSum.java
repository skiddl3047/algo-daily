package org.D0809;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NestedListWeightSum {

    static int result =0;
    public static void main(String[] args) {
        NestedInteger ns1 = new NestedInteger(1);
        NestedInteger ns2= new NestedInteger(2);
        NestedInteger ns3= new NestedInteger(3);
        NestedInteger ns4= new NestedInteger(4);
        System.out.println(depthSum(Arrays.asList(ns1,ns2,ns3,ns4)));

        result =0;
        ns1 = new NestedInteger();
        ns1.add(new NestedInteger(1)); //[ 1, 1 ]
        ns1.add(new NestedInteger(1));
        //ns2.add(ns2); //[ 2,2]
        System.out.println(depthSum(Arrays.asList(ns1,ns2,ns1)));

    }

    public static int depthSum(List<NestedInteger> nestedList) {
        dfs(nestedList,1);
        return result;
    }

    public static void dfs(List<NestedInteger> nestedList, int depth){
        for (NestedInteger ns: nestedList){
            if(ns.isInteger()){
                result += ns.getInteger() * depth;
            }else {
                dfs(ns.getList(),depth+1);
            }
        }
    }
}

