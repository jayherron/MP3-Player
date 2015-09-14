
package edu.virginia.cs2110;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class Mp3Player {
	public static PlayList main = new PlayList("main");
	private static ArrayList<PlayList> myLists = new ArrayList<PlayList>();

	public PlayList getMainPlayList(){
		return main;
	}
	public ArrayList getPlayList(){
		ArrayList <PlayList> tempList = new ArrayList <PlayList>();
		for (Playable next : myLists ) {
			if ( next instanceof Song ) {
				Song s = (Song) next;

			}
			else if ( next instanceof PlayList ) {
				PlayList pl = (PlayList) next;
				tempList.add(pl);
				;
				// do what you need for a PlayList
			}

		}

		return tempList;
	}


	public boolean isInMyList(String plName){
		for(PlayList p: myLists)
		{
			if(plName.equals(p.getName()))
				return true;
		}
		return false;
	}

	public PlayList listToUse(String plName){
		for(int i = 0; i < myLists.size(); i++){
			if (myLists.get(i).getName().equals(plName))
				return myLists.get(i);
		}
		return null;	
	}


	//getters
	public void start(){

		myLists.add(main);
		boolean b = true;
		Scanner kybrd = new Scanner (System.in);
		int in = 20;
		String option,plname, p2name, songname, filename, artist;
		int min, sec;
		double psec;
		Mp3FilePlayer myPlayer;
		System.out.println("Welcome to the Mp3 Player: ");
		System.out.println("_____________________________ ");
		while (b){
			System.out.println("Enter a number to select an option from the menu (11 displays a list of options):");
			try 
			{
				in =  kybrd.nextInt();
				kybrd.nextLine();
			}
			catch (Exception e)
			{
				kybrd.nextLine();
				in = 20;
			}
			switch (in){
			case 1:
				System.out.println("Please Enter Name of Play List You Would Like To Create: ");
				plname = kybrd.next();
				boolean found=false;
				for(int i = 0; i < myLists.size(); i++)
				{
					if (myLists.get(i).getName().equals(plname))
					{
						System.out.println("This playlist already exists. Please choose a new menu item.");
						found=true;
					}
				}
				if(!found){
					myLists.add(new PlayList(plname));
					System.out.println("The Play List "+ plname+ " Has Been Created.");
				}

				break;
			case 2:
				System.out.println("Please Enter Name of Play List You Would Like To Add Songs To: ");
				plname = kybrd.next();
				if (!isInMyList(plname)){
					System.out.println("This Play List Does Not Exist");
					break;
				}
				System.out.println("Please Enter Name of the text file you wish to load songs from: ");
				filename = kybrd.next();
				File c2= new File(filename);
				if(!c2.exists()){
					System.out.println("This File Does Not Exist");
					break;}
				else {
					listToUse(plname).loadSongs(filename);

					System.out.println("Play List "+ plname+ " Has Been Updated With " + filename);}
				break;

			case 3:
				System.out.println("First, Please Enter Name of Play List You Would Like To Add An Mp3 To: ");
				plname = kybrd.nextLine();
				if (!isInMyList(plname)){
					System.out.println("This Play List Does Not Exist");
					break;
				}
				System.out.println("Now, Please Enter File Name Of The Song You Wish To Add: ");
				filename = kybrd.nextLine();
				File c3= new File(filename);
				if(!c3.exists()){
					System.out.println("This File Does Not Exist");
					break;
				}
				System.out.println("Please Enter Name of the Song: ");
				songname = kybrd.nextLine();
				System.out.println("Please Enter Artist of the Song: ");
				artist = kybrd.nextLine();
				System.out.println("Please Song's Length In Minutes: ");
				min = kybrd.nextInt();
				
				System.out.println("Please Song's Length In Seconds: ");
				sec = kybrd.nextInt();

				listToUse(plname).addSong(new Song(songname, artist, min, sec, filename));
				System.out.println("The Song: " + filename+ " Has Been Added To " + plname);
				break;
			case 4:
				System.out.println("Please Enter Name of Play List You Would Like To Update: ");
				plname = kybrd.next();

				System.out.println("Please Enter Name of Play List You Would Like To Add: ");
				p2name = kybrd.next();
				PlayList p2 = new PlayList(p2name);
				int index = 0;
				boolean listExists=false;
				for(int i = 0; i < myLists.size(); i++)
				{
					if (myLists.get(i).getName().equals(plname))
					{
						myLists.get(i).addPlayList(p2) ;
						index = i;
						listExists=true;
					//	System.out.println(myLists.get(i).size());
					}
				}
				if (!listExists){
					System.out.println("Sorry, The Play List Doesn't Exist. ");
				}
				for(int x = 0; x<myLists.get(index).size(); x++){
					ArrayList<Playable> g = myLists.get(index).getPlayableList();
					String usethisname = ( (((PlayList) g.get(0)).getName())  );
					if(g.contains(p2)){
						System.out.println(p2name + " is in "+ plname);
					}
					else{
						System.out.println("The Play List Could Not Be Added" );//+ myLists.get(index).getPlayableList().get(0)); //.get(x).toString());
					}
				}
				break;
			case 5:
				System.out.println("Please Enter Name of Play List You Would Like To Play: ");
				plname = kybrd.next();
				PlayList c5= new PlayList(plname);
				
				for (int q = 0; q < myLists.size(); q++) {
					if (myLists.get(q).getName().equals(c5.getName())
							&& myLists.get(q) instanceof PlayList) {


						PlayList newTempList = new PlayList();
						newTempList = (PlayList) myLists.get(q);
					}}
				if (!isInMyList(plname)){
					
					System.out.println("This Play List Does Not Exist");
				}
//				if (!n.getPlayableList().isEmpty()){
//					System.out.println("This Play List is Empty");
//					break;
//				}
				System.out.println("Would You Like To Play The Whole Song In The Selected Play List? Enter 'yes' Or 'no:");
				option= kybrd.next();
				if (option.equalsIgnoreCase("yes")){
					listToUse(plname).play();
				}
				if (option.equalsIgnoreCase("no")){
					System.out.println("Please Enter The Number Of Seconds You Would Like To Play Each Song:");
					psec= kybrd.nextDouble();
					for(int i = 0; i < myLists.size(); i++)
					{
						if (myLists.get(i).getName().equals(plname))
						{
							myLists.get(i).play(psec);
						}
					}
				}

				break;
			case 6:
				System.out.println("Please Enter FileName of the Mp3 File You Would Like to Play ");

				File f = new File( kybrd.nextLine());
				if (!f.exists()) {

					System.out.println("Sorry, that file does not exist.");
					break;
				}

				System.out.println("Would You Like To Play The Whole Song, Enter 'yes' Or 'no:");
				option= kybrd.next();
				if (option.equalsIgnoreCase("yes")){
					Mp3FilePlayer mp3 = new Mp3FilePlayer(f.getName());
					mp3.playAndBlock();
				}
				if (option.equalsIgnoreCase("no")){
					System.out.println("Please Enter The Number Of Seconds You Would Like To Play The Song:");
					psec= kybrd.nextDouble();
					Mp3FilePlayer mp3 = new Mp3FilePlayer(f.getName());
					mp3.playAndBlock(psec);
					System.out.println("You are Listening to: " +f);
				}

				break;
			case 7:
				System.out
						.println("Please Enter The Name Of Play List To View Its Contents? ");
				String plname3 = kybrd.next();
				PlayList temp1 = new PlayList(plname3);
				System.out.println("inside case 7");
				if (isInMyList(plname3)) {
					for (int q = 0; q < myLists.size(); q++) {
						if (myLists.get(q).getName().equals(temp1.getName())
								&& myLists.get(q) instanceof PlayList) {
							// System.out.println("inside if loop");

							PlayList newTempList = new PlayList();
							newTempList = (PlayList) myLists.get(q);
							System.out.println("The List you selected "
									+ newTempList.getName());
							for (int y = 0; y < newTempList.size(); y++) {
								if (newTempList.getPlayableList().get(y) instanceof PlayList) {
									PlayList realPL = new PlayList();
									realPL = (PlayList) newTempList
											.getPlayableList().get(y);
									System.out.println("The Inside list: "
											+ realPL.getName());
								}
								if (newTempList.getPlayableList().get(y) instanceof Song) {
									Song realSong;
									realSong = (Song) newTempList
											.getPlayableList().get(y);
									System.out.println("A Song: "
											+ realSong.toString());
								}
							}
						}
					}
				} else
					System.out
							.println("The Play List You Entered Does Not Exist");
				break;
			case 8:
				ArrayList <Song> mainSongList= new ArrayList <Song>();
				ArrayList<PlayList> mainPlayListList= new ArrayList <PlayList>();
				for (Playable next : myLists.get(0).getPlayableList()) {

					if ( next instanceof PlayList ) {
						PlayList pl = (PlayList) next;
						mainPlayListList.add(pl);
					}

					else if ( next instanceof Song ) {
						Song s = (Song) next;
						mainSongList.add(s);
					}
					System.out.println(""+ mainSongList+ " " + mainPlayListList);
				}
				break;
			case 9:
				for (int j=0; j<myLists.size(); j++){

					System.out.println(myLists.get(j).getName());
				}
				break;
			case 10:
				b=false;
				break;
			case 11:
				System.out.println("1.Create a new play-list with a given name.");
				System.out.println("2.Load Songs Into A Play List From A Data File"); 
				System.out.println("3.Add an Mp3 File To an Existing Play List");
				System.out.println("4.Add a Play List To an Existing Play List");
				System.out.println("5.Play All The Songs In The Play List Of Your Choice");
				System.out.println("6.Play an Mp3 File");
				System.out.println("7.Print the contents of a play-list.");
				System.out.println("8.View Contents Of Main Play List");
				System.out.println("9.View All PLay Lists.");
				System.out.println("10.Exit.");
				break;
			default:
				System.out.println("This is incorrect input. Please try again.");
			}
		}
		//main.addSong(new Song("songName", "band",3,20, "C:\\Users\\Ash\\Desktop\\GMOD\\Bassnectar - Bass Head (Original Mix).mp3"));
		//main.play();


	}



	public static void main(String[] args){

		Mp3Player myPlayer = new Mp3Player();
		myPlayer.start();

	}
}
