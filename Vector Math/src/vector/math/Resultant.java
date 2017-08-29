/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vector.math;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Saurav
 */
public class Resultant {
    
    static Vector2 initial = new Vector2(60.712f,144.38f);  //resultant of two initial vectors
    
    ArrayList<Vector2> resultants = new ArrayList<>(); //vector holding 6 vectors (initial + 5 additionals)
    
    private float mag;
    
    public Resultant(Vector2[] vectors) {
        resultants.add(initial);
        
        for(Vector2 vec : vectors) {
            resultants.add(vec);
        }
        
        mag = getInternalMag();
        
    }
    
    /**
     * Used to calculate the magnitude of the resultant vector of all the vectors in resultants
     * @return magnitude of resultant
     */
    private float getInternalMag() {
        Vector2 result = new Vector2(0,0);
        for(Vector2 v : resultants) {
            result.add(v);
        }
        
        return result.getMag();
    }
    
    
    public float getMagnitude() {
        return mag;
    }
    
    /**
     * If the System.our.println() method is called on a resultant var, this method is called
     * @return String Rep of this resultant
     */
    @Override
    public String toString() {
        ArrayList<Integer> ids = new ArrayList<>();
        Collections.sort(ids);
        
        String s = new String();
        for(Vector2 v: resultants) {
            if(v.id > 0)
                s +=v.id + ", ";
        }
        
        s += "= " + getMagnitude();
        
        return s;
    }
}
