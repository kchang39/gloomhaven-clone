package gloomhaven.clone.cs401;

import java.util.List;
import java.util.ArrayList;

class boardLocation{
    
    private int pieceType = 0;
    //Piece type should use 0 for empty, 1 for player, and 2 for enemy
    private int party;
    
    public void changePieceType(int piece){
        pieceType = piece;
    }
    
    public int getPieceType(){
        return pieceType;
    }
    
    public void changePartyMember(int member){
        party = member;
    }
    
    public int getPartyMember(){
        return party;
    }
    
    public void Empty(){
        pieceType = 0;
        party = -1;
    }
    
}

public class Board {
    
    private ArrayList<ArrayList<boardLocation>> Tiles;
    private int xSize;
    private int ySize;
    
    public void initializeBoardSize(int xS, int yS){
        xSize = xS;
        ySize = yS;
        
        Tiles = new ArrayList<>(xSize);
        for(int i = 0; i < xSize; i++){
            Tiles.add(new ArrayList(ySize));
        }
    }
    
    public int getXsize(){
        return xSize;
    }
    
    public int getYsize(){
        return ySize;
    }
    
    public Boolean Move(int before_x, int before_y, int after_x, int after_y){
        
        Boolean validMove = true;
        
        int checkEmpty = Tiles.get(after_x).get(after_y).getPieceType();
        if(checkEmpty != 0){
            validMove = false;
        }else{
            int newType = Tiles.get(before_x).get(before_y).getPieceType();
            int partyMember = Tiles.get(before_x).get(before_y).getPartyMember();
            Tiles.get(after_x).get(after_y).changePieceType(newType);
            Tiles.get(after_x).get(after_y).changePartyMember(partyMember);
            Tiles.get(before_x).get(before_y).Empty();
        }
        
        return validMove;
    }
    
    public void updateTile(int x, int y, int type, int party){
        //Use type = 0 for empty tile, type = 1 for player, type = 2 for enemy
        Tiles.get(x).get(y).changePieceType(type);
        Tiles.get(x).get(y).changePartyMember(party);
        
    }
    
    public void emptyTile(int x, int y){
        Tiles.get(x).get(y).Empty();
    }
    
    public int CheckObjectTypeInTile(int x, int y){
        //Should return 0 for empty tile, 1 for player, and 2 for enemy
        return Tiles.get(x).get(y).getPieceType();
        
    }
    
    public int CheckPartyMember(int x, int y){
        return Tiles.get(x).get(y).getPartyMember();
    }
    
    public boolean isAdjacent(int x1, int y1, int x2, int y2){
        boolean adjacent = false;
        
        if(x1 == x2 || x1 == (x2 + 1) || x1 == (x2 - 1)){
            if (y1 == y2 || y1 == (y2 + 1) || y1 == (y2 - 1)){
                adjacent = true;
            }
        }
        
        return adjacent;
    }
    
}
