package fr.kevin.reflectiongeneric.database.reflectionner;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToolsBox {
	public void readObject(List<? extends Object> listObject) {
		for (Object object : listObject) {
			Field[] declaredFields = object.getClass().getDeclaredFields();
			
			int index = 0;
			int maxAttribute = declaredFields.length;
			
			for (Method method : object.getClass().getMethods()) {
		        String name = method.getName();
		        
		        if (index < maxAttribute) {
			        if (name.equalsIgnoreCase("get"+declaredFields[index].getName())) {
			        	
			            Object value = null;
		
		                try {
							value = method.invoke(object);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}
		                
		                if (value.getClass().getName().equals(Arrays.asList(value.toString().split("@")).get(0))) {
		                	List<Object> list = new ArrayList<Object>(Arrays.asList(value));
		                	readObject(list);
		                } else {
		                	System.out.println(declaredFields[index].getName() + " : " + value.toString());
		                }
			            
			            index++;
			        }
		        }
			}
	    }
	}
}
