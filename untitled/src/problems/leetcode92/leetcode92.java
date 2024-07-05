package problems.leetcode92;



//PREPEND BEGIN
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Main {
//PREPEND END

//TEMPLATE BEGIN
//class ListNode {
//    int val;
//    problems.leetcode92.ListNode next;
//    ListNode() {}
//    ListNode(int val) { this.val = val; }
//    ListNode(int val, problems.leetcode92.ListNode next) { this.val = val; this.next = next; }
//}
static ListNode reverseBetween(ListNode head, int left, int right) {
    if(head == null || head.next == null) return head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;
    ListNode it = dummy;
    ListNode prevIt = null;
    // finding left and previous of left for reversing
    for(int i = 0; i < left; i++){
        prevIt = it;
        it = it.next;
    }
    ListNode prevItR = prevIt;
    ListNode itR = it;
    // loop till previous node is not equal to right node i.e. 4 in example
    for(int i = left; i <= right; i++){
        // itR is curr node
        ListNode forward = itR.next;
        itR.next = prevItR;
        prevItR = itR;
        itR = forward;
    }
    // making connection
    prevIt.next = prevItR;
    it.next = itR;
    return dummy.next;
}
//TEMPLATE END

    //APPEND BEGIN
    public static void main(String[] args) {
        try {
//            createTestCase();
//            PrintStream ps=new PrintStream(new FileOutputStream("1.out"));
//            System.setOut(ps);
//            System.setIn(new FileInputStream("1.in"));
            Scanner cin = new Scanner(System.in);
            while (cin.hasNextLine()) {
                int left = Integer.parseInt(cin.nextLine());
                int right = Integer.parseInt(cin.nextLine());
                String str = cin.nextLine();
                ListNode node = ConvertListToListNode(Arrays.stream(str.split(",")).map(Integer::valueOf).toList());
                String ans = ConvertListNodeToList(reverseBetween(node, left, right)).toString();
                System.out.println(ans);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Integer> ConvertListNodeToList(ListNode node) {
        ListNode tail = node;
        ArrayList<Integer> res =  new ArrayList<>();
        while (tail != null) {
            res.add(tail.val);
            tail = tail.next;
        }
        return res;
    }

    public static ListNode ConvertListToListNode(List<Integer> list) {
        ListNode res = new ListNode();
        ListNode cur = res;
        for (Integer val: list){
            cur.next = new ListNode(val);
            cur = cur.next;
        };
        return res.next;
    }

    static void createEachTestCase() {
        int n = 500;
        int MaxVal = 500;
        int MinVal = -500;
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int number = rand.ints(n/2, n).findFirst().getAsInt();
        for (int i = 0; i < number; i++){
            list.add(rand.nextInt(MaxVal - MinVal) + MinVal);
        }
        int left = rand.ints(1, number-50).findFirst().getAsInt();
        int right = rand.ints(left, number).findFirst().getAsInt();
        System.out.println(left);
        System.out.println(right);
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    static void createTestCase() {
        try {
            PrintStream ps=new PrintStream(new FileOutputStream("1.in"));
            System.setOut(ps);
            int caseNumber = 50;
            for (int i = 0; i < caseNumber; i++) {
                createEachTestCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//APPEND END