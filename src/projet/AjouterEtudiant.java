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

import javax.swing.*;
import java.awt.SystemColor;

public class AjouterEtudiant extends JFrame implements ActionListener {

	private JPanel contentPane;

	Connecter conn = new Connecter();
	JPanel formPanel = new JPanel();

	JLabel welcomeLabel = new JLabel("L'AJOUT D'UN ETUDIANT");
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

	JLabel nomLabel = new JLabel("NOM                                :");
	JTextField nomText = new JTextField();

	JLabel prenomLabel = new JLabel("PRENOM                        :");
	JTextField prenomText = new JTextField();

	JLabel apogeeLabel = new JLabel("APOGE                           :");
	JTextField apogeeText = new JTextField();

	JLabel CINLabel = new JLabel("CIN                                  :");
	JTextField CINText = new JTextField();

	JLabel CNELabel = new JLabel("CNE                                 :");
	JTextField CNEText = new JTextField();

	JLabel dateNaissanceLabel = new JLabel("DATE DE NAISSANCE :");
	JTextField dateNaissanceText = new JTextField();

	JLabel FiliereLabel = new JLabel("FILIERE                          :");
	String filiere[] = { "GI", "GC", "GM", "SCM", "GSTR", "2AP1", "2AP2" };
	JComboBox filiereChoix = new JComboBox(filiere);

	JLabel niveauLabel = new JLabel("NIVEAU                          :");
	JTextField niveauText = new JTextField();

	JLabel emailLabel = new JLabel("EMAIL                            :");
	JTextField emailText = new JTextField();

	JLabel groupeLabel = new JLabel("GROUPE                        :");
	JTextField groupeText = new JTextField();

	JLabel adresseLabel = new JLabel("ADRESSE                      :");
	JTextField adresseText = new JTextField();

	JLabel teteLabel = new JLabel("TELE                              :");
	JTextField teleText = new JTextField();

	public AjouterEtudiant() {
		setLayoutManager();
		setLocationAndSizeAndColor();
		addComponentsToContainer();
		addActionEvent();

		this.setTitle("Espace de l'administrateur");
		this.setVisible(true);
		this.setBounds(160, 100,1020, 550);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

	}

	private void setLayoutManager() {
		container.setLayout(null);
		formPanel.setLayout(null);
		formPanel.setBounds(0, 100, 994, 500);
		getContentPane().add(formPanel);

	}

	private void setLocationAndSizeAndColor() {
		// Pour en-tete
		welcomeLabel.setBounds(0, 0, 1025, 90);
		welcomeLabel.setOpaque(true);
		welcomeLabel.setBackground(new Color(173, 216, 230));
		welcomeLabel.setFont(new Font("Segoe UI", 1, 16));
		welcomeLabel.setForeground(SystemColor.text);
		welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

		addButton.setBounds(796, 350, 40, 40);
		addButton.setOpaque(true);
		addButton.setBackground(new Color(45, 152, 218));
		addButton.setIcon(addIcon);

		resetButtom.setBounds(926, 350, 40, 40);
		resetButtom.setOpaque(true);

		annulerButtom.setBounds(862, 350, 40, 40);
		annulerButtom.setOpaque(true);
		annulerButtom.setBackground(Color.WHITE);
		annulerButtom.setFont(new Font("Segoe UI", 1, 14));
		annulerButtom.setForeground(Color.BLACK);

		nomLabel.setBounds(150, 25, 150, 20);
		nomText.setBounds(320, 25, 300, 20);

		prenomLabel.setBounds(150, 50, 150, 20);
		prenomText.setBounds(320, 50, 300, 20);

		apogeeLabel.setBounds(150, 75, 150, 20);
		apogeeText.setBounds(320, 75, 300, 20);

		CINLabel.setBounds(150, 100, 150, 20);
		CINText.setBounds(320, 100, 300, 20);

		CNELabel.setBounds(150, 125, 150, 20);
		CNEText.setBounds(320, 125, 300, 20);

		dateNaissanceLabel.setBounds(150, 150, 150, 20);
		dateNaissanceText.setBounds(320, 150, 300, 20);

		FiliereLabel.setBounds(150, 175, 150, 20);
		filiereChoix.setBounds(320, 175, 300, 20);

		niveauLabel.setBounds(150, 200, 150, 20);
		niveauText.setBounds(320, 200, 300, 20);

		emailLabel.setBounds(150, 225, 150, 20);
		emailText.setBounds(320, 225, 300, 20);

		groupeLabel.setBounds(150, 250, 150, 20);
		groupeText.setBounds(320, 250, 300, 20);

		adresseLabel.setBounds(150, 275, 150, 20);
		adresseText.setBounds(320, 275, 300, 20);

		teteLabel.setBounds(150, 300, 150, 20);
		teleText.setBounds(320, 300, 300, 20);

	}

	private void addComponentsToContainer() {
		formPanel.add(annulerButtom);
		container.add(EnsaLabel);
		container.add(welcomeLabel);
		formPanel.add(addButton);
		formPanel.add(resetButtom);

		formPanel.add(nomLabel);
		formPanel.add(nomText);

		formPanel.add(prenomLabel);
		formPanel.add(prenomText);

		formPanel.add(apogeeLabel);
		formPanel.add(apogeeText);

		formPanel.add(CINLabel);
		formPanel.add(CINText);

		formPanel.add(CNELabel);
		formPanel.add(CNEText);

		formPanel.add(dateNaissanceLabel);
		formPanel.add(dateNaissanceText);

		formPanel.add(FiliereLabel);
		formPanel.add(filiereChoix);

		formPanel.add(niveauLabel);
		formPanel.add(niveauText);

		formPanel.add(emailLabel);
		formPanel.add(emailText);

		formPanel.add(groupeLabel);
		formPanel.add(groupeText);

		formPanel.add(adresseLabel);
		formPanel.add(adresseText);

		formPanel.add(teteLabel);
		formPanel.add(teleText);
	}

	private void addActionEvent() {
		addButton.addActionListener(this);
		annulerButtom.addActionListener(this);
		resetButtom.addActionListener(this);

	}

	public void resetTextField() {
		nomText.setText("");
		prenomText.setText("");
		apogeeText.setText("");
		CINText.setText("");
		CNEText.setText("");
		dateNaissanceText.setText("");
		niveauText.setText("");
		emailText.setText("");
		groupeText.setText("");
		adresseText.setText("");
		teleText.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addButton) {
			if (nomText.getText().length() > 0 && prenomText.getText().length() > 0 && apogeeText.getText().length() > 0
					&& CINText.getText().length() > 0 && CNEText.getText().length() > 0
					&& dateNaissanceText.getText().length() > 0 && niveauText.getText().length() > 0
					&& emailText.getText().length() > 0 && groupeText.getText().length() > 0
					&& adresseText.getText().length() > 0 && teleText.getText().length() > 0) {
				int input = JOptionPane.showConfirmDialog(null, "confirmer l'ajout ");
				if (input == 0) {
					int stc = 0;
					stc = stocheEtudiant(nomText.getText(), prenomText.getText(), apogeeText.getText(),
							CINText.getText(), CNEText.getText(), dateNaissanceText.getText(),
							"" + filiereChoix.getSelectedItem(), niveauText.getText(), emailText.getText(),
							groupeText.getText(), adresseText.getText(), teleText.getText());
					if (stc == 1) {
						JOptionPane.showMessageDialog(this, "L'étudiant a été stocké");
						resetTextField();
					}
					if (stc == 2)
						JOptionPane.showMessageDialog(this, "Numéro d'apogee déjà existe");
					if (stc == 0)
						JOptionPane.showMessageDialog(this, "erreur");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Remplissez toutes les informations ");
			}

		}
		if (e.getSource() == annulerButtom) {
			EditionEtudiant editionEtudiant = new EditionEtudiant();
			dispose();
		}
		if (e.getSource() == resetButtom) {
			resetTextField();
		}
	}

	private int stocheEtudiant(String nom, String prenom, String apogee, String CIN, String CNE, String dateNaissance,
			String filiere, String niveau, String email, String groupe, String adresse, String tele) {
		int a = 0;
		try {
			Statement stmt0 = conn.obtenirconnexion().createStatement();
			ResultSet rs_length = stmt0
					.executeQuery("SELECT count(*) As count FROM etudiant where apogee=" + apogee + "  ;");
			rs_length.next();
			int existe = rs_length.getInt("count");
			if (existe > 0)
				a = 2;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (a != 2)
			try {
				Statement stmt = conn.obtenirconnexion().createStatement();
				int rs = stmt.executeUpdate(
						"INSERT INTO `etudiant` ( `apogee`, `cin`, `cne`, `nom`, `prenom`, `email`, `niveau`, `filiere`, `groupe`, `date_naissance`, `adresse`, `telephone`)"
								+ " VALUES ( '" + apogee + "', '" + CIN + "', '" + CNE + "', '" + nom + "', '" + prenom
								+ "', '" + email + "', '" + niveau + "', '" + filiere + "',  " + Integer.valueOf(groupe)
								+ ", '" + dateNaissance + "','" + adresse + "', '" + tele + "')");
				if (rs == 1)
					a = 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return a;
		
	}

}
