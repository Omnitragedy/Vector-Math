/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vector.math;

/**
 *
 * @author Saurav
 */
public class Vector2 {
    
    private float x, y;
    public final int id;
    
    public Vector2(float r, float theta) {
        x = r * (float)Math.cos(Math.toRadians(theta));
        y = r * (float)Math.sin(Math.toRadians(theta));
        
        id=-1;  //default value if no other value is later set
    }
    
    /**
     * Add a vector to this vector
     * @param v other vector to add
     * @return return the resulting Vector2
     */
    public Vector2 add(Vector2 v) {
        x += v.x;
        y += v.y;
        return this;
    }
    
    //set the id of vector
    public void setid(int id) {
        this.id = id;
    }
    
    //get the number of vector on our worksheet
    public int getid() {
        return id;
    }
    
    /**
     * Return the magnitude of this vector
     * @return the magnitude
     */
    public float getMag() {
        return (float)Math.sqrt(x*x + y*y);
    }
}
