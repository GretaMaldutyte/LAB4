package com.example.madt1116;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlParser {
    public static ArrayList<String> getAllRatesFromECB(InputStream stream) throws IOException {
        ArrayList<String> result = new ArrayList<String>();

        try {
            DocumentBuilderFactory xmlDocFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder xmlDocBuilder = xmlDocFactory.newDocumentBuilder();
            Document doc = xmlDocBuilder.parse(stream);

            NodeList rateNodes = doc.getElementsByTagName(Constants.CUBE_NODE);

            for (int i = 0; i < rateNodes.getLength(); ++i) {
                Element cube = (Element) rateNodes.item(i);

                if(cube.hasAttribute("currency")){
                    String currencyName = cube.getAttribute("currency");
                    String currencyRate = cube.getAttribute("rate");

                    result.add("Currency: " + currencyName + ". Rate: " + currencyRate);
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return result;
    }
}
