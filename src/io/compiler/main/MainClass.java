package io.compiler.main;

import org.antlr.v4.runtime.CommonTokenStream;
//import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;

import io.compiler.core.GrammarLexer;
import io.compiler.core.GrammarParser;
import io.compiler.core.ast.Program;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class MainClass {
    public static void main(String[] args) {
        try {
            GrammarLexer lexer;
            GrammarParser parser;

            lexer = new GrammarLexer(CharStreams.fromFileName("isiProg/program10.isi"));

            CommonTokenStream tokenStream = new CommonTokenStream(lexer);

            parser = new GrammarParser(tokenStream);

            System.out.println("Isi language Compiler.\nCompiling program...");
            parser.prog();
            System.out.println("Compilation complete!");

            Program program = parser.getProgram();

            System.out.println("Generating Java program...");

            try {
                File f = new File(program.getName() + ".java");
                FileWriter fr = new FileWriter(f);
                PrintWriter pr = new PrintWriter(fr);

                pr.println(program.generateTarget());
                pr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("Equivalent program in Java was generated!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
