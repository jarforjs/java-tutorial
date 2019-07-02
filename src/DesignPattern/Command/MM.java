package DesignPattern.Command;

public class MM {
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void order(GG gg){
    Command c1= new ShoppingCommand();
    gg.addCommand(c1);
    Command c2=new HugCommand();
    gg.addCommand(c2);
    gg.executeCommands();
  }
}
