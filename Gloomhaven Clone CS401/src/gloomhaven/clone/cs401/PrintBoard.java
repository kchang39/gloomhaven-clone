package gloomhaven.clone.cs401;

public class PrintBoard {
    
    public void Print(Board board){
        
        int x = board.getXsize();
        int y = board.getYsize();
        
        for (int k = 0; k < x; k++){
            System.out.print(k);
            System.out.print("  ");
        }
        
        System.out.print("\n1");
        
        for(int i = 0; i < y; i++){
            System.out.println();
            System.out.print(i);
            System.out.print("  ");
            for(int h = 0; h< x; h++){
            int j = board.CheckObjectTypeInTile(h, i);
                if(j == 0){
                    System.out.print("⬡  ");
                }else if(j == 1){
                    System.out.print("P  ");
                }else if(j == 2){
                    System.out.print("E  ");
                }
            }
        }
        
    }
    
}
