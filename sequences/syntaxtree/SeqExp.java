package syntaxtree;import visitor.Visitor;import visitor.TypeVisitor;public class SeqExp extends Exp {  public Exp e1;  public Exp e2;    public SeqExp(Exp ae1, Exp ae2, Position p) {    e1=ae1; e2=ae2; position=p;  }  public void accept(Visitor v) {    v.visit(this);  }  public Type accept(TypeVisitor v) {    return v.visit(this);  }}