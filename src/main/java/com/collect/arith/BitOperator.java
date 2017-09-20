package com.collect.arith;

import java.util.HashMap;
import java.util.Map;

public class BitOperator {

    private static final Integer MAXIMUM_CAPACITY = 1000000;

    static int remainder = 0;

    private static int division(int dividend, int divisor)
    {
        int quotient = 1;

        int neg = 1;
        if ((dividend>0 &&divisor<0)||(dividend<0 && divisor>0))
            neg = -1;

        // Convert to positive
        int tempdividend = (dividend < 0) ? -dividend : dividend;
        int tempdivisor = (divisor < 0) ? -divisor : divisor;

        if (tempdivisor == tempdividend) {
            remainder = 0;
            return 1*neg;
        }
        else if (tempdividend < tempdivisor) {
            if (dividend < 0)
                remainder = tempdividend*neg;
            else
                remainder = tempdividend;
            return 0;
        }
        while (tempdivisor<<1 <= tempdividend)
        {
            tempdivisor = tempdivisor << 1;
            quotient = quotient << 1;
        }

        // Call division recursively
        if(dividend < 0)
            quotient = quotient*neg + division(-(tempdividend-tempdivisor), divisor);
        else
            quotient = quotient*neg + division(tempdividend-tempdivisor, divisor);
        return quotient;
    }



    public static void main(String[] args) {

        int dividend = 25, divisor = 3;
        char ch = 's';
        while (ch != 'x') {
            System.out.printf("Enter the Dividend:%d\n ", dividend);
            System.out.printf("\nEnter the Divisor: %d", divisor);

            System.out.printf("\n%d / %d: quotient = %d\n", dividend, divisor, division(dividend, divisor));
            System.out.printf("%d / %d: remainder = %d\n", dividend, divisor, remainder);
        }
    }
}
