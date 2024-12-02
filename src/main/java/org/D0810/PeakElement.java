package org.D0810;

/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index.
If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞.
In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
 */
//https://leetcode.com/problems/find-peak-element/description/comments/2157160
public class PeakElement {

    public static void main(String[] args) {
        PeakElement peak = new PeakElement();
        System.out.println(peak.findPeakElementNeetcodeImplementation(new int[]{2,4,1,2,1,2}));
        //System.out.println(peak.findPeakElement(new int[]{2,4,1,2,1,2}));
        System.out.println(peak.findPeakElementNeetcodeImplementation(new int[]{2,4,3,2,1}));
        //System.out.println(peak.findPeakElement1(new int[]{2,4,3,2,1}));
        System.out.println(peak.findPeakElementNeetcodeImplementation(new int[]{1,2,3,1}));
        System.out.println(peak.findPeakElementNeetcodeImplementation(new int[]{1,2,1,3,5,6,4}));
        System.out.println(peak.findPeakElementNeetcodeImplementation(new int[]{1,2,3,4,5,6}));
    }

    public int findPeakElementNeetcodeImplementation(int[] nums) {

        int left =0;
        int right = nums.length -1;

        while(left <= right){
            int mid = (left + (right-left))/2;
            //left neighbour greater
            if(mid > 0 && nums[mid] > nums[mid-1])
                right = mid - 1;
            //right neighbour greater
            else if(mid < nums.length -1 &&  nums[mid] > nums[mid-1])
                left = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public int findPeakElementOriginal(int[] nums) {
        int left =0;
        int right = nums.length -1;

        while(left < right){
            int mid = (left + right)/2;

            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
                return mid;
            else{
                left = mid +1;
            }
        }
        return left;
    }

    public int webfindPeakElement(int[] nums) {
        int size = nums.length;
        if(size == 1 || nums[0] > nums[1])
            return 0;
        if(nums[size-1] > nums[size-2])
            return size-1;
        int left =1;
        int right = nums.length -2;

        while(left <= right){
            int mid = (left + right)/2;

            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
                return mid;
            else if(nums[mid] > nums[mid-1]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return left;
    }
}
