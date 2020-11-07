
public class Sudokugen {
     public static void genSudoku(int[][] grid)
     {
         fillDiagonal(grid);
         Controls.solve1(grid);
         removingCells(grid);
     }
     static int emptyPerBox=5;

     static boolean checkRowCol(int[][] grid,int row ,int col)
     {
         int r=0,c=0;
         for(int i=0;i<9;i++)
         {
             if(grid[row][i]==0)
                 r++;
             if(grid[i][col]==0)
                 c++;

         }
         if(row<=4||col<=4)
             return true;
         return false;
     }
      static void removingCells(int[][] grid) {
          emptyBox(grid,3,3);
          emptyBox(grid,0,0);
          emptyBox(grid,3,0);
          emptyBox(grid,6,0);
          emptyBox(grid,6,3);
      }

      static void emptyBox(int[][] grid,int row,int col) {
          int emptyCells=0;
          int r=row-row%3;
          int c=col-col%3;
          while(emptyCells<emptyPerBox)
          {
              int ran=ranNumCheck();
              emptycells(grid,r,c,ran);
              emptyCells++;
          }
          index=0;

    }
    static int index=0;
    static int[] a=new int[emptyPerBox];
    private static int ranNumCheck() {
        int ran;
        boolean bool=false,flag;
        do{
            flag=false;
            ran=randomGen();
            if(index==0)
            {
                a[index]=ran;
                index++;
                bool=true;
            }
            else
            {
                for (int i : a) {
                    if (i == ran) {
                        flag = true;
                        break;
                    }
                }
                if(!flag)
                {
                    a[index]=ran;
                    bool=true;
                    index++;
                }
            }
        }while(!bool);
        return ran;
    }

    static void emptycells(int[][] grid, int r, int c, int ran) {
         int count=1;
         outerloop:
         for(int i=r;i<r+3;i++)
         {
             for(int j=c;j<c+3;j++)
             {
                 if(ran==count)
                 {
                     grid[i][j]=0;
                     break outerloop;
                 }
                 count++;
             }
         }
    }

    static void fillDiagonal(int[][] grid)
     {
         int i=0;
         while(i!=9)
         {
             fillBox(i,i,grid);
             i+=3;
         }
     }

    private static void fillBox(int row, int col,int[][] grid) {
         int random;
         for(int i=row;i<row+3;i++)
         {
             for(int j=col;j<col+3;j++)
             {
                 do{
                     random=randomGen();
                 }while(!Controls.isPossible(random,row,col,grid));
                 grid[i][j]=random;
             }
         }
    }


     static int randomGen() {
         return (int)Math.floor(Math.random()*9+1);
    }
}
