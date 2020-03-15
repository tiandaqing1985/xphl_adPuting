package com.ruoyi.today;


import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Test {


	/**
	 * 获取指定视频的帧并保存为图片至指定目录
	 * @param videofile  源视频文件路径
	 * @param framefile  截取帧的图片存放路径
	 * @throws Exception
	 */
	public static void fetchFrame(String videofile, String framefile)
			throws Exception {
	}

	public static void main(String[] args) {
		try {
			Test.fetchFrame("C:\\Users\\lhl\\Desktop\\3.mp4", "D:\\test5.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



}
