package mygame;
 
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Spatial;
import com.jme3.light.DirectionalLight;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Matrix4f;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.renderer.Camera;
import com.jme3.scene.Node;
import com.jme3.ui.Picture;
import com.jme3.util.SkyFactory;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Toolkit;
import static org.graalvm.compiler.nodes.CallTargetNode.InvokeKind.Interface;

public class Main extends SimpleApplication {
 
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
 
    public Main() { 
        visualAppState = new VisualAppState();
        
    }
    /*public Spatial myVisual, myTorpedo;
    public int ScreenWidth;
    public int ScreenHeight;*/
    public VisualAppState visualAppState;
    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(paused); 
        visualAppState.initialize(stateManager, this);
        /*ScreenWidth = cam.getWidth();
        ScreenHeight = cam.getHeight();
        
        myVisual = assetManager.loadModel("Models/kapal/kapal.j3o");
        myVisual.rotate(FastMath.HALF_PI, 0, 0);
        myVisual.setLocalScale((float)0.1, (float)0.1, (float)0.1);
        
        DirectionalLight light = new DirectionalLight();
        light.setDirection(new Vector3f(0, 1, 0));
        rootNode.addLight(light);
        rootNode.attachChild(myVisual);
        
        
        myTorpedo = assetManager.loadModel("Models/Torpedo/Torpedo.j3o");
        myTorpedo.rotate(FastMath.HALF_PI, 0, 0);
        myTorpedo.setLocalScale((float)0.1, (float)0.1, (float)0.1);
        myTorpedo.setLocalTranslation( -4, -4, 0);
        rootNode.attachChild(myTorpedo);
        
        
        Spatial sky = SkyFactory.createSky(assetManager, "Textures/Sky/Lagoon/lagoon_up.jpg", true);
        rootNode.attachChild(sky);*/
                
        initKeys();
    }
 private void initKeys() {

        inputManager.addMapping("Rotate", new MouseAxisTrigger(MouseInput.AXIS_X, true)
                                        , new MouseAxisTrigger(MouseInput.AXIS_X, false)
                                        , new MouseAxisTrigger(MouseInput.AXIS_Y, true)
                                        , new MouseAxisTrigger(MouseInput.AXIS_Y, false));
        inputManager.addListener(analogListener, "Rotate");
    }
    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {

            if (name.equals("Rotate")) {
               visualAppState.RotateBehindCursor();
            }
        }
    };
    
    @Override
    public void simpleUpdate(float tpf) {
        visualAppState.update(tpf);
      /*  //System.out.println("-------------------------");
      Vector2f mouse = new Vector2f(inputManager.getCursorPosition());
      float x_Ship = myVisual.getLocalTranslation().x;
      float y_Ship = myVisual.getLocalTranslation().y;
      
      float dX = mouse.x-ScreenWidth/2 - x_Ship*(1440/11);
      float dY = mouse.y-ScreenHeight/2 - y_Ship*(900/8);
      
      float dX_Ship_Torpedo = x_Ship - myTorpedo.getLocalTranslation().x;
      float dY_Ship_Torpedo = y_Ship - myTorpedo.getLocalTranslation().y;
      
      System.out.println("dX_Ship_Torpedo = " + dX_Ship_Torpedo);
      System.out.println("dY_Ship_Torpedo = " + dY_Ship_Torpedo);
      
      Vector3f localTranslationShip = myVisual.getLocalTranslation();
      Vector3f localTranslationTorpedo = myTorpedo.getLocalTranslation();

      
      if (FastMath.abs(dX) > 0.9 || FastMath.abs(dY) > 0.9) {
        myVisual.setLocalTranslation( localTranslationShip.x + (float)0.000005*FastMath.sign(dX)*FastMath.abs(dX), localTranslationShip.y + (float)0.000005*FastMath.sign(dY)*FastMath.abs(dY), 0);
      }
      
      Quaternion positionTorpedo = new Quaternion();
      positionTorpedo.fromAngles(FastMath.HALF_PI, 0, FastMath.atan2(dY_Ship_Torpedo, dX_Ship_Torpedo));
      myTorpedo.setLocalRotation(positionTorpedo);
      myTorpedo.setLocalTranslation( localTranslationTorpedo.x + (float)0.0005*FastMath.sign(dX_Ship_Torpedo), localTranslationTorpedo.y + (float)0.0005*FastMath.sign(dY_Ship_Torpedo), 0);
      if (FastMath.abs(dX_Ship_Torpedo) < 0.9 || FastMath.abs(dY_Ship_Torpedo) < 0.9) {
      //бум. Проиграли
      }*/
    
    }
 
    @Override
    public void simpleRender(RenderManager rm) {
      
    }
}