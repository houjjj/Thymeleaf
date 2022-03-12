package com.houjun.array;

/**
 * 第一个错误的版本：即二分查找目标值
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        System.out.println(firstBadVersion(100));
    }

    public static int firstBadVersion(int n) {
        int start = 1, end = n, mid;
        // 重点是start 不能等于end，
         while (start < end) {
            mid = (start + end) / 2;
            if (isBadVersion(mid)) {
                // 如果该版本是错误版本，那么第一个错误版本可能是mid，也可能是在mid左边，我们收紧有边界
                end = mid;
            } else {
                // 如果该版本是正确版本，那么第一个错误版本一定在mid右边，我们收紧左边界
                start = mid + 1;
            }
        }
        return start;
    }

    private static boolean isBadVersion(int mid) {
        if (mid >= 50) {
            return true;
        }
        return false;
    }
}
