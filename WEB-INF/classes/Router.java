import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

class Router {
    
    private String model;
    private String controller;
    private String view;

    private String url;
    
    private XMLParser parser;
    private NodeList nList;

    public Router(String url) {

        parser = new XMLParser();
        nList = parser.getViewPath();

        for (int i = 0; i < nList.getLength(); i++) {
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String viewPath = eElement.getElementsByTagName("url-parameter").item(0).getTextContent();

                if (viewPath.equals(url)) {
                    this.model = eElement.getElementsByTagName("model").item(0).getTextContent();
                    this.controller = eElement.getElementsByTagName("controller").item(0).getTextContent();
                    this.view = eElement.getElementsByTagName("url-parameter").item(0).getTextContent();
                    break;
                }        
            }
        }
    }
   
    public String getModel() {
        return this.model;
    }

    public String getController() {
        return this.controller;
    }

    public String getView() {
        return this.view;
    }
}