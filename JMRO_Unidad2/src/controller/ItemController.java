package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dom.ItemDOM;
import model.Item;



/**
 * Servlet implementation class ItemController
 */
@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Item item;
	private List<Item> items;
	private ItemDOM itemDOM;
	private List<String> ids = new ArrayList<String>();
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemController() {
        super();
        // TODO Auto-generated constructor stub
       item = new Item();
        items = new ArrayList<Item>();
        itemDOM = new ItemDOM();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
if (request.getParameter("btn_save")!= null) {
			
			item.setName(request.getParameter("name"));
			item.setType(request.getParameter("type"));
			
			
		
			
			try {
				
				item.setMaximum(Integer.parseInt(request.getParameter("maximum")));
			}catch(NumberFormatException e) {
				item.setMaximum(25);
				
				
			}
			
            try {
				
				item.setMinimum(Integer.parseInt(request.getParameter("minimum")));
			}catch(NumberFormatException e) {
				item.setMinimum(20);
				
				
			}
			
			if(item.getId()=="") {
				int id = 1;
				String newId= "ITE"+String.format("%05d", 1);
				item.setId(newId);;
				
				if (items.size()>0) {
					ids.clear();
					for (Item p: items) {
						ids.add(p.getId());
					}
					for (int i=0; i<= ids.size(); i++){
						newId= "ITE"+ String.format("%05d", i+1);
						
						if (! ids.contains(newId)) {
						item.setId(newId);
						break;
						}
					}
				}
				itemDOM.add(item);
			}else {
				itemDOM.update(item);
			}
			items = itemDOM.getItems();
			request.setAttribute("items", items);
			request.getRequestDispatcher("item_list.jsp").forward(request, response);
			
		}else if (request.getParameter("btn_new")!=null) {
			item = new Item();
			request.getRequestDispatcher("item_form.jsp").forward(request, response);
		
		}else if(request.getParameter("btn_edit")!=null) {	
			try {
				String id = request.getParameter("id");
				item = itemDOM.findById(id);
				
			}catch (Exception e) {
				
				item = new Item();
			}
			request.setAttribute("item", item );
			
			request.getRequestDispatcher("item_form.jsp").forward(request, response);
			
		}else if(request.getParameter("btn_delete")!=null) {
		
			
			try {
			String id = request.getParameter("id");
			itemDOM.delete(id);
			items = itemDOM.getItems();
			
			}catch(Exception e) {
				e.printStackTrace();
				
				
			}
			request.setAttribute("items", items);
			request.getRequestDispatcher("item_list.jsp").forward(request, response);
		}else {
			items = itemDOM.getItems();
			request.setAttribute("items", items);
			request.getRequestDispatcher("item_list.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
