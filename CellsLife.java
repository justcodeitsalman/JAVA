import java.util.Scanner;

class CellsLife
{
	public static void main(String[] args) 
	{
	   
	   System.out.print("Enter 2D array size : "); // Enter the size of array (matrix format) E.g rowsxcolumns=? i.e 2x2=4 
       Scanner sc=new Scanner(System.in);
       int rows=sc.nextInt();						//Input for no. rows 
       int columns=sc.nextInt();					//Input for no. of colums
       
       System.out.println("Enter array elements : ");    
        
       int cells[][]=new int[rows][columns];      // create object of array of given dimension 
        
          
        for(int i=0; i<rows;i++)				// loop to enter data in 2D array of size rowsXcolumns
         {            
            for(int j=0; j<columns;j++)
            {
                cells[i][j]=sc.nextInt();
            }
         }

        System.out.print("\nData you entered : \n"); // loop to print data in provided by user  
        for(int []x:cells){
            for(int y:x){
            System.out.print(y+"        ");
            }
            System.out.println();
        }

		nextGeneration(cells, rows, columns);       // call next generation based on user provided cells data
	}

	static void nextGeneration(int cells[][], int rows, int columns)
    {
        int[][] nextGenCells = new int[rows][columns];
  
        // Loop through every cell
        for (int l = 1; l < rows - 1; l++)
        {
            for (int m = 1; m < columns - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += cells[l + i][m + j];
  
                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= cells[l][m];
  
                // Implementing the Rules of Life
  
                // Cell is lonely and dies
                if ((cells[l][m] == 1) && (aliveNeighbours < 2))
                    nextGenCells[l][m] = 0;
  
                // Cell dies due to over population
                else if ((cells[l][m] == 1) && (aliveNeighbours > 3))
                    nextGenCells[l][m] = 0;
  
                // A new cell is born
                else if ((cells[l][m] == 0) && (aliveNeighbours == 3))
                    nextGenCells[l][m] = 1;
  
                // Remains the same
                else
                    nextGenCells[l][m] = cells[l][m];
            }
        }
  
	System.out.println("Next Generation");
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                if (nextGenCells[i][j] == 0)
                    System.out.print("0");
                else
                    System.out.print("1");
            }
            System.out.println();
        }

	}
}
