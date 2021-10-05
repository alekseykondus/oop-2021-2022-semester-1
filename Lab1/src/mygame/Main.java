package mygame;
 
import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseAxisTrigger;
import com.jme3.renderer.RenderManager;

public class Main extends SimpleApplication {
 
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
 
    public Main() { 
        visualAppState = new VisualAppState();
        
    }

    public VisualAppState visualAppState;
    @Override
    public void simpleInitApp() {
        flyCam.setEnabled(paused); 
        visualAppState.initialize(stateManager, this);
                
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
    }
 
    @Override
    public void simpleRender(RenderManager rm) {
      
    }
}