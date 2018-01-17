package com.shilec.structurepatterns;

import java.util.Vector;

/***
 * 享元模式，单例模式，抽象工厂模式
 * @author Administrator
 *
 */
public class FlyWeightPatterns {
	public static void main(String[] args) {
		Uploader uploader = TranserPool.getInstance().getUploader();
		uploader.trans("234");
		System.out.println(uploader);
		
		uploader = TranserPool.getInstance().getUploader();
		uploader.trans("456");
		System.out.println(uploader);
		
		uploader = TranserPool.getInstance().getUploader();
		uploader.trans("789");
		System.out.println(uploader);
		uploader.release();
		
		uploader = TranserPool.getInstance().getUploader();
		uploader.trans("148");
		System.out.println(uploader);
	}
}

interface ITranser {
	void trans(Object obj);
}

class Downloader extends BaseTranser {

	public void trans(Object obj) {
		super.trans(obj);
		System.out.println("下载:" + obj);
	}
	
}
abstract class BaseTranser implements ITranser{
	boolean isRunning;
	void release() {
		isRunning = false;
	}
	
	public void trans(Object obj) {
		isRunning = true;
	}
}

class Uploader extends BaseTranser {

	public void trans(Object obj) {
		super.trans(obj);
		System.out.println("上传:" + obj);
	}
	
}

interface ITranserMaker {
	ITranser create();
}

class DownloadMaker implements ITranserMaker{

	public ITranser create() {
		return new Downloader();
	}
} 

class UploaderMaker implements ITranserMaker {

	public ITranser create() {
		return new Uploader();
	}
	
}

class TranserPool {
	private static TranserPool instance;
	private Vector<Downloader> dloaderPool;
	private Vector<Uploader> uploaderPool;
	
	private TranserPool() {
		dloaderPool = new Vector<Downloader>(3);
		uploaderPool = new Vector<Uploader>(3);
	}
	
	public static TranserPool getInstance() {
		if(instance == null) {
			syncinit();
		}
		return instance;
	}
	
	public Uploader getUploader() {
		if(uploaderPool.isEmpty()) {
			uploaderPool.add(new Uploader());
			return uploaderPool.get(0);
		} 
		for(Uploader uploader : uploaderPool) {
			if(!uploader.isRunning) {
				return uploader;
			}
		}
		if(uploaderPool.size() >= 3) {
			return null;
		}
		Uploader uploader = new Uploader();
		uploaderPool.add(uploader);
		return uploader;
	}
	
	private static synchronized void syncinit() {
		instance = new TranserPool();
	}
}