package com.imit;

import java.io.IOException;

import com.imit.service.FileWatcherService;

public class Main {
    public static void main(String[] args) {
        try {
        	FileWatcherService fileWatcherService = new FileWatcherService("Your path goes here");
        	fileWatcherService.startWatching();
        } catch (IOException e) {
			System.out.println("Error initializing the watcher server: " + e.getMessage());
		}
    }
}