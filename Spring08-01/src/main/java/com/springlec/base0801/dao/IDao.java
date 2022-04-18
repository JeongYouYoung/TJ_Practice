package com.springlec.base0801.dao;

import java.util.ArrayList;

import com.springlec.base0801.dto.ContentDto;

public interface IDao {
		/*interfase Dao*/
	
	public ArrayList<ContentDto> listDao();
	
	public void writeDao(String mWriter, String mContent); 
		
	public void deleteDao(int mId); 
		

}
