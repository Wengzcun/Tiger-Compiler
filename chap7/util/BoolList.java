package util;

public class BoolList {
  public boolean head;
  public BoolList tail;
  ///In mini-java, no parameters ever escape (see p 127)! Never create a BoolList with parameter h = true.
  public BoolList(boolean h, BoolList t) {head=h; tail=t;}
}
