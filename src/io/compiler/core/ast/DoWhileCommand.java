package io.compiler.core.ast;

import java.util.List;

public class DoWhileCommand extends Command {
    private String expression;
    private List<Command> whileList;

    public DoWhileCommand() {
        super();
    }

    public DoWhileCommand(String expresssion, List<Command> whileList) {
        super();
        this.expression = expresssion;
        this.whileList = whileList;
    }

    public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

    public List<Command> getWhileList() {
		return whileList;
	}

	public void setWhileList(List<Command> whileList) {
		this.whileList = whileList;
	}

    @Override
    public String generateTarget() {
        StringBuilder str = new StringBuilder();

        str.append("do {\n");
		for (Command cmd: whileList) {
			str.append(cmd.generateTarget());
		}
        str.append("} while ("+expression.replace(',', '.')+")\n");

        return str.toString();
    }
}
