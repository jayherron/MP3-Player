
package edu.virginia.cs2110;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.security.auth.login.FailedLoginException;


public class PlayListTest {

       private static PlayList p1 = new PlayList ("name1");
       private static PlayList p2 = new PlayList ("name2");
       private static PlayList p3 = new PlayList ("name3");

       private static Song s1 = new Song("title1","artist1","mp31");
       private static Song s2 = new Song("title2","artist2","mp32");

       @Before
       public void setUp() throws Exception {
               p1 = new PlayList("name1");
               p2 = new PlayList ("name2");
               p3 = new PlayList("name3");
               s1 = new Song("title1","artist1","mp31");
               s2 = new Song("title2","artist2","mp32");
       }

       @Test
       public void testAddSong1(){
//              String testId = "P-AddS1";
//              String descr = "Adding a song to the playlist should return true.";
               assertTrue(p1.addSong(s1));
               assertTrue(p1.size()==1);
       }
       @Test
       public void testAddSong2(){
//              String testId = "P-AddS2";
//              String descr = "Adding the same song to the same playlist should return false.";
               assertTrue(p1.addSong(s1));
               assertFalse(p1.addSong(s1));
       }
       @Test
       public void testAddSong3(){
//              String testId = "P-AddS3";
//              String descr = "Adding different songs to the same playlist should return true.";
               assertTrue(p1.addSong(s1));
               assertTrue(p1.addSong(s2));
               assertTrue(p1.size()==2);
       }
       @Test
       public void testAddPlayList1(){
//              String testId = "P-AddP1";
//              String descr = "Adding the same playlist twice to another playlist should return false.";
               assertTrue(p1.addPlayList(p2));
               assertFalse(p1.addPlayList(p2));
               assertTrue(p1.size()==1);
               assertTrue(p2.size()==0);
       }
       @Test
       public void testAddPlayList2(){
//              String testId = "P-AddP2";
//              String descr = "Adding a playlist not yet in another playlist should return true.";
               assertTrue(p1.addPlayList(p2));
               assertTrue(p2.addPlayList(p1));
               assertTrue(p1.size()==1);
               assertTrue(p2.size()==1);
       }
       @Test
       public void testAddPlayList3(){
//              String testId = "P-AddP3";
//              String descr = "Adding multiple playlists into each other should return true.";
               assertTrue(p2.addPlayList(p3));
               assertTrue(p1.addPlayList(p2));
               assertTrue(p1.size()==1);
               assertTrue(p2.size()==1);
               assertTrue(p3.size()==0);
       }
       @Test
       public void testLoadSongs1(){
//              String testId = "P-LoadS1";
//              String descr = "Passing a non-existant file into the method should return false.";
               assertFalse(p1.loadSongs("thisDoesNotExist.txt"));
               assertTrue(p1.size()==0);
       }
       @Test
       public void testLoadSongs2(){
//              String testId = "P-LoadS2";
//              String descr = "Passing a correctly formatted file into the method should return true.";
               assertTrue(p1.loadSongs("correct.txt"));
               assertTrue(p1.size()==1);
       }
       @Test
       public void testLoadSongs3(){
//              String testId = "P-LoadS3";
//              String descr = "Passing a file with excess comments and commenting slashes into the method should return true.";
               assertTrue(p1.loadSongs("slashes.txt"));
               assertTrue(p1.size()==1);
       }
       @Test
       public void testLoadSongs4(){
//              String testId = "P-LoadS4";
//              String descr = "Passing a file with blank lines between data into the method should return true.";
               assertTrue(p1.loadSongs("spaces.txt"));
               assertTrue(p1.size()==1);
       }
       @Test
       public void testLoadSongs5(){
//              String testId = "P-LoadS5";
//              String descr = "Passing a file with incorrectly formatted runtimes into the method should return true.";
               assertTrue(p1.loadSongs("wrongTime.txt"));
               assertTrue(p1.size()==1);
       }

       @Test
       public void testLoadSongs6(){
//              String testId = "P-LoadS6";
//              String descr = "Passing a blank file into the method should return true.";
               assertTrue(p1.loadSongs("blank.txt"));
               assertTrue(p1.size()==0);

       }
}