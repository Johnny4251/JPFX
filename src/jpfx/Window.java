
package jpfx;

import java.util.HashSet;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Window {
    
    private static HashSet<KeyCode> activeKeys = new HashSet<>();
    
    private Stage window;
    private Scene scene;
    
    private AnimationTimer update;
    
    private Group view;
    private Rectangle bg;
    
    private int width;
    private int height;
    
    public Window(int width, int height) {
        this.width = width;
        this.height = height;
        view = new Group();
        setScene(createScene());
    }
    public Window(Stage window, int width, int height) { 
        this(width, height);
        this.window = window; 
    }
 
    public void setBackground(String url) {
        bg = new Rectangle(width + 20, height + 20);
        bg.setStyle("-fx-fill: url(\""+url+"\");");
        view.getChildren().add(bg);
        bg.toBack();
    }
    
    public void removeBackground() { view.getChildren().remove(bg); }
    
    public Group getView() { return view; }
    public void setView(Group view) { this.view = view; }
    
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    
    public void setWidth(int width) { this.width = width; }
    public void setHeight(int length) { this.height = length; }
    
    public void setPosX(int posX) { window.setX(posX); }
    public void setPosY(int posY) { window.setY(posY); }
    
    public void setStage(Stage s) { window = s; }
    public Stage getStage() { return window; }
    
    public void setScene(Scene s) { 
        scene = s;
    }
    public Scene getScene() { return scene; }
    public Scene createScene() { 
        scene = new Scene(view, width, height);
        scene.setOnKeyPressed(new KeyPressedHandler());
        scene.setOnKeyReleased(new KeyReleasedHandler());
        return scene;
    }
    
    public void close() { window.close(); }
    public void launch() { 
        window.setScene(scene);
        window.show(); 
    }
    
    public void addSprite(Sprite s) { view.getChildren().add(s.getBody()); }
    public void removeSprite(Sprite s) { view.getChildren().remove(s.getBody()); }
    
    public void addNode(Node n) { view.getChildren().add(n); }
    public void removeNode(Node n) { view.getChildren().remove(n); }
    
    public void startUpdate() { update.start(); }
    public void stopUpdate() { update.stop(); }
    
    public void setFullScreen(boolean flag) { window.setFullScreen(flag); }
    public void setResizable(boolean flag) { window.setResizable(flag); }
    
    public void setTitle(String s) { window.setTitle(s); }
    
    public HashSet<KeyCode> getActiveKeys() { return activeKeys; }
    
    public boolean hasCollided(Sprite one, Sprite two) {
        
        if(one.getBottomPos() >= two.getTopPos()
        && one.getTopPos() <= two.getBottomPos()
        && one.getRightPos() >= two.getLeftPos()
        && one.getLeftPos() <= two.getRightPos()
        ) {
            return true;
        }
        return false;
    }
    
    public void update(Updater upd) {
        update = new AnimationTimer() {
            public void handle(long now) {
                upd.update(upd);
            }
        };
        update.start();
    }
    
    class KeyPressedHandler implements EventHandler<KeyEvent> {
        public void handle(KeyEvent e) {
            activeKeys.add(e.getCode());
        }
    }
    
    class KeyReleasedHandler implements EventHandler<KeyEvent> {
        public void handle(KeyEvent e) {
            if(activeKeys.contains(e.getCode()))
                activeKeys.remove(e.getCode());
        }
    }
 }
