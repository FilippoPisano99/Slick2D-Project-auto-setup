import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Main
{
	static JTextField pathProjIn;
	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(3,1));

		JPanel p1 = new JPanel();
		JLabel nameProjLabel = new JLabel("Nome progetto:");
		JTextField nameProjIn = new JTextField(20);
		p1.add(nameProjLabel);
		p1.add(nameProjIn);


		JPanel p2 = new JPanel();
		pathProjIn = new JTextField(20);
		pathProjIn.setText("Percorso del progetto");
		pathProjIn.setEnabled(false);

		JButton choosePathBtn = new JButton("Scegli un percorso...");
		choosePathBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser(); 
				chooser.setDialogTitle("Scegli una cartella");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(new JFrame()) == JFileChooser.APPROVE_OPTION) 
				{ 
					pathProjIn.setText(chooser.getSelectedFile()+"");
				}

			}
		});
		p2.add(pathProjIn);
		p2.add(choosePathBtn);

		JButton generateBtn = new JButton("Genera");
		generateBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) 
			{
				String projName = nameProjIn.getText();
				String projPath = pathProjIn.getText();
				if(!projName.equals("") && ! projPath.equals(""))
				{
					File projDir = new File(projPath+"\\"+projName);
					projDir.mkdir();
					try
					{
						Process p = Runtime.getRuntime().exec("copyProcess.bat " +projPath+"\\"+projName);
						p.waitFor();

						System.out.println("DONE");
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}

				}

			}
		});

		p.add(p1);
		p.add(p2);
		p.add(generateBtn);

		
		f.add(p);

		
		f.setDefaultCloseOperation(3);
		f.setSize(400,200);
		f.setResizable(false);
		f.setVisible(true);
	}
}

