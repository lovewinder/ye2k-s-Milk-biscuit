package cn.y.ye2k.common.utils;

import java.io.*;
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
        //    System.out.println(Question_Answer.readTxt("D:\\work_space\\ye2k's_q-a\\ye2k's_q-a\\target\\travel-1.0-SNAPSHOT\\txt\\question\\ajax.txt"));
        //      System.out.println(Question_Answer.parseQA(Question_Answer.readTxt("D:\\work_space\\ye2k's_q-a\\ye2k's_q-a\\target\\travel-1.0-SNAPSHOT\\txt\\question\\ajax.txt")));
//        String path = (new Question_Answer().getClass().getResource("/").getPath().replaceFirst("/", "").replace("classes","")+"travel-1.0-SNAPSHOT/txt/question/ajax.txt");
//        String str = readTxt(path);
//        Map<String, String> map = parseQA(str);
//        System.out.println(map);
    }
}
