package org.D0812;

public class BillionUsers {

    int billion = 1000000000;

    public boolean growthRateHelper(int mid, float[] growthRates)
    {
        double totalUsers = 0;
        for(int i = 0 ; i < growthRates.length; i++)
        {
            totalUsers +=  Math.pow(growthRates[i], mid);
        }

        return (int)totalUsers >= billion;
    }


    int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int low = 1, high = Integer.MAX_VALUE;
        while(low < high)
        {
            int mid = low + (high-low)/2;
            if(growthRateHelper(mid,growthRates))
            {
                high = mid;
            }else{
                low = mid+1;
            }
        }

        return low;

    }
}
