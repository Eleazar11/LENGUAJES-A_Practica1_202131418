/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
public class LexerOperatorOrSymbol {

    private final String input;
    private int position;

    public LexerOperatorOrSymbol(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public Token lex() {
        if (position >= input.length()) {
            return new Token(TokenType.DESCONOCIDO.toString(), "", position, position, TokenColor.getColor(TokenType.DESCONOCIDO));
        }

        char currentChar = input.charAt(position);
        String lexeme = String.valueOf(currentChar);
        TokenType type = TokenType.DESCONOCIDO;

        System.out.println("Read character: " + currentChar);

        switch (currentChar) {
            // Manejo de Comentarios
            case '\'':
                type = TokenType.COMENTARIO;
                lexeme = readComment();
                break;
            
            // Operadores Aritméticos
            case '+':
                type = TokenType.OPERADOR_ARITMETICO_SUMA;
                break;
            case '-':
                type = TokenType.OPERADOR_ARITMETICO_RESTA;
                break;
            case '*':
                type = TokenType.OPERADOR_ARITMETICO_MULTIPLICACION;
                break;
            case '/':
                type = TokenType.OPERADOR_ARITMETICO_DIVISION;
                break;
            case '%':
                type = TokenType.OPERADOR_ARITMETICO_MODULO;
                break;
            case '^':
                type = TokenType.OPERADOR_ARITMETICO_EXPONENTE;
                break;

            // Operadores Relacionales
            case '=':
                if (peekNext() == '=') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_RELACIONAL_IGUAL;
                } else {
                    type = TokenType.OPERADOR_ASIGNACION;
                }
                break;
            case '!':
                if (peekNext() == '=') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_RELACIONAL_DIFERENTE;
                } else {
                    type = TokenType.OPERADOR_LOGICO_NEGACION;
                }
                break;
            case '>':
                if (peekNext() == '=') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_RELACIONAL_MAYOR_IGUAL;
                } else {
                    type = TokenType.OPERADOR_RELACIONAL_MAYOR;
                }
                break;
            case '<':
                if (peekNext() == '=') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_RELACIONAL_MENOR_IGUAL;
                } else {
                    type = TokenType.OPERADOR_RELACIONAL_MENOR;
                }
                break;

            // Operadores Lógicos
            case '&':
                if (peekNext() == '&') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_LOGICO_Y;
                }
                break;
            case '|':
                if (peekNext() == '|') {
                    lexeme += input.charAt(++position);
                    type = TokenType.OPERADOR_LOGICO_O;
                }
                break;

            // Signos y símbolos
            case ',':
                type = TokenType.COMA;
                break;
            case '(':
                type = TokenType.PARANTESIS;
                break;
            case ')':
                type = TokenType.PARANTESIS;
                break;
            case '{':
                type = TokenType.LLAVES;
                break;
            case '}':
                type = TokenType.LLAVES;
                break;
            case '[':
                type = TokenType.CORCHETES;
                break;
            case ']':
                type = TokenType.CORCHETES;
                break;
            case '.':
                type = TokenType.PUNTO;
                break;
            default:
                type = TokenType.DESCONOCIDO;
                break;
        }

        position++;
        return new Token(type.toString(), lexeme, position - 1, position, TokenColor.getColor(type));
    }

    private String readComment() {
        StringBuilder comment = new StringBuilder("'");
        position++;
        while (position < input.length() && input.charAt(position) != '\n') {
            comment.append(input.charAt(position));
            position++;
        }
        comment.append('\n');
        return comment.toString();
    }

    private char peekNext() {
        if (position + 1 < input.length()) {
            return input.charAt(position + 1);
        } else {
            return '\0'; // Fin del string
        }
    }

    public int getPosition() {
        return position;
    }
}