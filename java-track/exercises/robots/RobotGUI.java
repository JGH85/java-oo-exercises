package robots;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RobotGUI {

	private JFrame frame;
	private DefaultListModel<Robot> listModel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RobotGUI window = new RobotGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RobotGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList();
		list.setBounds(198, 250, 226, -245);
		frame.getContentPane().add(list);
		
		JButton btnMakeNewRobot = new JButton("Make New Robot");
		btnMakeNewRobot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Hello. This is a test.");
				int selected = list.getSelectedIndex();
				int x = getValue("What is the starting X coordinate?", "X Coordinate");
				int y = getValue("What is the starting Y coordinate?", "Y Coordinate");
				int rot = getValue("Is it facing 0(N), 90(E), 180(S) or 270(W)?", "Direction");
				int sp = getValue("What is its speed", "Speed");
				Robot r = new Robot (x, y, rot, sp);
				listModel.add(listModel.size(), r);
			}
		});
		btnMakeNewRobot.setBounds(10, 11, 155, 23);
		frame.getContentPane().add(btnMakeNewRobot);
		
		JButton btnMoveRobot = new JButton("Move Robot");
		btnMoveRobot.setBounds(10, 45, 155, 23);
		frame.getContentPane().add(btnMoveRobot);
		
		JButton btnRotateRobot = new JButton("Rotate Robot");
		btnRotateRobot.setBounds(10, 79, 155, 23);
		frame.getContentPane().add(btnRotateRobot);
		
		JButton btnDistanceBetweenRobots = new JButton("Distance between Robots");
		btnDistanceBetweenRobots.setBounds(10, 113, 155, 23);
		frame.getContentPane().add(btnDistanceBetweenRobots);
	
	}
	
	private int getValue (String prompt, String title)
	{
		String s = (String)JOptionPane.showInputDialog(
				frame, 
				prompt, title, JOptionPane.PLAIN_MESSAGE, 
				null, null, "");
		int i = Integer.parseInt(s);
		return i;
	}
	
	
}
