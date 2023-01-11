package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AjouterUtilisateur extends JFrame implements ActionListener {

	private JPanel contentPane;
	  Connecter conn = new Connecter();
	    JPanel formPanel = new JPanel();

	    JLabel welcomeLabel = new JLabel("L'AJOUT D'UN UTILISATEUR");
	    ImageIcon addIcon = new ImageIcon(
	            new ImageIcon("fichier/addIcon.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
	    JButton addButton = new JButton();
	    Container container = getContentPane();
	    ImageIcon EnsaIcon = new ImageIcon("fichier/logo.png");
	    JLabel EnsaLabel = new JLabel(EnsaIcon);

	    // buttom de Déconnexion
	    ImageIcon annuleIcon = new ImageIcon(
	            new ImageIcon("fichier/annuler.png").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
	    JButton annulerButtom = new JButton(annuleIcon);
	    // buttom du reset
	    ImageIcon resetIcon = new ImageIcon(
	            new ImageIcon("fichier/reset.jpg").getImage().getScaledInstance(40, 40, Image.SCALE_DEFAULT));
	    JButton resetButtom = new JButton(resetIcon);

	    JLabel nomLabel = new JLabel("CODE(Login)                             :");
	    JTextField codeText = new JTextField();

	    JLabel prenomLabel = new JLabel("PASSWORD                              :");
	    JTextField passwordText = new JTextField();

	    JLabel FiliereLabel = new JLabel("TYPE DE L'UTILISATEUR        :");

	    String filiere[] = {"professeur", "directeur", "scolarite", "admin_apogee","etudiant"};

	    JComboBox filiereChoix = new JComboBox(filiere);
	    ResultSet rscodeAdmin;
	    ResultSet rscodeprof;
	    ResultSet rscodeetu;

	    AjouterUtilisateur() {
	        setLayoutManager();
	        setLocationAndSizeAndColor();
	        addComponentsToContainer();
	        addActionEvent();

	        this.setTitle("Espace de l'administrateur");
	        this.setVisible(true);
	        this.setBounds(250, 100, 920, 540);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setResizable(false);

	    }

	    private void setLayoutManager() {
	        container.setLayout(null);
	        formPanel.setLayout(null);
	        formPanel.setBounds(0, 100, 920, 500);
	        getContentPane().add(formPanel);

	    }

	    private void setLocationAndSizeAndColor() {
	        // Pour en-tete
	        welcomeLabel.setBounds(0, 0, 920, 90);
	        welcomeLabel.setOpaque(true);
	        welcomeLabel.setBackground(new Color(173, 216, 230));
	        welcomeLabel.setFont(new Font("Segoe UI", 1, 16));
	        welcomeLabel.setForeground(Color.BLACK);
	        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

	        addButton.setBounds(750, 330, 40, 40);
	        addButton.setOpaque(true);
	        addButton.setBackground(new Color(45, 152, 218));
	        addButton.setIcon(addIcon);

	        resetButtom.setBounds(850, 330, 40, 40);
	        resetButtom.setOpaque(true);

	        annulerButtom.setBounds(800, 330, 40, 40);
	        annulerButtom.setOpaque(true);
	        annulerButtom.setBackground(Color.WHITE);
	        annulerButtom.setFont(new Font("Segoe UI", 1, 14));
	        annulerButtom.setForeground(Color.BLACK);

	        nomLabel.setBounds(150, 35, 180, 20);
	        codeText.setBounds(320, 35, 300, 20);

	        prenomLabel.setBounds(150, 60, 180, 20);
	        passwordText.setBounds(320, 60, 300, 20);

	        FiliereLabel.setBounds(150, 85, 180, 20);
	        filiereChoix.setBounds(320, 85, 300, 20);

	    }

	    private void addComponentsToContainer() {
	        formPanel.add(annulerButtom);
	        container.add(EnsaLabel);
	        container.add(welcomeLabel);
	        formPanel.add(addButton);
	        formPanel.add(resetButtom);

	        formPanel.add(nomLabel);
	        formPanel.add(codeText);

	        formPanel.add(prenomLabel);
	        formPanel.add(passwordText);

	        formPanel.add(FiliereLabel);
	        formPanel.add(filiereChoix);
	    }

	    private void addActionEvent() {
	        addButton.addActionListener(this);
	        annulerButtom.addActionListener(this);
	        resetButtom.addActionListener(this);

	    }

	    public void resetTextField() {
	        codeText.setText("");
	        passwordText.setText("");

	    }

	    @Override
	    public void actionPerformed(ActionEvent e) {
	        if (e.getSource() == addButton) {
	            if (codeText.getText().length() > 0 && passwordText.getText().length() > 0) {
	                int input = JOptionPane.showConfirmDialog(null, "voulez-vous ajouter cet utilisateur");
	                if (input == 0) {
	                    int stc = 0;
	                    stc = stocheEtudiant(codeText.getText(), passwordText.getText(), "" + filiereChoix.getSelectedItem());
	                    if (stc == 1) {
	                        JOptionPane.showMessageDialog(this, "L'utilisateur a été stocké");
	                        resetTextField();
	                    }
	                    if (stc == 2) {
	                        JOptionPane.showMessageDialog(this, "Ce utilisateur avec ce type d'acces déjà existe");
	                    }
	                    if (stc == 0) {
	                        JOptionPane.showMessageDialog(this, "erreur le code sasai pour le login n'appartient à aucun profil ou profil et login sont incompatibles");
	                    }
	                    
	                }
	            } else {
	                JOptionPane.showMessageDialog(this, "Remplissez toutes les informations ");
	            }

	        }
	        if (e.getSource() == annulerButtom) {
	            EditionUtilisateur editionUser = new EditionUtilisateur();
	            dispose();
	        }
	        if (e.getSource() == resetButtom) {
	            resetTextField();
	        }
	    }

	    private int stocheEtudiant(String code, String password, String type) {
	        int a = 0;
	        int b=0;
	        String profil;
	        try {
	            Statement stmt0 = conn.obtenirconnexion().createStatement();
	            ResultSet rs_length = stmt0.executeQuery("SELECT count(*) As count FROM utilisateur where login=" + code);
	            rs_length.next();
	            int existe = rs_length.getInt("count");
	            if (existe > 0) {
	                a = 2;
	            }
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        if (a != 2) {
	            try {
	                Statement stmtadmin = conn.obtenirconnexion().createStatement();
	                rscodeAdmin = stmtadmin.executeQuery("select code_admin,profil from administrateur");
	                while (rscodeAdmin.next()) {
	                    if (code.equals(rscodeAdmin.getString("code_admin")) && type.equals(rscodeAdmin.getString("profil"))) {
	                        b = 1; 
	                    }
	                }
	            } catch (Exception ea) {
	                ea.printStackTrace();}
	            try{
	                Statement stmtprof = conn.obtenirconnexion().createStatement();
	                rscodeprof = stmtprof.executeQuery("select code_prof from professeur");
	                while (rscodeprof.next()) {
	                    if (code.equals(rscodeprof.getString("code_prof")) && type.equals("professeur")) {
	                        b = 1; 
	                    }
	                }}catch (Exception ep) {
	                ep.printStackTrace();}
	            try{
	                Statement stmtetu = conn.obtenirconnexion().createStatement();
	                rscodeetu = stmtetu.executeQuery("select apogee from etudiant");
	                while (rscodeetu.next()) {
	                    if (code.equals(rscodeetu.getString("apogee")) && type.equals("etudiant")) {
	                        b = 1; 
	                    }
	                }
	            }catch (Exception ee) {
	                ee.printStackTrace();}
	                 

	            

	        }
	        if (a != 2 && b!=0) {
	            try {
	                Statement stmt = conn.obtenirconnexion().createStatement();
	                int rs = stmt.executeUpdate(
	                        "INSERT INTO `utilisateur` ( `login`, `password`, `type`)"
	                        + " VALUES ( '" + code + "', '" + password + "', '" + type + "')");
	                if (rs == 1) {
	                    a = 1;
	                }
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	    
	    return a ;
	}
	

}
