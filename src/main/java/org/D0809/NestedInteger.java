package org.D0809;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
        // If it holds a single integer, value will be non-null and list will be null
        private Integer value;
        // If it holds a nested list, value will be null and list will be non-null
        private List<NestedInteger> list;

        // Constructor initializes an empty nested list.
    public NestedInteger() {
        this.list = new ArrayList<>();
        this.value = null;
    }

        // Constructor initializes a single integer.
    public NestedInteger(int value) {
        this.value = value;
        this.list = null;
    }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
        return value != null;
    }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
        return value;
    }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
        this.value = value;
        this.list = null;
    }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.add(ni);
        this.value = null;
    }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
        if (this.list == null) {
            return new ArrayList<>();
        }
        return this.list;
    }

        @Override
        public String toString() {
        if (isInteger()) {
            return String.valueOf(value);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).toString());
                if (i != list.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }

        public void printNestedIntegers(List<NestedInteger> nestedIntegers) {
        System.out.println("Nested Integer List: " + nestedIntegers.toString());
    }
}
