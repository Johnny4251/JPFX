/**
 * TODO:    
 *          COLLISION DETECTION
 *              -> Leaves Window
 *          COLOR SETTER
 */


package jpfx;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class RectangleSprite extends Sprite{

    private Rectangle body;
    
    private AnimationTimer updateTimer;
    
    private double velX;
    private double velY;
    
    public RectangleSprite() {}
    public RectangleSprite(double width, double height){
        body = new Rectangle(width, height);
    }
    
    public RectangleSprite(Rectangle body) {
        this.body = body;
    }
    
    public Node getBody(){ return body; }
    public void setBody(Rectangle body) {this.body = body; }
    
    @Override
    public double getVelX() {
        return velX;
    }

    @Override
    public void setVelX(double x) {
        velX = x;
    }

    @Override
    public double getVelY() {
        return velY;
    }

    @Override
    public void setVelY(double y) {
        velY = y;;
    }

    @Override
    public void setVelocity(double x, double y) {
        setVelX(x);
        setVelY(y);
    }
    
    @Override
    public double getX() {
        return body.getX();
    }

    @Override
    public void setX(double x) {
        body.setX(x);
    }

    @Override
    public double getY() {
        return body.getY();
    }

    @Override
    public void setY(double y) {
        body.setY(y);
    }

    public void setPosition(double x, double y) { 
        setX(x);
        setY(y);
    }
    
    @Override
    public double getWidth() {
        return body.getWidth();
    }
    @Override
    public void setWidth(double width) {
        body.setWidth(width);
    }

    @Override
    public double getHeight() {
        return body.getHeight();
    }
    @Override
    public void setHeight(double height) {
        body.setHeight(height);
    }

    public void setColor(Color c) { body.setFill(c); }
    
    public double getBottomPos() { return getY() + getHeight(); }
    public double getTopPos() { return getY(); }
    
    public double getRightPos() {return getX() + getWidth();}
    public double getLeftPos() {return getX(); }
    
    @Override
    public void startUpdate() {
        updateTimer.start();
    }

    @Override
    public void stopUpdate() {
        updateTimer.stop();
    }

    public void moveX(double velocity) { setX(body.getX() + velocity); }
    public void moveY(double velocity) { setY(body.getY() + velocity); }
    
    public void update(Updater upd) {
       updateTimer = new AnimationTimer() {
           @Override
           public void handle(long l) {
               upd.update(upd);
               moveY(velY);
               moveX(velX);
           }
           
       };
       updateTimer.start();
    }
    
     /**
     * Not recommended for scaling projects. But an easy solution
     * for quick project demos.
     */
    public void addDefaultMovement(Window window, double speedX, double speedY) 
    {
        this.update(upd -> {
            if(window.getActiveKeys().contains(Config.UP_KEY)) 
                moveY(-speedY);
            else if(window.getActiveKeys().contains(Config.RIGHT_KEY))
                moveX(speedX);
            else if(window.getActiveKeys().contains(Config.DOWN_KEY))
                moveY(speedY);
            else if(window.getActiveKeys().contains(Config.LEFT_KEY))
                moveX(-speedX);
            
        });
    }
    
    /**
     * Not recommended for scaling projects. But an easy solution
     * for quick project demos.
     */
    public void addDefaultDiagonalMovement(Window window, double speedX, double speedY)
    {
        this.update(upd -> {
            if(window.getActiveKeys().contains(Config.UP_KEY)
            && window.getActiveKeys().contains(Config.RIGHT_KEY)) {
                moveY(-speedY / 2);
                moveX(speedX / 2);
            }
            else if(window.getActiveKeys().contains(Config.DOWN_KEY)
            && window.getActiveKeys().contains(Config.RIGHT_KEY)) {
                moveY(speedY / 2);
                moveX(speedX / 2);
            }
            else if(window.getActiveKeys().contains(Config.DOWN_KEY)
            && window.getActiveKeys().contains(Config.LEFT_KEY)) {
                moveY(speedY / 2);
                moveX(-speedX / 2);
            }
            else if(window.getActiveKeys().contains(Config.UP_KEY)
            && window.getActiveKeys().contains(Config.LEFT_KEY)) {
                moveY(-speedY / 2);
                moveX(-speedX / 2);
            }
        });
    }
}
