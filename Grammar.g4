grammar Grammar;

@header { 
  import java.util.ArrayList;
  import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;
}

@members { 
    private HashMap<String,Variable> symbolTable = new HashMap<String, Variable>();
    private ArrayList<Variable> currentDecl = new ArrayList<Variable>();
    private Types currentType;
    private Types leftType = null, rightType = null;
    private Variable leftVariable = null;
    private Program program = new Program();
    private String strExpr = "";
    private IfCommand currentIfCommand;
    private AttrCommand currentAttr;
    private WhileCommand currentWhile;
    private DoWhileCommand currentDo;
    
    private Stack<ArrayList<Command>> stack = new Stack<ArrayList<Command>>();
    
    
    public void updateType(){
    	for(Variable v: currentDecl){
    	   v.setType(currentType);
    	   symbolTable.put(v.getId(), v);
    	}
    }
    public void exibirVariable(){
        for (String id: symbolTable.keySet()){
        	System.out.println(symbolTable.get(id));
        }
    }

    public boolean isVariable(String maybeVar) {
        for (String id: symbolTable.keySet()){
            if (symbolTable.get(id).getId().equals(maybeVar)) {
                return true;
            }
        }

        return false;
    }
    
    public Program getProgram(){
    	return this.program;
    	}
    
    public boolean isDeclared(String id){
    	return symbolTable.get(id) != null;
    }  
}

prog        : 'programa' ID     { program.setName(_input.LT(-1).getText());
                                  stack.push(new ArrayList<Command>()); }
              declara+ 
              cmd+
              'fimprog' END
                                //{ exibirVariable();}
                                { for(String id : symbolTable.keySet()) {
                                      if (!symbolTable.get(id).isUsed()) {
                                          throw new SemanticException("Unused variable " + symbolTable.get(id).getId() + " was found!");
                                      }
                                  }
                                }
                                { program.setSymbolTable(symbolTable);
                                  program.setCommandList(stack.pop()); }
            ;

declara     : 'declare'             { currentDecl.clear(); } 
               ID                   { currentDecl.add(new Variable(_input.LT(-1).getText()));}  //System.out.println("New Variable: " + _input.LT(-1).getText());
               (VIRGULA ID          { currentDecl.add(new Variable(_input.LT(-1).getText()));}  //System.out.println("New Variable: " + _input.LT(-1).getText());
               )*
               ':' ('number'        {currentType = Types.NUMBER;} 
               | 'string'           {currentType = Types.STRING;}
               )
                                    { updateType(); } 
               END    
            ;

cmd         : cmdLeitura END | cmdEscrita END | cmdIf | cmdAttr END | cmdWhile | cmdDoWhile
            ;

cmdLeitura  : 'leia' '(' 
              ID                { if (!isDeclared(_input.LT(-1).getText())) {
                                      throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                                  }
                                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                                  Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
                                  stack.peek().add(cmdRead); } 
              ')'
            ;

cmdEscrita  : 'escreva' '('       
              termo               { if (isVariable(_input.LT(-1).getText())) {
                                      if (symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
                                          symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                                      }
                                    }
                                  }
                                  //System.out.println(symbolTable.get(_input.LT(-1).getText()));
                                  //System.out.println(leftVariable);
                                  { Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
                                    stack.peek().add(cmdWrite); } 
              ')'                 { rightType = null; leftVariable = null;}
            ;            

cmdIf       : 'se'          { stack.push(new ArrayList<Command>());
                              strExpr = "";
                              currentIfCommand = new IfCommand(); 
                              leftVariable = null; } 
              '(' expr      
              OP_REL        { strExpr += _input.LT(-1).getText(); }
              expr 
              ')'           { currentIfCommand.setExpression(strExpr); }
              'entao' '{'   { leftVariable = null; }
              cmd+          { currentIfCommand.setTrueList(stack.pop()); }  
              '}'
              ('senao'      { stack.push(new ArrayList<Command>()); leftVariable = null; }
              '{' cmd+      { currentIfCommand.setFalseList(stack.pop()); } 
              '}')?         { stack.peek().add(currentIfCommand); }
            ;

cmdAttr     : ID            { currentAttr = new AttrCommand();
                              if (!isDeclared(_input.LT(-1).getText())) {
                                  throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                              }
                              symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
                              leftType = symbolTable.get(_input.LT(-1).getText()).getType(); 
                              leftVariable = new Variable (_input.LT(-1).getText(), leftType); 
                              currentAttr.setVar(_input.LT(-1).getText()); 
                              strExpr = "";}
              ':=' expr     { if (leftType.getValue() < rightType.getValue()){
                                  throw new SemanticException("Type Mismatch on Assignment");
                              }
                            }
                            //System.out.println("Left  Side Expression Type = "+leftType);
                            //System.out.println("Right Side Expression Type = "+rightType);
                            { currentAttr.setExpression(strExpr);
                              stack.peek().add(currentAttr);
                              strExpr = "";
                              leftVariable = null;}
            ;

cmdWhile    : 'enquanto'                    { stack.push(new ArrayList<Command>());
                                              strExpr = "";
                                              currentWhile = new WhileCommand(); 
                                              leftVariable = null; }
              '(' expr                      
              OP_REL                        { strExpr += _input.LT(-1).getText(); }
              expr 
              ')'                           { currentWhile.setExpression(strExpr); }
              '{'                           { leftVariable = null;}
              cmd+                          { currentWhile.setWhileList(stack.pop()); }
              '}'                           { stack.peek().add(currentWhile); }
            ;

cmdDoWhile  : 'faca'                        { stack.push(new ArrayList<Command>());
                                              strExpr = "";
                                              currentDo = new DoWhileCommand();
                                              leftVariable = null;}
              '{' cmd+                      { currentDo.setWhileList(stack.pop()); }
              '}'                     
              'enquanto' '('                { leftVariable = null;}
              expr 
              OP_REL                        { strExpr += _input.LT(-1).getText(); }
              expr 
              ')'                           { currentDo.setExpression(strExpr);
                                              stack.peek().add(currentDo); }
            ;

OP_REL      : '<' | '>' | '<=' | '>=' | '!=' | '=='
            ;

expr        : termo { strExpr += _input.LT(-1).getText(); } 
              exprl
            ;

exprl		: ( OP_MATH          { strExpr += _input.LT(-1).getText(); } 
          termo              { strExpr += _input.LT(-1).getText(); } 
          ) *
        ;

termo		: ID      { if (leftVariable == null && isDeclared(_input.LT(-1).getText())) {
                        leftVariable = new Variable(_input.LT(-1).getText(), symbolTable.get(_input.LT(-1).getText()).getType());
                    } else if (leftVariable.getId() != _input.LT(-1).getText()) {
                        if (symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
                          symbolTable.get(_input.LT(-1).getText()).setUsed(true);
                        }
                    }
                  }
                  { if (!isDeclared(_input.LT(-1).getText())) {
                       throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
                    }
                    if (!symbolTable.get(_input.LT(-1).getText()).isInitialized()){
                       throw new SemanticException("Variable "+_input.LT(-1).getText()+" has no value assigned");
                    }
                    if (rightType == null){
                       rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                       //System.out.println("Encontrei pela 1a vez uma variavel = "+rightType);
                    }   
                    else{
                       if (symbolTable.get(_input.LT(-1).getText()).getType().getValue() > rightType.getValue()){
                          rightType = symbolTable.get(_input.LT(-1).getText()).getType();
                          //System.out.println("Ja havia tipo declarado e mudou para = "+rightType);
                          
                       }
                    }
                  }   
			| NUM    {  if (rightType == null) {
			 				rightType = Types.NUMBER;
			 				//System.out.println("Encontrei um numero pela 1a vez "+rightType);
			            }
			            else{
			                if (rightType.getValue() < Types.NUMBER.getValue()){			                    			                   
			                	rightType = Types.NUMBER;
			                	//System.out.println("Mudei o tipo para Number = "+rightType);
			                }
			            }
			         }
			| STRING    {  if (rightType == null) {
			 				    rightType = Types.STRING;
			 				    //System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
			                } else {
			                    if (rightType.getValue() < Types.STRING.getValue()){			                    
			                	    rightType = Types.STRING;
			                	    //System.out.println("Mudei o tipo para STRING = "+rightType);
			                    }
			                }
			            }
			;

OP_MATH     : '+' | '-' | '*' | '/'
            ;

STRING      : '"' ([a-z] | [A-Z] | [0-9] | ',' | '.' | ' ' | '-' | '!' | ':' | ';' | '?' | '=')+ '"'
            ;

ID          : [a-z] ([a-z] | [A-Z] | [0-9])*
            ;

NUM         : [0-9]+ (VIRGULA [0-9]+)?
            ;

ESPACO      : (' ' | '\n' | '\r' | '\t') -> skip
            ;

VIRGULA     : ','
            ;

END         : '.'
            ;