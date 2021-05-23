package Zadachi;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Zadachi1 {
    //Задачи из первого файла

        public static void main(String[] args) {
            Zadachi1 s = new Zadachi1();
            System.out.println("Задание 1:");
            s.Z1();
            System.out.println("Задание 2:");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество чисел массива nums");
            int z=scanner.nextInt();
            int[] int_nums = new int[z];
            for (int i=0;i<z;i++){
                int_nums[i] = scanner.nextInt();
            }
            System.out.println(Z2(int_nums));
            System.out.println("Задание 3:");
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите размерность матрицы:");
            String m1 = sc.nextLine();
            String n1 = m1;
            System.out.println("Введите минимальный элемент матрицы:");
            String min_lim1 = sc.nextLine();
            System.out.println("Введите максимальный элемент матрицы:");
            String max_lim1 = sc.nextLine();
            if (n1.equals(""))
                n1 = "50";
            if (m1.equals(""))
                m1 = "50";
            if (min_lim1.equals(""))
                min_lim1 = "-250";
            if (max_lim1.equals(""))
                max_lim1 = "1013";
            int n = Integer.parseInt(n1);
            int m = Integer.parseInt(m1);
            int min_lim = Integer.parseInt(min_lim1);
            int max_lim = Integer.parseInt(max_lim1);
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                System.out.print("\n");
                for (int j = 0; j < m; j++) {
                    arr[i][j] = (int) ((Math.random() * (max_lim - min_lim)) + min_lim);
                    System.out.print(arr[i][j] + "\t");
                }
                System.out.println();
            }
            Zadachi1 f = new Zadachi1();
            int[][] rez = f.Z3(arr,n,m);
            System.out.println("-----------------------------------------------------------------------");
            for (int i=0;i<n;i++){
                System.out.print("\n");
                for (int j=0;j<n;j++){
                    System.out.print(rez[i][j]+"\t");
                }
                System.out.println();
            }
        }
        public void Z1() {
            System.out.println("Введите размер массива:");
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = (int) (Math.random() * 100);
            }
            System.out.println("Сгенерированный массив:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
            maxPerimeter(arr, n);
        }
        static void maxPerimeter (int[] arr, int n) {
            int maxi = 0;                        // инициализируем максимальный периметр как 0.

            for (int i = 0; i < n - 2; i++)      // подбираем 3 разных элемента
            {                                   // из массива
                for (int j = i + 1; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        int a = arr[i];
                        int b = arr[j];
                        int c = arr[k];
                        if (a < b + c && b < c + a && c < a + b)         //проверяем, a, b, c образуют треуг. или нет
                        {
                            maxi = Math.max(maxi, a + b + c);          // если он образует треугольник
                        }                                              // затем обновляем максимум
                    }
                }
            }
            if (maxi > 0)                                                // Если максимальный периметр ненулевой
                System.out.println("Максимальный периметр: " + maxi);
            else                                                         // иначе треугольник не строится
                System.out.println("Невозможно составить треугольник");
        }
        public static String Z2(int[] int_nums) {
            String str = "";
            int k = 0;
            for (int i= 0; i < int_nums.length; i++){
                for (int j = 1; j < int_nums.length-i; j++) {
                    String x = Integer.toString(int_nums[j-1])+Integer.toString(int_nums[j]);
                    String y = Integer.toString(int_nums[j])+Integer.toString(int_nums[j-1]);
                    if (x.compareTo(y)<0) {
                        k=int_nums[j];int_nums[j]=int_nums[j-1];int_nums[j-1]=k;
                    }
                }
            }
            for (int item:int_nums) {
                str+=Integer.toString(item);
            }
            return str;
        }
    public static int[][] Z3(int[][] a,int n,int m){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sort(a,i,j);
            }

        }
        return a;
    }

    public static void sort(int [][] a, int i, int j){


        if (i==0 || j==0){}else{
            if(a[i][j]<a[i-1][j-1]){
                int k = a[i][j];
                a[i][j]=a[i-1][j-1];
                a[i-1][j-1]=k;
            }
            sort(a,i-1,j-1);
        }
    }


}

