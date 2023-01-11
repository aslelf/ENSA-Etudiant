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
public class ModifieEtudiant extends JFrame implements ActionListener{

	private JPanel contentPane;

	 Connecter conn = new Connecter();

	    Container container = getContentPane();
	    JPanel infoPanel = new JPanel();

	    JLabel Entete = new JLabel("Page de modification");
	    JLabel nomLabel = new JLabel("Nom:");
	    JTextField nomText = new JTextField();
	    JLabel prenomLabel = new JLabel("Prénom:");
	    JTextField prenomText = new JTextField();
	    JLabel apogeeLabel = new JLabel("Code apogée:");
	    JTextField apogeeText = new JTextField();
	    JLabel cneLabel = new JLabel("CNE:");
	    JTextField cneText = new JTextField();
	    JLabel cinLabel = new JLabel("CIN:");
	    JTextField cinText = new JTextField();
	    JLabel emailLabel = new JLabel("Email:");
	    JTextField emailText = new JTextField();
	    JLabel niveauLabel = new JLabel("Niveau:");
	    JTextField niveauText = new JTextField();
	    Object[] elements = new Object[] {"GI","SCM","GM","2AP1","2AP2","GSTR","GC"};
	    JComboBox<String> filiere = new JComboBox(elements);
	    JLabel filiereLabel = new JLabel("filiere");
	    JLabel dateNaissLabel = new JLabel("Date naissance:");
	    JTextField dateNaissText = new JTextField();
	    JLabel grpLabel = new JLabel("Groupe:");
	    JTextField grpText = new JTextField();
	    JLabel adresseLabel = new JLabel("Adresse:");
	    JTextField adresseText = new JTextField();
	    JLabel teleLabel = new JLabel("Téléphone:");
	    JTextField teleText = new JTextField();
	    JButton DeconnexionButton = new JButton("Déconnexion");
	    JButton Modifierbutton = new JButton("Modifier");
	    int apogee;
	   

	    public void setLayoutManager() {
	        // Pour en-tete
	        container.setLayout(null);
	        // Pour les demandes
	        infoPanel.setLayout(null);
	        infoPanel.setBounds(0, 140, 920, 500);
	        infoPanel.setBorder(BorderFactory.createTitledBorder("Informations de l'étudiant:"));

	    }

	    public void setLocationAndSizeAndColor() {
	        // Pour en-tete
	        Entete.setBounds(0, 0, 920, 90);
	        Entete.setOpaque(true);
	        Entete.setBackground(new Color(173, 216, 230));
	        Entete.setFont(new Font("Segoe UI", 1, 14));
	        Entete.setForeground(Color.WHITE);
	        Entete.setHorizontalAlignment(JLabel.CENTER);

	        // pour les demandes
	        nomLabel.setBounds(50, 30, 80, 30);
	        nomLabel.setOpaque(true);
	        nomLabel.setForeground(Color.BLACK);
	        nomLabel.setFont(new Font("Segoe UI", 1, 14));

	        nomText.setBounds(150, 30, 200, 30);
	        nomText.setOpaque(true);

	        prenomLabel.setBounds(380, 30, 80, 30);
	        prenomLabel.setOpaque(true);
	        prenomLabel.setForeground(Color.BLACK);
	        prenomLabel.setFont(new Font("Segoe UI", 1, 14));

	        prenomText.setBounds(480, 30, 200, 30);
	        prenomText.setOpaque(true);

	        apogeeLabel.setBounds(30, 70, 100, 30);
	        apogeeLabel.setOpaque(true);
	        apogeeLabel.setForeground(Color.BLACK);
	        apogeeLabel.setFont(new Font("Segoe UI", 1, 14));

	        apogeeText.setBounds(150, 70, 200, 30);
	        apogeeText.setOpaque(true);
	        apogeeText.setEditable(false);
	        cneLabel.setBounds(380, 70, 80, 30);
	        cneLabel.setOpaque(true);
	        cneLabel.setForeground(Color.BLACK);
	        cneLabel.setFont(new Font("Segoe UI", 1, 14));

	        cneText.setBounds(480, 70, 200, 30);
	        cneText.setOpaque(true);

	        cinLabel.setBounds(50, 110, 100, 30);
	        cinLabel.setOpaque(true);
	        cinLabel.setForeground(Color.BLACK);
	        cinLabel.setFont(new Font("Segoe UI", 1, 14));

	        cinText.setBounds(150, 110, 200, 30);
	        cinText.setOpaque(true);

	        emailLabel.setBounds(380, 110, 80, 30);
	        emailLabel.setOpaque(true);
	        emailLabel.setForeground(Color.BLACK);
	        emailLabel.setFont(new Font("Segoe UI", 1, 14));

	        emailText.setBounds(480, 110, 200, 30);
	        emailText.setOpaque(true);

	        niveauLabel.setBounds(50, 150, 100, 30);
	        niveauLabel.setOpaque(true);
	        niveauLabel.setForeground(Color.BLACK);
	        niveauLabel.setFont(new Font("Segoe UI", 1, 14));

	        niveauText.setBounds(150, 150, 200, 30);
	        niveauText.setOpaque(true);
	        
	        filiereLabel.setBounds(380, 150, 80, 30);
	        filiereLabel.setOpaque(true);
	        filiereLabel.setForeground(Color.BLACK);
	        filiereLabel.setFont(new Font("Segoe UI", 1, 14));

	        filiere.setBounds(480, 150, 200, 30);

	        
	        dateNaissLabel.setBounds(30, 190, 120, 30);
	        dateNaissLabel.setOpaque(true);
	        dateNaissLabel.setForeground(Color.BLACK);
	        dateNaissLabel.setFont(new Font("Segoe UI", 1, 14));

	        dateNaissText.setBounds(150, 190, 200, 30);
	        dateNaissText.setOpaque(true);
	        
	        grpLabel.setBounds(380, 190, 80, 30);
	        grpLabel.setOpaque(true);
	        grpLabel.setForeground(Color.BLACK);
	        grpLabel.setFont(new Font("Segoe UI", 1, 14));

	        grpText.setBounds(480, 190, 200, 30);
	        grpText.setOpaque(true);
	        
	        teleLabel.setBounds(50, 230, 100, 30);
	        teleLabel.setOpaque(true);
	        teleLabel.setForeground(Color.BLACK);
	        teleLabel.setFont(new Font("Segoe UI", 1, 14));

	        teleText.setBounds(150, 230, 200, 30);
	        teleText.setOpaque(true);
	        
	        adresseLabel.setBounds(380, 230, 80, 30);
	        adresseLabel.setOpaque(true);
	        adresseLabel.setForeground(Color.BLACK);
	        adresseLabel.setFont(new Font("Segoe UI", 1, 14));

	        adresseText.setBounds(480, 230, 200, 30);
	        adresseText.setOpaque(true);
	        // Deconnexion
	        DeconnexionButton.setBounds(770, 50, 120, 30);
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
	        infoPanel.add(nomText);
	        infoPanel.add(nomLabel);
	        infoPanel.add(prenomText);
	        infoPanel.add(prenomLabel);
	        infoPanel.add(apogeeText);
	        infoPanel.add(apogeeLabel);
	        infoPanel.add(cneText);
	        infoPanel.add(cneLabel);
	        infoPanel.add(cinLabel);
	        infoPanel.add(cinText);
	        infoPanel.add(emailLabel);
	        infoPanel.add(emailText);
	        infoPanel.add(niveauLabel);
	        infoPanel.add(niveauText);
	        infoPanel.add(filiere);
	        //infoPanel.add(filiereLabel);
	        infoPanel.add(dateNaissLabel);
	        infoPanel.add(dateNaissText);
	        infoPanel.add(grpLabel);
	        infoPanel.add(grpText);
	        infoPanel.add(adresseLabel);
	        infoPanel.add(adresseText);
	        infoPanel.add(teleLabel);
	        infoPanel.add(teleText);
	        infoPanel.add(Modifierbutton);

	    }

	    public void remplirInfo(String code_apogee) {
	       apogee = Integer.valueOf(code_apogee);
	        int id_filiere;
	        Connecter conn = new Connecter();

	        ResultSet res2;
	        try {

	            Statement stmt = conn.obtenirconnexion().createStatement();
	            Statement stmt2 = conn.obtenirconnexion().createStatement();
	            String sql = "select * from etudiant where apogee=" + apogee;
	            ResultSet res = stmt.executeQuery(sql);
	            //étape 5: Vérification de l'authntification
	            while (res.next()) {

	                nomText.setText(res.getString("nom"));
	                prenomText.setText(res.getString("prenom"));
	                apogeeText.setText(res.getString("apogee"));
	                cneText.setText(res.getString("cne"));
	                cinText.setText(res.getString("cin"));
	                emailText.setText(res.getString("email"));
	                niveauText.setText(res.getString("niveau"));
	               /* id_filiere = res.getInt("filiere");
	                res2 = stmt2.executeQuery("select nom_filiere from filiere where id_filiere=" + id_filiere);
	                while (res2.next()) {
	                    filiere.setText(res2.getString("nom_filiere"));

	                }*/
	               filiere.setSelectedItem(res.getString("filiere"));
	                dateNaissText.setText(res.getString("date_naissance"));
	                grpText.setText(res.getString("groupe"));
	                adresseText.setText(res.getString("adresse"));
	                teleText.setText(res.getString("telephone"));

	            }

	            //étape 6: fermez l'objet de connexion
	            conn.obtenirconnexion().close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    ModifieEtudiant(String id_etudiant) {
			setLayoutManager();
			setLocationAndSizeAndColor();
			addComponentsToContainer();
			remplirInfo(id_etudiant);
			addActionEvent();
	                this.setTitle("Modification des informations de l'étudiant");
			this.setVisible(true);
			this.setBounds(250, 100, 920, 540);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.add(infoPanel);


	    }

	      public void addActionEvent() {
		    	Modifierbutton.addActionListener(this);
		    	DeconnexionButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});

		        
		    }
	             @Override
		    public void actionPerformed(ActionEvent e) {
	            
	                Statement stam;
	                
	       //System.out.println(" "+id);}
	       try {  
	           if (JOptionPane.showConfirmDialog(null, "confirmer la modification", "modification",
	                    JOptionPane.YES_NO_OPTION) == JOptionPane.OK_OPTION) {
	               stam = conn.obtenirconnexion().createStatement();
	               stam.executeUpdate("UPDATE etudiant SET apogee='" +apogeeText.getText()+"',cne='" + cneText.getText()+"',cin='" + cinText.getText()+"',nom='" + nomText.getText()+ "',prenom='" + prenomText.getText()+"',email='" + emailText.getText()+"',niveau='" + niveauText.getText()+"',filiere='" + filiere.getSelectedItem()+"',groupe='" + grpText.getText()+"',date_naissance='" + dateNaissText.getText()+"',adresse='" + adresseText.getText()+"',telephone='" + teleText.getText()+"' WHERE apogee= " +apogee );
	           JOptionPane.showMessageDialog(null, "modification avec succès");
	           EditionEtudiant s=new EditionEtudiant();
	           dispose();
	           }
	           
	      
	        } catch (Exception ex) {
	            System.out.println(ex);
	        }
		    		}
	           

}
