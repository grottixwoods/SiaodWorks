package Lab4;
import java.io.*;
import java.util.*;
//вывод сначала отрицательных , потом положительных
public class Seventh {

    public static void main(String[] args) throws IOException {
        Deque temp = new ArrayDeque(); 
        Stack s = new Stack(); 
        File file = new File("D:\\VSCode\\Projects\\Lab4\\files\\Seventh.txt");
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine(); 
        String [] str1 = str.split(" "); 
        for (int i = 0; i < str1.length; i++) { 
            s.push(Integer.valueOf(str1[i]));
        }
        Iterator iterator = s.iterator(); 
        Iterator iterator1 = s.iterator();

        while (iterator1.hasNext()) { //Проходимся по стеку
            int r  = (int) iterator1.next(); //Записываем 1 элемент в переменную
            if (r<0){ //Проверяем меньше нуля и записываем в дек
                temp.add(r);
            }
        }
        while (iterator.hasNext()) {
            int r  = (int) iterator.next();
            if (r>0){ //Проверяем меньше нуля и записываем в дек
                temp.add(r);
            }
        }
        System.out.println(temp); //Выводим дек

    }
}