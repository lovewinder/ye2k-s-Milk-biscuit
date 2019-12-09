package cn.y.ye2k.utils;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Question_Answer {
    // Map<Integer, String>
    public static String readTxt(String path) throws IOException {

        StringBuffer sb = new StringBuffer("");
        try {
            // read file content from file
//            FileReader reader = new FileReader(path);
//            BufferedReader br = new BufferedReader(reader);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(path));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));

            String str = null;
            while ((str = br.readLine()) != null) {
                sb.append(str);
            }
            br.close();
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static Map<Integer, String> parseQA(String qa) {
        String[] strs = qa.split("\\[or\\]");

        Map<Integer, String> map = new LinkedHashMap<>();
        for (int i = 0; i < strs.length; i++) {
            map.put(Integer.parseInt(strs[i].split("\\[sp\\]")[0]), strs[i].split("\\[sp\\]")[1]);
            // System.out.println(strs[i].split("\\[sp\\]")[0]);
        }
        return map;
    }

    public static void main(String[] args) throws IOException {
        String md = Question_Answer.readTxt("d:/test.md");
        System.out.println(md);
    }

}
