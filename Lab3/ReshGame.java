package Lab3;
import java.util.*;
//Решатель для Game

public class ReshGame {  //  наш "решатель"

    private Table initial;    
    private List<Table> result = new ArrayList<Table>();   
    private class ITEM{    
        private ITEM prevBoard;  
        private Table board;   

        private ITEM(ITEM prevBoard, Table board) {
            this.prevBoard = prevBoard;
            this.board = board;
        }

        public Table getBoard() {
            return board;
        }


    }

    public ReshGame(Table initial) {
        this.initial = initial;

        if(!isSolvable()) return;  

        PriorityQueue<ITEM> priorityQueue = new PriorityQueue<ITEM>(10, new Comparator<ITEM>() {
            @Override
            public int compare(ITEM o1, ITEM o2) {
                return new Integer(measure(o1)).compareTo(new Integer(measure(o2)));
            }
        });


        // шаг 1
        priorityQueue.add(new ITEM(null, initial));

        while (true){
            ITEM board = priorityQueue.poll(); 
            //  шаг 2
            if(board.board.isGoal()) {
                itemToList(new ITEM(board, board.board));
                return;
            }
            //   шаг 3
            Iterator iterator = board.board.neighbors().iterator(); // соседи
            while (iterator.hasNext()){
                Table board1 = (Table) iterator.next();

                if(board1!= null && !containsInPath(board, board1))
                    priorityQueue.add(new ITEM(board, board1));
            }

        }
    }

    //  вычисляем f(x)
    private static int measure(ITEM item){
        ITEM item2 = item;
        int c= 0;   
        int measure = item.getBoard().h();  
        while (true){
            c++;
            item2 = item2.prevBoard;
            if(item2 == null) {
                return measure + c;
            }
        }
    }

    //  сохранение
    private void itemToList(ITEM item){
        ITEM item2 = item;
        while (true){
            item2 = item2.prevBoard;
            if(item2 == null) {
                Collections.reverse(result);
                return;
            }
            result.add(item2.board);
        }
    }

    // была ли уже такая позиция в пути
    private boolean containsInPath(ITEM item, Table board){
        ITEM item2 = item;
        while (true){
            if(item2.board.equals(board)) return true;
            item2 = item2.prevBoard;
            if(item2 == null) return false;
        }
    }


    public boolean isSolvable() {
        return true;
    }

    public int moves() {
        if(!isSolvable()) return -1;
        return result.size() - 1;
    }


    // result
    public Iterable<Table> solution() {
        return result;
    }


}