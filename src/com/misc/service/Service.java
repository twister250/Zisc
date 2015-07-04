package com.misc.service;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Service {

	private List<Path> entries;
	private List<Path> files;
	
	public List<Path> list(Path path) throws DirectoryIteratorException, IOException{
		entries = new ArrayList<Path>();
		files = new ArrayList<Path>();
		try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)){
			for(Path file: stream){
				if(Files.isDirectory(file)){
					entries.add(file);
				}else{
					files.add(file);
				}
			}
		}catch(DirectoryIteratorException e){
			throw new DirectoryIteratorException(e.getCause());
		}catch(IOException e){
			throw new IOException();
		}
		System.out.println(entries);
		return entries;
	}
	
	public List<Path> getFiles(){
		return files;
	}
}