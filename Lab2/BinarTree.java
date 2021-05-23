package Lab2;
import java.util.Scanner;
import java.util.Stack;

public class BinarTree {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер масива:");
        String n1 = scanner.nextLine();
        System.out.println("Введите минимальное число масива:");
        String min_lim1 = scanner.nextLine();
        System.out.println("Введите максимальное число масива:");
        String max_lim1 = scanner.nextLine();
        if (n1.equals(""))
            n1 = "50";
        if (min_lim1.equals(""))
            min_lim1 = "-250";
        if (max_lim1.equals(""))
            max_lim1 = "1014";
        int n = Integer.parseInt(n1);
        int min_lim = Integer.parseInt(min_lim1);
        int max_lim = Integer.parseInt(max_lim1);
        int[] arr = new int[n];

        System.out.println("Исходный массив:");
        for (int i = 0; i < n; i++) {
            arr[i] = (int) ((Math.random() * (max_lim - min_lim)) + min_lim);
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
        for (int i=0;i<n;i++){
            tree.insertNode(arr[i]);
        }
       
        tree.printTree();
        tree.deleteNode(5);
        tree.printTree();

        Node foundNode = tree.findNodeByValue(3);
        if (foundNode==null){
            System.out.println("Элемента нет в дереве");
        } else {
            foundNode.printNode();
        }
    }
}
class Tree { 
    private Node rootNode; 

    public Tree() { 
        rootNode = null;
    }

    public Node findNodeByValue(int value) { 
        Node currentNode = rootNode; 
        while (currentNode.getValue() != value) { 
            if (value < currentNode.getValue()) { 
                currentNode = currentNode.getLeftChild();
            } else { 
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) { 
                return null; 
            }
        }
        return currentNode; 
    }

    public void insertNode(int value) { 
        Node newNode = new Node(); 
        newNode.setValue(value); 
        if (rootNode == null) { 
            rootNode = newNode;
        }
        else { 
            Node currentNode = rootNode; 
            Node parentNode;
            while (true) 
            {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {   
                    return;    
                }
                else  if (value < currentNode.getValue()) {   
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){ 
                        parentNode.setLeftChild(newNode); 
                        return;
                    }
                }
                else { 
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { 
                        parentNode.setRightChild(newNode);  
                        return; 
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) 
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) { 
            parentNode = currentNode;
            if (value < currentNode.getValue()) { 
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else { 
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false; 
        }

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) { 
            if (currentNode == rootNode) 
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null); 
            else
                parentNode.setRightChild(null);
        }
        else if (currentNode.getRightChild() == null) { 
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        }
        else if (currentNode.getLeftChild() == null) { 
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        }
        else { 
            Node heir = receiveHeir(currentNode);
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true; 
    }

    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild(); 
        while (currentNode != null) 
        {
            parentNode = heirNode;
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild(); 
        }
        if (heirNode != node.getRightChild()) 
        { 
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;
    }

    public void printTree() { 
        Stack globalStack = new Stack(); 
        globalStack.push(rootNode);
        int gaps = 32; 
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); 
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { 
                Node temp = (Node) globalStack.pop(); 
                if (temp != null) {
                    System.out.print(temp.getValue()); 
                    localStack.push(temp.getLeftChild()); 
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }
        System.out.println(separator);
    }
}

