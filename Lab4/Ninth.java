package Lab4;
import java.io.*;
import java.util.Iterator;
import java.util.Stack;
// Выполнение логических операций над числами с ипользованием , лог.опер
public class Ninth {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\VSCode\\Projects\\Lab4\\files\\Ninth.txt")));
        Stack st = new Stack(); //Основной стек в который все записываем
        Stack num = new Stack(); //Стек для чисел
        Stack letter = new Stack(); //Стек для букав
        Stack preanswer = new Stack(); //Стек для пред ответа (значения скобок, считаем за скобки)
        int i = 0;
        while ((i = reader.read()) != -1) { 
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator = st.iterator();
        while (iterator.hasNext()) { //записывает в виде t f
            char r=(char) iterator.next();
            if(Character.isDigit(r)){
                if (r=='0')
                    num.push(false);
                else
                num.push(true);
            }
        }
        Iterator iterator1 = st.iterator();
        while (iterator1.hasNext()) { //записывает буквы в стек с буквами 
            char r=(char) iterator1.next();
            if(Character.isAlphabetic(r)){
                letter.push(r);
            }
        }
        while (preanswer.size()!=6) { 
            char s =(char) letter.pop(); 
            switch (s) { // на букву срабатывает кейс с такой же буквой
                case ('O'): //Производится логическая операция над числами из массива числел
                    boolean num1 = (boolean) num.pop(); //Числа вынимаются по очереди с конца в обратном порядке
                    boolean num2 = (boolean) num.pop();
                    preanswer.add(num1 || num2); //и записывается true или в false в preanswer
                    break;
                case ('X'):
                    boolean num3 = (boolean) num.pop();
                    boolean num4 = (boolean) num.pop();
                    if (num3 != num4) {
                        preanswer.add(true);
                    } else {
                        preanswer.add(false);
                    }
                    break;
                case ('A'):
                    boolean num5 = (boolean) num.pop();
                    boolean num6 = (boolean) num.pop();
                    preanswer.add(num5 && num6);
                    break;
                case ('N'):
                    boolean num7 = (boolean) num.pop();
                    if (num7 == true) {
                        preanswer.add(false);
                    } else {
                        preanswer.add(true);
                    }
                    break;
                case ('F'):
                    preanswer.add(false);
                    break;
                case ('T'):
                    preanswer.add(true);
                    break;
            }

        }
        Iterator iterator2 = preanswer.iterator();
        boolean answer=false;
        while (iterator2.hasNext()) {
             if ((boolean)iterator2.next() == true){ 
                 //Если находит хоть 1 true то все равно true
                 answer = true;
             }
        }
        System.out.println("Лв = " + answer); //Вывод функции
    }

}
