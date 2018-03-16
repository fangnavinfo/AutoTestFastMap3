package com.fang.testAdapter;  

import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.LinkedList;  
import java.util.List;  
import java.util.Map;  
import java.util.Stack;  
  
import org.xml.sax.Attributes;  
import org.xml.sax.SAXException;  
import org.xml.sax.helpers.DefaultHandler;  
  
/** 
 * .plist配置文件的解析器  
 *  
 * @author afly 
 *  
 */  
public class PlistHandler extends DefaultHandler {  
  
    private boolean isRootElement = false;  
  
    private boolean keyElementBegin = false;  
  
    private String key;  
  
    Stack<Object> stack = new Stack<Object>();  
  
    private boolean valueElementBegin = false;  
  
    private Object root;  
  
    @SuppressWarnings("unchecked")  
    public HashMap<String, Object> getMapResult() {  
        return (HashMap<String, Object>) root;  
    }  
  
    @SuppressWarnings("unchecked")  
    public List<Object> getArrayResult() {  
        return (List<Object>) root;  
    }  
  
    @Override  
    public void startDocument() throws SAXException {  
        System.out.println("开始解析");  
    }  
  
    @Override  
    public void endDocument() throws SAXException {  
        System.out.println("结束解析");  
    }  
  
    @SuppressWarnings("unchecked")  
    @Override  
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {  
        // System.out.println(uri+"startElement:"+qName);  
        if ("plist".equals(qName)) {  
            isRootElement = true;  
        }  
        if ("dict".equals(qName)) {  
            if (isRootElement) {  
                stack.push(new HashMap<String, Object>());// 压栈  
                isRootElement = !isRootElement;  
            } else {  
                Object object = stack.peek();  
                HashMap<String, Object> dict = new HashMap<String, Object>();  
                if (object instanceof ArrayList)  
                    ((ArrayList<Object>) object).add(dict);  
                else if (object instanceof HashMap)  
                    ((HashMap<String, Object>) object).put(key, dict);  
                stack.push(dict);  
            }  
        }  
  
        if ("key".equals(qName)) {  
            keyElementBegin = true;  
        }  
        if ("true".equals(qName)) {  
            HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();  
            parent.put(key, true);  
        }  
        if ("false".equals(qName)) {  
            HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();  
            parent.put(key, false);  
        }  
        if ("array".equals(qName)) {  
            if (isRootElement) {  
                ArrayList<Object> obj = new ArrayList<Object>();  
                stack.push(obj);  
                isRootElement = false;  
            } else {  
            	
            	Object temp = stack.peek();
            	if(temp.getClass().getName().contains("HashMap"))
            	{
	                HashMap<String, Object> parent = (HashMap<String, Object>) temp; 
	              
	                ArrayList<Object> obj = new ArrayList<Object>();  
	                stack.push(obj);  
	                parent.put(key, obj);  
            	}
            	if (temp.getClass().getName().contains("ArrayList"))
            	{
            		ArrayList<Object> parent = (ArrayList<Object>) temp;
            		ArrayList<Object> obj = new ArrayList<Object>();  
	                stack.push(obj);  
	                parent.add(obj);
            	}
            }  
        }  
        if ("string".equals(qName)) {  
            valueElementBegin = true;  
        }  
    }  
  
    /* 
     * 字符串解析(non-Javadoc) 
     *  
     * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int) 
     */  
    @SuppressWarnings("unchecked")  
    @Override  
    public void characters(char[] ch, int start, int length) throws SAXException {  
        System.out.println("characters:");  
        if (length > 0) {  
            if (keyElementBegin) {  
                key = new String(ch, start, length);  
                System.out.println("key:" + key);  
            }  
            if (valueElementBegin) {  
                if (HashMap.class.equals(stack.peek().getClass())) {  
                    HashMap<String, Object> parent = (HashMap<String, Object>) stack.peek();  
                    String value = new String(ch, start, length);  
                    parent.put(key, value);  
                } else if (ArrayList.class.equals(stack.peek().getClass())) {  
                    ArrayList<Object> parent = (ArrayList<Object>) stack.peek();  
                    String value = new String(ch, start, length);  
                    parent.add(value);  
                }  
                System.out.println("value:" + new String(ch, start, length));  
            }  
        }  
    }  
  
    @Override  
    public void endElement(String uri, String localName, String qName) throws SAXException {  
        if ("plist".equals(qName)) {  
            ;  
        }  
        if ("key".equals(qName)) {  
            keyElementBegin = false;  
        }  
        if ("string".equals(qName)) {  
            valueElementBegin = false;  
        }  
        if ("array".equals(qName)) {  
            root = stack.pop();  
        }  
        if ("dict".equals(qName)) {  
            root = stack.pop();  
        }  
    }  
} 
