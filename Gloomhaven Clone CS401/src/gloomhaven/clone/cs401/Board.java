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
    
}

public class Board {
    
    private boardLocation[][] Tiles = new boardLocation[12][12];
    
    public Boolean Move(int before, int after){
        
        Boolean validMove = true;
        
        
        
        return validMove;
    }
    
    public void updateTile(int x, int y, int type, int party){
        //Use type = 0 for empty tile, type = 1 for player, type = 2 for enemy
        Tiles[x][y].changePieceType(type);
        Tiles[x][y].changePartyMember(party);
        
    }
    
    public int CheckObjectTypeInTile(int x, int y){
        //Should return 0 for empty tile, 1 for player, and 2 for enemy
        return Tiles[x][y].getPieceType();
        
    }
    
    public int CheckPartyMember(int x, int y){
        return Tiles[x][y].getPartyMember();
    }
    
}
