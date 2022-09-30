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


/**
 * Controlador del archivo XML, permite hacer todas las manipulaciones necesarias
 * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, DiscoDurodeRoer https://www.youtube.com/watch?v=Hlo_Fw3UXt0
 */
public class XMLController {

    private static String PlayingPlaylist;

    /**
     * @param Song   La cancion que se quiere agregar al xml
     * @param Genre  El genero de la cancion que se quiere agregar
     * @param Artist El Artista de la cancion que se quiere agregar
     * @param Album  El Album de la cancion que se quiere agregar
     * @param Year   El Año de la cancion que se quiere agregar
     * @param Lyrics La letra de la cancion que se quiere agregar
     * @param Path   La direccion del archivo de la cancion que se quiere agregar
     * @throws IOException
     * @author Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556, DiscoDurodeRoer
     */
    public static void creator(String Song, String Genre, String Artist, String Album, String Year, String Lyrics, String Path) throws IOException {
        Element PlaylistMetadata = new Element("Metadata");
        Document doc = new Document(PlaylistMetadata);
        Element Songs = new Element("Songs");
        PlaylistMetadata.addContent(Songs); // este es tu hijo
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

    public static String GetGenero(File FILENAME) {
        String name = "";
        String data = String.valueOf(FILENAME);
        try {
            SAXBuilder sax = new SAXBuilder();
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            Document doc = sax.build(new File(data));
            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");
            for (Element target : list) {
                name = target.getChildText("Genero");
            }
            return name;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param FILENAME Nombre del archivo
     * @return Aritsta de la cancion
     * @author DiscoDurodeRoer https://www.youtube.com/watch?v=_tHtDjwhkKc, Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String GetArtist(File FILENAME){
        String Artist="";
        String data= String.valueOf(FILENAME);
        try{
            SAXBuilder sax = new SAXBuilder();
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            Document doc = sax.build(new File(data));
            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");
            for (Element target : list) {
                Artist = target.getChildText("Artist");
            }
            return Artist;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @param FILENAME Nombre del archivo
     * @return Aritsta del album
     * @author DiscoDurodeRoer https://www.youtube.com/watch?v=_tHtDjwhkKc, Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String GetAlbum(File FILENAME){
        String Album="";
        String data= String.valueOf(FILENAME);
        try{
            SAXBuilder sax = new SAXBuilder();
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
            Document doc = sax.build(new File(data));
            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");
            for (Element target : list) {
                Album = target.getChildText("Album");
            }
            return Album;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * @param FILENAME Nombre del archivo
     * @return Año de creacion de la cancion
     * @author DiscoDurodeRoer https://www.youtube.com/watch?v=_tHtDjwhkKc, Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String GetYear(File FILENAME){


        String Year="";
        String data= String.valueOf(FILENAME);


        try{
            SAXBuilder sax = new SAXBuilder();


            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");


            Document doc = sax.build(new File(data));

            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");

            for (Element target : list) {


                Year = target.getChildText("Year");





            }

            return Year;


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }

    }
    /**
     * @param FILENAME Nombre del archivo
     * @return Letra de la cancion
     * @author DiscoDurodeRoer https://www.youtube.com/watch?v=_tHtDjwhkKc, Oscar Arturo Acuña Duran 2022049304, Michael Suarez - 2021138556
     */
    public static String GetLyrics(File FILENAME){

        String Lyrics="";
        String data= String.valueOf(FILENAME);


        try{
            SAXBuilder sax = new SAXBuilder();


            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            sax.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");


            Document doc = sax.build(new File(data));

            Element rootNode = doc.getRootElement();
            List<Element> list = rootNode.getChildren("Songs");

            for (Element target : list) {


                Lyrics = target.getChildText("Lyrics");





            }

            return Lyrics;


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (JDOMException e) {
            throw new RuntimeException(e);
        }

    }



}