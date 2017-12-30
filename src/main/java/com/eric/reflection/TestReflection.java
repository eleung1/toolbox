package com.eric.reflection;

/**
 * This is a simulation of a legacy code scenario where the parent 
 * class has a private variable that is not accessible by child classes.
 * 
 * The goal is to call printName() and have the parent print "Parent"
 * and child print "Child" via the parent's instance variable name.
 * 
 * @author Eric Leung
 *
 */
public class TestReflection {

  public static void main(String[] args) {
    
    Parent p = new Parent();
    p.printName(); // print "Parent".  CORRECT
    
    Child c = new Child();
    c.printName(); // print "Child".  CORRECT
    
    ChildWrong cw = new ChildWrong();
    cw.printName(); // print null. WRONG
  }
}
