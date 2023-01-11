package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class login_scolarité extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField passwords;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_scolarité frame = new login_scolarité();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login_scolarité() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setBounds(160, 100,1020, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
	
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane();
		setVisible(true);
		
	
		// Création de panels
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(0, 0, 330, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// Création de labels
		JLabel lblNewLabel = new JLabel("ADMINISTRATION\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.black);
		lblNewLabel.setBounds(0, 22, 326, 55);
		panel.add(lblNewLabel);
		
		
	
		//Creation de labels
		JLabel lblLogin = new JLabel("");
		lblLogin.setIcon(new ImageIcon(login_directeur.class.getResource("/image/user.png")));
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 45));
		lblLogin.setBounds(598, 11, 490, 136);
		contentPane.add(lblLogin);
		
		
		// creation de nom de barre de text 
		JLabel lblNewLabell = new JLabel("nom d'utilisateur");
		lblNewLabell.setForeground(new Color(0,0,0));
		lblNewLabell.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabell.setBounds(466, 186, 190, 27);
		contentPane.add(lblNewLabell);
		
		JLabel lblNewLabel_1 = new JLabel("mot de passe");
		lblNewLabel_1.setForeground(new Color(0,0,0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(500, 280,180, 27);
		contentPane.add(lblNewLabel_1);
		
		
	 // creation de barre de text
		username = new JTextField();
		username.setBounds(700, 190, 190, 27);
		contentPane.add(username);
		username.setColumns(10);
		username.setVisible(true);
		
		passwords = new JPasswordField();
		passwords.setBounds(700, 280, 190, 27);
		contentPane.add(passwords);
		passwords.setColumns(10);
		
		//Connexion a la base de donnée
		JButton next = new JButton("Connexion");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Statement st;
				Connection con;
				
				String addCheck = username.getText();
				String apgCheck = passwords.getText();

				// Affichage de message d'erreurs au cas d'erreur ou oublier la barre vide
				
				if(addCheck.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Entrez votre username!");
				}
				else if (apgCheck.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Entrez votre mot de passe!");
				}
				
				else
				{
					try 
					{
						//Connextion a la base de donnée
						
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensasms","root","");
						st = con.createStatement();
						//Check if username and passwords exist in BD 
						String sql = "Select * From utilisateur Where login= '"+username.getText()+"'and password = '"+passwords.getText()+"' and type='scolarité'";
						ResultSet res = st.executeQuery(sql);
						if(res.next())
						{
							setVisible(false);
		        		   listes_etudiants ff = new listes_etudiants();
						}
						else
							JOptionPane.showMessageDialog(null, "La connexion a échoué, veuillez réessayer..");
						con.close();
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
				}
			}
		});
		next.setFont(new Font("Times New Roman", Font.BOLD, 15));
		
		next.setForeground(Color.WHITE);
		next.setBackground(new Color(173,216,230));
		next.setBounds(565, 373, 283, 36);
		contentPane.add(next);
	
	// creation de boutton
	JButton back = new JButton("Retour");
	back.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
      acceuil cl = new acceuil();
		}
	});
	back.setFont(new Font("Times New Roman", Font.BOLD, 15));
	back.setForeground(Color.BLACK);
	back.setBackground( new Color(173,216,230));
	back.setBounds(360, 454, 100, 27);;
	contentPane.add(back);

	}

}
