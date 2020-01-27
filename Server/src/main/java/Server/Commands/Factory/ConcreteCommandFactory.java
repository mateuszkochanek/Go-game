package Server.Commands.Factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import ClientApplication.GoGame.Entities.ClientMessages.ClientMessage;
import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.Surrender;
import Server.Commands.Command;
import Server.Commands.MoveCommand;
import Server.Commands.PassCommand;
import Server.Commands.SurrenderCommand;

@Component
public class ConcreteCommandFactory implements CommandFactory {
  
  @Autowired
  ApplicationContext applicationContext;
	
    public Command getCommand(ClientMessage message) {
        
        if (message instanceof Move) {
          MoveCommand moveCommand = applicationContext.getBean(MoveCommand.class);
          moveCommand.setClientMessage(message);
          return moveCommand;
        } else if (message instanceof Surrender) {
          SurrenderCommand surrenderCommand = applicationContext.getBean(SurrenderCommand.class);
          surrenderCommand.setClientMessage(message);
          return surrenderCommand;
        } else if (message instanceof Pass) {
          PassCommand passCommand = applicationContext.getBean(PassCommand.class);
          passCommand.setClientMessage(message);
          return passCommand;
        }
        
        return null;
    }
}