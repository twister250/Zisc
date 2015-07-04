package com.misc.test;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.Paths;

import com.misc.service.Service;

public class Main {

	public static void main(String[] args) {

		Service service = new Service();
		try {
			service.list(Paths.get("/media/HD-Windows/Torrents/Arrow/02"));
		} catch (DirectoryIteratorException | IOException e) {
			e.printStackTrace();
		}		
	}
}
