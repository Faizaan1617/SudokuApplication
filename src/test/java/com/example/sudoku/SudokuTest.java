package com.example.sudoku;

import com.example.sudoku.model.Sudoku;
import com.example.sudoku.service.SudokuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 * JUnit Test Cases for Sudoku 
 */
@SpringBootTest
public class SudokuTest {

    @Autowired
    private SudokuService sudokuService;
    Sudoku test = new Sudoku();

    @Test
    public void sudokuSuccess() {
        int[][] sudoku = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
                { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
                { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
                { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
                { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
                { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
                { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

        test.setSudoku(sudoku);
        boolean result = sudokuService.Sudoku(test);
        assertEquals(true, result);
    }

    @Test
    public void sudokuFailureRow() {
        int[][] sudoku = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 6, 7, 8, 9, 1, 2, 2 },
                { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
                { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
                { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
                { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
                { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
                { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

        test.setSudoku(sudoku);
        boolean result = sudokuService.Sudoku(test);
        assertEquals(false, result);
    }

    @Test
    public void sudokuFailureColumn() {
        int[][] sudoku = {
                { 4, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
                { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
                { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
                { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
                { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
                { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
                { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

        test.setSudoku(sudoku);
        boolean result = sudokuService.Sudoku(test);
        assertEquals(false, result);
    }

    @Test
    public void sudokuFailureGrid() {
        int[][] sudoku = {
                { 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 2, 3, 4, 5, 6, 7, 8, 9, 1 },
                { 3, 4, 5, 6, 7, 8, 9, 1, 2 },
                { 4, 5, 6, 7, 8, 9, 1, 2, 3 },
                { 5, 6, 7, 8, 9, 1, 2, 3, 4 },
                { 6, 7, 8, 9, 1, 2, 3, 4, 5 },
                { 7, 8, 9, 1, 2, 3, 4, 5, 6 },
                { 8, 9, 1, 2, 3, 4, 5, 6, 7 },
                { 9, 1, 2, 3, 4, 5, 6, 7, 8 } };

        test.setSudoku(sudoku);
        boolean result = sudokuService.Sudoku(test);
        assertEquals(false, result);
    }
}
