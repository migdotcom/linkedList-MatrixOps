class CalculateMatrices {
    LinkedList2D matrixA;
    LinkedList2D matrixB;
    LinkedList2D outputMatrix;
    CalculateMatrices(LinkedList2D inputMatrixA){
        this.matrixA = inputMatrixA;
        outputMatrix = new LinkedList2D();
    }

    CalculateMatrices(LinkedList2D inputMatrixA, LinkedList2D inputMatrixB){
        this.matrixA = inputMatrixA;
        this.matrixB = inputMatrixB;
        outputMatrix = new LinkedList2D();
    }

    public CalculateMatrices AddOrSubtractMatrices(boolean add){
        int currentRow = 0;
        int currentColum = 0;
        for (currentRow = 0; currentRow < matrixA.row; currentRow++){
            for (currentColum = 0; currentColum < matrixA.column; currentColum++){
                double addingNode;
                if (add){
                    addingNode = matrixA.GetNode(matrixA, currentRow, currentColum).element + matrixB.GetNode(matrixB, currentRow, currentColum).element;
                }
                else{
                    addingNode = matrixA.GetNode(matrixA, currentRow, currentColum).element - matrixB.GetNode(matrixB, currentRow, currentColum).element;
                }

                outputMatrix.insert(outputMatrix, addingNode, currentRow);
            }
        }
        return this;
    }

    public CalculateMatrices Multiplication(){
        for (int currentRow = 0; currentRow < matrixA.row; currentRow++){
            for (int currentColum = 0; currentColum < matrixB.column; currentColum++){
                Node matrixAHeadRow = matrixA.GetNode(matrixA, currentRow, 0);
                Node matrixBHeadColum = matrixB.GetNode(matrixB, 0, currentColum);

                double calculateNode = 0;
                while (matrixAHeadRow != null){
                    calculateNode = calculateNode + matrixAHeadRow.element*matrixBHeadColum.element;
                    matrixAHeadRow = matrixAHeadRow.right;
                    matrixBHeadColum = matrixBHeadColum.down;
                }
                outputMatrix.insert(outputMatrix, calculateNode, currentRow);

            }
        }
        return this;
    }

    public CalculateMatrices Transpose(){
        for (int currentRow = 0; currentRow < matrixA.row; currentRow++){
            for (int currentColum = 0; currentColum < matrixB.column; currentColum++){
                Node matrixAHeadRow = matrixA.GetNode(matrixA, currentRow, 0);
                Node matrixBHeadColum = matrixA.GetNode(matrixA, 0, currentColum);

                double calculateNode = 0;
                while (matrixAHeadRow != null){
                    calculateNode =matrixBHeadColum.down.element;
                    matrixAHeadRow = matrixAHeadRow.right;
                    matrixBHeadColum = matrixBHeadColum.down;
                }
                outputMatrix.insert(outputMatrix, calculateNode, currentRow);

            }
        }
        return this;
    }


    public LinkedList2D GetOutputMatrix(){
        return outputMatrix;
    }
}
