package com.eric.reflection;

/**
 * Parent class with a private variable "name".
 * 
 * This is a simulation of a legacy code scenario where the parent 
 * class has a private variable that is not accessible by child classes.
 * 
 * The goal is to call printName() and have the parent print "Parent"
 * and child print "Child" via the parent's instance variable name.
 * 
 * @author Eric Leung
 *
 */
public class Parent {
  private String name;
  
  public void init() {
    name = "Parent";
  }
  
  public void printName() {
    init();
    System.out.println(String.format("My name is %s", name));
  }
}
