package gloomhaven.clone.cs401;

import java.util.List;
import java.util.ArrayList;

class boardLocation{
    
    private int pieceType = 0;
    private Player player;
    private Enemy enemy;
    
    public void addPlayer(Player play){
        
        player = play;
        pieceType = 1;
        
    }
    
    public void addEnemy(Enemy enem){
        
        enemy = enem;
        pieceType = 2;
        
    }
    
    public void removeObject(){
        
        player = null;
        enemy = null;
        pieceType = 0;
        
    }
    
    public int getPieceType(){
        
        return pieceType;
        
    }
    
    public Player getPlayer(){
        
        return player;
        
    }
    
    public Enemy getEnemy(){
        
        return enemy;
        
    }
    
}

public class Board {
    
    private boardLocation[] Tiles = new boardLocation[32];
    
    public Boolean Move(int before, int after){
        
        Boolean validMove = true;
        
        int check = Tiles[after].getPieceType();
        if(check == 0){
            
            check = Tiles[before].getPieceType();
            if(check == 1){
                Player play = Tiles[before].getPlayer();
                Tiles[after].addPlayer(play);
                Tiles[before].removeObject();
            }else if(check == 2){
                Enemy enemy = Tiles[before].getEnemy();
                Tiles[after].addEnemy(enemy);
                Tiles[before].removeObject();
            }
            
        }else{
            validMove = false;
        }
        
        return validMove;
    }
    
    public void updateTilePlayer(Player player, int tile){
        
        Tiles[tile].addPlayer(player);
        
    }
    
    public void updateTileEnemy(Enemy enemy, int tile){
        
        Tiles[tile].addEnemy(enemy);
        
    }
    
    public void deadObject(int tile){
        
        Tiles[tile].removeObject();
        
    }
    
    public int CheckObjectTypeInTile(int tile){
        
        return Tiles[tile].getPieceType();
        
    }
    
    public Player checkPlayer(int tile){
        
        return Tiles[tile].getPlayer();
        
    }
    
    public Enemy checkEnemy(int tile){
        
        return Tiles[tile].getEnemy();
        
    }
    
}
