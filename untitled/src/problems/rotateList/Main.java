package problems.rotateList;



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
    static ListNode rotateRight(ListNode head, int k) {
        if (head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy,slow=dummy;

        int i;
        for (i=0;fast.next!=null;i++)//Get the total length
            fast=fast.next;

        for (int j=i-k%i;j>0;j--) //Get the i-n%i th node
            slow=slow.next;

        fast.next=dummy.next; //Do the rotation
        dummy.next=slow.next;
        slow.next=null;

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
                int k = Integer.parseInt(cin.nextLine());
                String str = cin.nextLine();
                ListNode node = ConvertListToListNode(Arrays.stream(str.split(",")).map(Integer::valueOf).toList());
                String ans = ConvertListNodeToList(rotateRight(node, k)).toString();
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
        int MaxVal = 100;
        int MinVal = -100;
        ArrayList<Integer> list = new ArrayList<>();
        Random rand = new Random();
        int number = rand.ints(n/2, n).findFirst().getAsInt();
        for (int i = 0; i < number; i++){
            list.add(rand.nextInt(MaxVal - MinVal) + MinVal);
        }
        int k = rand.nextInt(2000000000);
        System.out.println(k);
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    static void createTestCase() {
        try {
            PrintStream ps=new PrintStream(new FileOutputStream("1.in"));
            System.setOut(ps);
            int caseNumber = 1000;
            for (int i = 0; i < caseNumber; i++) {
                createEachTestCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//APPEND END