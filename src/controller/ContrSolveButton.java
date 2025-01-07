package controller;
import mainGame.*;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Classe qui permet de gerer le bouton Resoudre
public class ContrSolveButton implements ActionListener{
    Play play;
    InterfaceGraphique interfaceGraphique;
    Play copyPlay;
    Tower[] listTower = new Tower[3];

    //Constructeur de la classe Controller.ContrSolveButton qui prend en parametre un objet Play et un objet InterfaceGraphique
    public ContrSolveButton(Play play, InterfaceGraphique interfaceGraphique){
        //On copie la partie actuelle pour pouvoir la resoudre et recuperer les mouvements a effectuer
        this.play = play;
        this.interfaceGraphique = interfaceGraphique;
        ArrayList<Disk> listDisk1 = new ArrayList<>();
        ArrayList<Disk> listDisk2 = new ArrayList<>();
        ArrayList<Disk> listDisk3 = new ArrayList<>();
        for (int i = 0; i < play.getTower(0).length(); i++){
            listDisk1.add(new Disk(play.getTower(0).getListDisk().get(i).getSize()));
        }
        for (int i = 0; i < play.getTower(1).length(); i++){
            listDisk2.add(new Disk(play.getTower(1).getListDisk().get(i).getSize()));
        }
        for (int i = 0; i < play.getTower(2).length(); i++){
            listDisk3.add(new Disk(play.getTower(2).getListDisk().get(i).getSize()));
        }
        listTower[0] = new Tower("X", listDisk1);
        listTower[1] = new Tower("Y", listDisk2);
        listTower[2] = new Tower("Z", listDisk3);
        copyPlay = new Play(play.getNbDisks(), listTower);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        //On donne les mouvements a effectuer a l'interface graphique pour les afficher
        copyPlay.solveHanoi();
        ArrayList<String> list = copyPlay.getMoveForSolveList();
        interfaceGraphique.SolveList = list;
        interfaceGraphique.SolveBool = 1;
        interfaceGraphique.updateGame(play);
    }
}
