package Lab2;
import java.util.Scanner;
public class Rehashing_random {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTable_random hashTable = new HashTable_random(128);
        hashTable.insert("visa");
        hashTable.insert("gang");
        hashTable.insert("beatz");
        hashTable.insert("world");
        hashTable.insert("wide");
        hashTable.print();
        System.out.println("Введите слово для поиска:");
        String word = scanner.nextLine();
        Item item = hashTable.find(word);
        if (item != null)
            System.out.println("Элемент найден, его хэш: " + hashTable.hash_random(word));
        else
            System.out.println("Элемент не найден!");
    }
}

