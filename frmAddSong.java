import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmAddSong extends GUI implements ActionListener{
	
	JTextField songInput = new JTextField(30);
	JTextField artistInput = new JTextField(30);
	DefaultListModel listModel = new DefaultListModel();
	JList lstSong = new JList(listModel);
	JButton btnAdd = new JButton("Add Song");
	JButton btnDone = new JButton("Done");
	JButton btnRemove = new JButton("Remove Song");
	SongSorter songSorter;
	
	/**
	 * Creates a form where the user can add songs
	 */
	public frmAddSong(){
		super();
		
		JPanel pnlList = new JPanel(new GridLayout(1,1));
		pnlList.setBounds(50,50, 350, 250);
		pnlList.setBackground(new Color(217,217,217));
		pnlList.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportView(lstSong);
		pnlList.add(scrollPane);
		this.add(pnlList);
		
		JPanel pnlInputs = new JPanel(new GridLayout(7,1));
		pnlInputs.setBounds(75, 320, 300, 120);
		pnlInputs.setBackground(new Color(217,217,217));
		pnlInputs.setBorder(BorderFactory.createLineBorder(Color.black));

		JLabel nameLabel = new JLabel("Song Name:");
		pnlInputs.add(nameLabel);
		pnlInputs.add(songInput);
		JLabel artistLabel = new JLabel("Artist:");
		pnlInputs.add(artistLabel);
		pnlInputs.add(artistInput);
		btnAdd.addActionListener(this);
		btnDone.addActionListener(this);
		btnRemove.addActionListener(this);
		pnlInputs.add(btnAdd);
		pnlInputs.add(btnRemove);
		pnlInputs.add(btnDone);
		
		this.add(pnlInputs);
		
		setVisible(true);
	}

	public void	actionPerformed(ActionEvent evt){
		// Adds the inputted song to the list
		if (evt.getSource() == btnAdd){
			addSong();
		}
		// Removes the selected song
		else if (evt.getSource() == btnRemove){
			int index = lstSong.getSelectedIndex();
			if (index > -1){
				listModel.remove(index);
			}
		}
		// Begins the sorting process if at least two songs have been added and shows the sorting form
		else if (evt.getSource() == btnDone){
			String[] songs = new String[lstSong.getModel().getSize()];
			if (songs.length < 2){
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Please input at least two songs to rank","Warning!",JOptionPane.ERROR_MESSAGE);
			}
			else {
				for (int i = 0; i < lstSong.getModel().getSize(); i++){
					songs[i] = lstSong.getModel().getElementAt(i).toString();
				}
				frmSortSongs frmSortSongs = new frmSortSongs(songs);
				this.setVisible(false);
			}
		}
	}
	public void addSong(){
		String songName = songInput.getText().trim();
		String artistName = artistInput.getText().trim();
		if (songName.isBlank() || artistName.isBlank()){
			JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Please input both Song Name and Artist Name","Warning!",JOptionPane.ERROR_MESSAGE);
		} else {
			listModel.addElement(songName + " - " + artistName);
			songInput.setText("");
			artistInput.setText("");
		}

	}
	
}