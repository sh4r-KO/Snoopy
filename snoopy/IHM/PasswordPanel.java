package IHM;

import javax.swing.*;

import controller.Tmp;

import java.awt.*;


class PasswordPanel extends JPanel{
    Tmp t ;
    PasswordPanel(Tmp t) {
        super();
        this.t = t;
        this.setUp();
    }
    //alexandra, je te laisse comprendre comment ça marche, j'ai trop la flemme
    //https://examples.javacodegeeks.com/java-swing-layouts-example/
    private void setUp(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);


        JLabel label = new JLabel("Mot de passe : ");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setAlignmentY(Component.CENTER_ALIGNMENT);

        JTextField textEntry = new JTextField();//il y avait aussi JTextArea et JTextField mais j'ai choisi JtextPane; il est + lourd mais + manoeuvrable

        

        JButton buttonValider = new JButton("Valider");
        buttonValider.setFont(new Font("Arial", Font.BOLD, 20));
        buttonValider.setBackground(Color.LIGHT_GRAY);
        buttonValider.setForeground(Color.BLUE);
        buttonValider.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        buttonValider.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonValider.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonValider.addActionListener(t);

        JButton buttonRetour = new JButton("retour");
        buttonRetour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonRetour.setBackground(Color.LIGHT_GRAY);
        buttonRetour.setForeground(Color.BLUE);
        buttonRetour.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        buttonRetour.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonRetour.setAlignmentY(Component.CENTER_ALIGNMENT);
        buttonRetour.addActionListener(t);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        //espace les elements des uns des autres
        gbc.insets = new Insets(50, 100, 50, 100);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.CENTER;

        this.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;// on réitère apres les precedents changements

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