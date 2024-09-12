package io.compiler.core;
// Generated from Grammar.g4 by ANTLR 4.13.2
 
  import java.util.ArrayList;
  import java.util.Stack;
	import java.util.HashMap;
	import io.compiler.types.*;
	import io.compiler.core.exceptions.*;
	import io.compiler.core.ast.*;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GrammarParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GrammarParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void enterDeclara(GrammarParser.DeclaraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declara}.
	 * @param ctx the parse tree
	 */
	void exitDeclara(GrammarParser.DeclaraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(GrammarParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(GrammarParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(GrammarParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(GrammarParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(GrammarParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(GrammarParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void enterCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdIf}.
	 * @param ctx the parse tree
	 */
	void exitCmdIf(GrammarParser.CmdIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void enterCmdExpr(GrammarParser.CmdExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdExpr}.
	 * @param ctx the parse tree
	 */
	void exitCmdExpr(GrammarParser.CmdExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdWhile(GrammarParser.CmdWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void enterCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cmdDoWhile}.
	 * @param ctx the parse tree
	 */
	void exitCmdDoWhile(GrammarParser.CmdDoWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GrammarParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GrammarParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void enterExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#exprl}.
	 * @param ctx the parse tree
	 */
	void exitExprl(GrammarParser.ExprlContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(GrammarParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(GrammarParser.TermoContext ctx);
}