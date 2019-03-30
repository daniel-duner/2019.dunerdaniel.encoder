package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import controller.Controller;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class View extends JFrame {
	private Controller ctrl = new Controller();
	private JTextPane encryption;
	private JPanel contentPane;
	private JTextField input;
	private int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
					frame.setLocationRelativeTo(null);
					frame.setUndecorated(true);
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
	public View() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 574, 303);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				View.this.setLocation(x-xx, y-xy);
			}
		});
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xx = e.getX();
				xy = e.getY();
			}
		});
		panel.setBackground(new Color(255, 76, 82));
		panel.setBounds(0, 0, 193, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEncoder = new JLabel("Encoder");
		lblEncoder.setForeground(Color.WHITE);
		lblEncoder.setFont(new Font("Stencil", Font.PLAIN, 25));
		lblEncoder.setBounds(46, 36, 137, 30);
		panel.add(lblEncoder);
		
		Button generate = new Button("Generate Password");
		generate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				generate.setBackground(new Color(255, 76, 82));
			}
			public void mouseExited(MouseEvent arg0) {
				generate.setBackground(new Color(255, 76, 82));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!input.getText().equals("")) {
						encryption.setText(ctrl.encrypt(input.getText()));
					} else {
						encryption.setText("");
					}
			}
		});
		generate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		generate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		generate.setForeground(Color.WHITE);
		generate.setBackground(new Color(255, 76, 82));
		generate.setBounds(259, 125, 221, 41);
		contentPane.add(generate);
		
		input = new JTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==KeyEvent.VK_ENTER){
					if(!input.getText().equals("")) {
					encryption.setText(ctrl.encrypt(input.getText()));
					}
					else {
						encryption.setText("");
					}
			    }
			}
		});
		input.setFont(new Font("Tahoma", Font.PLAIN, 16));
		input.setBounds(228, 72, 291, 38);
		contentPane.add(input);
		input.setColumns(10);
		
		JLabel lbl_input = new JLabel("Type password to encrypt");
		lbl_input.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_input.setBounds(228, 41, 291, 20);
		contentPane.add(lbl_input);
		
		JLabel lbl_close = new JLabel("  X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
		});
		lbl_close.setForeground(Color.RED);
		lbl_close.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 19));
		lbl_close.setBounds(540, 0, 38, 38);
		contentPane.add(lbl_close);
		
		JLabel lbl_password = new JLabel("Generated Password:");
		lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_password.setBounds(228, 185, 193, 20);
		contentPane.add(lbl_password);
		
		encryption = new JTextPane();
		encryption.setFont(new Font("Tahoma", Font.PLAIN, 16));
		encryption.setEditable(false);
		encryption.setBounds(228, 216, 291, 20);
		contentPane.add(encryption);
	}
}
