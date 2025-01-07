package controller;
import mainGame.*;
import java.awt.event.*;
import javax.swing.*;

public class BoutonValiderMenuContr implements ActionListener{
    private JComboBox comboBox;
    private InterfaceGraphique interfaceGraphique;

    public BoutonValiderMenuContr(JComboBox comboBox, InterfaceGraphique interfaceGraphique){
        this.comboBox = comboBox;
        this.interfaceGraphique = interfaceGraphique;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        int nbDisks = Integer.parseInt(comboBox.getSelectedItem().toString());
        interfaceGraphique.setGame(nbDisks);
    }
}