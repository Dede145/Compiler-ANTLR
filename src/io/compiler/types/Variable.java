package io.compiler.types;

public class Variable {
    private String id;
    private Types type;
	private boolean initialized;
	private boolean used;
	
	public Variable(String id, Types type) {
		super();
		this.id = id;
		this.type = type;
	}
	public Variable(String id) {
		super();
		this.id = id;
	}
	public Variable() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Types getType() {
		return type;
	}
	public void setType(Types type) {
		this.type = type;
	}
	public boolean isInitialized() {
		return initialized;
	}
	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	public boolean isUsed() {
		return used;
	}
	public void setUsed(boolean used) {
		this.used = used;
	}
	@Override
	public String toString() {
		return "Variable [id: " + id + ", type: " + type + ", initialized: " + initialized + ", was used: " + used + "]";
	}
}
