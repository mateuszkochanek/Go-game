package Server.Factory;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

import ClientApplication.GoGame.Entities.ClientMessages.Move;
import ClientApplication.GoGame.Entities.ClientMessages.Pass;
import ClientApplication.GoGame.Entities.ClientMessages.Surrender;

import static org.junit.Assert.assertThat;
import Server.Commands.Command;
import Server.Commands.MoveCommand;
import Server.Commands.PassCommand;
import Server.Commands.SurrenderCommand;
import Server.Commands.Factory.CommandFactory;
import Server.Commands.Factory.ConcreteCommandFactory;

public class FactoryTest {
    
    @Test
    public void messageTest() {
        CommandFactory factory = new ConcreteCommandFactory();
        
        Command command = factory.getCommand(new Move(0, 0));
        assertThat(command, instanceOf(MoveCommand.class));
        
        command = factory.getCommand(new Pass());
        assertThat(command, instanceOf(PassCommand.class));
        
        command = factory.getCommand(new Surrender());
        assertThat(command, instanceOf(SurrenderCommand.class));
    }
}
