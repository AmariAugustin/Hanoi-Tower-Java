package controller;
import mainGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

//Classe qui permet de gerer le bouton qui sert a réinitialiser le jeu
public class ContrResetButton implements ActionListener{
    private JFrame frame;

    public ContrResetButton(JFrame frame){
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        frame.dispose();
        InterfaceGraphique interfaceGraphique = new InterfaceGraphique();
    }
}
