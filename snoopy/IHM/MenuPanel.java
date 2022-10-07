package IHM;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import controller.Tmp;  


class MenuPanel extends JPanel{
    Tmp t;
    //AFAIRE use GridBagLayout instead of GridLayout
    MenuPanel(Tmp t) {
        super();
        this.t = t;

        this.setUp1();
    }
    //le meilleir set up que j'ai fait pour l'instant, il utilise un gridlayout de 7 lignes et 5 colonnes
    /*
     * la façon dont j'ai fait pour placer les boutons est la suivante:
     * j'ajout des labels blanc sur une ligne, puis j'ajoute les boutons sur la ligne suivante en alternant avec des labels blanc 
     * les labels blanc servent a créer du vide entre les boutons ou des lignes de vides
     * et je ne remplis pas de blanc la derniere ligne, c'est pas necessaire
     */
    private void setUp1(){ 
        this.setLayout(new GridLayout(7,4,10,10));
        JButton button1 = new JButton("Jeu de base");
        JButton button2 = new JButton("Jeu avancé");
        JButton button3 = new JButton("Charger une partie");
        JButton button4 = new JButton("Mot de passe");
        JButton button5 = new JButton("Scores");
        JButton button6 = new JButton("Quitter");
        JButton[] buttons = {button1, button2, button3, button4, button5, button6};
        Color lightBlue = new Color(0,0,200);

        for (JButton button : buttons){
            button.addActionListener(this.t);

            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(lightBlue);
            button.setBorder(BorderFactory.createLineBorder(lightBlue, 2));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
        }

        //ce code permet d'avoir une grille de 35 elements, avec 7 lignes et 5 colonnes
        //avec des boutons agencé d'une manière très précise, c'est pas optimisé comme façon de faire
        //je vais une autre version avec un GridLayout de seulement 6 lignes et 2 colonnes
        for(int i = 0; i < 6; i++){
            this.add(new JLabel());
        }
        this.add(buttons[0]);
        this.add(new JLabel());
        this.add(buttons[1]);
        for(int i = 0; i < 7; i++){
            this.add(new JLabel());
        }
        this.add(buttons[2]);
        this.add(new JLabel());
        this.add(buttons[3]);

        for(int i = 0; i < 7; i++){
            this.add(new JLabel());
        }
        this.add(buttons[4]);
        this.add(new JLabel());
        this.add(buttons[5]);
       

    }
    /*
     * ici j'ai essaye de faire un gridlayout avec 6 lignes et 1 col=onnes, mais c'est très moche,
     * j'arrive pas a rendre ça viables
     */
    public void setUp2(){ 
        this.setLayout(new GridLayout(6,2,100,100));
        JButton button1 = new JButton("Jeu de base");
        JButton button2 = new JButton("Jeu avancé");
        JButton button3 = new JButton("Charger une partie");
        JButton button4 = new JButton("Mot de passe");
        JButton button5 = new JButton("Scores");
        JButton button6 = new JButton("Quitter");
        JButton[] buttons = {button1, button2, button3, button4, button5, button6};

        for (JButton button : buttons){
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK);
            button.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5));
            button.setAlignmentX(Component.CENTER_ALIGNMENT);
            button.setAlignmentY(Component.CENTER_ALIGNMENT);
            this.add(button,button);
        }
    }
}
