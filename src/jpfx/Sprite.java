
package jpfx;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import javafx.scene.Node;

public abstract class Sprite extends Node implements Updater {

    public abstract double getVelX();
    public abstract void setVelX(double x);
    
    public abstract double getVelY();
    public abstract void setVelY(double y);
    
    public abstract double getX();
    public abstract void setX(double x);
    
    public abstract void setVelocity(double x, double y);
    
    public abstract double getY();
    public abstract void setY(double y);
    
    public abstract double getWidth();
    public abstract void setWidth(double width);
    
    public abstract double getHeight();
    public abstract void setHeight(double height);
    
    public abstract Node getBody();
    
    public abstract double getBottomPos();
    public abstract double getTopPos();
    
    public abstract double getRightPos();
    public abstract double getLeftPos();
    
    public abstract void startUpdate();
    public abstract void stopUpdate();
    
    public abstract void moveX(double velocity);
    public abstract void moveY(double velocity);
    
    public abstract void update(Updater upd);
    
    
    // OVERIDES
    @Override
    protected NGNode impl_createPeer() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public BaseBounds impl_computeGeomBounds(BaseBounds bb, BaseTransform bt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    protected boolean impl_computeContains(double d, double d1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Object impl_processMXNode(MXNodeAlgorithm mxna, MXNodeAlgorithmContext mxnac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
