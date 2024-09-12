package io.compiler.core.ast;

//import io.compiler.types.String;

public class AttrCommand extends Command{
    private String var;
    private String expression;

    public AttrCommand() {
        super();
    }

    public AttrCommand(String var, String expression) {
		super();
		this.var = var;
        this.expression = expression;
	}

    public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

    public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

    @Override
    public String generateTarget() {
        return var + " = " + expression.replace(',', '.') + ";\n";
    }
}
