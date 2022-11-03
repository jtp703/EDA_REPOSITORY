package eda1.practica02.parte03;

import java.util.Iterator;

import eda1.auxiliar.AVLTree;
import eda1.auxiliar.Pair;


public class User implements Comparable<User>, Iterable<Pair<String, AVLTree<String>>> {

	private String userID;
	private MyTreeMap<String, AVLTree<String>> dispositivos;
		
	public User(String userID) {
		this.userID = userID;
		this.dispositivos= new MyTreeMap<>();
	}
	
	public void clear() {
		this.dispositivos.clear();
	}
	
	public void add(String dispositivoID, String...palabras) {
		AVLTree<String> current = this.dispositivos.get(dispositivoID);
		if(current == null){
			dispositivos.put(dispositivoID, new AVLTree<>(palabras));
		}else{
			for (String word: palabras) {
				current.add(word);
			}
		}
	}

	@Override
	public String toString() {
		return userID + "=" +"<" +
				(dispositivos.size() == 1 ? dispositivos.size() + " dispositivo>"
						: dispositivos.size() + " dispositivos>");
	}
	
	@Override
	public boolean equals(Object o) {
		return this.compareTo((User)o) == 0; 
	}
	
	@Override
	public int compareTo(User o) {
		return this.userID.compareTo(o.userID);
	}

	@Override
	public Iterator<Pair<String,AVLTree<String>>> iterator() {
		return this.dispositivos.entrySet().iterator();
	}
}
