package com.yang.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.baidu.aip.ocr.AipOcr;

@Service
public class Img2word {
	public static final String APP_ID = "15214602";
	public static final String API_KEY = "kmZ1EsLBY0jvlQunad828PHD";
	public static final String SECRET_KEY = "0sup2vcjPuRHDetYHw1nBYZHyy2RcbVs";

	public String img2word(byte[] img)
	{
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		// 调用接口
		String path = "C:\\Users\\fan\\Desktop\\p9.png";
		JSONObject res = client.basicGeneral(img, new HashMap<String, String>());
		JSONArray arr = (JSONArray) res.get("words_result");
		StringBuffer buffer = new StringBuffer();
		for (Object obj : arr) {
			JSONObject jo = (JSONObject) obj;
			buffer.append(jo.get("words") + " ");
		}
		
		return buffer.toString();

	}

}
