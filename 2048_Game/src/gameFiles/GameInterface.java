package gameFiles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

public class GameInterface implements ActionListener {
	
	protected JLabel[][] b = new JLabel[4][4];
	protected static final Font LABEL_FONT = new Font(Font.DIALOG, Font.PLAIN, 24);
	protected Color Purple = new Color(26,0,255);
	protected Color DarkOrange = new Color(255,94,0);
	protected Color Gold = new Color(213,183,33);
	protected Color DarkGreen = new Color(52,134,16);
	protected Board b1 = new Board();
	protected JFrame win = new JFrame();
	protected JFrame lose = new JFrame();
	protected JButton newGame = new JButton();
	protected JButton playAgain = new JButton();
	protected JButton keepPlaying = new JButton();
	protected JButton playAgainLose = new JButton();
	
	public GameInterface() {
		
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
		panel.setLayout(new BorderLayout());
		
		JLabel directions = new JLabel();
		JLabel title = new JLabel();
		JLabel name = new JLabel();
		title.setText("Welcome to the 2048 Game!");
		title.setForeground(Color.white);
		title.setVerticalAlignment(JLabel.TOP);
		title.setHorizontalAlignment(JLabel.CENTER);
		panel.add(title, BorderLayout.NORTH);
		
		name.setText("                          Coded by Carter Schmidt");
		name.setForeground(Color.white);
		name.setVerticalAlignment(JLabel.TOP);
		name.setHorizontalAlignment(JLabel.LEFT);
		panel.add(name, BorderLayout.CENTER);
		
		directions.setText("Use the Arrow Keys to move the board!");
		directions.setForeground(Color.GREEN);
		directions.setVerticalAlignment(JLabel.TOP);
		directions.setHorizontalAlignment(JLabel.CENTER);
		
		panel.add(directions, BorderLayout.SOUTH);
		
		newGame.setText("New Game");
		newGame.setFocusable(false);
		newGame.addActionListener(this);
		
		panel.add(newGame, BorderLayout.WEST);
		
		win.setLayout(null);
		win.setSize(300,300);
		win.setFocusable(true);
		win.setResizable(false);
		
		lose.setLayout(null);
		lose.setSize(300,300);
		lose.setFocusable(true);
		lose.setResizable(false);
		
		JLabel winMessage = new JLabel();
		winMessage.setText("You Win! Play a new game or continue: ");
		winMessage.setBounds(35,25,300,20);
		
		JLabel loseMessage = new JLabel();
		loseMessage.setText("No valid moves left. Play a new game? ");
		loseMessage.setBounds(35,25,300,20);
		
		playAgainLose.setBounds(60,115,150,50);
		playAgainLose.setText("Play Again");
		playAgainLose.setFocusable(false);
		playAgainLose.addActionListener(this);
		
		playAgain.setBounds(60,115,150,50);
		playAgain.setText("Play Again");
		playAgain.setFocusable(false);
		playAgain.addActionListener(this);
		keepPlaying.setBounds(60,165,150,50);
		keepPlaying.setText("Continue");
		keepPlaying.setFocusable(false);
		keepPlaying.addActionListener(this);
		
		lose.add(loseMessage);
		lose.add(playAgainLose);
		
		win.add(winMessage);
		win.add(playAgain);
		win.add(keepPlaying);
		
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
			public void keyPressed(KeyEvent e) throws IllegalArgumentException {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_UP: {
					b1.moveUp();
					if (!b1.lose()) {
						for (int i = 0; i < b1.returnBoardState().length; i++) {
							for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
								if (b1.returnBoardState()[i][j] != 0) {
									b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
									switch (b1.returnBoardState()[i][j]) {
									case (2):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (4):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (8):{
										b[i][j].setForeground(Color.red);
										break;
									}
									case (16):{
										b[i][j].setForeground(DarkOrange);
										break;
									}
									case (32):{
										b[i][j].setForeground(Gold);
										break;
									}
									case (64):{
										b[i][j].setForeground(DarkGreen);
										break;
									}
									case (128):{
										b[i][j].setForeground(Color.cyan);
										break;	
									}
									case (256):{
										b[i][j].setForeground(Color.blue);
										break;
									}
									case (512):{
										b[i][j].setForeground(Color.magenta);
										break;	
									}
									case (1024):{
										b[i][j].setForeground(Purple);
										break;	
									}
									case (2048):{
										b[i][j].setForeground(Color.pink);
										win.setVisible(true);
										break;
									}	
									}
								}
								else {
									b[i][j].setText("");
								}
							}
						}
						lose.setVisible(true);
						break;
					}
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
								switch (b1.returnBoardState()[i][j]) {
								case (2):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (4):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (8):{
									b[i][j].setForeground(Color.red);
									break;
								}
								case (16):{
									b[i][j].setForeground(DarkOrange);
									break;
								}
								case (32):{
									b[i][j].setForeground(Gold);
									break;
								}
								case (64):{
									b[i][j].setForeground(DarkGreen);
									break;
								}
								case (128):{
									b[i][j].setForeground(Color.cyan);
									break;	
								}
								case (256):{
									b[i][j].setForeground(Color.blue);
									break;
								}
								case (512):{
									b[i][j].setForeground(Color.magenta);
									break;	
								}
								case (1024):{
									b[i][j].setForeground(Purple);
									break;	
								}
								case (2048):{
									b[i][j].setForeground(Color.pink);
									win.setVisible(true);
									break;
								}	
								}
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
					if (!b1.lose()) {
						for (int i = 0; i < b1.returnBoardState().length; i++) {
							for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
								if (b1.returnBoardState()[i][j] != 0) {
									b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
									switch (b1.returnBoardState()[i][j]) {
									case (2):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (4):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (8):{
										b[i][j].setForeground(Color.red);
										break;
									}
									case (16):{
										b[i][j].setForeground(DarkOrange);
										break;
									}
									case (32):{
										b[i][j].setForeground(Gold);
										break;
									}
									case (64):{
										b[i][j].setForeground(DarkGreen);
										break;
									}
									case (128):{
										b[i][j].setForeground(Color.cyan);
										break;	
									}
									case (256):{
										b[i][j].setForeground(Color.blue);
										break;
									}
									case (512):{
										b[i][j].setForeground(Color.magenta);
										break;	
									}
									case (1024):{
										b[i][j].setForeground(Purple);
										break;	
									}
									case (2048):{
										b[i][j].setForeground(Color.pink);
										win.setVisible(true);
										break;
									}	
									}	
								}
								else {
									b[i][j].setText("");
								}
							}
						}
						lose.setVisible(true);
						break;
					}
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
								switch (b1.returnBoardState()[i][j]) {
								case (2):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (4):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (8):{
									b[i][j].setForeground(Color.red);
									break;
								}
								case (16):{
									b[i][j].setForeground(DarkOrange);
									break;
								}
								case (32):{
									b[i][j].setForeground(Gold);
									break;
								}
								case (64):{
									b[i][j].setForeground(DarkGreen);
									break;
								}
								case (128):{
									b[i][j].setForeground(Color.cyan);
									break;	
								}
								case (256):{
									b[i][j].setForeground(Color.blue);
									break;
								}
								case (512):{
									b[i][j].setForeground(Color.magenta);
									break;	
								}
								case (1024):{
									b[i][j].setForeground(Purple);
									break;	
								}
								case (2048):{
									b[i][j].setForeground(Color.pink);
									win.setVisible(true);
									break;
								}	
								}
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
					if (!b1.lose()) {
						for (int i = 0; i < b1.returnBoardState().length; i++) {
							for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
								if (b1.returnBoardState()[i][j] != 0) {
									b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
									switch (b1.returnBoardState()[i][j]) {
									case (2):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (4):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (8):{
										b[i][j].setForeground(Color.red);
										break;
									}
									case (16):{
										b[i][j].setForeground(DarkOrange);
										break;
									}
									case (32):{
										b[i][j].setForeground(Gold);
										break;
									}
									case (64):{
										b[i][j].setForeground(DarkGreen);
										break;
									}
									case (128):{
										b[i][j].setForeground(Color.cyan);
										break;	
									}
									case (256):{
										b[i][j].setForeground(Color.blue);
										break;
									}
									case (512):{
										b[i][j].setForeground(Color.magenta);
										break;	
									}
									case (1024):{
										b[i][j].setForeground(Purple);
										break;	
									}
									case (2048):{
										b[i][j].setForeground(Color.pink);
										win.setVisible(true);
										break;
									}	
									}	
								}
								else {
									b[i][j].setText("");
								}
							}
						}
						lose.setVisible(true);
						break;
					}
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
								switch (b1.returnBoardState()[i][j]) {
								case (2):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (4):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (8):{
									b[i][j].setForeground(Color.red);
									break;
								}
								case (16):{
									b[i][j].setForeground(DarkOrange);
									break;
								}
								case (32):{
									b[i][j].setForeground(Gold);
									break;
								}
								case (64):{
									b[i][j].setForeground(DarkGreen);
									break;
								}
								case (128):{
									b[i][j].setForeground(Color.cyan);
									break;	
								}
								case (256):{
									b[i][j].setForeground(Color.blue);
									break;
								}
								case (512):{
									b[i][j].setForeground(Color.magenta);
									break;	
								}
								case (1024):{
									b[i][j].setForeground(Purple);
									break;	
								}
								case (2048):{
									b[i][j].setForeground(Color.pink);
									win.setVisible(true);
									break;
								}	
								}	
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
					if (!b1.lose()) {
						for (int i = 0; i < b1.returnBoardState().length; i++) {
							for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
								if (b1.returnBoardState()[i][j] != 0) {
									b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
									switch (b1.returnBoardState()[i][j]) {
									case (2):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (4):{
										b[i][j].setForeground(Color.black);
										break;
									}
									case (8):{
										b[i][j].setForeground(Color.red);
										break;
									}
									case (16):{
										b[i][j].setForeground(DarkOrange);
										break;
									}
									case (32):{
										b[i][j].setForeground(Gold);
										break;
									}
									case (64):{
										b[i][j].setForeground(DarkGreen);
										break;
									}
									case (128):{
										b[i][j].setForeground(Color.cyan);
										break;	
									}
									case (256):{
										b[i][j].setForeground(Color.blue);
										break;
									}
									case (512):{
										b[i][j].setForeground(Color.magenta);
										break;	
									}
									case (1024):{
										b[i][j].setForeground(Purple);
										break;	
									}
									case (2048):{
										b[i][j].setForeground(Color.pink);
										win.setVisible(true);
										break;
									}	
									}
								}
								else {
									b[i][j].setText("");
								}
							}
						}
						lose.setVisible(true);
						break;
					}
					for (int i = 0; i < b1.returnBoardState().length; i++) {
						for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
							if (b1.returnBoardState()[i][j] != 0) {
								b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
								switch (b1.returnBoardState()[i][j]) {
								case (2):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (4):{
									b[i][j].setForeground(Color.black);
									break;
								}
								case (8):{
									b[i][j].setForeground(Color.red);
									break;
								}
								case (16):{
									b[i][j].setForeground(DarkOrange);
									break;
								}
								case (32):{
									b[i][j].setForeground(Gold);
									break;
								}
								case (64):{
									b[i][j].setForeground(DarkGreen);
									break;
								}
								case (128):{
									b[i][j].setForeground(Color.cyan);
									break;	
								}
								case (256):{
									b[i][j].setForeground(Color.blue);
									break;
								}
								case (512):{
									b[i][j].setForeground(Color.magenta);
									break;	
								}
								case (1024):{
									b[i][j].setForeground(Purple);
									break;	
								}
								case (2048):{
									b[i][j].setForeground(Color.pink);
									win.setVisible(true);
									break;
								}	
								}}
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == playAgain) {
			b1.resetBoard();
			for (int i = 0; i < b1.returnBoardState().length; i++) {
				for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
					if (b1.returnBoardState()[i][j] != 0) {
						b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
						b[i][j].setForeground(Color.black);
					}
					else {
						b[i][j].setText("");
					}
				}
			}
			win.setVisible(false);
		}
		else if (e.getSource() == newGame) {
			b1.resetBoard();
			for (int i = 0; i < b1.returnBoardState().length; i++) {
				for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
					if (b1.returnBoardState()[i][j] != 0) {
						b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
						b[i][j].setForeground(Color.black);
					}
					else {
						b[i][j].setText("");
					}
				}
			}
		}
		else if (e.getSource() == keepPlaying) {
			win.setVisible(false);
		}
		else if (e.getSource() == playAgainLose) {
			b1.resetBoard();
			for (int i = 0; i < b1.returnBoardState().length; i++) {
				for (int j = 0; j < b1.returnBoardState()[i].length; j++) {
					if (b1.returnBoardState()[i][j] != 0) {
						b[i][j].setText(Integer.toString(b1.returnBoardState()[i][j]));
						b[i][j].setForeground(Color.black);
					}
					else {
						b[i][j].setText("");
					}
				}
			}
			lose.setVisible(false);
		}
	}
	
	
}
