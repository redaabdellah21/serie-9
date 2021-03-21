package exo19;

import java.lang.reflect.InvocationTargetException;

import model.Employee;
import model.Person;

public class exo19 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		AnalyzeBean analyzeBean = new AnalyzeBean();
		Person person = new Person("Chris", "Evans", 32);
		Employee employee = new Employee("Chris", "Evans", 32,1500);
		PersonReader personReader= new PersonReader();
		
		
		System.out.println("\n Question 1 \n");
		System.out.println(analyzeBean.getClassName(4));
		
		System.out.println("\n Question 2 \n");
		System.out.println(analyzeBean.getInstance("exo19.Person"));
		System.out.println("Je peux cr�er une instance tant que je peux trouver un constructeur vide");
		
		System.out.println("\n Question 3 \n");
		System.out.println("Person: " +analyzeBean.getProperties(person));
		System.out.println("Employee: "+analyzeBean.getProperties(employee));
		
		System.out.println("\n Question 4 \n");
		
		System.out.println("\n Question 5 \n");
//		analyzeBean.set(person,"age",50);
//		System.out.println(person);
		
		
		System.out.println("\n Question 6 \n");
		System.out.println(personReader.read("files/file.txt"));
		
		System.out.println("\n Question 7 \n");
	}

}
