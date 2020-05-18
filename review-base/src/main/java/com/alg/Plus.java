package com.alg;

import java.util.ArrayList;
import java.util.List;

public class Plus {

    public static void main(String[] args) {
        //System.out.println(aplusb(1,2));
        //System.out.println(aplusb(2,3));
        //System.out.println(aplusb(5,4));
        //System.out.println(aplusb(6,7));

        //System.out.println(fn(5555550000000L) == fnwhile(5555550000000L));

        //System.out.println(Arrays.toString(merge(new int[] { 1, 5}, new int[]{2,3})));

        //rotateString("abcdefg".toCharArray(), 3);
        //rotateString("abcdefg".toCharArray(), 0);
        //rotateString("abcdefg".toCharArray(), 1);
        //rotateString("abcdefg".toCharArray(), 2);
        //rotateString("abcdefg".toCharArray(), 20);
        //rotateString("".toCharArray(), 10);
        //rotateString("a".toCharArray(), 1);
        //rotateString("a".toCharArray(), 2);
        //rotateString("a".toCharArray(), 3);
        //rotateString("ab".toCharArray(), 1);
        //rotateString("ab".toCharArray(), 2);
        //rotateString("ab".toCharArray(), 3);

        //System.out.println(fizzBuzz(15));

        //System.out.println(binarySearch(new int[]{1, 4, 4, 5, 7, 7, 8, 9, 9, 10}, 1));
        //System.out.println(binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 3));
        //System.out.println(binarySearch(new int[]{1, 2, 3, 3, 4, 5, 10}, 6));

        //ListNode node = new ListNode(1), head = node;
        //for (int i = 2; i <= 4; i++) {
        //    node.next = new ListNode(i);
        //    node = node.next;
        //}
        //ListNode reverse = reverse(head);
        //while (reverse != null) {
        //    System.out.println(reverse.val);
        //    reverse = reverse.next;
        //}
        //List<Integer> ints = Arrays.asList(4, 5, 1, 2, 3);
        //recoverRotatedSortedArray(ints);
        //List<Integer> ints2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        //recoverRotatedSortedArray(ints2);

        //System.out.println(ints);
        //System.out.println(ints2);
        System.out.println(strStrNoKMP("abcdabcdefg", "bcd"));
        System.out.println(strStrNoKMP("source", "target"));
        System.out.println(strStrNoKMP("source", "rced"));
        System.out.println(strStrNoKMP("", ""));
        System.out.println(strStrNoKMP("abcde", "e"));

    }

    public static int strStrNoKMP(String source, String target) {
        // Write your code here

        if ("".equals(target))
            return 0;

        int i = 0, j = 0;
        int slen = source.length();
        int tlen = target.length();
        int index = -1;

        for (i = 0; i < slen; i++) {
            int curr = i;
            for (j = 0; j < tlen; j++, curr++) {
                if (curr < slen && source.charAt(curr) != target.charAt(j)) {
                    break;
                }
                if (curr < slen && j == tlen - 1) {
                    return i;
                }
            }
        }
        return index;
    }


    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(
                    (i % 3 == 0 && i % 5 == 0) ? "fizz buzz" :
                            ((i % 3 == 0) ? "fizz" :
                                    (i % 5 == 0 ? "buzz" : String.valueOf(i)))
            );
        }
        return list;
    }

    private static int aplusb(int a, int b) {
        if ( (a & b) == 0) return a | b;
        else return aplusb(a ^ b, (a & b) << 1);
    }

    private static long fn(long n) {
        if (n == 0) return 0;
        else return n / 5L + fn(n / 5L);
    }

    private static long fnwhile(long n) {
        long sum = n / 5, length = sum;
        while (sum >= 5) {
            length += (sum = sum / 5);
        }
        return length;
    }

    private static int[] merge(int[] A, int[] B) {
        int clen = A.length + B.length;
        int[] c = new int[clen];
        int ai = 0, bi = 0, ci = 0;
        while (ai < A.length && bi < B.length) {
            c[ci++] = A[ai] <= B[bi] ? A[ai++] : B[bi++];
        }
        while (ai < A.length) {
            c[ci++] = A[ai++];
        }
        while (bi < B.length) {
            c[ci++] = B[bi++];
        }
        return c;
    }

    public static void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        //三步反转
        if (nums.size() <= 1) return;
        int offset = 0, temp;

        for (int i = 0; i < nums.size() - 2; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                offset = i + 1;
            }
        }

        // 0 - offset
        int j, k, size = nums.size();
        for (j = 0; j < (offset) / 2; j++) {
            k = (offset - 1) - j;
            temp = nums.get(j);
            nums.set(j, nums.get(k));
            nums.set(k, temp);
        }
        for (j = offset, k = size - 1; j < offset + (size - offset) / 2; j++, k--) {
            temp = nums.get(j);
            nums.set(j, nums.get(k));
            nums.set(k, temp);
        }
        for (j = (size - 2) >> 1; j >= 0; j--) {
            k = (size - 1) - j;
            temp = nums.get(j);
            nums.set(j, nums.get(k));
            nums.set(k, temp);
        }
    }


    public static void rotateString(char[] str, int offset) {

        if (str == null || str.length <= 1)
            return;

        int length = str.length, j, k;
        char temp;
        offset = offset % str.length;
        //all
        for (j = (length - 2) >> 1; j >= 0; j--) {
            k = (length - 1) - j;
            temp = str[j];
            str[j] = str[k];
            str[k] = temp;
        }
        //offset
        for (j = (offset - 2) >> 1; j >= 0; j--) {
            k = (offset - 1) - j;
            temp = str[j];
            str[j] = str[k];
            str[k] = temp;
        }
        //rest
        for (j = offset, k = length -1; j < offset + (length - offset) / 2; j++, k--) {
            temp = str[j];
            str[j] = str[k];
            str[k] = temp;
        }
        System.out.println(new String(str));
    }

    public static int binarySearch(int[] nums, int target) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int index = -1, low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) index = mid;
            //if (nums[mid] >= target) {
            //    high = mid - 1;
            //} else if (nums[mid] < target) {
            //    low = mid + 1;
            //}
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] <= target) {
                low = mid + 1;
            }
        }
        return index;
    }

    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                list.addAll(flatten(nestedInteger.getList()));
            }
        }
        return list;
    }

    public List<Integer> flattenNonRecrusive(List<NestedInteger> nestedList) {
        // Write your code here
        //LinkedList<NestedInteger> linkedList = new LinkedList<>(nestedList);
        ArrayList<NestedInteger> arrayList = new ArrayList<>(nestedList);
        List<Integer> list = new ArrayList<>();

        while (arrayList.size() > 0) {
            NestedInteger first = arrayList.remove(0);
            if (first.isInteger()) {
                list.add(first.getInteger());
            } else {
                List<NestedInteger> newFirst = first.getList();
                arrayList.addAll(0, newFirst);
            }
        }
        return list;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return false;

        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            //
            i = mid % n;
            j = mid / n;
            if (matrix[j][i] == target) return true;
            else if (matrix[j][i] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public static ListNode reverse(ListNode head) {
        ListNode pre = null, temp;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}
