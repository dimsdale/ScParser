package com;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.utils.HTMLParser;
import com.utils.JSONConverter;
import com.utils.impl.BasicHTMLParser;
import com.utils.impl.BasicJsonConverter;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static Logger logMain = Logger.getLogger(Main.class);
    private static HTMLParser htmlParser;
    private static JSONConverter jsonConverter;
     public static void main(String[] args) throws IOException {
         htmlParser = new BasicHTMLParser();
         jsonConverter = new BasicJsonConverter();
         Document page =htmlParser.getMainPage();
         System.out.println(page.toString());


     }
}
