package com.epam.bp.matrix;

public class Matrix {

    public static final int RAND_MIN = 1;
    public static final int RAND_MAX = 10;
    private int[][] values;

    public Matrix(int rows, int cols) {
        if (rows < 1 || cols < 1) {
            throw new IllegalArgumentException("Dimensions of matrix must be greater than zero");
        }
        values = new int[rows][cols];
    }

    public int customRandom(int min, int max) {
        return (int) (Math.random()*(max-min+1)+min);
    }

    public void setValue(int row, int column, int value) {
        values[row][column] = value;
    }

    public int getValue(int row, int column) {
        return values[row][column];
    }

    public int getRowsCount() {
        return values.length;
    }

    public int getColumnsCount() {
        return values[0].length;
    }

    public void fill() {
        for (int i = 0; i < getRowsCount(); ++i) {
            for (int j = 0; j < getColumnsCount(); ++j) {
                setValue(i, j, customRandom(RAND_MIN, RAND_MAX));
            }
        }
    }

    public String matrixToString() {
        int rows = getRowsCount();
        int cols = getColumnsCount();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                result.append(getValue(i,j));
                result.append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public Matrix multiply(Matrix multiplier) {
        int thisRows = getRowsCount();
        int thisCols = getColumnsCount();
        int otherRows = multiplier.getRowsCount();
        int otherCols = multiplier.getColumnsCount();

        if (thisCols != otherRows) {
            throw new IllegalArgumentException("Matrices are not have arbitrary dimensions.");
        }
        Matrix result = new Matrix(thisRows, otherCols);

        for (int thisRow = 0; thisRow < thisRows; ++thisRow) {
            for (int otherCol = 0; otherCol < otherCols; ++otherCol) {
                for (int thisCol = 0; thisCol < thisCols; ++thisCol) {
                    result.values[thisRow][otherCol] += values[thisRow][thisCol]
                            * multiplier.getValue(thisCol, otherCol);
                }
            }
        }
        return result;
    }
}