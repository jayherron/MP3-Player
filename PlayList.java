
package edu.virginia.cs2110;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PlayList implements Playable {
private String name;
private ArrayList <Playable> playableList;

public PlayList(){
	name= "Untitled";
	playableList= new ArrayList <Playable>();
}

public PlayList(String newName){
	name= newName;
	playableList= new ArrayList <Playable>();
}
public String getName() {
	return name;
}

public void setName(String n) {
	this.name = n;
}

public ArrayList<Playable> getPlayableList() {
	return playableList;
}

public void setplayableList(ArrayList<Playable> sL) {
	this.playableList = sL;
}



public boolean loadSongs(String fileName){
	String title, artist, time, mp3;
	String[] lines = new String[4];
	int min, sec, j=0;
	File theFile = new File(fileName);
	Scanner scanr;
	try {
		scanr = new Scanner(theFile);
	} catch (FileNotFoundException e){
		e.printStackTrace();
		return false;
	}
	while ( scanr.hasNext() ) {
		for(int i = 0; i < 4; i++)
		{
			lines[i] = scanr.nextLine();
			while(lines[i].isEmpty()){
				lines[i] = scanr.nextLine();
			}
			j = lines[i].indexOf("//");
			if (j > -1)
			{
				lines[i] = lines[i].substring(0, j-1);
			}
		}
		title=lines[0];
		artist=lines[1];
		time=lines[2];
		mp3=lines[3];
		File testfile = new File(mp3);
		if (!testfile.exists())
			{
				return false;
			}
		String[] times = time.split(":");
		try
		{
			min=Integer.parseInt(times[0]);
			sec=Integer.parseInt(times[1]);
			min += sec/60;
			sec = sec%60;
			this.addSong(new Song(title,artist,min,sec, mp3));
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	return true;
}
public boolean clear(){
	playableList.clear();
	return true;
}

public boolean addSong(Song s){
	if (playableList.contains(s)){
		return false;
	}
	playableList.add(s);
	return true;
}

public Playable removeSong(int index){
	if (index < playableList.size())
	{
		Playable s = playableList.get(index);
		playableList.remove(index);
		return s;
	}
	else
	{
		return null;
	}
}

public Song removeSong(Song s){
	if (!playableList.contains(s)){
		return null;
	}
	else
	{
		playableList.remove(s);
		return s;
	}
}

public Playable getSong( int ind){
	return (Song) playableList.get(ind);
	
}



public void play()
{
	for (int i=0; i< playableList.size(); i++ ){
		playableList.get(i).play();
	}
}

public void play(double s)
{
	for (int i=0; i< playableList.size(); i++ ){
		playableList.get(i).play(s);
	}
}

public int size()
{
	return this.playableList.size();
	
}

public boolean addPlayList(PlayList pl){
	for (int i=0; i< playableList.size(); i++ ){
		if(this.playableList.get(i) instanceof PlayList ){
			if(pl.getName().equals(((PlayList)this.playableList.get(i)).getName())){
				return false;
			}
		}
	}
	playableList.add(pl);
	return true;
}

public String toString(){
	String r="";
	
	for(Playable p: playableList){
		r= "PlayList Name: " + getName() + p.toString();
	}
	return r;
}

/**
	 * @param args
	 */
	public static void main(String[] args) {
//		PlayList app = new PlayList();
//		app.loadSongs("test2-threesongs.txt");
//		PlayList pl = new PlayList();
//		pl.addSong(new Song("horse", "hound", 5, 10));
//		pl.addSong(new Song("orse", "hound", 5, 10));
//		pl.addSong(new Song("horse", "ound", 5, 10));
//		pl.addSong(new Song("horse", "hound", 4, 10));
//		pl.addSong(new Song("horse", "hound", 5, 20));
//		pl.addSong(new Song("horse", "hound", 5, 10));
//		System.out.println(app.getSong(0).toString());
//		System.out.println(app.totalPlayTime());
////		pl.addSong(new Song("horse", "hound", 70, 10));
//		System.out.println(app.totalPlayTime());
//		app.sortByArtist();
//		for (int i = 0; i < app.size(); i++)
//		{
//		Song s = app.getSong(i);
//		System.out.println(s.toString() + " Minutes: " + s.getMinutes() + " Seconds: " + s.getSeconds());
	}




}
