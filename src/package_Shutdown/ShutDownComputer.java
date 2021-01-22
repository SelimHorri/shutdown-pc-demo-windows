package package_Shutdown;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.border.LineBorder;

public class ShutDownComputer {
// Begin Class
	
	private JFrame frame;
	private JTextField txtEnterTimeAmount;
	private JComboBox<String> comboBox;
	private boolean verif = false;
	
	private void initialize () {
	// Begin initialize()
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\USER\\Desktop\\Prg\\- Java -\\ShutDown_Computer\\Sign-Shutdown-icon.ico"));
		frame.setBounds(100, 100, 614, 350);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if ( (txtEnterTimeAmount.getText().isEmpty()) || (txtEnterTimeAmount.getText().contains("Enter Time amount")) ) {
					txtEnterTimeAmount.setForeground(Color.lightGray);
					txtEnterTimeAmount.setText("Enter Time amount");
				}
				
			}
		});
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(0, 0, 608, 321);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		comboBox = new JComboBox<String>();
		comboBox.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		comboBox.setBackground(new Color(255, 228, 196));
		comboBox.setFont(new Font("Tahoma", Font.ITALIC, 9));
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Hours", "Minutes", "Seconds"}));
		comboBox.setBounds(331, 85, 80, 32);
		panel.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setBounds(182, 52, 150, 31);
		panel.add(label);
		
		txtEnterTimeAmount = new JTextField();
		txtEnterTimeAmount.setBackground(new Color(255, 228, 196));
		txtEnterTimeAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				
				int c = arg0.getKeyCode();
				
				if (c == KeyEvent.VK_ENTER)
					test();
				
			}
		});
		txtEnterTimeAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txtEnterTimeAmount.setForeground(Color.BLACK);
				
				if ( (txtEnterTimeAmount.getText().isEmpty()) || (txtEnterTimeAmount.getText().contains("Enter Time amount")) ) {
					txtEnterTimeAmount.setText(null);
				}
				
			}
		});
		txtEnterTimeAmount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				
				if ( (txtEnterTimeAmount.getText().isEmpty()) || (txtEnterTimeAmount.getText().contains("Enter Time amount")) ) {
					txtEnterTimeAmount.setForeground(Color.lightGray);
					txtEnterTimeAmount.setText("Enter Time amount");
				}
				else {
					txtEnterTimeAmount.setForeground(Color.black);
				}
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				
				txtEnterTimeAmount.setForeground(Color.black);
				
				if ( (txtEnterTimeAmount.getText().isEmpty()) || (txtEnterTimeAmount.getText().contains("Enter Time amount")) ) {
					txtEnterTimeAmount.setText(null);
				}
				
			}
		});
		txtEnterTimeAmount.setForeground(new Color(169, 169, 169));
		txtEnterTimeAmount.setFont(new Font("Microsoft New Tai Lue", Font.PLAIN, 13));
		txtEnterTimeAmount.setBorder(new LineBorder(new Color(192, 192, 192), 1, true));
		txtEnterTimeAmount.setText("Enter Time amount");
		txtEnterTimeAmount.setBounds(182, 86, 150, 31);
		panel.add(txtEnterTimeAmount);
		txtEnterTimeAmount.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBorder(new LineBorder(Color.LIGHT_GRAY, 2, true));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				test();
				
			}
		});
		btnOk.setFont(new Font("Century Gothic", Font.BOLD | Font.ITALIC, 14));
		btnOk.setForeground(new Color(165, 42, 42));
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setBounds(243, 191, 89, 32);
		panel.add(btnOk);
		
//		JSeparator separator = new JSeparator();
//		separator.setForeground(Color.BLACK);
//		separator.setBounds(182, 116, 150, 9);
//		panel.add(separator);
		
		JButton btnCancelOperation = new JButton("Cancel Operation");
		btnCancelOperation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					Runtime.getRuntime().exec("shutdown -a");
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if (verif == false)
					JOptionPane.showMessageDialog(null,"Le système n’étant pas en cours d’arrêt, il est impossible d’annuler l’arrêt du système.(1116)");
				else {
					
					try {
						Runtime.getRuntime().exec("shutdown -a");
					}
					catch (IOException e) {
						e.printStackTrace();
					}
					
					verif = false;
					
				}
				
			}
		});
		btnCancelOperation.setForeground(new Color(0, 100, 0));
		btnCancelOperation.setBorder(null);
		btnCancelOperation.setBackground(Color.WHITE);
		btnCancelOperation.setFont(new Font("Tahoma", Font.ITALIC, 9));
		btnCancelOperation.setBounds(248, 158, 73, 11);
		panel.add(btnCancelOperation);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.BLACK);
		separator_1.setBounds(248, 171, 73, 9);
		panel.add(separator_1);
		
	// End initialize()
	}
	
	private void test () {
	// Begin test()
		
		if ( (txtEnterTimeAmount.getText().isEmpty()) || (txtEnterTimeAmount.getText().contains("Enter Time amount")) )
			JOptionPane.showMessageDialog(null,"Field's empty");
		else {
			
			int h = 0,m = 0,s = 0;
			Object selected = comboBox.getSelectedItem();
				
				if (selected.toString().equals("Hours")) {
					
					try {
						h = Integer.parseInt(txtEnterTimeAmount.getText().trim());
						s = h * 3600;
						
						try {
							
							Runtime.getRuntime().exec("shutdown.exe -s -f -t "+ s +" ");
							verif = true;
							txtEnterTimeAmount.setText(null);
							int choice = JOptionPane.showConfirmDialog(null,"Would you like to cancel shutdown operation ?");
							if (choice == 0)
								Runtime.getRuntime().exec("shutdown -a");
							else
								if (choice == 1)
									System.exit(0);
							
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Please enter numbers only !");
					}
					
				}
				
				if (selected.toString().equals("Minutes")) {
					
					try {
						m = Integer.parseInt(txtEnterTimeAmount.getText().trim());
						s = m * 60;
						
						try {
							Runtime.getRuntime().exec("shutdown.exe -s -f -t "+ s +" ");
							verif = true;
							txtEnterTimeAmount.setText(null);
							int choice = JOptionPane.showConfirmDialog(null,"Would you like to cancel shutdown operation ?");
							if (choice == 0)
								Runtime.getRuntime().exec("shutdown -a");
							else
								if (choice == 1)
									System.exit(0);
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Please enter numbers only !");
					}
					
				}
				
				if (selected.toString().equals("Seconds")) {
					
					try {
						s = Integer.parseInt(txtEnterTimeAmount.getText().trim());
						
						try {
							Runtime.getRuntime().exec("shutdown.exe -s -f -t "+ s +" ");
							verif = true;
							txtEnterTimeAmount.setText(null);
							int choice = JOptionPane.showConfirmDialog(null,"Would you like to cancel shutdown operation ?");
							if (choice == 0)
								Runtime.getRuntime().exec("shutdown -a");
							else
								if (choice == 1)
									System.exit(0);
						}
						catch (IOException e) {
							e.printStackTrace();
						}
					}
					catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(null,"Please enter numbers only !");
					}
					
				}
			
		}
		
	// End test()
	}
	
	public ShutDownComputer () {
		initialize();
	}
	
	public static void main (String[] args) {
	// Begin main()
		
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
					ShutDownComputer window = new ShutDownComputer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	// End main()
	}
	
// End Class
}
