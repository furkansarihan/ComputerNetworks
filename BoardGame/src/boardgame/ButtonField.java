package boardgame;

import java.lang.reflect.Field;
import javax.swing.JButton;

public class ButtonField {
    JButton button;
    Field field;

    ButtonField(JButton b, Field f1) {
        this.button = b;
        this.field = f1;
    }
}