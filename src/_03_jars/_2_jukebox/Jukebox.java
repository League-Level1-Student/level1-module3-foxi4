package _03_jars._2_jukebox;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */

											import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

											//PLAying music.


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import javazoom.jl.player.advanced.AdvancedPlayer;

/*   If you don't have javazoom.jar in your project, you can download it from here: http://bit.ly/javazoom
 *   Right click your project and add it as a JAR (Under Java Build Path > Libraries).*/

public class Jukebox implements Runnable, ActionListener {
	Song song = new Song("Main Heroine.mp3");
	Song song2 = new Song("New Shoes.mp3");
	Song song3 = new Song("Honeycrisp (ft. taobien).mp3");
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();

	

	
    public void run() {
    	JLabel cover1 =  loadImage("Slice of Life (ALBUM COVER).png");
    	JLabel cover2 = loadImage("New Shoes (ALBUM COVER).png");
    	JLabel cover3 = loadImage("Honeycrisp (ALBUM COVER).png");
    	button1.setText("Main Heroine - cute girls doing cute things");
    	//yes also how do you make it so the text also appears since its being covered
    	button2.setText("New Shoes - Blue Wednesday");
    	button3.setText("Honeycrisp - Seycara (ft. taobien)");
    	panel.add(cover1); 
    	panel.add(cover2);
    	panel.add(cover3);
    	panel.setPreferredSize(new Dimension(1200,500));
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	frame.add(panel);
//yes but i need to stop the song when the other is pressed
    	frame.setVisible(true);
		// 1. Find an mp3 on your computer or on the Internet.
		// 2. Create a Song object for that mp3
		// 3. Play the Song



		/*
		 * 4. Create a user interface for your Jukebox so that the user can to
		 * choose which song to play. You can use can use a different button for
		 * each song, or a picture of the album cover. When the button or album
		 * cover is clicked, stop the currently playing song, and play the one
		 * that was selected.
		 */



//touch something dk 
panel.add(button1);
panel.add(button2);
panel.add(button3);
frame.pack();
frame.setTitle("Choose a Song");

    }
    
    
	/* Use this method to add album covers to your Panel. */
	private JLabel loadImage(String fileName) {
		URL imageURL = getClass().getResource(fileName);
		Icon icon = new ImageIcon(imageURL);
		return new JLabel(icon);
		
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
			if (button1 == e.getSource()) {
				song.play();
				song2.stop();
				song3.stop();
			}
			if(button2 == e.getSource()) {
				song2.play();
				song3.stop();
				song.stop();
			}
			if(button3 == e.getSource()) {
				song3.play();
				song.stop();
				song2.stop();
				
			}
	}
		
}

class Song {

	private int duration;
	private String songAddress;
	private AdvancedPlayer mp3Player;
	private InputStream songStream;

	/**
	 * Songs can be constructed from files on your computer or Internet
	 * addresses.
	 * 
	 * Examples: <code> 
	 * 		new Song("everywhere.mp3"); 	//from default package 
	 * 		new Song("/Users/joonspoon/music/Vampire Weekend - Modern Vampires of the City/03 Step.mp3"); 
	 * 		new	Song("http://freedownloads.last.fm/download/569264057/Get%2BGot.mp3"); 
	 * </code>
	 */
	public Song(String songAddress) {
		this.songAddress = songAddress;
	}

	public void play() {
		loadFile();
		if (songStream != null) {
			loadPlayer();
			startSong();
		} else
			System.err.println("Unable to load file: " + songAddress);
	}

	public void setDuration(int seconds) {
		this.duration = seconds * 100;
	}

	public void stop() {
		if (mp3Player != null)
			mp3Player.close();
	}

	private void startSong() {
		Thread t = new Thread() {
			public void run() {
				try {
					if (duration > 0)
						mp3Player.play(duration);
					else
						mp3Player.play();
				} catch (Exception e) {
				}
			}
		};
		t.start();
	}

	private void loadPlayer() {
		try {
			this.mp3Player = new AdvancedPlayer(songStream);
		} catch (Exception e) {
		}
	}

	private void loadFile() {
		if (songAddress.contains("http"))
			this.songStream = loadStreamFromInternet();
		else
			this.songStream = loadStreamFromComputer();
	}

	private InputStream loadStreamFromInternet() {
		try {
			return new URL(songAddress).openStream();
		} catch (Exception e) {
			return null;
		}
	}

	private InputStream loadStreamFromComputer() {
		try {
			return new FileInputStream(songAddress);
		} catch (FileNotFoundException e) {
			return this.getClass().getResourceAsStream(songAddress);
		}
	}
}

