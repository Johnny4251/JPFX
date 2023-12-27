
package jpfx;

import javafx.application.Application;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class JPFX extends Application{
    boolean isOnGround = true;

    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage stage) {
        
        // Example usage
        Window window = new Window(stage, 640, 480);
        window.setPosX(-2000);
        window.setPosY(400);
        
        RectangleSprite player = new RectangleSprite(30, 60);
        player.setColor(Color.RED);
        player.setX(300);
        player.setY(340);
        player.setVelY(1);
        player.update(upd -> {
            if(window.getActiveKeys().contains(KeyCode.LEFT))
                player.moveX(-1);
            if(window.getActiveKeys().contains(KeyCode.RIGHT))
                player.moveX(1);
            if(window.getActiveKeys().contains(KeyCode.SPACE) && isOnGround) {
                player.setVelY(-100);
                isOnGround = false;
            }
        });
        
        
        RectangleSprite ground = new RectangleSprite(window.getWidth() - 300, 30);
        ground.setColor(Color.GREEN);
        ground.setY(window.getHeight() - ground.getHeight() + 10);
        
        RectangleSprite groundOne = new RectangleSprite(window.getWidth() - 300, 30);
        groundOne.setColor(Color.GREEN);
        groundOne.setY(window.getHeight() - ground.getHeight() + 10);
        groundOne.setX(ground.getX() + 400);
        
        Updater collisionDetection = upd -> {
           if(window.hasCollided(player, ground) || window.hasCollided(player, groundOne)) {
                player.setVelY(0);
                isOnGround = true;
            }
           else {
               player.setVelY(1);
           }
                
        };
        window.update(collisionDetection);
        
        
        
        window.addSprite(player);
        window.addSprite(ground);
        window.addSprite(groundOne);
        window.setBackground("background.jpeg");
        window.setTitle("JPFX Application");
        window.launch();
        
    }
    
}
