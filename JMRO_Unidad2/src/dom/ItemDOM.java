package dom;



import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Item;


public class ItemDOM {
	private String pathFile = "C:\\Users\\Rincon\\newworkspace\\JMRO_Unidad2\\src\\data\\items.xml";
	public void add(Item data) {
		try {
			
				Document document = DOMHelper.getDocument(pathFile);
				Element items = document.getDocumentElement();
				
				//CREATE player TAG
				
				Element item = document.createElement("item");
				//CREAR ID TAGG
				
				Element id = document.createElement("id");
				id.appendChild(document.createTextNode(data.getId()));
				item.appendChild(id);
				// create name tag
				
				Element name = document.createElement("name");
				name.appendChild(document.createTextNode(data.getName()));
				item.appendChild(name);
				
					// create team tag
				
				Element type = document.createElement("type");
				type.appendChild(document.createTextNode(data.getType()));
				item.appendChild(type);
				
				//create age tag
				
				Element maximum = document.createElement("maximum");
				maximum.appendChild(document.createTextNode(String.valueOf(data.getMaximum())));
				item.appendChild(maximum);
				
				Element minimum = document.createElement("minimum");
				minimum.appendChild(document.createTextNode(String.valueOf(data.getMinimum())));
				item.appendChild(minimum);
				
				items.appendChild(item);
				
				// Write to file
				DOMHelper.saveXMLContent(document, pathFile);
		}catch(Exception e){
			
				System.out.println(e.getMessage());
			
		}
	}
	
	public void delete (String id ) {
		
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("item");
			for (int i =0; i< nodelist.getLength(); i++) {
				
				Element item = (Element)nodelist.item(i);
				if (item.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					item.getParentNode().removeChild(item);
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update (Item data) {
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("item");
			for (int i =0; i< nodelist.getLength(); i++) {
				Element item = (Element)nodelist.item(i);
				if (item.getElementsByTagName("id").item(0).getTextContent().equals(data.getId())) {
					item.getElementsByTagName("name").item(0).setTextContent(data.getName());
					item.getElementsByTagName("type").item(0).setTextContent(data.getType());
					item.getElementsByTagName("maximum").item(0).setTextContent(String.valueOf(data.getMaximum()));
					item.getElementsByTagName("minimum").item(0).setTextContent(String.valueOf(data.getMinimum()));
					
				}
			}
			DOMHelper.saveXMLContent(document, pathFile);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Item findById(String id) {
		Item item = null;
		try {
			Document document = DOMHelper.getDocument(pathFile);
			NodeList nodelist = document.getElementsByTagName("item");
			for(int i=0; i<nodelist.getLength(); i++) {
				Element s = (Element)nodelist.item(i);
				if(s.getElementsByTagName("id").item(0).getTextContent().equals(id)) {
					item = new Item();
					item.setId(id);
					item.setName(s.getElementsByTagName("name").item(0).getTextContent());
					item.setType(s.getElementsByTagName("type").item(0).getTextContent());
					item.setMaximum(Integer.parseInt(s.getElementsByTagName("maximum").item(0).getTextContent()));
					item.setMinimum(Integer.parseInt(s.getElementsByTagName("minimum").item(0).getTextContent()));
				}
				
				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}
	
	public  List<Item> getItems(){
		
		List<Item> items = new ArrayList<Item>();
		Document document = DOMHelper.getDocument(pathFile);
		NodeList nodelist = document.getElementsByTagName("item");
		for (int i =0; i<nodelist.getLength(); i++) {
			
			Element s = (Element)nodelist.item(i);
			Item item = new Item();
			item.setId(s.getElementsByTagName("id").item(0).getTextContent());
			item.setName(s.getElementsByTagName("name").item(0).getTextContent());
			item.setMaximum(Integer.parseInt(s.getElementsByTagName("maximum").item(0).getTextContent()));
			item.setMinimum(Integer.parseInt(s.getElementsByTagName("minimum").item(0).getTextContent()));
			item.setType(s.getElementsByTagName("type").item(0).getTextContent());
			
			items.add(item);
			
		}
		return items;
	}
}
