package boardgame;

import java.awt.Color;

public class Piece
{
    public Player player;
    public Color color;
    public int layer;
    public int order;
    
    public Piece(Player p, int l, int o) {
        this.color = Color.WHITE;
        p = this.player;
        this.layer = l;
        this.order = o;
    }
}