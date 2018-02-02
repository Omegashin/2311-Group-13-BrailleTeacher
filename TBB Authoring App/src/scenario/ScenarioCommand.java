package scenario;

import java.util.Arrays;

/**
 * Defines an event in a scenario.
 * 
 * @author DKozlovsky
 *
 */
public abstract class ScenarioCommand{
	
	
	private Object[] arguments;
	private EnumPossibleCommands command;
	
	
	public ScenarioCommand(EnumPossibleCommands command)
	{
		this.command = command;
	}
	
	/**
	 * Set the arguments for a specific command. Overwrites current arguments. 
	 *
	 * @param arguments The arguments to set. Must correspond to command, i.e: same amount of arguments
	 * and same types.
	 * Example: the disp_cell_char command must have arguments {Integer, String}.
	 * 
	 * @throws IllegalArgumentException If parameter conditions are not satisfied.
	 * 
	 */
	public void setArguments(Object[] arguments) throws IllegalArgumentException
	{
		if(arguments.length != command.getArgumentTypes().length)
		{
			throw new IllegalArgumentException("Invalid amount of arguments!");
		}
		//TODO fix argument type check. Current else if is wrong.
		else if(!Arrays.equals(arguments, command.getArgumentTypes()))
		{
			throw new IllegalArgumentException("Invalid types in argument");
		}
		else
		{
			this.arguments = arguments;
		}
	}
	
	/**
	 * Get the name of the command
	 * @return the name of the command
	 */
	public String getName()
	{
		return command.getName();
	}
	
	/**
	 * Get the description for the command
	 * @return the description of the command
	 */
	public String getDescription() 
	{
		return command.getDescription();
	}
	
	/**
	 * Get the command format
	 * @return the formatting of the command
	 */
	public String getFormat()
	{
		return command.getFormat();
	}
	/**
	 * get the arguments for a command
	 * @return the arguments
	 */
	public Object[] getArguments()
	{
		return this.arguments;
	}
	
	/**
	 * Gets the type of command that this ScenarioCommand is. 
	 * Does not return reference to actual command.
	 * 
	 * @return a copy of the command
	 */
	public EnumPossibleCommands getEnum()
	{
		EnumPossibleCommands e = command;
		return e;
		//TODO: Test privacy
	}

}
