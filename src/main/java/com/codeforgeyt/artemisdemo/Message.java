package com.codeforgeyt.artemisdemo;

import java.io.Serializable;

public class Message implements Serializable {

	private long id;

    private String msg;
    // standard getters and setters

    Message() {}

    public Message(String msg) {

      this.msg = msg;
    }
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
}
