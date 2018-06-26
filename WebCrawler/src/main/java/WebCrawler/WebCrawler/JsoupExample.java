package WebCrawler.WebCrawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * Hello world! Gets the product names on PLP for Bensharman
 *
 */
public class JsoupExample  {
	public static void main(String[] args) throws IOException {
		
	Document doc = Jsoup.connect("http://www.bensherman.com/store/all-clothing?limit=all").get();
	Elements productURL = doc.select("h2.product-name > a");
	/*for (Element URL : productURL) {
	  System.out.println(URL.text());
	}*/
	
	Elements imageLinks = doc.select("a.product-image > img");
    for (Element link : imageLinks) {
      // get the value from the href attribute
      System.out.println("\nlink: " + link.absUrl("data-src"));
}
}
}