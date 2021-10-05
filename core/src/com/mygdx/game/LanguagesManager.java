package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LanguagesManager {

    private static final String LANGUAGES_FILE = "languages.xml";

    private LanguagesManager() {
    }

    public static String getLanguageChars(String languageName) {
        HashMap<String, String> _language = new HashMap<String, String>();
        StringBuilder allChars = new StringBuilder();

        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            FileHandle fileHandle = Gdx.files.internal(LANGUAGES_FILE);
            Document doc = db.parse(fileHandle.read());

            Element root = doc.getDocumentElement();

            NodeList languages = root.getElementsByTagName("language");
            int numLanguages = languages.getLength();

            for (int i = 0; i < numLanguages; ++i) {
                Node language = languages.item(i);

                if (language.getAttributes().getNamedItem("name").getTextContent().equals(languageName)) {
                    _language.clear();
                    Element languageElement = (Element) language;
                    NodeList strings = languageElement.getElementsByTagName("string");
                    int numStrings = strings.getLength();

                    for (int j = 0; j < numStrings; ++j) {
                        NamedNodeMap attributes = strings.item(j).getAttributes();
                        String key = attributes.getNamedItem("key").getTextContent();
                        String value = attributes.getNamedItem("value").getTextContent();
//                        System.out.println(value);
                        value = value.replace("<br />", "\n");
                        _language.put(key, value);
                        allChars.append(value);
                    }

                    return allChars.toString();
                }
            }
        } catch (Exception e) {
            System.out.println("Error loading languages file " + LANGUAGES_FILE);
            return null;
        }

        return null;
    }
}

