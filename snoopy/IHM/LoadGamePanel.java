package IHM;
import java.awt.*;
import javax.swing.*;

class LoadGamePanel extends JPanel{
    LoadGamePanel() {
        super();
        this.setUp();
    }

    private void setUp(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        

        JLabel label = new JLabel("Nom du fichier de Sauvegarde : ");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        

        JTextField textEntry = new JTextField();//il y avait aussi JTextArea et JTextField mais j'ai choisi JtextPane; il est + lourd mais + manoeuvrable

        JButton buttonValider = new JButton("Valider");
        JButton buttonRetour = new JButton("retour");
        JButton[] buttons = {buttonValider, buttonRetour};

        for (JButton button : buttons) {
            button.setFont(new Font("Arial", Font.BOLD, 20));
            button.setBackground(Color.LIGHT_GRAY);
            button.setForeground(Color.BLUE);
            button.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        } 
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
