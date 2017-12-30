package com.eric.reflection;

/**
 * A WRONG example of child.
 * 
 * Creating a new instance variable "name" in this case would not work
 * because parent's printName() is looking at parent's instance
 * variable "name".
 * 
 * @author Eric Leung
 *
 */
public class ChildWrong extends Parent{
  private String name;
  
  @Override
  public void init() {
    name = "Child";
  }
}
