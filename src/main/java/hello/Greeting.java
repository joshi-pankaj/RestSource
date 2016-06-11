package main.java.hello;

public class Greeting {
    
	private  int content;
	
    private long id;
    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	

	public int getContent() {
		return content;
	}
	public void setContent(int content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "Greeting [ content=" + content + "]";
	}
	public Greeting(int content) {
		super();
		this.id = id;
		this.content = content;
	}
	public Greeting(long incrementAndGet, String format) {
		// TODO Auto-generated constructor stub
	}
}
