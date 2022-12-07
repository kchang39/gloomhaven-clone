package gloomhaven.clone.cs401;

import java.util.List;
import java.util.ArrayList;

class boardLocation{
    
    private int pieceType = 0;
    private int player;
    private Enemy enemy;
    private int x;
    private int y;
    
    public void addX(int xCoord){
        x = xCoord;
    }
    
    public void addY(int yCoord){
        y = yCoord;
    }
    
    public void addPlayer(int play){
        
        player = play;
        pieceType = 1;
        
    }
    
    public void addEnemy(Enemy enem){
        
        enemy = enem;
        pieceType = 2;
        
    }
    
    public void removeObject(){
        
        player = -1;
        enemy = null;
        pieceType = 0;
        
    }
    
    public int getPieceType(){
        
        return pieceType;
        
    }
    
    public int getPlayer(){
        
        return player;
        
    }
    
    public Enemy getEnemy(){
        
        return enemy;
        
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
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
                int play = Tiles[before].getPlayer();
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
    
    public void updateTilePlayer(int player, int tile){
        
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
    
    public int checkPlayer(int tile){
        
        return Tiles[tile].getPlayer();
        
    }
    
    public Enemy checkEnemy(int tile){
        
        return Tiles[tile].getEnemy();
        
    }
    
}
