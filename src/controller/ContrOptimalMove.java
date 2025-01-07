package controller;

import mainGame.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;

//Classe qui permet de gerer le bouton Mouvement Optimal qui affiche la liste des mouvements optimaux dans une nouvelle fenetre
public class ContrOptimalMove extends JPanel implements ActionListener {
    Play play;
    JFrame frame;
    ArrayList<String> listOptimalMove;

    public ContrOptimalMove(Play play) {
        this.play = new Play(play.getNbDisks());
        play.solveHanoi();
        this.listOptimalMove = play.getMoveForSolveList();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame = new JFrame("Liste des Mouvements Optimaux");
        frame.setSize(500, 800);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label1 = new JLabel("Source       ->               Destination");
        panel.add(label1);

        for (int i = 0; i < listOptimalMove.size(); i = i + 2) {
            JLabel label = new JLabel(listOptimalMove.get(i) + "                ->                " + listOptimalMove.get(i + 1));
            panel.add(label);
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }
}
