package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import main.Creator;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JTextField pathTextfield;
	Creator creator = new Creator();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel depthLabel = new JLabel("Depth");
		depthLabel.setBounds(170, 66, 46, 14);
		contentPane.add(depthLabel);

		JLabel folderCountLabel = new JLabel("Amount of Folders");
		folderCountLabel.setBounds(170, 99, 172, 14);
		contentPane.add(folderCountLabel);

		JLabel selectPathLabel = new JLabel("Path");
		selectPathLabel.setBounds(170, 132, 46, 14);
		contentPane.add(selectPathLabel);

		JComboBox selectDepthButton = new JComboBox();
		selectDepthButton
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		selectDepthButton.setBounds(26, 62, 129, 22);
		contentPane.add(selectDepthButton);

		JComboBox selectFoldersButton = new JComboBox();
		selectFoldersButton
				.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
		selectFoldersButton.setBounds(26, 95, 129, 22);
		contentPane.add(selectFoldersButton);

		pathTextfield = new JTextField();
		pathTextfield.setEditable(false);
		pathTextfield.setBounds(26, 175, 361, 20);
		contentPane.add(pathTextfield);
		pathTextfield.setColumns(10);

		JButton selectPathButton = new JButton("Choose Path");
		selectPathButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser folderChooser = new JFileChooser();
				folderChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = folderChooser.showOpenDialog(null);

				if (returnValue == JFileChooser.APPROVE_OPTION) {
					File selectedFolder = folderChooser.getSelectedFile();
					String selectedFolderPath = selectedFolder.getAbsolutePath();
					pathTextfield.setText(selectedFolderPath);
				}
			}
		});

		selectPathButton.setBounds(26, 128, 129, 23);
		contentPane.add(selectPathButton);

		JLabel headerLabel = new JLabel("File Creator V1.0");
		headerLabel.setBounds(26, 37, 103, 14);
		contentPane.add(headerLabel);

		JButton generateButton = new JButton("Generate");
		generateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int depth = Integer.parseInt((String) selectDepthButton.getSelectedItem());
				int folder = Integer.parseInt((String) selectFoldersButton.getSelectedItem());
				String path = pathTextfield.getText();
				Creator.erstelleOrdner(path, depth, folder);

			}
		});
		generateButton.setBounds(26, 203, 89, 23);
		contentPane.add(generateButton);

	}
}
