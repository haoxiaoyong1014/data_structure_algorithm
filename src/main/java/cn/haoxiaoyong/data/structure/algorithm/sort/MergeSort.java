package cn.haoxiaoyong.data.structure.algorithm.sort;

import java.util.Arrays;

/**
 * @author haoxiaoyong on 2021/1/9 下午 10:09
 * e-mail: hxyHelloWorld@163.com
 * github: https://github.com/haoxiaoyong1014
 * Blog: www.haoxiaoyong.cn
 * 归并排序
 */
public class MergeSort {

    private static int[] tmps;

    public static void mergeSort(int[] arr, int n) {

        int lo = 0;
        int hi = n - 1;
        //初始化一个临时数组；
        tmps = new int[arr.length];
        //分治，先分
        sort(arr, lo, hi);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }

        //对lo到hi之间的数据进行分为两个组
        //int mid = lo+(hi-lo)/2;//   5,9  mid=7
        int mid = (lo + hi) / 2;

        //分别对每一组数据进行排序
        sort(a, lo, mid);
        sort(a, mid + 1, hi);

        //再把两个组中的数据进行归并
        //merge(a, lo, mid, hi);

        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组的对应索引处
        while (p1 <= mid && p2 <= hi) {
            //比较对应索引处的值
            if (a[p1] <= a[p2]) {
                tmps[i++] = a[p1++];
            } else {
                tmps[i++] = a[p2++];
            }
        }
        // 下面两个循环只会走一个
        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1 <= mid) {
            tmps[i++] = a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while (p2 <= hi) {
            tmps[i++] = a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = tmps[index];
        }

    }


    /*
   对数组中，从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
    */
    private static void merge(int[] a, int lo, int mid, int hi) {
        //定义三个指针
        int i = lo;
        int p1 = lo;
        int p2 = mid + 1;

        //遍历，移动p1指针和p2指针，比较对应索引处的值，找出小的那个，放到辅助数组的对应索引处
        while (p1 <= mid && p2 <= hi) {
            //比较对应索引处的值
            if (a[p1] < a[p2]) {
                tmps[i++] = a[p1++];
            } else {
                tmps[i++] = a[p2++];
            }
        }

      /*  int start = p1, end = mid;
        if (p2 <= hi) {
            start = p2;
            end = hi;
        }

         while (start <= end) {
            tmps[i++] = a[start++];
        }
        */

        // 下面两个循环只会走一个
        //遍历，如果p1的指针没有走完，那么顺序移动p1指针，把对应的元素放到辅助数组的对应索引处
        while (p1 <= mid) {
            tmps[i++] = a[p1++];
        }
        //遍历，如果p2的指针没有走完，那么顺序移动p2指针，把对应的元素放到辅助数组的对应索引处
        while (p2 <= hi) {
            tmps[i++] = a[p2++];
        }
        //把辅助数组中的元素拷贝到原数组中
        for (int index = lo; index <= hi; index++) {
            a[index] = tmps[index];
        }

    }

    public static void main(String[] args) {
        int a[] = {8, 4, 5, 7, 1, 3, 6, 2};
        mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }

}
