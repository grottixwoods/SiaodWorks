package Lab4;
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class Third { //Головоломка с пирадмидами
    public static void main(String[] args) {
        Stack a = new Stack(); // 3 Башни
        Stack b = new Stack();
        Stack c = new Stack();
        System.out.println("Введите n количество дисков:");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i=n;i>0;i--){
            a.add(i);
        }
        swap(a,b,c,n);
        System.out.println("Ответ:");
        System.out.println(c);
    }
    public static void swap (Stack a, Stack b, Stack c,int n){ 
        //Рекурсивно вызывает сам себя и перезаписывает по разным башням
        if (n == 1) {
            c.add(a.pop());

        } else {
            swap(a,c,b,n-1);
            c.add(a.pop());
            swap(b,a,c,n-1);
        }
    }
}
