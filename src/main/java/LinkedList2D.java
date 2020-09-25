import java.io.*;
import java.util.Scanner;


public class LinkedList2D<E> {
    Node head;
    public int row;
    public int column;

    public LinkedList2D insert(LinkedList2D list, double inputData, int rowNumber){
        Node tempNode = new Node(inputData);
        tempNode.right = null;
        tempNode.down = null;

        if (list.head == null){
            list.head = tempNode;
        }
        else{
            Node currentNode = list.head;
            Node previousNode = currentNode;

            if (rowNumber > 0){
                // Iterate in row
                for(int i = 0; i < rowNumber; i++){
                    previousNode = currentNode;
                    currentNode = currentNode.down;
                }

                Node headRow = currentNode;
                Node previousHead = previousNode;

                if (headRow == null){
                    // When row does not exist
                    previousNode.down = tempNode;
                }
                else{
                    // Iterate in column
                    previousHead = previousHead.right;
                    while (headRow.right != null){
                        previousHead = previousHead.right;
                        headRow = headRow.right;
                    }
                    headRow.right = tempNode;
                    previousHead.down = tempNode;
                }

            }
            else{
                while (currentNode.right != null){
                    currentNode = currentNode.right;
                }
                currentNode.right = tempNode;
            }
        }

        return list;
    }

    public void printList(LinkedList2D list){
        Node headRow = list.head;
        while (headRow != null){
            Node currentNode = headRow;
            while (currentNode != null){
                System.out.print(currentNode.element + " ");
                currentNode = currentNode.right;
            }
            System.out.println("");
            headRow = headRow.down;

        }
    }


    public Node GetNode(LinkedList2D list, int row, int column){
        Node currentNodeRow = list.head;
        for (int i = 0; i< row; i++){
            currentNodeRow = currentNodeRow.down;
        }
        Node currentNodeColum = currentNodeRow;
        for (int i = 0; i < column; i++){
            currentNodeColum = currentNodeColum.right;
        }
        Node wantedNote = currentNodeColum;
        return wantedNote;
    }


    public LinkedList2D CalculateRowAndColum(LinkedList2D list){
        Node headRow = list.head;
        int rowCount = 0;
        int columCount = 0;
        int numberOfNode = 0;
        while (headRow != null){
            Node currentNode = headRow;
            while (currentNode != null){
                currentNode = currentNode.right;
                numberOfNode++;
            }
            headRow = headRow.down;
            rowCount++;
        }
        columCount = numberOfNode/rowCount;
        this.column = columCount;
        this.row = rowCount;
        return this;
    }




    public static void main(String[] args) throws IOException {
        LinkedList2D matrixA = new LinkedList2D();
        LinkedList2D matrixB = new LinkedList2D();

        try{
            String input1 = "src/test/resources/sample_input_output/1_a.txt";
            String input2 = "src/test/resources/sample_input_output/1_b.txt";
            File myObj = new File(input1);
            Scanner myReader = new Scanner(myObj);
            int rowCount = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] allData = data.split(" ");
                for (int i = 0; i < allData.length; i++){
                    matrixA.insert(matrixA, Double.parseDouble(allData[i]), rowCount);
                }
                rowCount++;
            }
            myReader.close();

            myObj = new File(input2);
            myReader = new Scanner(myObj);
            rowCount = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] allData = data.split(" ");
                for (int i = 0; i < allData.length; i++){
                    matrixB.insert(matrixB,Double.parseDouble(allData[i]), rowCount);
                }
                rowCount++;
            }
            myReader.close();
        }
        catch(FileNotFoundException e){}


//        matrixA.printList(matrixA);
        matrixA.CalculateRowAndColum(matrixA);
//        matrixB.printList(matrixB);
        matrixB.CalculateRowAndColum(matrixB);



        System.out.println("\\n");
        CalculateMatrices calculateMatrices = new CalculateMatrices(matrixA, matrixB);
        calculateMatrices.Multiplication();
        LinkedList2D outputMatrix = calculateMatrices.GetOutputMatrix();
        outputMatrix.printList(outputMatrix);


        System.out.println("Now Adding\\n");
        CalculateMatrices calculateMatrices1 = new CalculateMatrices(matrixA, matrixB);
        calculateMatrices1.AddOrSubtractMatrices(true);
        LinkedList2D addOutputMatrix = calculateMatrices1.GetOutputMatrix();
        System.out.println("\\n");

        addOutputMatrix.printList(addOutputMatrix);
        System.out.println("\\n");
    }
}


