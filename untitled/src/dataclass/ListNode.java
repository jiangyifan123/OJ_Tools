package dataclass;

import java.util.List;

public class ListNode<T> {
  private T val;
  public ListNode<T> next = null;
  public ListNode() {}
  public ListNode(T val) { this.val = val; }
  public ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
  public T getVal() {
    return val;
  }
}