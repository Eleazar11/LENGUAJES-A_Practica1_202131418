/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app;

import com.mycompany.lexer.Token;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Eleazr
 */
public class DisplayTokenGrid {
    private final List<Token> tokens;
    private final JPanel panel;

    public DisplayTokenGrid(List<Token> tokens, JPanel panel) {
        this.tokens = tokens;
        this.panel = panel;
    }

    public void showGrid() {
        panel.removeAll(); // Limpiar el panel antes de agregar nuevos componentes
        int gridSize = (int) Math.ceil(Math.sqrt(tokens.size()));
        panel.setLayout(new GridLayout(gridSize, gridSize)); // Ajustar el diseño según tus necesidades
        
        for (Token token : tokens) {
            GridCell cell = new GridCell(token);
            panel.add(cell);
        }

        panel.revalidate(); // Revalidar para actualizar la vista
        panel.repaint();    // Asegurarse de que el panel se repinte
    }
}