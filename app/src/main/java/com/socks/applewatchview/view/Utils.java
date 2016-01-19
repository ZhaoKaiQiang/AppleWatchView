package com.socks.applewatchview.view;

/**
 * Created by zhaokaiqiang on 16/1/18.
 */
public class Utils {

    public static int[] generateNums(int num) {

        if (num < 10) {
            return generate10(num);
        } else if (num < 30) {
            return generate10To30(num);
        } else {
            return generate30To60(num);
        }
    }

    private static int[] generate10(int num) {

        int[] nums = null;
        switch (num) {
            case 4:
                nums = new int[] { 1, 2, 1 };
                break;
            case 5:
                nums = new int[] { 1, 3, 1 };
                break;
            case 6:
                nums = new int[] { 1, 4, 1 };
                break;
            case 7:
                nums = new int[] { 2, 3, 2 };
                break;
            case 8:
                nums = new int[] { 2, 4, 2 };
                break;
            case 9:
                nums = new int[] { 1, 2, 3, 2, 1 };
                break;
        }

        return nums;
    }

    private static int[] generate10To30(int num) {
        int sum = 9;
        int[] result = new int[] { 1, 2, 3, 2, 1 };
        int addNum = (num - sum) / 5;
        sum = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] += addNum;
            sum += result[i];
        }

        int remainder = num - sum;

        if (remainder < 3) {
            result[2] += remainder;
        } else if (remainder == 3) {
            result[0]++;
            result[1]++;
            result[2]++;
        } else if (remainder == 4) {
            result[1]++;
            result[2] += 2;
            result[3]++;
        }
        return result;
    }

    private static int[] generate30To60(int num) {
        int sum = 16;
        int[] result = new int[] { 1, 2, 3, 4, 3, 2, 1 };
        int addNum = (num - sum) / result.length;

        sum = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] += addNum;
            sum += result[i];
        }

        int remainder = num - sum;

        if (remainder < 4) {
            result[3] += remainder;
        } else if (remainder == 4) {
            result[0]++;
            result[1]++;
            result[2]++;
            result[3]++;
        } else if (remainder == 5) {
            result[1]++;
            result[2]++;
            result[3]++;
            result[4]++;
            result[5]++;
        } else if (remainder == 6) {
            result[1]++;
            result[2]++;
            result[3] += 2;
            result[4]++;
            result[5]++;
        }
        return result;
    }

    public static void printArray(int[] nums) {
        for (int i : nums) {
            if (i > 0) {
                for (int j = 0; j < i; j++) {
                    System.out.print("★");
                }
                System.out.println();
            }
        }
    }
}
