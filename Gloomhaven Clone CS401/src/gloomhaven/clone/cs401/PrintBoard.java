package gloomhaven.clone.cs401;

public class PrintBoard {
    
    public void Print(Board board){
        
        Boolean pattern = true;
        int pattern1 = 0;
        int col = 2;
        
        for (int k = 0; k < 7; k++){
            System.out.print(k+1);
            System.out.print(" ");
        }
        
        System.out.print("\n1");
        
        for(int i = 0; i < 32; i++){
            if(pattern == true && pattern1 == 4){
                System.out.print("\n ");
                pattern = false;
                pattern1 = 0;
                System.out.print(col);
                col++;
            }else if (pattern == false && pattern1 == 3){
                System.out.println();
                pattern = true;
                pattern1 = 0;
                System.out.print(col);
                col++;
            }
            
            int j = board.CheckObjectTypeInTile(i);
            if(j == 0){
                System.out.print("⬡  ");
            }else if(j == 1){
                System.out.print("P  ");
            }else if(j == 2){
                System.out.print("E  ");
            }
            pattern1++;
        }
        
    }
    
}
