package mainGame;

import javax.swing.*;

import controller.*;

import java.awt.*;
import java.util.ArrayList;


public class InterfaceGraphique extends JPanel {
    //Initialisation des variables
    JLabel label1 = new JLabel("Entrez le nombre de disques : ");
    JComboBox comboBox = new JComboBox();
    int nbCoups;
    JButton button = new JButton("Valider");
    int nbDisks;
    public JFrame frame;
    int diskWidths[];
    JLabel CoupsCompteur;
    JButton resetButton;
    public int iAuto = 0;
    public int SolveBool = 0;
    public int scoreSaved = 0;
    public ArrayList<String> SolveList = new ArrayList<String>();
    public JButton saveButton = new JButton("Sauvegarder le score");
    
    public InterfaceGraphique() {
        //Gere l'ecran de menu
        frame = new JFrame("Tour de Hanoi");
        int s1[] = { 2,3,4,5,6,7,8,9 };
        for (int i = 0; i < s1.length; i++) {
            comboBox.addItem(s1[i]);
        }
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        label1.setBounds(20, 20, 200, 30);
        comboBox.setBounds(20, 50, 200, 30);
        button.setBounds(20, 90, 200, 30);
        frame.add(label1);
        frame.add(comboBox);
        frame.add(button);
        frame.setVisible(true);

        button.addActionListener(new BoutonValiderMenuContr(comboBox, this));
    }

    public void setGame(int nbDisks) {
        //Gere l'initialisation du jeu
        this.nbDisks = nbDisks;
        Play play = new Play(nbDisks);
        play.initGame(nbDisks);
        frame.getContentPane().removeAll();
        frame.setLayout(null);
        diskWidths = listDiskWidths(nbDisks);
        frame.setResizable(false);

        frame.setSize(1000,800);

        updateGame(play);
    }


    public void updateGame(Play play) {
        //Gere l'ecran de jeu principal
        frame.getContentPane().removeAll();
        //initialisation des variables
        int towerSpacing = 300; 
        int rectangleHeight = 35;
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.MAGENTA};
        CoupsCompteur = new JLabel("Nombre de coups : " + play.getNbCoups());
        CoupsCompteur.setBounds(20, 20, 200, 30);
        frame.add(CoupsCompteur);

        //Affichage et gestion du bouton resoudre
        if (SolveBool == 0){
            JButton solveButton = new JButton("Résoudre");
            solveButton.addActionListener(new ContrSolveButton(play, this));
            solveButton.setBounds(800, 700, 100, 30);
            frame.add(solveButton);
        }
        else{
            JButton preced = new JButton("Précédent");
            JButton suivant = new JButton("Suivant");
            JButton reprendre = new JButton("Reprendre");
            preced.setBounds(700, 700, 100, 30);
            suivant.setBounds(800, 700, 100, 30);
            reprendre.setBounds(600, 700, 100, 30);
            frame.add(reprendre);
            frame.add(preced);
            frame.add(suivant);
            preced.addActionListener(new ContrPrecedent(play, this, iAuto, SolveList));
            suivant.addActionListener(new ContrSuivant(play, this, iAuto, SolveList));
            reprendre.addActionListener(new ContrReprendre(play, this));
        }

        //Affichage et gestion du bouton recommencer
        resetButton = new JButton("Recommencer");
        resetButton.setBounds(85, 700, 125, 30); 
        resetButton.addActionListener(new ContrResetButton(frame));
        frame.add(resetButton);

        //Affichage et gestion des erreurs de placement de disques
        JLabel alertLabel = new JLabel("");
        alertLabel.setBounds(20, 70, 500, 30);
        frame.add(alertLabel);

        //Affichage et gestion de la bar de menu
        JMenu menu;
        JMenuItem e1, e2;
        JMenuBar menubar = new JMenuBar();
        menu = new JMenu("Info");
        e1 = new JMenuItem("A propos");
        e2 = new JMenuItem("Tableau des scores");
        menu.add(e1); 
        menu.add(e2); 
        menubar.add(menu);
        frame.setJMenuBar(menubar);
        e1.addActionListener(new ContrApropos());
        e2.addActionListener(new ContrScore());
        
        //Affichage des boutons de selection de tour
        if (SolveBool == 0){
            for (int towerIndex = 0; towerIndex < play.getListTower().length; towerIndex++) { 
                Tower tower = play.getListTower()[towerIndex];
                JButton button = new JButton(tower.getName());
                button.addActionListener(new ContrButtonDisk(play, tower, frame, this, alertLabel));
                button.setBounds(towerIndex * towerSpacing + (towerSpacing - 100) / 2, 550, 100, 30); 
                frame.add(button);
            }
        }
    
        //Affichage des disques
        for (int towerIndex = 0; towerIndex < play.getListTower().length; towerIndex++) {
            Tower tower = play.getListTower()[towerIndex];
            Disk[] disks = tower.getListDisk().toArray(new Disk[0]);
            for (int diskIndex = 0; diskIndex < disks.length; diskIndex++) {
                int rectangleWidth = diskWidths[disks[diskIndex].getSize() - 1]; 
                int xPosition = towerIndex * towerSpacing + (towerSpacing - rectangleWidth) / 2; 
                Color color = colors[disks[diskIndex].getSize() % colors.length]; 
        
                RectanglePanel rectanglePanel = new RectanglePanel(color); 
                rectanglePanel.setBounds(xPosition, 500 - (diskIndex * rectangleHeight), rectangleWidth, rectangleHeight); 
        
                JLabel diskSizeLabel = new JLabel(Integer.toString(disks[diskIndex].getSize()));
                diskSizeLabel.setHorizontalAlignment(JLabel.CENTER);
                rectanglePanel.add(diskSizeLabel);
        
                frame.add(rectanglePanel);
            }
        }

        //Affichage de l'écran de fin
        if (play.isFinished() == true || scoreSaved == 1) {
            int[] tabMouvementOpti = {0,0,3,7,15,31,63,127,255,511,1023,2047,4095,8191,16383,32767,65535,131071,262143,524287,1048575,2097151,4194303,8388607,16777215,33554431,67108863,134217727,268435455,536870911,1073741823,2147483647};
            frame.getContentPane().removeAll();
            JLabel label = new JLabel("Vous avez gagné !");
            if (scoreSaved == 0){
                nbCoups = play.getNbCoups();
            }
            System.out.println(tabMouvementOpti[nbDisks]);
            System.out.println(nbCoups);
            System.out.println(tabMouvementOpti[nbDisks] == nbCoups);
            JLabel label2 = new JLabel("Nombre de coups : " + nbCoups);
            JButton button = new JButton("Recommencer");
            JTextField name = new JTextField("Entrez votre nom");
            JLabel comentary = new JLabel("Vous avez effectué le nombre de coups optimal pour ce nombre de disques");
            Button optimalMoveButton = new Button("Voir la liste des mouvements optimaux");
            optimalMoveButton.setBounds(50, 450, 200, 30);
            label.setBounds(50, 400, 200, 30);
            comentary.setBounds(170, 400, 900, 30);
            label2.setBounds(50, 50, 200, 30);
            button.setBounds(750, 700, 170, 30);
            saveButton.setBounds(250, 700, 200, 30);
            name.setBounds(50, 700, 200, 30);
            frame.add(optimalMoveButton);
            frame.add(label);
            frame.add(label2);
            frame.add(button);
            button.addActionListener(new ContrResetButton(frame));
            optimalMoveButton.addActionListener(new ContrOptimalMove(play));

            if (scoreSaved == 0){
                frame.add(saveButton);
                frame.add(name);
                System.out.println(nbCoups);
                saveButton.addActionListener(new ContrSaveScore(play, name, this, nbCoups));
            } else{
                JLabel saved = new JLabel("Score sauvegardé");
                saved.setBounds(250, 700, 200, 30);
                frame.add(saved);
            }

            if (tabMouvementOpti[nbDisks] == nbCoups){
                comentary.setText("Vous avez effectué le nombre optimal pour ce nombre de disques");
                comentary.setForeground(Color.GREEN);
            } else{
                comentary.setText("Votre nombre de coups n'est pas optimal pour ce nombre de disques, le nombre optimal de coups est "+ tabMouvementOpti[nbDisks] + " coups");
                comentary.setForeground(Color.RED);
            }
            frame.add(comentary);
        }
        frame.revalidate();
        frame.repaint();
    }

    //Methode pour calculer la largeur des disques
    private int[] listDiskWidths(int nbDisks) {
        int[] diskWidths = new int[nbDisks];
        int baseWidth = 250; 
        int topWidth = 50; 
        for (int i = 0; i < nbDisks; i++) {
            int rectangleWidth = baseWidth - (baseWidth - topWidth) * (nbDisks - 1 - i) / (nbDisks - 1); 
            diskWidths[i] = rectangleWidth;
        }      
        return diskWidths;
    }
}
