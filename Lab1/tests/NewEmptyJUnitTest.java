/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.jme3.effect.ParticleEmitter;
import com.jme3.effect.ParticleMesh;
import com.jme3.input.FlyByCamera;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import mygame.VisualAppState;
import org.junit.Test;
import static org.junit.Assert.*;

import org.mockito.Mockito;


/**
 *
 * @author Professional
 */
public class NewEmptyJUnitTest {
    
    FlyByCamera flyCam;
    DirectionalLight light;
    boolean flyCamEnabled;
    ParticleEmitter Fire;

    public NewEmptyJUnitTest() {
        
        flyCam = Mockito.mock(FlyByCamera.class);
        
        Mockito.when(flyCam.isEnabled()).thenReturn(false);
        
        light = Mockito.mock(DirectionalLight.class);
        Mockito.when(light.getDirection()).thenReturn(new Vector3f(0, 1, 0));

        Fire = VisualAppState.InitFire(new ParticleEmitter("Emitter", ParticleMesh.Type.Triangle, 30) );
    }
    
    @Test
     public void flyCamEnabledTest() {    
        assert(flyCam.isEnabled() == false);
        assert(light.getDirection().x == 0);
        assert(light.getDirection().y == 1);
        assert(light.getDirection().z == 0);
    }
     
    @Test
     public void FireTest() {    
        assertTrue(Fire.getEndColor().a == 1f);
        assertTrue(Fire.getEndColor().b == 0f);
        assertTrue(Fire.getEndColor().g == 0f);
        assertTrue(Fire.getEndColor().r == 1f);
        assertTrue(Fire.getParticleInfluencer().getInitialVelocity().x == 0);
        assertTrue(Fire.getParticleInfluencer().getInitialVelocity().y == 2);
        assertTrue(Fire.getParticleInfluencer().getInitialVelocity().z == 0);
        assertTrue(Fire.getStartSize() == 0.5f);
        assertTrue(Fire.getEndSize() == 0.1f);
        assertTrue(Fire.getLowLife() == 0.5f);
        assertTrue(Fire.getHighLife() == 3f);
        assertTrue(Fire.getParticleInfluencer().getVelocityVariation() == 0.3f);
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
