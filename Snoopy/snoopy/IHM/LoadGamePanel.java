package IHM;
import java.awt.*;
import javax.swing.*;

import controller.Tmp;

class LoadGamePanel extends JPanel{
    private JButton buttonValider;
    private JButton buttonRetour;
    private JTextField textEntry;
    Tmp t ;
    LoadGamePanel(Tmp t) {
        super();
        this.t = t;
        this.setUp();
    }

    private void setUp(){
        
        /////////////////////////////////// set les elements ///////////////////////////////////////////////////

        JLabel label = new JLabel("Nom du fichier de Sauvegarde : ");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        

        textEntry = new JTextField();//il y avait aussi JTextArea et JTextField mais j'ai choisi JtextPane; il est + lourd mais + manoeuvrable
        buttonValider = new JButton("Valider");
        buttonRetour = new JButton("retour");
        JButton[] buttons = {buttonValider, buttonRetour};

        for (JButton button : buttons) {
            button.addActionListener(t);

            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLUE);
            button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        } 

        /////////////////////////////////// set l'agencement=layout des elements ///////////////////////////////////////////////////
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //espace les elements des uns des autres
        gbc.insets = new Insets(50, 100, 50, 100);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;

        this.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        this.add(textEntry, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        this.add(buttonRetour, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(buttonValider, gbc);
    }
}
