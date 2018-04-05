
package boardgame;

import java.util.ArrayList;
import javax.swing.JButton;

public class Player
{
    Player rival;
    String name;
    ArrayList<Piece> pieces; // Should be hashset.
    ArrayList<Piece> possibleSet = new ArrayList<>();
    ArrayList<Move> scoreSet = new ArrayList<>();
    boolean canSet = true;
    boolean isOne;
    Piece from = null;     //Default is null
    Piece to = null;       //returns to null when movement is end
    
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
    Player getRival(){return rival;}
    boolean playFrom(JButton b) {
        Piece p;
        p = getPiece(b.getName());
        
        if(p == null) return false;
        else {
            fillAllSets(p);
            from = p;
            return true;
        }
    }
    
    public void fillAllSets(Piece p){
        int layer = p.layer, order = p.order;
        possibleSet.removeAll(possibleSet);
        scoreSet.removeAll(scoreSet);
        if(layer == 0){
            for (int i = 0; i < 8; i++) {
                possibleSet.add(new Piece(this,layer+1,order+i));
                possibleSet.add(new Piece(this,layer+2,order+i));
                if(rival.isHere(layer+1,order+i) && !this.isHere(layer+2,order+i) && !rival.isHere(layer+2,order+i)){
                    scoreSet.add(new Move(new Piece(this,layer+2,order+i),new Piece(this,layer+1,order+i)));
                }
            }
        }else if(layer == 1){
            possibleSet.add(new Piece(this,layer+1,order));
            possibleSet.add(new Piece(this,layer+2,order));
            if(rival.isHere(layer+1,order) && !this.isHere(layer+2,order) && !rival.isHere(layer+2,order)){
                    scoreSet.add(new Move(new Piece(this,layer+2,order),new Piece(this,layer+1,order)));
            }
            possibleSet.add(new Piece(this,layer-1,0));
            if(order < 4){
                possibleSet.add(new Piece(this,layer,order+4));
                if(rival.isHere(layer-1,0) && !this.isHere(layer,order+4) && !rival.isHere(layer,order+4)){
                    scoreSet.add(new Move(new Piece(this,layer,order+4),new Piece(this,0,0)));
                }
            }else{
                possibleSet.add(new Piece(this,layer,order-4));
                if(rival.isHere(layer-1,0) && !this.isHere(layer,order-4) && !rival.isHere(layer,order-4)){
                    scoreSet.add(new Move(new Piece(this,layer,order-4),new Piece(this,0,0)));
                }
            }
            possibleSet.add(new Piece(this,layer,((order+1)%8)));
            possibleSet.add(new Piece(this,layer,((order+2)%8)));
            if(rival.isHere(layer,((order+1)%8)) && !this.isHere(layer,((order+2)%8)) && !rival.isHere(layer,((order+2)%8))){
                    scoreSet.add(new Move(new Piece(this,layer,((order+2)%8)),new Piece(this,layer,((order+1)%8))));
            }
            if(order == 0){
                possibleSet.add(new Piece(this,layer,7));
                possibleSet.add(new Piece(this,layer,6));
                if(rival.isHere(layer,7) && !this.isHere(layer,6) && !rival.isHere(layer,6)){
                    scoreSet.add(new Move(new Piece(this,layer,6),new Piece(this,layer,7)));
                }
            }else if(order == 1){
                possibleSet.add(new Piece(this,layer,0));
                possibleSet.add(new Piece(this,layer,7));
                if(rival.isHere(layer,0) && !this.isHere(layer,7) && !rival.isHere(layer,7)){
                    scoreSet.add(new Move(new Piece(this,layer,7),new Piece(this,layer,0)));
                }
            }else{
                possibleSet.add(new Piece(this,layer,order-1));
                possibleSet.add(new Piece(this,layer,order-2));
                if(rival.isHere(layer,order-1) && !this.isHere(layer,order-2) && !rival.isHere(layer,order-2)){
                    scoreSet.add(new Move(new Piece(this,layer,order-2),new Piece(this,layer,order-1)));
                }
            }
        }else if(layer == 2 || layer == 3){
            if(layer == 2){
                possibleSet.add(new Piece(this,layer+1,order));
                possibleSet.add(new Piece(this,layer-1,order));
                possibleSet.add(new Piece(this,0,0));
                if(rival.isHere(layer-1,order) && !this.isHere(0,0) && !rival.isHere(0,0)){
                    scoreSet.add(new Move(new Piece(this,0,0),new Piece(this,layer-1,order)));
                }
            }else if(layer == 3){
                possibleSet.add(new Piece(this,layer-1,order));
                possibleSet.add(new Piece(this,layer-2,order));
                if(rival.isHere(layer-1,order) && !this.isHere(layer-2,order) && !rival.isHere(layer-2,order)){
                    scoreSet.add(new Move(new Piece(this,layer-2,order),new Piece(this,layer-1,order)));
                }
            }
            
            possibleSet.add(new Piece(this,layer,((order+1)%8)));
            possibleSet.add(new Piece(this,layer,((order+2)%8)));
            if(rival.isHere(layer,((order+1)%8)) && !this.isHere(layer,((order+2)%8)) && !rival.isHere(layer,((order+2)%8))){
                scoreSet.add(new Move(new Piece(this,layer,((order+2)%8)),new Piece(this,layer,((order+1)%8))));
            }
            if(order == 0){
                possibleSet.add(new Piece(this,layer,7));
                possibleSet.add(new Piece(this,layer,6));
                if(rival.isHere(layer,7) && !this.isHere(layer,6) && !rival.isHere(layer,6)){
                    scoreSet.add(new Move(new Piece(this,layer,6),new Piece(this,layer,7)));
                }
            }else if(order == 1){
                possibleSet.add(new Piece(this,layer,0));
                possibleSet.add(new Piece(this,layer,7));
                if(rival.isHere(layer,0) && !this.isHere(layer,7) && !rival.isHere(layer,7)){
                    scoreSet.add(new Move(new Piece(this,layer,7),new Piece(this,layer,0)));
                }
            }else{
                possibleSet.add(new Piece(this,layer,order-1));
                possibleSet.add(new Piece(this,layer,order-2));
                if(rival.isHere(layer,order-1) && !this.isHere(layer,order-2) && !rival.isHere(layer,order-2)){
                    scoreSet.add(new Move(new Piece(this,layer,order-2),new Piece(this,layer,order-1)));
                }
            }
        }
    }
    
    void defaultMoveTo(String b){
        for (Piece pe : possibleSet)
            if(pe.getName().equals(b))
                from.move(b.substring(1,2),b.substring(3));
    }
    void scoreMoveTo(String to){
        for (Move m : scoreSet){
            if(m.moving.getName().equals(to)) {
                this.rival.removePiece(m.scored);
                from.move(to.substring(1,2),to.substring(3));
            }
        }
    }
    void removePiece(Piece rem){
        for (Piece p : pieces) 
            if(rem.getName().equals(p.getName())) {pieces.remove(p); break;}
    }
    boolean isHere(String b){
        for (Piece p : pieces)
            if(p.getName().equals(b)) { return true;} // is here ?
        return false;
    }
    boolean isHere(int layer, int order){ // calls from inside
        for (Piece p : pieces)
            if(p.getName().equals("L" + layer + "_" + order)) { return true;} // is here ?
        return false;
    }
    boolean isEmptyAll(int layer, int order){ // calls from inside
        for (Piece p : pieces)
            if(p.getName().equals("L" + layer + "_" + order)) { return true;} // is here ?
        for (Piece p : this.rival.pieces)
            if(p.getName().equals("L" + layer + "_" + order)) { return true;} // is here ?
        return false;
    }
    boolean isInScoreSet(String b){
        for (Move m : scoreSet)
            if(m.moving.getName().equals(b)) { return true;} // in score set
        return false;
    }
    boolean isInPossibleSet(String b){
        for (Piece p : possibleSet)
            if(p.getName().equals(b)) { return true;} // in possible set
        return false;
    }
    boolean isScoreSetEmpty(String name){
        Piece p = getPiece(name);
        this.fillAllSets(p);
        if (scoreSet.isEmpty()) return true;
        else return false;
    }
    Piece getPiece(String name){
        for (Piece p : pieces) 
            if(p.getName().equals(name)) return p;
        return null;
    }
}
