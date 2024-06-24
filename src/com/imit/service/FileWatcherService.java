package com.imit.service;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;

import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchService;

public class FileWatcherService {
	
	private final WatchService watchService;
	private final Path pathToWatch;
	
	public FileWatcherService(String path) throws IOException {
		this.pathToWatch = Paths.get(path);
		this.watchService = FileSystems.getDefault().newWatchService();
		this.pathToWatch.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);
	}
	
	public void startWatching() {
		System.out.println("Starting to watch directory: " + pathToWatch);
		
		while(true) {
			WatchKey key;
			
			try {
				key  = watchService.take();
			} catch (InterruptedException e) {
				System.out.println("File watching interrupted.");
				return;
			}
			
			for (WatchEvent<?> event : key.pollEvents()) {
				WatchEvent.Kind<?> kind = event.kind();
				Path fileName = (Path) event.context();
				
				System.out.println("Event kind: " + kind + ". File affected: " + fileName + ".");
				
				if (kind == ENTRY_CREATE) {
					System.out.println("File " + fileName + " created.");
				} else if (kind == ENTRY_DELETE) {
					System.out.println("File " + fileName + " deleted.");
				} else if (kind == ENTRY_MODIFY) {
					System.out.println("File " + fileName + " modified.");
				}
			}
			
			boolean valid = key.reset();
			if (!valid) {
				break;
			}
			
		}
	}

}
