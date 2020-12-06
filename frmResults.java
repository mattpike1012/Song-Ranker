import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class frmResults extends GUI{
    String[] songs;
    DefaultListModel listModel = new DefaultListModel();
    JList lstResults = new JList(listModel);

    /**
     * Creates a form where users can see the song ranking results
     */
    public frmResults(String[] songs){
        super();
        JPanel pnlLabel = new JPanel(new GridLayout(1,1));
        pnlLabel.setBounds(50,20, 300, 30);
        JLabel lblTitle = new JLabel("Song Rankings");
        pnlLabel.add(lblTitle);
        this.add(pnlLabel);
        JPanel pnlList = new JPanel(new GridLayout(1,1));
		pnlList.setBounds(50,50, 350, 250);
        pnlList.setBackground(new Color(217,217,217));
        pnlList.setBorder(BorderFactory.createLineBorder(Color.black));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(lstResults);
        pnlList.add(scrollPane);
		this.add(pnlList);

        // Creates an ordered list based on the sort that is displayed
        int count = 1;
        for (int i = songs.length - 1; i > -1;  i--){
            listModel.addElement(String.format("%d. %s", count, songs[i]));
            count++;
        }
        setVisible(true);
    }
}
