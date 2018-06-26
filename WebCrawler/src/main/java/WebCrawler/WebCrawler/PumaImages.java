package WebCrawler.WebCrawler;

import java.io.*;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.URL;

public class PumaImages {

    //The url of the website. This is just an example
    private static final String webSiteURL = "http://www.bensherman.com/store/all-clothing?limit=all";

    //The path of the folder that you want to save the images to
    private static final String folderPath = "/Users/robingupta/Downloads/ImagesBenSharman";

    public static void main(String[] args) throws InterruptedException {

        try {
        	

            //Connect to the website and get the html
            Document doc = Jsoup.connect(webSiteURL).get();
            //Get all elements with img tag ,
            Elements img = doc.select("div.thumbnail > div.product-info > h2 > a");

            for (Element el : img) {

                //for each element get the srs url
                String src = el.absUrl("src");

                System.out.println("Image Found!");
                System.out.println("src attribute is : "+src);

                //getImages(src);

            }

        } catch (IOException ex) {
            System.err.println("There was an error");
            Logger.getLogger(PumaImages.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /*private static void getImages(String src) throws IOException {

        String folder = null;

        //Exctract the name of the image from the src attribute
        int indexname = src.lastIndexOf("/");

        if (indexname == src.length()) {
            src = src.substring(1, indexname);
        }

        indexname = src.lastIndexOf("/");
        String name = src.substring(indexname, src.length());

        System.out.println(name);

        //Open a URL Stream
        URL url = new URL(src);
        InputStream in = url.openStream();

        OutputStream out = new BufferedOutputStream(new FileOutputStream( folderPath+ name));

        for (int b; (b = in.read()) != -1;) {
            out.write(b);
        }
        out.close();
        in.close();

    }*/
}