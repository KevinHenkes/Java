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
			int objectMethodNumbers = object.getClass().getMethods().length;
			List<Method> listMethod = new ArrayList<Method>(Arrays.asList(object.getClass().getMethods()));

			for (int i = 0; i < objectMethodNumbers; i++) {
				Method method = listMethod.get(i);
				String name = method.getName();
				
				if (index < maxAttribute) {
					/*System.out.println("index = " + index);
					System.out.println(name);
					System.out.println("get" + declaredFields[index].getName());
					System.out.println("-------------------------------------");*/

					if (name.equalsIgnoreCase("get" + declaredFields[index].getName())) {
						
						Object value = null;

						try {
							value = method.invoke(object);
						} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
							e.printStackTrace();
						}

						if (!(this.isPrimitive(value))) {
							List<Object> list = new ArrayList<Object>(Arrays.asList(value));
							readObject(list);
						} else {
							System.out.println(declaredFields[index].getName() + " : " + String.valueOf(value));
							System.out.println("-----------------------------------------");
						}

						index++;
						i = -1;
					}
				}
			}
		}
	}

	public boolean isPrimitive(Object Object) {
		boolean[] result = {false};
		
		String[] type = new String[1];
		
		if (Object.getClass().isArray()) {
			type[0] = Object.getClass().getComponentType().getSimpleName();
		} else {
			type[0] = Object.getClass().getSimpleName();
		}
		
		type[0] = type[0].toLowerCase();

		List<String> listPrimitiveType = new ArrayList<String>(
				Arrays.asList(
						"character",
						"char",
						"byte",
						"double",
						"short",
						"long",
						"integer",
						"int",
						"float",
						"boolean",
						"string"
					)
				);
		
		listPrimitiveType.forEach(t -> {
			if (type[0].equals(t)) {
				result[0] = true;
			}
		});
		
		return result[0];
	}
}
