import java.util.Scanner;

public class Main {
//5 3 0 0 7 0 0 0 0 6 0 0 1 9 5 0 0 0 0 9 8 0 0 0 0 6 0 8 0 0 0 6 0 0 0 3 4 0 0 8 0 3 0 0 1 7 0 0 0 2 0 0 0 6 0 6 0 0 0 0 2 8 0 0 0 0 4 1 9 0 0 5 0 0 0 0 8 0 0 7 9
    static int[][] grid={
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}};
    static int[][] userGrid=new int[9][9];
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.println("SUDOKO");
        System.out.println("Enter 1 for generating Sudoku nd 2 to solve Sudoku");
        int op=s.nextInt();
        if(op==1)
        {
            Sudokugen.genSudoku(userGrid);
            Controls.displaySudoku(userGrid);
        }
        else
        {
            Controls.readSudoku();
            Controls.solve1(userGrid);
            Controls.displaySudoku(userGrid);
        }
    }
}
