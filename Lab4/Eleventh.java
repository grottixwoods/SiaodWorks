package Lab4;
import java.io.*;
import java.util.Iterator;
import java.util.Stack;
//Проверка формулы на правильность
public class Eleventh {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("D:\\VSCode\\Projects\\Lab4\\files\\Eleventh.txt")));
        Stack st = new Stack();
        Stack letter = new Stack();
        Stack symbols = new Stack();
        int i = 0;
        while ((i = reader.read()) != -1) { 
            char ch = (char) i;
            st.add(ch);
        }
        Iterator iterator1 = st.iterator();
        while (iterator1.hasNext()) { 
            char r = (char) iterator1.next();
            if (Character.isAlphabetic(r)) {
                letter.push(r);
            }
        }
        Iterator iterator2 = st.iterator();
        while (iterator2.hasNext()) { 
            char r = (char) iterator2.next();
            if (!(Character.isDigit(r) || Character.isAlphabetic(r))) {
                symbols.push(r);
            }
        }
        int kol = 0; //Записываем количество + или -
        int open = 0,close = 0; //Скобки
        while (symbols.size() != 0) {  
            char s = (char) symbols.pop();
            switch (s) { //сравниваем
                case ('+'):
                case ('-'):
                    kol++;
                    break;
                case ('('):
                    open++;
                    break;
                case (')'):
                    close++;
                    break;
            }
        }
        int w = 0; //записываем кол во букв
        while (letter.size() != 0) { 
            char s = (char) letter.pop();
            switch (s) { //сравниваем 
                case ('x'):
                case ('y'):
                case ('z'):
                    w++; 

                    break;
            }
        }

        if ((w-1 == kol) && (close==open)) 
        //Логика в том , что букв на 1 больше чем знаков ,
        // по этому вычетаем 1 их букв и сравниваем , потом сравниваем со скопбками
            System.out.println("Формула имеет правильный вид");
        else
            System.out.println("Формула имеет не правильный вид");
    }
}

