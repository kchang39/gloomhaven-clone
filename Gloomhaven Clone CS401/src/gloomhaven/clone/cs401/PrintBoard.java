package gloomhaven.clone.cs401;

public class PrintBoard {
    
    public void Print(Board board){
        
        for (int k = 0; k < 12; k++){
            System.out.print(k);
            System.out.print("  ");
        }
        
        System.out.print("\n1");
        
        for(int i = 0; i < 12; i++){
            System.out.print(i);
            System.out.print("  ");
            for(int h = 0; h< 12; h++){
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
