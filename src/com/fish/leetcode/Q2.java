package com.fish.leetcode;

/**
 * @author Jerry Fish / fishruijie@163.com
 * @since 0.0.1
 * date 2021/2/25
 * Stay curious, stay childlike.
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 */
public class Q2 {

    public static void main(String[] args) {
        int[] a1 = {9,9,9,9,9,9,9};
        int[] a2 = {9,9,9,9};
        ListNode l1 = createNode(a1);
        ListNode l2 = createNode(a2);
        addTwoNumbers(l1, l2);
    }

    private static ListNode createNode(int[] a1) {
        ListNode ret = new ListNode(a1[0]);
        ListNode next = null;
        for(int i = 1; i < a1.length; i++){
            if(next == null){
                ret.next = new ListNode(a1[i]);
                next = ret.next;
            } else {
                next.next = new ListNode(a1[i]);
                next = next.next;
            }
        }
        return  ret;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode before = null;
        ListNode ret = new ListNode(0);
        boolean hasIn = false;
        while (l1 != null || l2 != null || hasIn){

            int v1 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2;
            if(hasIn){
                sum++;
                hasIn = false;
            }
            if(sum > 9){
                hasIn = true;
                sum %= 10;
            }
            if(before == null){
                ret = new ListNode(sum);
                before = ret;
            } else {
                before.next = new ListNode(sum);
                before = before.next;
            }
        }
        return ret;
    }

    /* github
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ret = new ListNode(0);
        ListNode cur = ret;
        int carry = 0;
        while (l1 != null || l2 != null){

            int v1 = 0;
            if(l1 != null){
                v1 = l1.val;
                l1 = l1.next;
            }
            int v2 = 0;
            if(l2 != null){
                v2 = l2.val;
                l2 = l2.next;
            }
            int sum = v1 + v2 + carry;
            if(sum > 9){
                carry = 1;
                sum %= 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return ret.next;
    }*/


    public static class ListNode {
        int val;
        public ListNode next;
        ListNode(int x) { val = x; }
    }
}