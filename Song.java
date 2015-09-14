
package edu.virginia.cs2110;

public class Song implements Playable{

private String artist;
private String title;
private int minutes;
private int seconds;
private String  mp3File;
public Song (String InputTitle, String InputArtist, String mp3){
	title= InputTitle;
	artist= InputArtist;
	mp3File=mp3;
	
	
}

public Song ( String InputTitle, String InputArtist, int InputMinutes, int InputSeconds, String mp3){
	title= InputTitle;
	artist= InputArtist;
	minutes=InputMinutes;
	seconds=InputSeconds;
	mp3File=mp3;
	
}

public Song (Song s){
	title= s.getTitle();
	artist= s.getArtist();
	minutes= s.getMinutes();
	seconds= s.getSeconds();
	mp3File=s.getmp3File();
}

public String getArtist() {
	return artist;
}

public void setArtist(String a) {
	this.artist = a;
}

public String getTitle() {
	return title;
}

public String getmp3File() {
	return mp3File;
}

public void setTitle(String t) {
	this.title = t;
}

public int getMinutes() {
	return minutes;
}

public void setMinutes(int m) {
	this.minutes = m;
}

public int getSeconds() {
	return seconds;
}

public void setSeconds(int s) {
	this.seconds = s;
}



public boolean equals(Object o) {
	if (o instanceof Song) {
		Song x = (Song)o;
		return this.artist.equals(x.getArtist()) && this.title.equals(x.getTitle()) && this.minutes == x.getMinutes()
				&& this.seconds == x.getSeconds();
	}
	else {
		return false;
	}
}

public String toString(){
	return "Song: Title= " + getTitle() + " Artist= " + getArtist() + " Minutes= "+ getMinutes()+ "Seconds= "+ getSeconds();
}

public void play(){
	System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	Mp3FilePlayer myPlayer = new Mp3FilePlayer(this.getmp3File());
	myPlayer.playAndBlock();
}

public void play(double s){
	System.out.printf("Playing Song: artist=%-20s title=%s\n", artist, title);
	Mp3FilePlayer myPlayer = new Mp3FilePlayer(this.getmp3File());
	myPlayer.playAndBlock(s);
}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Song x = new Song("horse", "hound", 5, 20);
//		Song y = new Song("horse", "hound", 5, 20);
//		Song z = new Song(x);
//		System.out.println(x.equals(y));
//		z.setMinutes(20);
//		System.out.println(x.equals(z));
	}

}
