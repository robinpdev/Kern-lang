package com.example.kernlang.interpreter.lexer;

public enum TokenType {
    TOK_UNIT, TOK_BOOL, TOK_CHAR, TOK_NUMBER, TOK_IDENTIFIER, TOK_OPEN_PAREN, TOK_CLOSE_PAREN, TOK_OPEN_CURLY,
    TOK_CLOSE_CURLY, TOK_SEMI_COLON, TOK_DOT,

    TOK_MINUS, TOK_PLUS, TOK_STAR, TOK_SLASH,

    TOK_BANG, TOK_BANG_EQUAL, TOK_EQUAL, TOK_EQUAL_EQUAL, TOK_LESS, TOK_GREATER,

    TOK_AND, TOK_OR, TOK_ELSE, TOK_IF, TOK_TRUE, TOK_FALSE, TOK_RETURN, TOK_THIS,

    TOK_EOF
}
