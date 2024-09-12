// Generated from c:/Users/win/Documents/Projects Java/Compiler ANTLR/Grammar.g4 by ANTLR 4.13.1
 
  import java.util.ArrayList;
  import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, OP_REL=19, OP_MATH=20, STRING=21, ID=22, NUM=23, ESPACO=24, 
		VIRGULA=25, END=26;
	public static final int
		RULE_prog = 0, RULE_declara = 1, RULE_cmd = 2, RULE_cmdLeitura = 3, RULE_cmdEscrita = 4, 
		RULE_cmdIf = 5, RULE_cmdAttr = 6, RULE_cmdWhile = 7, RULE_cmdDoWhile = 8, 
		RULE_expr = 9, RULE_exprl = 10, RULE_termo = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "declara", "cmd", "cmdLeitura", "cmdEscrita", "cmdIf", "cmdAttr", 
			"cmdWhile", "cmdDoWhile", "expr", "exprl", "termo"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'programa'", "'fimprog'", "'declare'", "':'", "'number'", "'string'", 
			"'leia'", "'('", "')'", "'escreva'", "'se'", "'entao'", "'{'", "'}'", 
			"'senao'", "':='", "'enquanto'", "'faca'", null, null, null, null, null, 
			null, "','", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "OP_REL", "OP_MATH", "STRING", 
			"ID", "NUM", "ESPACO", "VIRGULA", "END"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	 
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

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode END() { return getToken(GrammarParser.END, 0); }
		public List<DeclaraContext> declara() {
			return getRuleContexts(DeclaraContext.class);
		}
		public DeclaraContext declara(int i) {
			return getRuleContext(DeclaraContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(24);
			match(T__0);
			setState(25);
			match(ID);
			 program.setName(_input.LT(-1).getText());
			                                  stack.push(new ArrayList<Command>()); 
			setState(28); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(27);
				declara();
				}
				}
				setState(30); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 );
			setState(33); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(32);
				cmd();
				}
				}
				setState(35); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4590720L) != 0) );
			setState(37);
			match(T__1);
			setState(38);
			match(END);
			 for(String id : symbolTable.keySet()) {
			                                      if (!symbolTable.get(id).isUsed()) {
			                                          throw new SemanticException("Unused variable " + symbolTable.get(id).getId() + " was found!");
			                                      }
			                                  }
			                                
			 program.setSymbolTable(symbolTable);
			                                  program.setCommandList(stack.pop()); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclaraContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(GrammarParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GrammarParser.ID, i);
		}
		public TerminalNode END() { return getToken(GrammarParser.END, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(GrammarParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(GrammarParser.VIRGULA, i);
		}
		public DeclaraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declara; }
	}

	public final DeclaraContext declara() throws RecognitionException {
		DeclaraContext _localctx = new DeclaraContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_declara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(T__2);
			 currentDecl.clear(); 
			setState(44);
			match(ID);
			 currentDecl.add(new Variable(_input.LT(-1).getText()));
			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(46);
				match(VIRGULA);
				setState(47);
				match(ID);
				 currentDecl.add(new Variable(_input.LT(-1).getText()));
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
			match(T__3);
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(55);
				match(T__4);
				currentType = Types.NUMBER;
				}
				break;
			case T__5:
				{
				setState(57);
				match(T__5);
				currentType = Types.STRING;
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			 updateType(); 
			setState(62);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdContext extends ParserRuleContext {
		public CmdLeituraContext cmdLeitura() {
			return getRuleContext(CmdLeituraContext.class,0);
		}
		public TerminalNode END() { return getToken(GrammarParser.END, 0); }
		public CmdEscritaContext cmdEscrita() {
			return getRuleContext(CmdEscritaContext.class,0);
		}
		public CmdIfContext cmdIf() {
			return getRuleContext(CmdIfContext.class,0);
		}
		public CmdAttrContext cmdAttr() {
			return getRuleContext(CmdAttrContext.class,0);
		}
		public CmdWhileContext cmdWhile() {
			return getRuleContext(CmdWhileContext.class,0);
		}
		public CmdDoWhileContext cmdDoWhile() {
			return getRuleContext(CmdDoWhileContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cmd);
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(64);
				cmdLeitura();
				setState(65);
				match(END);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(67);
				cmdEscrita();
				setState(68);
				match(END);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(70);
				cmdIf();
				}
				break;
			case ID:
				enterOuterAlt(_localctx, 4);
				{
				setState(71);
				cmdAttr();
				setState(72);
				match(END);
				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 5);
				{
				setState(74);
				cmdWhile();
				}
				break;
			case T__17:
				enterOuterAlt(_localctx, 6);
				{
				setState(75);
				cmdDoWhile();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdLeituraContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public CmdLeituraContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeitura; }
	}

	public final CmdLeituraContext cmdLeitura() throws RecognitionException {
		CmdLeituraContext _localctx = new CmdLeituraContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_cmdLeitura);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__6);
			setState(79);
			match(T__7);
			setState(80);
			match(ID);
			 if (!isDeclared(_input.LT(-1).getText())) {
			                                      throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                                  }
			                                  symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                                  Command cmdRead = new ReadCommand(symbolTable.get(_input.LT(-1).getText()));
			                                  stack.peek().add(cmdRead); 
			setState(82);
			match(T__8);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdEscritaContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public CmdEscritaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscrita; }
	}

	public final CmdEscritaContext cmdEscrita() throws RecognitionException {
		CmdEscritaContext _localctx = new CmdEscritaContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cmdEscrita);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__9);
			setState(85);
			match(T__7);
			setState(86);
			termo();
			 if (isVariable(_input.LT(-1).getText())) {
			                                      if (symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
			                                          symbolTable.get(_input.LT(-1).getText()).setUsed(true);
			                                      }
			                                    }
			                                  
			 Command cmdWrite = new WriteCommand(_input.LT(-1).getText());
			                                    stack.peek().add(cmdWrite); 
			setState(89);
			match(T__8);
			 rightType = null; leftVariable = null;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdIfContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdIf; }
	}

	public final CmdIfContext cmdIf() throws RecognitionException {
		CmdIfContext _localctx = new CmdIfContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cmdIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(T__10);
			 stack.push(new ArrayList<Command>());
			                              strExpr = "";
			                              currentIfCommand = new IfCommand(); 
			                              leftVariable = null; 
			setState(94);
			match(T__7);
			setState(95);
			expr();
			setState(96);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(98);
			expr();
			setState(99);
			match(T__8);
			 currentIfCommand.setExpression(strExpr); 
			setState(101);
			match(T__11);
			setState(102);
			match(T__12);
			 leftVariable = null; 
			setState(105); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(104);
				cmd();
				}
				}
				setState(107); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4590720L) != 0) );
			 currentIfCommand.setTrueList(stack.pop()); 
			setState(110);
			match(T__13);
			setState(122);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(111);
				match(T__14);
				 stack.push(new ArrayList<Command>()); leftVariable = null; 
				setState(113);
				match(T__12);
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(114);
					cmd();
					}
					}
					setState(117); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4590720L) != 0) );
				 currentIfCommand.setFalseList(stack.pop()); 
				setState(120);
				match(T__13);
				}
			}

			 stack.peek().add(currentIfCommand); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdAttrContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public CmdAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAttr; }
	}

	public final CmdAttrContext cmdAttr() throws RecognitionException {
		CmdAttrContext _localctx = new CmdAttrContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_cmdAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(ID);
			 currentAttr = new AttrCommand();
			                              if (!isDeclared(_input.LT(-1).getText())) {
			                                  throw new SemanticException("Undeclared Variable: "+_input.LT(-1).getText());
			                              }
			                              symbolTable.get(_input.LT(-1).getText()).setInitialized(true);
			                              leftType = symbolTable.get(_input.LT(-1).getText()).getType(); 
			                              leftVariable = new Variable (_input.LT(-1).getText(), leftType); 
			                              currentAttr.setVar(_input.LT(-1).getText()); 
			                              strExpr = "";
			setState(128);
			match(T__15);
			setState(129);
			expr();
			 if (leftType.getValue() < rightType.getValue()){
			                                  throw new SemanticException("Type Mismatch on Assignment");
			                              }
			                            
			 currentAttr.setExpression(strExpr);
			                              stack.peek().add(currentAttr);
			                              strExpr = "";
			                              leftVariable = null;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdWhileContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdWhile; }
	}

	public final CmdWhileContext cmdWhile() throws RecognitionException {
		CmdWhileContext _localctx = new CmdWhileContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_cmdWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__16);
			 stack.push(new ArrayList<Command>());
			                                              strExpr = "";
			                                              currentWhile = new WhileCommand(); 
			                                              leftVariable = null; 
			setState(135);
			match(T__7);
			setState(136);
			expr();
			setState(137);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(139);
			expr();
			setState(140);
			match(T__8);
			 currentWhile.setExpression(strExpr); 
			setState(142);
			match(T__12);
			 leftVariable = null;
			setState(145); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(144);
				cmd();
				}
				}
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4590720L) != 0) );
			 currentWhile.setWhileList(stack.pop()); 
			setState(150);
			match(T__13);
			 stack.peek().add(currentWhile); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CmdDoWhileContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP_REL() { return getToken(GrammarParser.OP_REL, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdDoWhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdDoWhile; }
	}

	public final CmdDoWhileContext cmdDoWhile() throws RecognitionException {
		CmdDoWhileContext _localctx = new CmdDoWhileContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_cmdDoWhile);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(153);
			match(T__17);
			 stack.push(new ArrayList<Command>());
			                                              strExpr = "";
			                                              currentDo = new DoWhileCommand();
			                                              leftVariable = null;
			setState(155);
			match(T__12);
			setState(157); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(156);
				cmd();
				}
				}
				setState(159); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4590720L) != 0) );
			 currentDo.setWhileList(stack.pop()); 
			setState(162);
			match(T__13);
			setState(163);
			match(T__16);
			setState(164);
			match(T__7);
			 leftVariable = null;
			setState(166);
			expr();
			setState(167);
			match(OP_REL);
			 strExpr += _input.LT(-1).getText(); 
			setState(169);
			expr();
			setState(170);
			match(T__8);
			 currentDo.setExpression(strExpr);
			                                              stack.peek().add(currentDo); 
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public TermoContext termo() {
			return getRuleContext(TermoContext.class,0);
		}
		public ExprlContext exprl() {
			return getRuleContext(ExprlContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			termo();
			 strExpr += _input.LT(-1).getText(); 
			setState(175);
			exprl();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprlContext extends ParserRuleContext {
		public List<TerminalNode> OP_MATH() { return getTokens(GrammarParser.OP_MATH); }
		public TerminalNode OP_MATH(int i) {
			return getToken(GrammarParser.OP_MATH, i);
		}
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public ExprlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprl; }
	}

	public final ExprlContext exprl() throws RecognitionException {
		ExprlContext _localctx = new ExprlContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_exprl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OP_MATH) {
				{
				{
				setState(177);
				match(OP_MATH);
				 strExpr += _input.LT(-1).getText(); 
				setState(179);
				termo();
				 strExpr += _input.LT(-1).getText(); 
				}
				}
				setState(186);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermoContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GrammarParser.ID, 0); }
		public TerminalNode NUM() { return getToken(GrammarParser.NUM, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_termo);
		try {
			setState(194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				match(ID);
				 if (leftVariable == null && isDeclared(_input.LT(-1).getText())) {
				                        leftVariable = new Variable(_input.LT(-1).getText(), symbolTable.get(_input.LT(-1).getText()).getType());
				                    } else if (leftVariable.getId() != _input.LT(-1).getText()) {
				                        if (symbolTable.get(_input.LT(-1).getText()).isInitialized()) {
				                          symbolTable.get(_input.LT(-1).getText()).setUsed(true);
				                        }
				                    }
				                  
				 if (!isDeclared(_input.LT(-1).getText())) {
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
				break;
			case NUM:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(NUM);
				  if (rightType == null) {
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
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(192);
				match(STRING);
				  if (rightType == null) {
							 				    rightType = Types.STRING;
							 				    //System.out.println("Encontrei pela 1a vez um texto ="+ rightType);
							                } else {
							                    if (rightType.getValue() < Types.STRING.getValue()){			                    
							                	    rightType = Types.STRING;
							                	    //System.out.println("Mudei o tipo para STRING = "+rightType);
							                    }
							                }
							            
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001a\u00c5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000\u001d\b\u0000"+
		"\u000b\u0000\f\u0000\u001e\u0001\u0000\u0004\u0000\"\b\u0000\u000b\u0000"+
		"\f\u0000#\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0005\u00012\b\u0001\n\u0001\f\u00015\t\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001<\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002M\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0004\u0005j\b\u0005\u000b\u0005\f\u0005k\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0004"+
		"\u0005t\b\u0005\u000b\u0005\f\u0005u\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005{\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0004\u0007"+
		"\u0092\b\u0007\u000b\u0007\f\u0007\u0093\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0004\b\u009e\b\b\u000b"+
		"\b\f\b\u009f\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0005\n\u00b7\b\n\n\n\f\n\u00ba\t\n"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u00c3\b\u000b\u0001\u000b\u0000\u0000\f\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0000\u0000\u00c9"+
		"\u0000\u0018\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000\u0004"+
		"L\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000\u0000\bT\u0001\u0000"+
		"\u0000\u0000\n\\\u0001\u0000\u0000\u0000\f~\u0001\u0000\u0000\u0000\u000e"+
		"\u0085\u0001\u0000\u0000\u0000\u0010\u0099\u0001\u0000\u0000\u0000\u0012"+
		"\u00ad\u0001\u0000\u0000\u0000\u0014\u00b8\u0001\u0000\u0000\u0000\u0016"+
		"\u00c2\u0001\u0000\u0000\u0000\u0018\u0019\u0005\u0001\u0000\u0000\u0019"+
		"\u001a\u0005\u0016\u0000\u0000\u001a\u001c\u0006\u0000\uffff\uffff\u0000"+
		"\u001b\u001d\u0003\u0002\u0001\u0000\u001c\u001b\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000"+
		"\u001e\u001f\u0001\u0000\u0000\u0000\u001f!\u0001\u0000\u0000\u0000 \""+
		"\u0003\u0004\u0002\u0000! \u0001\u0000\u0000\u0000\"#\u0001\u0000\u0000"+
		"\u0000#!\u0001\u0000\u0000\u0000#$\u0001\u0000\u0000\u0000$%\u0001\u0000"+
		"\u0000\u0000%&\u0005\u0002\u0000\u0000&\'\u0005\u001a\u0000\u0000\'(\u0006"+
		"\u0000\uffff\uffff\u0000()\u0006\u0000\uffff\uffff\u0000)\u0001\u0001"+
		"\u0000\u0000\u0000*+\u0005\u0003\u0000\u0000+,\u0006\u0001\uffff\uffff"+
		"\u0000,-\u0005\u0016\u0000\u0000-3\u0006\u0001\uffff\uffff\u0000./\u0005"+
		"\u0019\u0000\u0000/0\u0005\u0016\u0000\u000002\u0006\u0001\uffff\uffff"+
		"\u00001.\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000\u000053\u0001"+
		"\u0000\u0000\u00006;\u0005\u0004\u0000\u000078\u0005\u0005\u0000\u0000"+
		"8<\u0006\u0001\uffff\uffff\u00009:\u0005\u0006\u0000\u0000:<\u0006\u0001"+
		"\uffff\uffff\u0000;7\u0001\u0000\u0000\u0000;9\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=>\u0006\u0001\uffff\uffff\u0000>?\u0005\u001a"+
		"\u0000\u0000?\u0003\u0001\u0000\u0000\u0000@A\u0003\u0006\u0003\u0000"+
		"AB\u0005\u001a\u0000\u0000BM\u0001\u0000\u0000\u0000CD\u0003\b\u0004\u0000"+
		"DE\u0005\u001a\u0000\u0000EM\u0001\u0000\u0000\u0000FM\u0003\n\u0005\u0000"+
		"GH\u0003\f\u0006\u0000HI\u0005\u001a\u0000\u0000IM\u0001\u0000\u0000\u0000"+
		"JM\u0003\u000e\u0007\u0000KM\u0003\u0010\b\u0000L@\u0001\u0000\u0000\u0000"+
		"LC\u0001\u0000\u0000\u0000LF\u0001\u0000\u0000\u0000LG\u0001\u0000\u0000"+
		"\u0000LJ\u0001\u0000\u0000\u0000LK\u0001\u0000\u0000\u0000M\u0005\u0001"+
		"\u0000\u0000\u0000NO\u0005\u0007\u0000\u0000OP\u0005\b\u0000\u0000PQ\u0005"+
		"\u0016\u0000\u0000QR\u0006\u0003\uffff\uffff\u0000RS\u0005\t\u0000\u0000"+
		"S\u0007\u0001\u0000\u0000\u0000TU\u0005\n\u0000\u0000UV\u0005\b\u0000"+
		"\u0000VW\u0003\u0016\u000b\u0000WX\u0006\u0004\uffff\uffff\u0000XY\u0006"+
		"\u0004\uffff\uffff\u0000YZ\u0005\t\u0000\u0000Z[\u0006\u0004\uffff\uffff"+
		"\u0000[\t\u0001\u0000\u0000\u0000\\]\u0005\u000b\u0000\u0000]^\u0006\u0005"+
		"\uffff\uffff\u0000^_\u0005\b\u0000\u0000_`\u0003\u0012\t\u0000`a\u0005"+
		"\u0013\u0000\u0000ab\u0006\u0005\uffff\uffff\u0000bc\u0003\u0012\t\u0000"+
		"cd\u0005\t\u0000\u0000de\u0006\u0005\uffff\uffff\u0000ef\u0005\f\u0000"+
		"\u0000fg\u0005\r\u0000\u0000gi\u0006\u0005\uffff\uffff\u0000hj\u0003\u0004"+
		"\u0002\u0000ih\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000ki\u0001"+
		"\u0000\u0000\u0000kl\u0001\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000"+
		"mn\u0006\u0005\uffff\uffff\u0000nz\u0005\u000e\u0000\u0000op\u0005\u000f"+
		"\u0000\u0000pq\u0006\u0005\uffff\uffff\u0000qs\u0005\r\u0000\u0000rt\u0003"+
		"\u0004\u0002\u0000sr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000"+
		"us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0006\u0005\uffff\uffff\u0000xy\u0005\u000e\u0000\u0000y{\u0001"+
		"\u0000\u0000\u0000zo\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000"+
		"{|\u0001\u0000\u0000\u0000|}\u0006\u0005\uffff\uffff\u0000}\u000b\u0001"+
		"\u0000\u0000\u0000~\u007f\u0005\u0016\u0000\u0000\u007f\u0080\u0006\u0006"+
		"\uffff\uffff\u0000\u0080\u0081\u0005\u0010\u0000\u0000\u0081\u0082\u0003"+
		"\u0012\t\u0000\u0082\u0083\u0006\u0006\uffff\uffff\u0000\u0083\u0084\u0006"+
		"\u0006\uffff\uffff\u0000\u0084\r\u0001\u0000\u0000\u0000\u0085\u0086\u0005"+
		"\u0011\u0000\u0000\u0086\u0087\u0006\u0007\uffff\uffff\u0000\u0087\u0088"+
		"\u0005\b\u0000\u0000\u0088\u0089\u0003\u0012\t\u0000\u0089\u008a\u0005"+
		"\u0013\u0000\u0000\u008a\u008b\u0006\u0007\uffff\uffff\u0000\u008b\u008c"+
		"\u0003\u0012\t\u0000\u008c\u008d\u0005\t\u0000\u0000\u008d\u008e\u0006"+
		"\u0007\uffff\uffff\u0000\u008e\u008f\u0005\r\u0000\u0000\u008f\u0091\u0006"+
		"\u0007\uffff\uffff\u0000\u0090\u0092\u0003\u0004\u0002\u0000\u0091\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0095"+
		"\u0001\u0000\u0000\u0000\u0095\u0096\u0006\u0007\uffff\uffff\u0000\u0096"+
		"\u0097\u0005\u000e\u0000\u0000\u0097\u0098\u0006\u0007\uffff\uffff\u0000"+
		"\u0098\u000f\u0001\u0000\u0000\u0000\u0099\u009a\u0005\u0012\u0000\u0000"+
		"\u009a\u009b\u0006\b\uffff\uffff\u0000\u009b\u009d\u0005\r\u0000\u0000"+
		"\u009c\u009e\u0003\u0004\u0002\u0000\u009d\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u009d\u0001\u0000\u0000\u0000"+
		"\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a2\u0006\b\uffff\uffff\u0000\u00a2\u00a3\u0005\u000e\u0000\u0000"+
		"\u00a3\u00a4\u0005\u0011\u0000\u0000\u00a4\u00a5\u0005\b\u0000\u0000\u00a5"+
		"\u00a6\u0006\b\uffff\uffff\u0000\u00a6\u00a7\u0003\u0012\t\u0000\u00a7"+
		"\u00a8\u0005\u0013\u0000\u0000\u00a8\u00a9\u0006\b\uffff\uffff\u0000\u00a9"+
		"\u00aa\u0003\u0012\t\u0000\u00aa\u00ab\u0005\t\u0000\u0000\u00ab\u00ac"+
		"\u0006\b\uffff\uffff\u0000\u00ac\u0011\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0003\u0016\u000b\u0000\u00ae\u00af\u0006\t\uffff\uffff\u0000\u00af\u00b0"+
		"\u0003\u0014\n\u0000\u00b0\u0013\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005"+
		"\u0014\u0000\u0000\u00b2\u00b3\u0006\n\uffff\uffff\u0000\u00b3\u00b4\u0003"+
		"\u0016\u000b\u0000\u00b4\u00b5\u0006\n\uffff\uffff\u0000\u00b5\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b6\u00b1\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001"+
		"\u0000\u0000\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001"+
		"\u0000\u0000\u0000\u00b9\u0015\u0001\u0000\u0000\u0000\u00ba\u00b8\u0001"+
		"\u0000\u0000\u0000\u00bb\u00bc\u0005\u0016\u0000\u0000\u00bc\u00bd\u0006"+
		"\u000b\uffff\uffff\u0000\u00bd\u00c3\u0006\u000b\uffff\uffff\u0000\u00be"+
		"\u00bf\u0005\u0017\u0000\u0000\u00bf\u00c3\u0006\u000b\uffff\uffff\u0000"+
		"\u00c0\u00c1\u0005\u0015\u0000\u0000\u00c1\u00c3\u0006\u000b\uffff\uffff"+
		"\u0000\u00c2\u00bb\u0001\u0000\u0000\u0000\u00c2\u00be\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3\u0017\u0001\u0000\u0000"+
		"\u0000\f\u001e#3;Lkuz\u0093\u009f\u00b8\u00c2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}