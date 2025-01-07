package controller;
import mainGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

//Classe qui permet de gérer le bouton du menu a propos et d'ouvir une fenetre avec des informations sur le jeu
public class ContrApropos implements ActionListener {
    JFrame frame;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;

    @Override
    //Création de la fenetre a propos
    public void actionPerformed(ActionEvent e){
        frame = new JFrame("A propos");
        frame.setSize(500, 200);
        frame.setLayout(null);
        label1 = new JLabel("Ce jeu a été réalisé par : AMARI Augustin");
        label2 = new JLabel("Dans le cadre du cours de Programmation Orientée Objet");
        label3 = new JLabel("Université de Evry Val d'Essonne | Université Paris Saclay - Licence 2 Informatique");
        label4 = new JLabel("Codé en Java, avec Java Swing et Java AWT.");
        label5 = new JLabel("2023-2024");
        label1.setBounds(20, 20, 500, 30);
        label2.setBounds(20, 50, 500, 30);
        label3.setBounds(20, 80, 500, 30);
        label4.setBounds(20, 110, 500, 30);
        label5.setBounds(20, 140, 500, 30);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);

    }
}
