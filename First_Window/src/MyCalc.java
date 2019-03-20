import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.util.Random;
import java.awt.EventQueue;
import java.util.TimerTask;
import java.util.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MyCalc extends JFrame {

	private JPanel contentPane;
	int btn_y = 0;
	int btn_x = 0;
	int boundy, boundx;
	int xrand, yrand;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCalc frame = new MyCalc();
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
	public TimerTask task;
	public MyCalc() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//345x238 max rand do wyœwietlania przycisku
		
		contentPane.setLayout(null);
		
		JButton btnClick = new JButton("Click");
		btnClick.setBounds(btn_x, btn_y, 89, 23);
		contentPane.add(btnClick);
		Timer timer = new Timer();
		task = new TimerTask() {
			@Override
			public void run() {
				
					if (btn_x < xrand)
						btn_x++;
					else if (btn_x > xrand)
						btn_x--;
					if (btn_y < yrand)
						btn_y++;
					else if (btn_y > yrand)
						btn_y--;
				btnClick.setLocation(btn_x, btn_y);
				
			}
		};
		
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				btn_y = btnClick.getLocation().y;
				btn_x = btnClick.getLocation().x;
				
				Rectangle r = contentPane.getBounds();
				boundy = r.height - btn_y;
				boundx = r.width - btn_x;
				
				Random rand = new Random();
				xrand = rand.nextInt(boundx);
				yrand = rand.nextInt(boundy);
				timer.scheduleAtFixedRate(task,3,3);

			}
		});

	}
}
