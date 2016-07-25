package com.dur.shared;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.json.generators.JSONGenerator;
import com.json.generators.JsonGeneratorFactory;
import com.json.parsers.JSONParser;
import com.json.parsers.JsonParserFactory;

public class JSONMessage {
	
	private Map<Object, Object> messageContent;
	
	public JSONMessage(String jsonMessage) {
		this.messageContent = this.parseJson(jsonMessage);
	}
	
	public JSONMessage() {
		this.messageContent = new HashMap<Object, Object>();
	}
	
	public JSONMessage(Map<Object, Object> params) {
		this.messageContent = params;
	}
	
	public boolean hasParam(Constants param) {
		return messageContent.containsKey(param.toString());
	}
	
	public boolean hasParam(MessageTypes param) {
		return messageContent.containsKey(param.toString());
	}

	private String toJson(){
		JSONGenerator generator = JsonGeneratorFactory.getInstance().newJsonGenerator();
		return generator.generateJson(messageContent);
	}
	
	private Map<Object, Object> parseJson(String message) {
		JSONParser parser = JsonParserFactory.getInstance().newJsonParser();
		Map<Object, Object> jsonData = parser.parseJson(message);
		return (Map<Object, Object>) ((List) jsonData.get("root")).get(0);
	}
	
	public Object get(Constants key){
		return messageContent.get(key.toString());
	}
	
	public Object get(MessageTypes key){
		return messageContent.get(key.toString());
	}
	
	public void addParam(Constants key, Object value){
		messageContent.put(key.toString(),  value);
	}
	
	public void addParam(MessageTypes key, Object value){
		messageContent.put(key.toString(),  value);
	}
	
	@Override
	public String toString() {
		return toJson();
	}
	
	
}
