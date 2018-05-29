package demo.myapp;

public class HelloMessage {

    private String name;
    private String message;
    private String ip;

    public HelloMessage() {
    }

    public HelloMessage(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }
    
    public String getMessage() {
    	return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
 
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
}
