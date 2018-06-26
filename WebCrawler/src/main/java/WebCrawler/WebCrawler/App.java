package WebCrawler.WebCrawler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.processor.example.GithubRepoPageProcessor;

/**
 * Hello world!
 *
 */
public class App implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);
   

    public void process(Page page) {
       // page.addTargetRequests(page.getHtml().links().regex("(https://bensherman\\.com/\\w+/\\w+)").all());
        page.putField("Source URL", page.getHtml().xpath("//div/h2[@class=\"product-name\"]/a").toString());
       
        //page.putField("readme", page.getHtml().xpath("//div[@id='readme']/tidyText()"));
    }

    public Site getSite() {
        return site;
    }

    public static void main(String[] args) {
        Spider.create(new App()).addUrl("http://www.bensherman.com/store/all-clothing?limit=all").thread(3).run();
    }
}