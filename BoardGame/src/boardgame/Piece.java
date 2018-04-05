package boardgame;

import java.awt.Color;

public class Piece
{
    public Player player;
    public int layer;
    public int order;
    
    public Piece(Player p, int l, int o) {
        this.player = p;
        this.layer = l;
        this.order = o;
    }
    public boolean isEmpty(){
        if (player == null) return true;
        
        return false;
    }
    public void setEmpty(){
        player = null;
    }
    public void move(String l,String o){
        layer = Integer.valueOf(l);
        order = Integer.valueOf(o);
    }
    String getName(){
        return "L" + layer + "_" + order;
    }
}