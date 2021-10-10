package mygame;
 
import com.jme3.app.SimpleApplication;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.MouseAxisTrigger;

public class Main extends SimpleApplication {
    
    /**
     * Create an instance of our class  VisualAppState.
     */
    public VisualAppState visualAppState;
    
    /**
     * The main method of our class, creates an application and runs it.
     */
    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    /**
     * Class constructor.
     */
    public Main() { 
        visualAppState = new VisualAppState();
    }

    @Override
    /**
     * In the simpleInitApp() method, you load game objects before the game starts, 
     * Automatically called once at the beginning when the application starts.
     */
    public void simpleInitApp() {
        flyCam.setEnabled(paused); 
        visualAppState.initialize(stateManager, this);
                
        initKeys();
    }
    
    /**
     * Activating the listener for mouse movement, Here we map the name and the trigger.
     */
    private void initKeys() {
        inputManager.addMapping("Rotate", new MouseAxisTrigger(MouseInput.AXIS_X, true)
                                        , new MouseAxisTrigger(MouseInput.AXIS_X, false)
                                        , new MouseAxisTrigger(MouseInput.AXIS_Y, true)
                                        , new MouseAxisTrigger(MouseInput.AXIS_Y, false));
        inputManager.addListener(analogListener, "Rotate");
    }
    
    /**
     * Implementation of our listener.
     */
    private final AnalogListener analogListener = new AnalogListener() {
        @Override
        public void onAnalog(String name, float value, float tpf) {
            if (name.equals("Rotate")) {
               visualAppState.rotateBehindCursor();
            }
        }
    };
    
    @Override
    /**
     * Use the main event loop to trigger repeating actions.
     */
    public void simpleUpdate(float tpf) {
        visualAppState.update(tpf);
    }
}