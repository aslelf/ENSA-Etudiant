package projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
public class ModifierFiliere extends JFrame implements ActionListener{

    Connecter conn = new Connecter();

    Container container = getContentPane();
    JPanel infoPanel = new JPanel();

    JLabel Entete = new JLabel("Page de modification");
    JLabel apogeeLabel = new JLabel("Code apogée:");
    JTextField apogeeText = new JTextField();
    Object[] elements = new Object[] {"GI","SCM","GM","GSTR","GC"};
    JComboBox<String> filiere = new JComboBox(elements);
    JLabel filiereLabel = new JLabel("filiere");
    JButton DeconnexionButton = new JButton("Déconnexion");
    JButton Modifierbutton = new JButton("Modifier");
    String apogee; 
    
    public void setLayoutManager() {
        // Pour en-tete
        container.setLayout(null);
        // Pour les demandes
        infoPanel.setLayout(null);
        infoPanel.setBounds(10, 163, 994, 500);
        infoPanel.setBorder(BorderFactory.createTitledBorder("Informations de l'étudiant:"));

    }

    public void setLocationAndSizeAndColor() {
        // Pour en-tete
        Entete.setBounds(0, 0, 1004, 90);
        Entete.setOpaque(true);
        Entete.setBackground(new Color(173, 216, 230));
        Entete.setFont(new Font("Segoe UI", Font.BOLD, 22));
        Entete.setForeground(Color.WHITE);
        Entete.setHorizontalAlignment(JLabel.CENTER);

        // pour les demandes

        apogeeLabel.setBounds(30, 70, 100, 30);
        apogeeLabel.setOpaque(true);
        apogeeLabel.setForeground(Color.BLACK);
        apogeeLabel.setFont(new Font("Segoe UI", 1, 14));

        apogeeText.setBounds(150, 70, 200, 30);
        apogeeText.setOpaque(true);
        apogeeText.setEditable(false);
        
        filiereLabel.setBounds(380, 70, 80, 30);
        filiereLabel.setOpaque(true);
        filiereLabel.setForeground(Color.BLACK);
        filiereLabel.setFont(new Font("Segoe UI", 1, 14));
        filiere.setFont(new Font("Tahoma", Font.PLAIN, 15));

        filiere.setBounds(480, 70, 200, 30);

        // Deconnexion
        DeconnexionButton.setBounds(874, 60, 120, 30);
        DeconnexionButton.setOpaque(true);
        DeconnexionButton.setBackground(Color.WHITE);
        DeconnexionButton.setFont(new Font("Segoe UI", 1, 14));
        DeconnexionButton.setForeground(Color.BLACK);
        
               // Modifier
        Modifierbutton.setBounds(300, 300, 120, 30);
        Modifierbutton.setOpaque(true);
        Modifierbutton.setBackground(Color.WHITE);
        Modifierbutton.setFont(new Font("Segoe UI", 1, 14));
        Modifierbutton.setForeground(Color.BLACK);
    }

    public void addComponentsToContainer() {
        // Pour en-tete
        container.add(Entete);
        container.add(DeconnexionButton);
        // pour les demandes
      
        infoPanel.add(apogeeText);
        infoPanel.add(apogeeLabel);
        infoPanel.add(filiere);
        infoPanel.add(filiereLabel);

        //infoPanel.add(filiereLabel);
        infoPanel.add(Modifierbutton);

    }

    public void remplirInfo(String code_apogee) {
       apogee = code_apogee;
        int id_filiere;
        Connecter conn = new Connecter();

        ResultSet res2;
        try {

            Statement stmt = conn.obtenirconnexion().createStatement();
            Statement stmt2 = conn.obtenirconnexion().createStatement();
            String sql = "select apogee, filiere from etudiant where apogee=" + apogee;
            ResultSet res = stmt.executeQuery(sql);
            //étape 5: Vérification de l'authntification
            while (res.next()) {


                apogeeText.setText(res.getString("apogee"));
               /* id_filiere = res.getInt("filiere");
                res2 = stmt2.executeQuery("select nom_filiere from filiere where id_filiere=" + id_filiere);
                while (res2.next()) {
                    filiere.setText(res2.getString("nom_filiere"));

                }*/
               filiere.setSelectedItem(res.getString("filiere"));


            }

            //étape 6: fermez l'objet de connexion
            conn.obtenirconnexion().close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    ModifierFiliere(String id_etudiant) {
		setLayoutManager();
		setLocationAndSizeAndColor();
		addComponentsToContainer();
		remplirInfo(id_etudiant);
		addActionEvent();
                this.setTitle("Modification de la filière de l'étudiant");
		this.setVisible(true);
		
		this.setBounds(160, 100,1020, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		getContentPane().add(infoPanel);


    }

      public void addActionEvent() {
	    	Modifierbutton.addActionListener(this);
	        
	    }
             @Override
	    public void actionPerformed(ActionEvent e) {
            
                Statement stam;
                
       //System.out.println(" "+id);}
       try {  
           if (JOptionPane.showConfirmDialog(null, "confirmer la modification", "modification",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
               stam = conn.obtenirconnexion().createStatement();
               stam.executeUpdate("UPDATE etudiant SET filiere='" + filiere.getSelectedItem()+"' WHERE apogee= " +apogee );
           JOptionPane.showMessageDialog(null, "modification avec succès");
           setVisible(false);
           }
           
      
        } catch (Exception ex) {
            System.out.println(ex);
        }
	    		}
           
  
}