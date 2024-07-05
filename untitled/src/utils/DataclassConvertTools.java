package utils;

import dataclass.ListNode;

import java.util.ArrayList;
import java.util.List;

public class DataclassConvertTools<T> {
    public List<T> ConvertListNodeToList(ListNode<T> node) {
        ListNode<T> tail = node;
        ArrayList<T> res =  new ArrayList<>();
        while (tail != null) {
            res.add(tail.getVal());
            tail = tail.next;
        }
        return res;
    }

    public ListNode<T> ConvertListToListNode(List<T> list) {
        ListNode<T> res = new ListNode<T>();
        ListNode<T> cur = res;
        for (T val: list){
            cur.next = new ListNode<T>(val);
            cur = cur.next;
        };
        return res.next;
    }
}
