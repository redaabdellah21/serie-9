package exo19;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
public class AnalyzeBean {
	public String getClassName(Object o) {
		Class<?> clazzClass =o.getClass();
		return clazzClass.getName();
	}
	public Object getInstance(String className) {
		try {
			Class<?> clazz = Class.forName(className);
			Object newInstance = clazz.newInstance();
			return newInstance;
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<String> getProperties(Object o) {
		List<String> properties = new ArrayList<>();
		Method[] declaredMethods = o.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			String methodName = method.getName();
			if ((methodName.startsWith("get") ||
				 methodName.startsWith("is")) && 
				method.getParameterCount() == 0 &&
				Modifier.isPublic(method.getModifiers())) {
					String propertyName = "";
					if (methodName.startsWith("get")) {
						propertyName = methodName.substring(3);
					} else {
						propertyName = methodName.substring(2);
					}
					propertyName = 
							propertyName.substring(0, 1).toLowerCase() + 
							propertyName.substring(1);
					properties.add(propertyName);
				}
		}
		return properties;
	}
	
//	public Object get(Object bean, String property)){
//		String nameString= getClassName(bean);
//		String nomMethod = "get"+ property.substring(0,1).toUpperCase()+property.substring(1);
//		Method method= nameString.getClass().getMethod(nomMethod, Object.class);
//		Object value = nameString.getClass().method();
//	}
//	public void set(Object bean, String property, Object value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
//	String methodName = 
//			"set" + property.substring(0, 1).toUpperCase() + property.substring(1); 
//	Method methode = getClassName(bean).getClass().getMethod(methodName, int.class);
//	methode.invoke(getClassName(bean), value); 
//	}
	
}
