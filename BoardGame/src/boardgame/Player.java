
package boardgame;

import java.util.ArrayList;
import javax.swing.JButton;

public class Player
{
    Player rival;
    String name;
    ArrayList<Piece> pieces;
    ArrayList<Piece> possibleSet = new ArrayList<>();
    boolean isOne;
    Piece from;
    Piece to;
    
    public Player(final boolean b) {
        this.pieces = new ArrayList();
        this.isOne = b;
        this.setDefaultPiece();
    }
    
    void setDefaultPiece() {
        if (this.isOne) {
            for (int i = 0; i < 4; ++i) {
                int j = 1;
                while (j < 4) {
                    final Piece p = new Piece(this, j, i);
                    this.pieces.add(p);
                    ++j;
                }
            }
        }
        else {
            for (int i = 4; i < 8; ++i) {
                int j = 1;
                while (j < 4) {
                    final Piece p = new Piece(this, j, i);
                    this.pieces.add(p);
                    ++j;
                }
            }
        }
    }
    
    void setRival(Player p){rival = p;}
    boolean playFrom(JButton b) {
        Piece pe;
        for (Piece p : pieces) {
            if(("L" + p.layer + "_" + p.order).equals(b.getName())) { fillPossibleSet(p.layer,p.order); from = p; return true;} // Finding piece
        }
        return false;
    }
    ArrayList<Piece> playTo(JButton b){
        return possibleSet;
    }
    public void fillPossibleSet(int layer, int order){
        
        if(layer == 0){
            possibleSet.removeAll(possibleSet);
            for (int i = 0; i < 8; i++) {
                possibleSet.add(new Piece(this,layer+1,order+i));
                possibleSet.add(new Piece(this,layer+2,order+i));
            }
        }else if(layer == 1){
            possibleSet.removeAll(possibleSet);
            possibleSet.add(new Piece(this,layer+1,order));
            possibleSet.add(new Piece(this,layer+2,order));
            possibleSet.add(new Piece(this,layer-1,0));
            if(order < 4){
                possibleSet.add(new Piece(this,layer,order+4));
            }else{
                possibleSet.add(new Piece(this,layer,order-4));
            }
            possibleSet.add(new Piece(this,layer,((order+1)%8)));
            possibleSet.add(new Piece(this,layer,((order+2)%8)));
            if(order == 0){
                possibleSet.add(new Piece(this,layer,7));
                possibleSet.add(new Piece(this,layer,6));
            }else if(order == 1){
                possibleSet.add(new Piece(this,layer,0));
                possibleSet.add(new Piece(this,layer,7));
            }else{
                possibleSet.add(new Piece(this,layer,order-1));
                possibleSet.add(new Piece(this,layer,order-2));
            }
        }else if(layer == 2){
            possibleSet.removeAll(possibleSet);
            possibleSet.add(new Piece(this,layer+1,order));
            possibleSet.add(new Piece(this,layer-1,order));
            possibleSet.add(new Piece(this,0,0));
            possibleSet.add(new Piece(this,layer,((order+1)%8)));
            possibleSet.add(new Piece(this,layer,((order+2)%8)));
            if(order == 0){
                possibleSet.add(new Piece(this,layer,7));
                possibleSet.add(new Piece(this,layer,6));
            }else if(order == 1){
                possibleSet.add(new Piece(this,layer,0));
                possibleSet.add(new Piece(this,layer,7));
            }else{
                possibleSet.add(new Piece(this,layer,order-1));
                possibleSet.add(new Piece(this,layer,order-2));
            }
        }else if(layer == 3){
            possibleSet.removeAll(possibleSet);
            possibleSet.add(new Piece(this,layer-1,order));
            possibleSet.add(new Piece(this,layer-2,order));
            
            possibleSet.add(new Piece(this,layer,((order+1)%8)));
            possibleSet.add(new Piece(this,layer,((order+2)%8)));
            if(order == 0){
                possibleSet.add(new Piece(this,layer,7));
                possibleSet.add(new Piece(this,layer,6));
            }else if(order == 1){
                possibleSet.add(new Piece(this,layer,0));
                possibleSet.add(new Piece(this,layer,7));
            }else{
                possibleSet.add(new Piece(this,layer,order-1));
                possibleSet.add(new Piece(this,layer,order-2));
            }
        }
    }
    
    boolean isHere(JButton b){
        Piece pe;
        for (Piece p : pieces) {
            if(("L" + p.layer + "_" + p.order).equals(b.getName())) { return true;} // is here ?
        }
        return false;
    }
}
