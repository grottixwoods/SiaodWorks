package Lab4;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
//Подсчет количества скобок
public class Fourth {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\VSCode\\Projects\\Lab4\\files\\Fourth.txt");
        Scanner scanner = new Scanner(file);
        Stack temp = new Stack(); 
        while (scanner.hasNext()) { 
           temp.add(scanner.nextLine());
        }
        Iterator iterator = temp.iterator(); 
        int open=0, close=0; 
        while (iterator.hasNext()){
            String s = (String) iterator.next(); 
            char[] ch= s.toCharArray();  
            for (int i=0;i<s.length();i++){ //Проходим по массиву
                char o = '(';
                char c = ')';
                if (Character.compare(ch[i],o)==0) { //Сравниваем элементы со скобками
                        open++; //Считаем сколько скобок нашли
                }
                if (Character.compare(ch[i],c)==0) {
                    close++;
                }
            }
        }
        if (open == close) //Если символы равны то совпадает
        System.out.println("Количество символов совпадает");
        else
            System.out.println("Количество символов не совпадает");
    }
}