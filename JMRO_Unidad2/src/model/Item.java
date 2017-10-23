package model;

public class Item {

	private String id;
	private String name;
	private int maximum;
	private int minimum;
	private String type;
	
	
	
	public Item(String id, String name, int maximum,int minimum, String type) {
		super();
		this.id = id;
		this.name = name;
		maximum = maximum;
		minimum = minimum;
		this.type = type;
	}
	
	public Item() {
		this("","",0,0,"");
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
