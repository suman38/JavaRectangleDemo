package com.suman.game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;

	private Timer gameThread;

	private Rectangle r1,r2,r3;
	
	private int maxHealth, health;
	private int mana, maxMana;

	public Board() {
		maxHealth = 500;
		health = maxHealth;
		
		maxMana = 100;
		mana = maxMana;
		
		r1 = new Rectangle(10, 10, 250, 20);
		r2 = new Rectangle(10, 50, 250, 20);
		r3 = new Rectangle(10, 90, 250, 20);

		
		setFocusable(true);
		addMouseListener(this);
		
		
		
		gameThread = new Timer(16, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
		
				repaint();
			}
		});
	}

	public void startGame() {
		gameThread.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g2.setColor(Color.BLACK);
//		g2.setStroke(new BasicStroke(5));
		
		g2.fillRoundRect(r1.x, r1.y, r1.width, r1.height, 10, 10);
		g2.fill(r2);
		g2.fill(r3);
		
		g2.setColor(Color.RED);
		g2.fillRoundRect(r1.x, r1.y, (r1.width*health)/maxHealth, r1.height, 10, 10);
		
		g2.setColor(Color.CYAN);
		g2.fillRect(r2.x,r2.y,(r2.width*mana)/maxMana,r2.height);
		
		g2.setColor(Color.YELLOW);
		g2.fill(r3);
		
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}
	
	private void hurt(int damage)
	{
		health -= damage;
		if(health <= 0)health = 0;
		
		System.out.println("got hurt");
		
	}
	
	private void heal(int amount)
	{
		if(mana>0) {
		health += amount;
		mana -= 10;
		if(health >= maxHealth)
			health = maxHealth;
		
		
		if(mana <=0)
			mana = 0;
		
		
		
		System.out.println("got healed");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON1)
		{
			hurt(10);
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			heal(15);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
