A Sudoku is a puzzle which consists of a 9x9 grid of numbers ranging from 1-9. This grid is subdivided into smaller grids of dimensions 3x3.
The objective of the puzzle is to fill this grid with the numbers such that each digit only appears once in a row, column and in the
subdivided 3x3 grid. A matrix of ints is used to represent the grid.

The application is built on the following assumptions:
1. The value of any of the numbers on the grid is not less than 1 or greater than 9.
2. The grid is filled out, meaning that there are no empty spaces.

The Sudoku Application is a REST Spring boot application which uses Java 8 and spring boot version 2.3.3. 
The application receives an HTTP Post request from Postman which gives the input of the 9x9 grid of the numbers. 
Once the application receives the input, it invokes the method Sudoku which calls upon SudokuValidator method for the filled out matrix.

The logic starts of by accessing each row at a time. Once the row is accessed it instantiates three hash sets for the row, column and the sub grid. Next, it accesses each element of the row in consideration. Hash set is used because Hash sets do not accept duplicate entries. The add method returns a boolean value of true if the value that is being added into the set is unique and it returns a false value if the value is already present inside the hash set. Each value that is received in the input is added into a hash set after which it is validated for duplicacy against its respective row, column and grid and if it passes this validation a boolean response of true is returned, else false. 

As the row, column and sub grid for each element is checked at the same time, the time complexity of this code is O(n^2).

The test cases cover the following scenarios:
1. When valid input is given then returns success(true)
2. When invalid input with duplicate value in row is given then returns failure(false)
3. When invalid input with duplicate value in column is given then returns failure(false)
4. When invalid input with duplicate value in sub grid is given then returns failure(false)

Steps to run application:
1. Start the spring boot application.

2. Use below curl command to hit the application or you can use Postman.

curl --location --request POST 'localhost:8080/api/v1/sudoku' \
--header 'Content-Type: application/json' \
--data-raw '{
    "sudoku" : [
        [1, 2, 3, 4, 5, 6, 7, 8, 9],
        [4, 5, 6, 7, 8, 9, 1, 2, 3],
        [7, 8, 9, 1, 2, 3, 4, 5, 6],
        [2, 3, 4, 5, 6, 7, 8, 9, 1],
        [5, 6, 7, 8, 9, 1, 2, 3, 4],
        [8, 9, 1, 2, 3, 4, 5, 6, 7],
        [3, 4, 5, 6, 7, 8, 9, 1, 2],
        [6, 7, 8, 9, 1, 2, 3, 4, 5],
        [9, 1, 2, 3, 4, 5, 6, 7, 8]
    ]
}'

The HTTP response is true if the sudoku is valid or a false if its invalid.