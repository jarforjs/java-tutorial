package DesignPattern.Command;

import java.util.ArrayList;
import java.util.List;

public class GG {
  private String name;
  private List<Command> commands = new ArrayList<Command>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void pursue(MM mm){

  }

  public void doSomething(){

  }

  public void addCommand(Command command){
    this.commands.add(command);
  }

  public void executeCommands(){
    for(Command command:commands){
      command.execute();
    }
  }

  public void undoCommands(){

  }
}
