package io.compiler.core.ast;

import io.compiler.types.Types;
import io.compiler.types.Variable;

public class ReadCommand extends Command {
    private Variable var;

	public ReadCommand() {
		super();
	}

	public ReadCommand(Variable var) {
		super();
		this.var = var;
	}

	public Variable getVar() {
		return var;
	}

	public void setVar(Variable var) {
		this.var = var;
	}

	@Override
	public String generateTarget() {
		return var.getId() + " = " + ((var.getType()==Types.NUMBER)?"scan.nextDouble();":"scan.nextLine();")+"\n";
	}
}
