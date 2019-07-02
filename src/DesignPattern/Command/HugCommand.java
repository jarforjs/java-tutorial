package DesignPattern.Command;

public class HugCommand extends Command {
  @Override
  public void execute(){
    System.out.println("hug");
  }

  @Override
  public void undo(){
    System.out.println("open your arms");
  }
}
