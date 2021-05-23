package Zadachi;
import  java.util.Arrays;
import java.util.Scanner;

public class Zadachi4 {
    public static void main(String[] args) {
        Zadachi4 s = new Zadachi4();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Кол-во стопок монет");
        int z=scanner.nextInt();
        int[] piles = new int[z];
        System.out.println("Введите стопки монет");
        for (int i = 0; i < z; i++){
            piles[i] = scanner.nextInt();
        }
        s.max_coins(piles);
    }
    public void max_coins(int[] piles){
        Arrays.sort(piles);
        int sum = 0;
        int i =piles.length - 2;
        int j = 0;
        while(j++ < piles.length / 3){
            sum += piles[i];
            i -=2;
        }
        System.out.println("результат10");
        System.out.println(sum);
    }
}