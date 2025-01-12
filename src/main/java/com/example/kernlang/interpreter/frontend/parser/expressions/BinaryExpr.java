package com.example.kernlang.interpreter.frontend.parser.expressions;

import com.example.kernlang.codebase_viewer.graph.GraphNode;
import com.example.kernlang.interpreter.frontend.lexer.Token;
import com.example.kernlang.interpreter.frontend.lexer.TokenType;

import java.util.HashMap;

public class BinaryExpr extends Expr {

    private final Expr leftExpr;
    private final Token operator;
    private final Expr rightExpr;

    public BinaryExpr(Expr leftExpr, Token operator, Expr rightExpr) {
        this.leftExpr = leftExpr;
        this.operator = operator;
        this.rightExpr = rightExpr;
    }

    public String toString(int indent) {
        String tabs = getTabs(indent);

        return tabs + "expression (binary):\n" +
                tabs + "\toperator:" + "\n" +
                tabs + "\t\t" + operator.lexeme() + "\n" +
                tabs + "\tleft:\n" + leftExpr.toString(indent + 2) + "\n" +
                tabs + "\tright:\n" + rightExpr.toString(indent + 2) + "\n";
    }

    @Override
    public Literal interpret(GraphNode context, HashMap<String, Literal> additionalContext) {
        switch (operator.tokenType()) {
            case TOK_PLUS -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                        new Token(
                                TokenType.TOK_NUMBER, "", left + right, context, -1
                        )
                );
            }
            case TOK_MINUS -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                    new Token(
                            TokenType.TOK_NUMBER, "", left - right, context, -1
                    )
            ); }
            case TOK_STAR -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                        new Token(
                            TokenType.TOK_NUMBER, "", left * right, context, -1
                        )
                );
            }
            case TOK_SLASH -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                    new Token(
                            TokenType.TOK_NUMBER, "", left / right, context, -1
                    )
                );
            }
            case TOK_GREATER -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                        new Token(
                                TokenType.TOK_BOOL, "", left > right, context, -1
                        )
                );
            }
            case TOK_LESS -> {
                Double left = ((Double)((LiteralExpr) leftExpr.interpret(context, additionalContext)).getTok().literal());
                Double right = ((Double)((LiteralExpr) rightExpr.interpret(context, additionalContext)).getTok().literal());
                return new LiteralExpr(
                        new Token(
                                TokenType.TOK_BOOL, "", left < right, context, -1
                        )
                );
            }
            default -> { return null; }
        }
    }

    public Expr getLeftExpr() {
        return leftExpr;
    }

    public Token getOperator() {
        return operator;
    }

    public Expr getRightExpr() {
        return rightExpr;
    }
}
