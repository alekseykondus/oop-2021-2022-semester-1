package mygame;
 
import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
  

/*The class implements the factory pattern. It creates Spatial elements */
public class ModelFactory {
    
    /*In the "create" method, the assetManager is used to load the model */
    private final AssetManager assetManager;
  
    /*constructor of ModelFactory class, takes assetManager as input */
    public ModelFactory(AssetManager assetManager) {
        this.assetManager = assetManager;
    }
    
    /*The main method of this class. Loads models */
    public Spatial create(String name) {
        Node visual = new Node("Visual");
        Node model = (Node) assetManager.loadModel("Models/" + name + ".j3o");
        visual.attachChild(model);
        return visual;
    }
}