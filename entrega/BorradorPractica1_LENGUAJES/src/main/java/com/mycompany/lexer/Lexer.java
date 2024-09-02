/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int position;
    private final List<Token> tokens = new ArrayList<>();

    public Lexer(String input) {
        this.input = input;
    }

    public List<Token> tokenize() {
        while (position < input.length()) {
            char currentChar = input.charAt(position);

            // Manejo de comentarios
            if (currentChar == '\'') {
                Token commentToken = handleComment();
                tokens.add(commentToken);
                continue; // Continuar al siguiente carácter después del comentario
            }

            if (Character.isDigit(currentChar)) {
                LexerNumber lexerNumber = new LexerNumber(input, position);
                Token token = lexerNumber.lex();
                tokens.add(token);
                position = lexerNumber.getPosition();
            } else if (currentChar == '\"') {
                LexerString lexerString = new LexerString(input, position);
                Token token = lexerString.lex();
                tokens.add(token);
                position = lexerString.getPosition();
            } else if (Character.isLetter(currentChar)) {
                LexerIdentifier lexerIdentifier = new LexerIdentifier(input, position);
                Token token = lexerIdentifier.lex();
                tokens.add(token);
                position = lexerIdentifier.getPosition();
            } else if (isOperatorOrSymbol(currentChar)) {
                LexerOperatorOrSymbol lexerOperatorOrSymbol = new LexerOperatorOrSymbol(input, position);
                Token token = lexerOperatorOrSymbol.lex();
                tokens.add(token);
                position = lexerOperatorOrSymbol.getPosition();
            } else {
                position++;
            }
        }
        return tokens;
    }

    private boolean isOperatorOrSymbol(char c) {
        return "+-*/=<>!&|;(),{}[]".indexOf(c) >= 0;
    }

    // Manejo de comentarios y creación de un token para el comentario
    private Token handleComment() {
        int start = position;
        while (position < input.length() && input.charAt(position) != '\n') {
            position++;
        }
        // Después de salir del bucle, `position` está en el final de la línea
        String commentText = input.substring(start, position);
        return new Token(TokenType.COMENTARIO.toString(), commentText, start, position, TokenColor.getColor(TokenType.COMENTARIO));
    }
}