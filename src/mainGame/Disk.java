package mainGame;

public class Disk {
    //Initialisation des attributs
    private int size;

    //Constructeur de la classe Disk avec un paramètre size qui est la taille du disque
    public Disk(int size){
        this.size = size;
    }

    //Méthode qui retourne la taille du disque
    public int getSize(){
        return size;
    }
    @Override
    //Méthode qui retourne la taille du disque en chaîne de caractères pour l'affichage de celui ci dans l'interface graphique
    public String toString() {
        return Integer.toString(size);
    }

}