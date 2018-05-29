package demo.myapp;

public class Greeting {

    private String content;
    private String me;

    public Greeting() {
    }

    public Greeting(String content, String me) {
        this.content = content;
        this.me = me;
    }

    public String getContent() {
        return content;
    }
        
    public String getMe() {
    	return me;
    }

}
