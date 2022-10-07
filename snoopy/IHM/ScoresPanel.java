package IHM;

import javax.swing.*;

import controller.Tmp;

import java.awt.*;

class ScoresPanel extends JPanel{
    Tmp t ;
    
    ScoresPanel(Tmp t) {
        super();
        this.t = t;
        this.setUp();
    }

    private void setUp(){
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);

        JLabel label = new JLabel("Scores : ");
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(Color.BLUE);
        //https://docs.oracle.com/javase/tutorial/displayCode.html?code=https://docs.oracle.com/javase/tutorial/uiswing/examples/components/ListDialogRunnerProject/src/components/ListDialog.java
        
        DefaultListModel<String> l1 = new DefaultListModel<>();  
        l1.addElement("Item1");  
        l1.addElement("Item2");  
        for (int i = 0; i < 100; i++) {
            l1.addElement("Item"+i);
        }
        l1.addElement("Item3");  
        l1.addElement("Item4");  
        JList<String> list = new JList<>(l1);  
        list.setBounds(100,100, 75,75);  

        JButton buttonRetour = new JButton("retour");
        buttonRetour.setFont(new Font("Arial", Font.BOLD, 20));
        buttonRetour.setBackground(Color.LIGHT_GRAY);
        buttonRetour.setForeground(Color.BLUE);
        buttonRetour.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        buttonRetour.addActionListener(this.t);


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
        this.add(new JScrollPane(list),gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        this.add(buttonRetour, gbc);

    }
}
