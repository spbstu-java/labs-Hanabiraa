import java.io.IOException;

public abstract class AbstractMatrixBase {
    protected double[][] matrix;
    protected int rows;
    protected int cols;

    public AbstractMatrixBase() {
//        for more complex pipeline
    }

    public AbstractMatrixBase(int rowNum, int colNum) {
        this.rows = rowNum;
        this.cols = colNum;
        this.matrix = new double[this.rows][this.cols];
    }

    abstract void readMatrixFromFile(String path);

    abstract void writeMatrixToFile(String path, boolean add) throws IOException;
}
