package sk.upjs.paz1c.nezabudal.gui.forms;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Window;

/**
 *
 * @author Mikey
 */
class GuiUtilities {

    static void setPositionMiddle(Window parent, Window child) {
        Dimension dimParent = parent.getSize();
        Dimension dimThis = child.getSize();

        Point point = parent.getLocation();
        double x = point.getX() + dimParent.getWidth() / 2 - dimThis.getWidth() / 2;
        double y = point.getY() + dimParent.getHeight() / 2 - dimThis.getHeight() / 2;

        x = validateX(x);
        y = validateY(y);
        
        point.setLocation(x, y);
        child.setLocation(point);
    }


    private static double validateX(double x) {
        x = validateY(x);
        return x;
    }
    
    
    private static double validateY(double y) {
        if (y < 0) {
            y = 0;
        }
        return y;
    }
}
