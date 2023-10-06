package org.base64;

import org.base64.gui.EncoderGUI;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(EncoderGUI::new);
    }
}