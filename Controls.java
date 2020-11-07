import java.util.Scanner;

public class Controls extends Main {

    static int size=9;
    public static void displaySudoku(int[][] sudokuMatrix)
    {
       // System.out.println("SUDOKO");
        int colCount=0;
        for(int i=0;i<size;i++) {
            int rowCount = 0;
            if (colCount % 3 == 0 && colCount != 0) {
                for (int k = 0; k < 3; k++)
                    System.out.print("____________ ");
            }
            System.out.println();

            for (int j = 0; j < size; j++) {
                if (rowCount % 3 == 0 && rowCount != 0)
                    System.out.print("| ");
                System.out.print(sudokuMatrix[i][j] + "   ");
                rowCount++;
            }
            colCount++;
            System.out.println();
        }
    }
    static int countCheck=0;
    public static boolean solve1(int[][] grid)
    {
        if(countCheck>20000)
            System.out.println(countCheck);
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(grid[i][j]==0)
                {
                    for(int num=1;num<10;num++)
                    {
                        if(isPossible(num,i,j,grid))
                        {
                            grid[i][j]=num;
                            countCheck++;
                            if(solve1(grid))
                                return true;
                        }
                        grid[i][j]=0;
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isPossible(int num,int row,int col,int[][] grid)
    {
        int r=row-row%3;
        int c=col-col%3;

        for(int i=r;i<r+3;i++)
        {
            for(int j=c;j<c+3;j++)
            {
                if(grid[i][j]==num)
                    return false;
            }
        }
        for(int i=0;i<size;i++) {
            if (grid[row][i] == num)
                return false;
            if (grid[i][col] == num)
                return false;
        }
        return true;
    }
    public static boolean solve2(int row , int col ,int[][] grid )
    {
        countCheck++;
        if(row==8 && col==9)
            return true;
        if(col==9)
        {
            row++;
            col=0;
        }
        if(grid[row][col]!=0)
            return solve2(row,col+1, grid);
        for(int num=1;num<10;num++)
        {
            if(isPossible(num,row,col,grid))
            {
                grid[row][col]=num;
                if(solve2(row,col+1, grid))
                    return true;
            }
            grid[row][col]=0;
        }
        if(countCheck>10000)
            System.out.println(countCheck);
        return false;
    }

    public static void readSudoku() {
        String sudoLine=null;
        boolean flag=true;
        System.out.println("Enter the sudoku inputs");
        Scanner s=new Scanner(System.in);
        sudoLine=s.nextLine();
        sudoLine=sudoLine.replaceAll(" ","");
        if(sudoLine.length()==81)
        {
            for(int i=0;i<sudoLine.length();i++)
            {
                flag = Character.isDigit(sudoLine.charAt(i));
                if(!flag)
                {
                    System.out.println("invalid sudoku input");
                    break;
                }
            }
            if(flag)
            {
                int k=0;
                for(int i=0;i<size;i++)
                {
                    for(int j=0;j<size;j++)
                    {
                        userGrid[i][j]=sudoLine.charAt(k)-48;
                        k++;
                    }
                }

            }
        }
        else
            System.out.println("input insufficient");
    }
}

