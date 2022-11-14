package model.Post.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import model.employee.Response.Data;

public class PostResponse {

	@JsonProperty("data")
	private Data data;

	@JsonProperty("message")
	private String message;

	@JsonProperty("status")
	private String status;

	public Data getData(){
		return data;
	}

	public String getMessage(){
		return message;
	}

	public String getStatus(){
		return status;
	}

}