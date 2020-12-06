import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmSortSongs extends GUI implements ActionListener{
    JButton btnPivot = new JButton();
    JButton btnComparisonSong = new JButton();
    boolean choiceMade = false;
    String source = null;
    SongSorter songSorter;

    /**
     * Creates a form that allows the users to sort songs by choosing between two options
     * 
     * @param songs An array of songs that are to be sorted
     */
    public frmSortSongs(String[] songs){
        super();

        JLabel lblInstruction = new JLabel("Choose which song you prefer out of the two");
        JPanel pnlLabel = new JPanel();
        pnlLabel.setBounds(85, 150, 300, 200);
        pnlLabel.add(lblInstruction);
        this.add(pnlLabel);
        btnPivot.addActionListener(this);
        btnComparisonSong.addActionListener(this);
        songSorter = new SongSorter(songs);
				
		JPanel pnlInputs = new JPanel(new GridLayout(1,2));
		pnlInputs.setBounds(85, 200, 300, 100);
        pnlInputs.setBackground(new Color(217,217,217));
        btnPivot.setHorizontalAlignment(SwingConstants.CENTER);
        btnComparisonSong.setHorizontalAlignment(SwingConstants.CENTER);
        pnlInputs.add(btnPivot);
        pnlInputs.add(btnComparisonSong);
        this.add(pnlInputs);
        setVisible(true);

        setSongs();
    }
    public void actionPerformed(ActionEvent evt){
        // Passes that their is a new minimum song to the song sorter
        if (evt.getSource() == btnPivot){
            songSorter.sort(1);
        }
        // Simply increments songsorter.j by 1
        else {
            songSorter.sort(0);
        }
        if (!(songSorter.gap > 0)){
            frmResults frmResults = new frmResults(songSorter.songs);
            this.setVisible(false);
        }
        setSongs();
    }
    /**
     * Grabs the current song names from the songSorter and sets the button text to that
     */
    public void setSongs(){
        btnPivot.setText(songSorter.jSong);
        btnComparisonSong.setText(songSorter.tempSong);
    }
}
