package com.eric.reflection;

import java.lang.reflect.Field;

/**
 * Child class extending parent.
 * 
 * Normally this child class cannot access the parent's private variable.
 * We can use reflection to get around that.  Reflection is a powerful
 * tool so beware and try not to shoot yourself in the foot. 
 * 
 * @author Eric Leung
 *
 */
public class Child extends Parent {
  
  @Override
  public void init() {
    /* This line would work IF the parent's variable is protected instead of private */
    // name = "child"; 
    
    /* If changing the parent is not possible (for instance, legacy code),
     * reflection is an alternative.
     */ 
    
    try {
      // Get parent's private field "name"
      Field name = this.getClass().getSuperclass().getDeclaredField("name");
      
      // make it accessible
      name.setAccessible(true);
      
      // set it
      name.set(this, "child");
      
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
