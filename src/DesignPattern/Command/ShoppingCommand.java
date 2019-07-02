package DesignPattern.Command;

public class ShoppingCommand extends Command {
  @Override
  public void execute(){
    System.out.println("zoo");
  }

  @Override
  public void undo(){
    System.out.println("undo zoo");
  }
}
