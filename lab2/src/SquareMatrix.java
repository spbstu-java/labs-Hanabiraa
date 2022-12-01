import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SquareMatrix extends AbstractMatrixBase {
    private static final Logger logger = Logger.getLogger(SquareMatrix.class.getName());

    public SquareMatrix() {
        super();
    }

    public SquareMatrix(int size) {
        super(size, size);
    }

    @Override
    public void readMatrixFromFile(String path) throws NoFileOrAccessException, OutOfMemoryError {
        try (FileInputStream in = new FileInputStream(path)) {
            int size = new Scanner(in).nextInt();
            if (size < 0 || size > 1_000_000) {
                throw new MatrixMaxSizeException();
            }

            this.initMatrix(size);
            this.fillMatrixRandom();

        } catch (FileNotFoundException e) {
            throw new NoFileOrAccessException(path);
        } catch (OutOfMemoryError e) {
            logger.log(Level.WARNING, "Out of memory while reading!");
        } catch (InputMismatchException e) {
            logger.log(Level.WARNING, "size of matrix must be int!");
        } catch (NoSuchElementException e) {
            logger.log(Level.WARNING, "empty file for reading!");
        } catch (IOException e) {
            logger.log(Level.WARNING, "IO exception while reading!");
        }
    }

    @Override
    public void writeMatrixToFile(String path, boolean add) throws NoFileOrAccessException, OutOfMemoryError {
        try (FileWriter out = new FileWriter(path, add)) {
            for (int i = 0; i < this.rows; ++i) {
                for (int j = 0; j < this.cols; ++j) {
                    out.write(String.format("%+.2f", this.matrix[i][j]));
                    out.write(" ");
                }
                out.write("\n");
            }
            out.write("\n\n");
        } catch (FileNotFoundException e) {
            throw new NoFileOrAccessException(path);
        } catch (OutOfMemoryError e) {
            logger.log(Level.WARNING, "Out of memory while writing!");
            throw new OutOfMemoryError();
        } catch (IOException e) {
            logger.log(Level.WARNING, "IO exception while writing!");
        }
    }

    private void initMatrix(int size) {
        this.rows = size;
        this.cols = size;
        this.matrix = new double[this.rows][this.cols];
    }

    private void fillMatrixRandom() {
        Random generator = new Random();
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                this.matrix[i][j] = generator.nextDouble(this.rows * 2) - this.rows;
            }
        }
    }

    public void rotateBack90() {
        double[][] matrix = new double[this.rows][this.cols];
        for (int i = 0; i < this.rows; ++i) {
            for (int j = 0; j < this.cols; ++j) {
                matrix[i][j] = this.matrix[j][matrix.length - i - 1];
            }
        }
        this.matrix = matrix;
    }

    public void rotateBack180() {
        this.rotateBack90();
        this.rotateBack90();
    }

    public void rotateBack270() {
        this.rotateBack90();
        this.rotateBack90();
        this.rotateBack90();
    }

    public void divideAround() throws ZeroDivideException {
        double[][] matrix = this.matrix.clone();

        try {
            for (int i = 0; i < this.rows; ++i) {
                for (int j = 0; j < this.cols; ++j) {
                    double acc = 0;

                    if (i < this.rows - 1) {
                        acc += this.matrix[i + 1][j];
                    }

                    if (i > 0) {
                        acc += this.matrix[i - 1][j];
                    }

                    if (j < this.cols - 1) {
                        acc += this.matrix[i][j + 1];
                    }

                    if (j > 0) {
                        acc += this.matrix[i][j - 1];
                    }

                    if (acc == 0) {
                        throw new ZeroDivideException();
                    }
                    matrix[i][j] = this.matrix[i][j] / acc;
                }
            }
        } catch (ZeroDivideException e) {
            logger.log(Level.WARNING, "Divide by zero!");
            throw new ZeroDivideException();
        }


        this.matrix = matrix;
    }
}

