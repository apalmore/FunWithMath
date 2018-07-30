package com.austinpalmore.fun_with_math.probability;
import com.austinpalmore.fun_with_math.util.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lottery {
	private final int numbers_on_ticket = 6;
	private final int smallist_number_posible = 0;
	private int biggest_number_posible = 65;

	private int[] wining_numbers;
	private int[] other_numbers;

	public int[] getWining() { return this.wining_numbers; }
	public int[] getOther() { return this.other_numbers; }
	public int getOdds() { return (int)Math.pow((biggest_number_posible - smallist_number_posible), numbers_on_ticket); }

	public Lottery(boolean test_mode) {
		if (test_mode) {
			this.biggest_number_posible = 2;
		}
		this.wining_numbers = draw(numbers_on_ticket,smallist_number_posible,biggest_number_posible);
		this.other_numbers = draw(numbers_on_ticket,smallist_number_posible,biggest_number_posible);
		new LotteryGUI(this);
	}	
	private int[] draw(int size,int low,int high) {
		int[] r = new int[numbers_on_ticket];
		Random rand = new Random();
		for(int i = 0;i < numbers_on_ticket;i++)
			r[i] = rand.nextInt(high) + low;
		return r;
	}
	private class LotteryGUI extends JFrame implements ActionListener {
		private JPanel panel[] = new JPanel[3];
		private JButton button[][] = new JButton[2][6];
		private JTextArea middle_panel_jtext;
	        private int[] wining_numbers;
        	private int[] other_numbers;

		LotteryGUI(Lottery lottery) {
			super("Lottery Game 1 in " + lottery.getOdds());
			this.wining_numbers = lottery.getWining();
                        this.other_numbers = lottery.getOther();
			setSize(600,161);//this is praportional to the golden ratio
                        this.panel[0] = new JPanel(new GridLayout(2,1));

                        this.panel[1] = new JPanel(new GridLayout(1,6));
			for(int i = 0;i < 6;i++) {
				this.button[0][i] = new JButton("?");
				this.button[0][i].addActionListener(this);
				this.button[0][i].setFont(new Font("Arial", Font.PLAIN, 45));
                        	this.panel[1].add(this.button[0][i]);
                        }

                        this.panel[2] = new JPanel(new GridLayout(1,6));
                        for(int i = 0;i < 6;i++) {
                                this.button[1][i] = new JButton("" + this.other_numbers[i]);
				this.button[1][i].addActionListener(this);
				this.button[1][i].setFont(new Font("Arial", Font.PLAIN, 45));
                                this.panel[2].add(this.button[1][i]);
                        }

			this.panel[0].add(this.panel[1]);
			this.panel[0].add(this.panel[2]);
			add(this.panel[0]);
			setVisible(true);
		}
		public void actionPerformed(ActionEvent event) {
			for(int i = 0;i < 6;i++) {
				if( event.getSource() == this.button[0][i] || event.getSource() == this.button[1][i] ) {
					this.button[0][i].setText("" + this.wining_numbers[i]);
					if(this.wining_numbers[i] == this.other_numbers[i]) {
						this.button[0][i].setBackground(Color.green);
						this.button[1][i].setBackground(Color.green);
					} else {
						this.button[0][i].setBackground(Color.red);
						this.button[1][i].setBackground(Color.red);
					}
				}
			}
		}
	}
}
