/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.lexer.Token;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Eleazr
 */
public class DisplayTokenGrid extends JPanel {

    private List<Token> tokens;

    public DisplayTokenGrid(List<Token> tokens) {
        this.tokens = tokens;
        initUI();
    }

    private void initUI() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Token token = obtenerTokenEnPosicion(e.getX(), e.getY());
                if (token != null) {
                    mostrarAutomata(token);
                }
            }
        });
    }

    private Token obtenerTokenEnPosicion(int x, int y) {
        // Lógica para obtener el token en la posición x, y
        return null; // Reemplaza con la lógica adecuada
    }

    private void mostrarAutomata(Token token) {
        String rutaDot = "automata_" + token.getLexema() + ".dot";
        String rutaImagen = "automata_" + token.getLexema() + ".png";

        AutomataGenerator.generarArchivoDot(token, rutaDot);
        AutomataGenerator.generarImagenAutómata(rutaDot, rutaImagen);

        ImageIcon icon = new ImageIcon(rutaImagen);
        JLabel label = new JLabel(icon);
        JOptionPane.showMessageDialog(this, label, "Autómata de " + token.getLexema(), JOptionPane.PLAIN_MESSAGE);
    }
}