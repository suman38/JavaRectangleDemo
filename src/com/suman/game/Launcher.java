package com.suman.game;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Launcher {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame frm = new JFrame();
				Board b = new Board();
				frm.add(b);
				frm.pack();
				frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frm.setLocationRelativeTo(null);
				frm.setVisible(true);
				b.startGame();
			}
		});
	}
}
