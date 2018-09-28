import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class SuperAwesomeJFrame extends JFrame {
	
	private int image;
	
	private SuperAwesomeJPanel myPanel;
	private JButton tower1;
	private JButton tower2;
	private JButton tower3;
	private JButton start;

	private JLabel lblMoney;

	private JLabel lblNewLabel_1;

	private JLabel lblNewLabel;
	
	public SuperAwesomeJFrame() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(640, 704));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{120, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		MyActionListener listener = new MyActionListener();
		
		lblMoney = new JLabel("Monies = 100");
		GridBagConstraints gbc_lblNumberOfEnemies = new GridBagConstraints();
		gbc_lblNumberOfEnemies.anchor = GridBagConstraints.WEST;
		gbc_lblNumberOfEnemies.insets = new Insets(0, 0, 5, 5);
		gbc_lblNumberOfEnemies.gridx = 1;
		gbc_lblNumberOfEnemies.gridy = 11;
		getContentPane().add(lblMoney, gbc_lblNumberOfEnemies);
		
		lblNewLabel = new JLabel("Health = 5");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 10;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Number of Enemies Left = 10");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 13;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		drawMap();
		
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 10;
		gbc_panel.gridwidth = 9;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(myPanel, gbc_panel);
		
		start = new JButton("Start");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridheight = 2;
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.weighty = 0.05;
		gbc_btnNewButton.weightx = 0.05;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 10;
		getContentPane().add(start, gbc_btnNewButton);
		start.addActionListener(listener);
		
		JLabel label = new JLabel(" ");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 10;
		getContentPane().add(label, gbc_label);
		
		tower1 = new JButton("");
		tower1.setIcon(new ImageIcon("F:\\1410 eclipse\\TowerDefense\\spideyTower.png"));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridheight = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 10;
		getContentPane().add(tower1, gbc_btnNewButton_2);
		tower1.addActionListener(listener);
		
		tower2 = new JButton("");
		tower2.setIcon(new ImageIcon("F:\\1410 eclipse\\TowerDefense\\ironmanTower.png"));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.gridheight = 3;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 6;
		gbc_btnNewButton_3.gridy = 10;
		getContentPane().add(tower2, gbc_btnNewButton_3);
		tower2.addActionListener(listener);
		
		tower3 = new JButton("");
		tower3.setIcon(new ImageIcon("F:\\1410 eclipse\\TowerDefense\\ThorTower- Copy.png"));
		GridBagConstraints gbc_btnTower = new GridBagConstraints();
		gbc_btnTower.fill = GridBagConstraints.BOTH;
		gbc_btnTower.gridheight = 3;
		gbc_btnTower.insets = new Insets(0, 0, 5, 5);
		gbc_btnTower.gridx = 7;
		gbc_btnTower.gridy = 10;
		getContentPane().add(tower3, gbc_btnTower);
		tower3.addActionListener(listener);
		
		JLabel lblLevel = new JLabel("Level = 1");
		GridBagConstraints gbc_lblLevel = new GridBagConstraints();
		gbc_lblLevel.anchor = GridBagConstraints.WEST;
		gbc_lblLevel.insets = new Insets(0, 0, 5, 5);
		gbc_lblLevel.gridx = 1;
		gbc_lblLevel.gridy = 12;
		getContentPane().add(lblLevel, gbc_lblLevel);
		
		JButton btnNewButton_1 = new JButton("Pause");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridheight = 2;
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.weighty = 0.05;
		gbc_btnNewButton_1.weightx = 0.05;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 12;
		getContentPane().add(btnNewButton_1, gbc_btnNewButton_1);
		
		JLabel label_1 = new JLabel("$10");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 5;
		gbc_label_1.gridy = 13;
		getContentPane().add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel("$20");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 6;
		gbc_label_2.gridy = 13;
		getContentPane().add(label_2, gbc_label_2);
		
		JLabel label_3 = new JLabel("$30");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 7;
		gbc_label_3.gridy = 13;
		getContentPane().add(label_3, gbc_label_3);
		setVisible(true);
	}
	
	public void drawMap() {
		int numRows = 0;
		int numCols = 0; 
		
		try {
		
		String fileName = "Map.txt";
		
		
			Scanner file = new Scanner(new File(fileName));
			
			numRows = file.nextInt();
			numCols = file.nextInt();
			
			myPanel = new SuperAwesomeJPanel(200,200, numRows, numCols, lblMoney, lblNewLabel, lblNewLabel_1);
		

		
		for(int i=0; i<numRows; i++) {
			for(int j=0; j<numCols; j++) {
				String s = file.next();
		myPanel.addPicture(i, j, s + ".jpg");
			}
		}
		
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if (myPanel != null){
			getContentPane().add(myPanel);
		}
	}
	
	public static void main(String[] args) {
		SuperAwesomeJFrame g = new SuperAwesomeJFrame();
	}
	
	private class MyActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(arg0.getSource()==tower1) {
				myPanel.setWhichTower(1);
			}
			else if(arg0.getSource()==tower2) {
				myPanel.setWhichTower(2);
			}
			else if(arg0.getSource()==tower3) {
				myPanel.setWhichTower(3);
			}
			else if(arg0.getSource()==start) {
				myPanel.startGame();
			}
			
		}
		
	}

	

}
