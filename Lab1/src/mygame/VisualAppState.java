package mygame;
 
import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;
import com.jme3.util.SkyFactory;
import java.util.Random;
 
/*Class for creating the visual state of the application. Inherits from AbstractAppState */
public class VisualAppState extends AbstractAppState {
    
    private SimpleApplication app;
    private ModelFactory modelFactory;
    
    /*Hidden ship and torpedo models*/
    private Spatial myShip, myTorpedo;
    
    /*The width of the game screen is stored */
    public int ScreenWidth;
    
    /*The height of the game screen is stored */
    public int ScreenHeight;
   
    @Override
    /*The method loads models, sets some settings and displays everything on the screen */
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app;
        
        ScreenWidth = app.getCamera().getWidth();
        ScreenHeight = app.getCamera().getHeight();
        
        DirectionalLight light = new DirectionalLight();
        light.setDirection(new Vector3f(0, 1, 0));
        this.app.getRootNode().addLight(light);
        
        modelFactory = new ModelFactory(this.app.getAssetManager());
        myShip = modelFactory.create("Ship/Ship");
        myShip.rotate(FastMath.HALF_PI, 0, 0);
        myShip.setLocalScale((float)0.1, (float)0.1, (float)0.1);
        
        Random rand = new Random();
        myTorpedo = modelFactory.create("Torpedo/Torpedo");
        myTorpedo.rotate(FastMath.HALF_PI, 0, 0);
        myTorpedo.setLocalScale((float)0.1, (float)0.1, (float)0.1);
        myTorpedo.setLocalTranslation( (int)((rand.nextBoolean())?1:(-1))*4, (int)((rand.nextBoolean())?1:(-1))*4, 0);

        this.app.getRootNode().attachChild(myShip);
        this.app.getRootNode().attachChild(myTorpedo);
               
        Spatial sky = SkyFactory.createSky(this.app.getAssetManager(), "Textures/Sky/Lagoon/lagoon_up.jpg", true);
        this.app.getRootNode().attachChild(sky);
    }
    
    /*The method calculates the required angle of rotation of the ship towards the cursor and performs this rotation */
    public void RotateBehindCursor() {
        //System.out.println("-------------------------");
                  
        Vector2f mouse = new Vector2f(app.getInputManager().getCursorPosition());
        Quaternion Rotation =  myShip.getLocalRotation();
                
        float dX = mouse.x-myShip.getLocalTranslation().getX()-ScreenWidth/2-
                   myShip.getLocalTranslation().x*(1440/11);
        float dY = mouse.y-myShip.getLocalTranslation().getY()-ScreenHeight/2-
                   myShip.getLocalTranslation().y*(900/8);
                                
        Quaternion position = new Quaternion();
        position.fromAngles(FastMath.HALF_PI, 0, FastMath.PI/2 + FastMath.atan2(dY, dX));
        myShip.setLocalRotation(position);
    }
 
    @Override
    /*This method implements the movement of the ship and the rocket. The method also rotates the rocket towards the ship*/
    public void update(float tpf) {
        //System.out.println("-------------------------");
        Vector2f mouse = new Vector2f(app.getInputManager().getCursorPosition());
        float x_Ship = myShip.getLocalTranslation().x;
        float y_Ship = myShip.getLocalTranslation().y;
          
        float dX = mouse.x-ScreenWidth/2 - x_Ship*(1440/11);
        float dY = mouse.y-ScreenHeight/2 - y_Ship*(900/8);
      
        float dX_Ship_Torpedo = x_Ship - myTorpedo.getLocalTranslation().x;
        float dY_Ship_Torpedo = y_Ship - myTorpedo.getLocalTranslation().y;
      
        Vector3f localTranslationShip = myShip.getLocalTranslation();
        Vector3f localTranslationTorpedo = myTorpedo.getLocalTranslation();

        if (FastMath.abs(dX) > 0.9 || FastMath.abs(dY) > 0.9) {
            myShip.setLocalTranslation( localTranslationShip.x + (float)0.000005*FastMath.sign(dX)*FastMath.abs(dX), localTranslationShip.y + (float)0.000005*FastMath.sign(dY)*FastMath.abs(dY), 0);
        }
      
        Quaternion positionTorpedo = new Quaternion();
        positionTorpedo.fromAngles(FastMath.HALF_PI, 0, FastMath.atan2(dY_Ship_Torpedo, dX_Ship_Torpedo));
        myTorpedo.setLocalRotation(positionTorpedo);
        myTorpedo.setLocalTranslation( localTranslationTorpedo.x + (float)0.0005*FastMath.sign(dX_Ship_Torpedo), localTranslationTorpedo.y + (float)0.0005*FastMath.sign(dY_Ship_Torpedo), 0);
        
        if (FastMath.abs(dX_Ship_Torpedo) < 0.9 || FastMath.abs(dY_Ship_Torpedo) < 0.9) {
        //бум. Проиграли
        }
    }
}