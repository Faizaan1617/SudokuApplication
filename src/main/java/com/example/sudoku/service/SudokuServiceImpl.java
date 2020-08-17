package com.example.sudoku.service;

import com.example.sudoku.model.Sudoku;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/*
 *  Service class for Sudoku
 */
@Service
public class SudokuServiceImpl implements SudokuService {

    private static final int LEN = 9;

    @Override
    public boolean Sudoku(Sudoku sudoku) {
        if (sudokuValidator(sudoku.getSudoku())) 
            return true;
        
        return false;
    }

    /*
     * Sudoku Validator method 
     */
    private boolean sudokuValidator(int[][] sudoku) {
            for(int row = 0; row < LEN; row++){

                Set<Integer> rowHashSet = new HashSet<>();
                Set<Integer> colHashSet = new HashSet<>();
                Set<Integer> gridHashSet = new HashSet<>();

                for(int col = 0; col < LEN; col++){

                    int rowVal = 3 * (row / 3) + col / 3;
                    int colVal = 3 * (row % 3) + col % 3;

                    boolean checkRow = rowHashSet.add(sudoku[row][col]);
                    boolean checkCol = colHashSet.add(sudoku[col][row]);
                    boolean checkGrid = gridHashSet.add(sudoku[rowVal][colVal]);

                    if(!checkRow || !checkCol || !checkGrid)
                        return false;
                }
            }
            return true;
        }
}
