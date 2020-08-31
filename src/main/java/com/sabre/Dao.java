package com.sabre;

import java.util.List;

public interface Dao<T> {
	   List<T> getActors();
	    
	  T findById(int id);

	  void update(T t);

	   void create(T t);

	   void delete(T t);
	   
}
