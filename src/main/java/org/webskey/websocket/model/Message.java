package org.webskey.websocket.model;

public class Message {

    private String name;
    private String message;
    private String ip;

    public Message() { }

    public Message(String name, String message) {
        this.name = name;
        this.message = message;
    }
    
    public Message(String name, String message, String ip) {
    	this.name = name;
    	this.message = message;
    	this.ip = ip;
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
