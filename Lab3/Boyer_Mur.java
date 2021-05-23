package Lab3;
import java.util.*;
import java.util.Arrays;
public class Boyer_Mur {
    public static void main(String[] args) {
        Boyer_Mur a = new Boyer_Mur();
        ArrayList <String> names = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        String str = sc.nextLine();
        String template = "ja";
        names.add(str);
        long start = 0;
        long stop = 0;

        start = System.nanoTime();
        for (int i = 0; i < names.indexOf(i); i++){
            names.get(i).indexOf("ja");
            if (names.get(i) == " "){
                i++;
            }
        }
        stop = System.nanoTime();
        System.out.println("IndexOf: " + (stop-start));
        a.getFirstEntry(str,template);
}
    public int getFirstEntry(String str, String template) {
        long start = 0;
        long stop = 0;
        start = System.nanoTime();
        int sourceLen = str.length();
        int templateLen = template.length();
        if (templateLen > sourceLen) {
            return -1;
        }
        HashMap<Character, Integer> offsetTable = new HashMap<Character, Integer>();
        for (int i = 0; i <= 255; i++) {
            offsetTable.put((char) i, templateLen);
        }
        for (int i = 0; i < templateLen - 1; i++) {
            offsetTable.put(template.charAt(i), templateLen - i - 1);
        }
        int i = templateLen - 1;
        int j = i;
        int k = i;
        while (j >= 0 && i <= sourceLen - 1) {
            j = templateLen - 1;
            k = i;
            while (j >= 0 && str.charAt(k) == template.charAt(j)) {
                k--;
                j--;
            }
            i += offsetTable.get(str.charAt(i));
        }
        stop = System.nanoTime();
        System.out.println("Boyer - Mur: " + (stop-start));
        if (k >= sourceLen - templateLen) {
            return -1;
        } else {
            return k + 1;
        }

    }
}
