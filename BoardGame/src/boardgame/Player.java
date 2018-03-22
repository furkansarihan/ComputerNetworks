
package boardgame;

import java.util.ArrayList;

public class Player
{
    String name;
    ArrayList<Piece> pieces;
    boolean isOne;
    
    public Player(final boolean b) {
        super();
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
}
