package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;



public class FileUtility {
	
	class File {
		int size;
		String name;

		File(String name, int size) {
			this.size = size;
			this.name = name;
		}

		public int getSize() {
			return this.size;
		}

	}

	class Collection {

		public String name;
		public int totalSize;
		private List<File> files;
		//private List<Collection> collections;

		Collection(String n) {
			this.name = n;
			this.totalSize = 0;
			files = new ArrayList<>();
			// collections = new ArrayList<>();
		}

		public void addFile(File file) {
			files.add(file);
			this.totalSize = this.totalSize + file.getSize();
		}
		
		/*public void addCollection(Collection collection) {
			collections.add(collection);
			this.totalSize = this.totalSize + collection.totalSize;
		}*/
	}

	public int totalSizeProcessed = 0;

	public HashMap<String, Collection> collectionMap = new HashMap<>();
	public PriorityQueue<Collection> queue = new PriorityQueue<Collection>((a, b) -> {
		// if size is same then use name order
		if (b.totalSize == a.totalSize) {
			return a.name.compareTo(b.name);
		}
		return b.totalSize - a.totalSize;
	});

	public void getTotalSize() {
		System.out.println("Total size of files processed: " + totalSizeProcessed);
	}

	// time complexity - map - o(1) to o(n) for insert.edit
	// and heap - o(log M) - for  add/update/delete and o(1) for poll  
	// M is number of collections but here we have to find the top N
	// so time complexity will be o(N) - constant for each heap element lookup...
	public List<Collection> getTop(int N) {

		List<Collection> result = new ArrayList<>();
		System.out.println("Top " + N + " Collections:");

		for (int i = 0 ; i < N; i++) {
			Collection collection = queue.poll();
			if (!collection.name.equalsIgnoreCase("root")) {
				System.out.println("- " + collection.name + " " + collection.totalSize);
			}
			result.add(collection);
		}
		queue.addAll(result);//queue back to original..
		return result;
	}

	// time complexity - map - o(1) to o(n) for insert.edit
	// and heap - o(log N) - for  add/update/delete and o(1) for poll 
	public void saveFiletoCollection(String collectionName, String fileName, int fileSize) {
		if (collectionName == null || collectionName.equals(""))
			collectionName = "root";
		Collection collection;
		if (collectionMap.containsKey(collectionName)) {
			collection = collectionMap.get(collectionName);
			queue.remove(collection);
		} else {
			collection = new Collection(collectionName);
		}

		// handle corner case whether file already exists or not/ exception handling
		collection.addFile(new File(fileName, fileSize));
		totalSizeProcessed = totalSizeProcessed + fileSize;
		queue.add(collection);
		collectionMap.put(collectionName, collection);
	}

	public static void main(String[] args) {

		FileUtility utility = new FileUtility();
		utility.saveFiletoCollection("collection1", "file2.txt", 1200);
		utility.saveFiletoCollection("collection2", "file3.txt", 200);
		utility.saveFiletoCollection(null, "file1.txt", 200);

		utility.saveFiletoCollection("collection3", "file4.txt", 200);
		utility.saveFiletoCollection("collection1", "file4.txt", 200);
		utility.saveFiletoCollection("collection3", "file5.txt", 200);
		utility.saveFiletoCollection("collection3", "file6.txt", 200);
		utility.saveFiletoCollection("collection2", "file7.txt", 100);
		utility.saveFiletoCollection("collection2", "file8.txt", 300);
		utility.getTotalSize();
		utility.getTop(3);

	}

}
