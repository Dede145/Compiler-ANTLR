package io.compiler.core.ast;

import java.util.HashMap;
import java.util.List;

import io.compiler.types.Types;
import io.compiler.types.Variable;

public class Program {
    private String name;
	private HashMap<String, Variable> symbolTable;
	private List<Command> commandList;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public HashMap<String, Variable> getSymbolTable() {
		return symbolTable;
	}
	public void setSymbolTable(HashMap<String, Variable> symbolTable) {
		this.symbolTable = symbolTable;
	}
	public List<Command> getCommandList() {
		return commandList;
	}
	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}
	
	public String generateTarget() {
		StringBuilder str = new StringBuilder();
		str.append("import java.util.Scanner;\n");
		str.append("public class "+name+" { \n");
		str.append("   public static void main(String args[]) { \n");
		str.append("   Scanner scan = new Scanner(System.in);\n");
		for (String varId: symbolTable.keySet()) {
			Variable var = symbolTable.get(varId);
			if (var.getType() == Types.NUMBER) {
				str.append("	double ");
			} else {
				str.append("    String ");				
			}
			str.append(var.getId()+";\n");
		}
		
		for(Command cmd: commandList) {
			str.append(cmd.generateTarget());
		}
		str.append("   }\n");
		str.append("}");
		return str.toString();
	}
}
