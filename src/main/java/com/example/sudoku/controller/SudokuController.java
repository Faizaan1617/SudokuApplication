package com.example.sudoku.controller;

import com.example.sudoku.model.Sudoku;
import com.example.sudoku.service.SudokuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
 *  Controller class to call Sudoku
 */
@RestController
@RequestMapping("api/v1/sudoku")
public class SudokuController {

    @Autowired
    SudokuService sudokuService;

    @PostMapping
    public ResponseEntity<Boolean> sudokuValidate(@RequestBody Sudoku sudoku){
        return  new ResponseEntity<>(sudokuService.Sudoku(sudoku), HttpStatus.CREATED);
    }

}
