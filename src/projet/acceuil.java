package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class acceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					acceuil frame = new acceuil();
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
	public acceuil() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250, 100,920, 540);
		setTitle("ENSA_SMS");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		setResizable(false);
				contentPane.setLayout(null);
		
		// Création de labels
				JLabel lbl = new JLabel("");
				lbl.setIcon(new ImageIcon(acceuil.class.getResource("/image/rab.png")));
				lbl.setBounds(186, 0, 628, 98);
				lbl.setHorizontalAlignment(SwingConstants.CENTER);
				lbl.setForeground(new Color(0,0,0));
				lbl.setFont(new Font("Times New Roman", Font.BOLD, 50));
				contentPane.add(lbl);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(173, 216, 230));
				panel.setBounds(0, 0, 175, 520);
				contentPane.add(panel);
				panel.setLayout(null);
				
				// Création de labels
				JLabel lblNewLabel = new JLabel("BIENVENUE\r\n");
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
				lblNewLabel.setForeground(new Color(240, 248, 255));
				lblNewLabel.setBounds(0, 88, 184, 27);
				panel.add(lblNewLabel);

				JLabel imgee = new JLabel("");
				imgee.setBounds(304, 203, 200, 160);
				imgee.setIcon(new ImageIcon(acceuil.class.getResource("/image/utilisateur (1).png")));
				contentPane.add(imgee);
				
				
				
				JLabel im1 = new JLabel("");
				im1.setBounds(643, 203, 200, 160);
				im1.setIcon(new ImageIcon(acceuil.class.getResource("/image/teacher.png")));
				contentPane.add(im1);
				
				// Création de boutton 
				JButton login_1 = new JButton("Administrateur");
				login_1.setBounds(273, 374, 210, 33);
				login_1.setForeground(Color.WHITE);
				login_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
				login_1.setFocusPainted(false);
				login_1.setBackground(new Color(102, 153, 255));
				contentPane.add(login_1);
				
				login_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						administration ff = new administration(); 
					}
				});
				
				// Création de boutton 
				JButton login_2 = new JButton("professeur");
				login_2.setBounds(622, 374, 210, 33);
				login_2.setForeground(Color.WHITE);
				login_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
				login_2.setFocusPainted(false);
				login_2.setBackground(new Color(102, 153, 255));
				contentPane.add(login_2);
				login_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						login_prof ff = new login_prof(); 
					}
				});
	}

}
