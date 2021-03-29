package gameFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameInterface {
	
	protected JLabel[][] b = new JLabel[4][4];
	protected static final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 24);
	
	public GameInterface() {
		
		Board b1 = new Board();
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500,500);
		frame.setFocusable(true);
		frame.setResizable(false);
		frame.setTitle("2048 Game");
		ImageIcon image = new ImageIcon("Carter_Photo");
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(Color.gray);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.darkGray);
		panel.setBounds(0, 0, 600, 200);
		panel.setLayout(new BorderLayout());
		
		JLabel directions = new JLabel();
		JLabel title = new JLabel();
		JLabel name = new JLabel();
		title.setText("Welcome to the 2048 Game!");
		title.setForeground(Color.white);
		title.setVerticalAlignment(JLabel.TOP);
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title, BorderLayout.NORTH);
		name.setText("Coded by Carter Schmidt");
		name.setForeground(Color.white);
		name.setVerticalAlignment(JLabel.TOP);
		name.setHorizontalAlignment(JLabel.CENTER);
		panel.add(name, BorderLayout.CENTER);
		
		directions.setText("Use the Arrow Keys to move the board!");
		directions.setForeground(Color.GREEN);
		directions.setVerticalAlignment(JLabel.TOP);
		directions.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(directions, BorderLayout.SOUTH);
		
		JPanel gamePanel = new JPanel(new GridLayout(4,4,1,1));
		gamePanel.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
		gamePanel.setVisible(true);
		gamePanel.setBackground(Color.BLACK);
		gamePanel.setBounds(0,0,200,200);
		
		int[][] board = b1.returnBoardState();
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				if (board[i][j] == 0) {
					b[i][j] = new JLabel("", SwingConstants.CENTER);
				}
				else {
					b[i][j] = new JLabel(Integer.toString(board[i][j]), SwingConstants.CENTER);
				}
				b[i][j].setFont(LABEL_FONT);
				b[i][j].setOpaque(true);
				b[i][j].setBackground(Color.WHITE);
				gamePanel.add(b[i][j]);
			}
		}
		frame.add(panel, BorderLayout.NORTH);
		frame.add(gamePanel, BorderLayout.CENTER);
		frame.setVisible(true);

		
		frame.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP: {
					b1.moveUp();
					b1.randomNum();
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
							}
							else {
								b[i][j].setText("");
							}
						}
					}
					break;
				}
				case KeyEvent.VK_DOWN: {
					b1.moveDown();
					b1.randomNum();
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
							}
							else {
								b[i][j].setText("");
							}
						}
					}
					break;
				}
				case KeyEvent.VK_LEFT: {
					b1.moveLeft();
					b1.randomNum();
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
							}
							else {
								b[i][j].setText("");
							}
						}
					}
					break;
				}
				case KeyEvent.VK_RIGHT: {
					b1.moveRight();
					b1.randomNum();
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
							}
							else {
								b[i][j].setText("");
							}
						}
					}
					break;
				}
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
			
		});
	}
	
	
}
