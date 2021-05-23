package Lab2;

public class Koroleva {
    
    private int dimension;
    private int[] state;
    private int index = 1;

    public Koroleva(int n) {
        dimension = n;
        state = new int[n];

        for (int i = 0; i < state.length; i++) {
            state[i] = 0;
        }
    }

    public boolean next() {
        index++;
        return move(dimension - 1);
    }


    private boolean move(int index) { 
        if (state[index] < dimension - 1) {
            state[index]++;
            return true;
        }

        state[index] = 0;
        if (index == 0) {
            return false;
        } else {
            return move(index - 1);
        }
    }

    public int getIndex() { 
        return index;
    }
 
    public boolean isPeace() {
        for (int i = 0; i < state.length; i++) {
            for (int j = i + 1; j < state.length; j++) {
                if (state[i] == state[j]) {
                    return false;
                }
                if (Math.abs(i - j) == Math.abs(state[i] - state[j])) {
                    return false;
                }
            }
        }

        return true;
    }

    
    public void printState() {
        for (int i = 0; i < state.length; i++) {
            int position = state[i];
            for (int j = 0; j < dimension; j++) {
                System.out.print(j == position ? 'X' : '_');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Koroleva c = new Koroleva(8);
        int counter = 0;
        do {
            if (c.isPeace()) {
                counter ++;
                c.printState();
                System.out.println("----------------------"); 
            }
        } while (c.next());

        System.out.println("Итого: " + counter);
    }
}
