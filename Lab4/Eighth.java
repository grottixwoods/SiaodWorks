package Lab4;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
//Запись строки в обратном порядке в файл
public class Eighth {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("D:\\VSCode\\Projects\\Lab4\\files\\Eighth.txt");//Изначальный файл
        Scanner scanner = new Scanner(file);
        Stack temp = new Stack(); //Создаем стек
        while (scanner.hasNext()) { 
            temp.add(scanner.nextLine()); //Записывается через LIFO (порядок меняется)
        }
        try (PrintWriter pw = new PrintWriter("D:\\VSCode\\Projects\\Lab4\\files\\Eighth_answer.txt")) { 
            {
                for (int i=0;i<=temp.size();++i) { //Запись стека в файл
                    String s ;
                    s = (String) temp.pop();
                    pw.println(s);
                }
                pw.println(temp.pop());
                }
                temp.remove(temp);
        } catch (IOException exc) {
            System.out.println(exc);
        }
    }

}
