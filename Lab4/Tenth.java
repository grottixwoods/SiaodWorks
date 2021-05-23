package Lab4;
import java.io.*;
import java.util.Iterator;
import java.util.Stack;
//То же самое что и в 9том только используем другие буквы в case и действия другие
public class Tenth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\VSCode\\Projects\\Lab4\\files\\Tenth.txt")));
        Stack st = new Stack(); //Основной стек, для записи из файла
        Stack num = new Stack(); // Стек чисел
        Stack letter = new Stack(); //Стек букав
        Stack answer = new Stack(); // Стек ответов
        int i = 0;
        while ((i = reader.read()) != -1) { 
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator = st.iterator(); 
        while (iterator.hasNext()) {
            char r=(char) iterator.next();
            if(Character.isDigit(r)){
                num.add(r);
            }
        }
        Iterator iterator2 = st.iterator(); 
        while (iterator2.hasNext()) {
            char r=(char) iterator2.next();
            if(Character.isAlphabetic(r)){
                letter.push(r);
            }
        }
        while (answer.size()!=1){
            char s =(char) letter.pop(); 
            switch (s){ // на букву срабатывает кейс с такой же буквой
                case ('M'): //Производятся логические операции над числами
                    char num1 =(char)  num.pop(); //Производится логическая операция над числами из массива числел
                    char num2 =(char)  num.pop();
                    if (num1>num2)
                    answer.add(num1); //записывается в стек answer
                    else
                        answer.add(num2);
                    break;
                case ('N'):
                    char num3 = (char) num.pop();
                    char num4 = (char) num.pop();
                    if (num4>num3)
                        answer.add(num3);
                    else
                        answer.add(num4);
                    break;
                case ('F'):
                    char num6 = (char) num.pop();
                    answer.add(num6);
            }
        }
        System.out.println(answer);
    }
}
