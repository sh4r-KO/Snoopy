package controller;
import java.awt.event.*;


import IHM.*;


public class Tmp implements ActionListener{ 
    MainFrame F;
    //JPanel p;


    public Tmp(MainFrame M){  //ptet protected
        this.F = M;
    }  
    
    public void actionPerformed(ActionEvent e){  
        
        System.out.println("e.getActionCommand() : "+e.getActionCommand());
        if(e.getActionCommand().equals("Scores")){
            F.scoresCliked();
            System.out.println("F.scoresCliked");
        } else if (e.getActionCommand().equals("retour")){
            F.retourCliked();
            System.out.println("F.retourCliked");

        }else if (e.getActionCommand().equals("Quitter")){
            F.quitterCliked();
            System.out.println("F.quitterCliked");

        }else if (e.getActionCommand().equals("Mot de passe")){
            F.mdpClicked();
            System.out.println("F.mdpClicked");

        }else if (e.getActionCommand().equals("Charger une partie")){
            F.chargerPClicked();
            System.out.println("F.chargerPClicked");

        }else if (e.getActionCommand().equals("Jeu de base")){
            F.jeuBaseClicked();
            System.out.println("F.jeuBaseClicked");

        }else if (e.getActionCommand().equals("Jeu avancé")){
            F.jeuAvcClicked();
            System.out.println("F.jeuAvcClicked");

        }
        
    }  
}  
