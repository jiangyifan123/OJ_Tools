package problems.APlusB;


//PREPEND BEGIN
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
class Main {
//PREPEND END

    //TEMPLATE BEGIN
    static int add(int a, int b) {
        return a + b;
    }
//TEMPLATE END

    //APPEND BEGIN
    public static void main(String [] args) {
//            System.setIn(new FileInputStream("1.in"));
//            PrintStream ps=new PrintStream(new FileOutputStream("1.out"));
//            System.setOut(ps);
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextLine()) {
            String s = cin.nextLine();
            List<Integer> list = Arrays.stream(s.split(",")).map(Integer::valueOf).toList();
            System.out.println(add(list.get(0), list.get(1)));
        }
    }
}
//APPEND END