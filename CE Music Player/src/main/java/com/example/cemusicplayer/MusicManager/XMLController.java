package com.example.cemusicplayer.MusicManager;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import javax.xml.XMLConstants;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;





public class XMLController {

    private static String PlayingPlaylist;

    public static void creator(Boolean value, String Song, String Genre, String Artist, String Album, String Year, String Lyrics, String Path) throws IOException {
        Element PlaylistMetadata = new Element("Metadata");
        Document doc = new Document(PlaylistMetadata);


        // para cada objeto se tiene que ir haciendo lo siguiente
        Element Songs = new Element("Songs");
        PlaylistMetadata.addContent(Songs); // este es tu hijo

        // Song 1
        Element ChoosedSong = new Element("Song");
        Element ChoosedGenre = new Element("Genero");
        Element ChoosedArtist = new Element("Artist");
        Element ChoosedAlbum = new Element("Album");
        Element ChoosedYear = new Element("Year");
        Element ChoosedLyrics = new Element("Lyrics");
        ChoosedSong.setText(Song);
        ChoosedGenre.setText(Genre); // Esto es lo que se le pone a dentro
        ChoosedArtist.setText(Artist); // Esto es lo que se le pone a dentro
        ChoosedAlbum.setText(Album); // Esto es lo que se le pone a dentro
        ChoosedYear.setText(Year); // Esto es lo que se le pone a dentro
        ChoosedLyrics.setText(Lyrics); // Esto es lo que se le pone a dentro
        Songs.addContent(ChoosedGenre);
        Songs.addContent(ChoosedArtist);
        Songs.addContent(ChoosedAlbum);
        Songs.addContent(ChoosedYear);
        Songs.addContent(ChoosedLyrics);
        Songs.addContent(ChoosedSong);


        XMLOutputter xml = new XMLOutputter();
        xml.setFormat(Format.getPrettyFormat()); //  para que no esten todas las lineas juntas
        xml.output(doc, new FileWriter(Path));
    }
    public static void readxml(){
        String FILENAME= "Users/prueba/The Dark Side Of The Moon/Any Colour You Like.mp3.xml";
        try{
            SAXBuilder sax = new SAXBuilder();


            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");


            Document doc = sax.build(new File(FILENAME));

            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");

            for (Element target : list) {

                String name = target.getChildText("Genero");
                String Artist = target.getChildText("Artist");
                String Album = target.getChildText("Album");
                String Year = target.getChildText("Year");

                System.out.println(name+Artist+Album+Year);


            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }

    }



}