package csvTOjson;
import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class csvTojson {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\java-learning\\src\\csvTOjson\\json.txt");//你自己的json文件
        FileReader fread = new FileReader(file);
        BufferedReader reader = new BufferedReader(fread);
        while (true) {
            String line = reader.readLine();
            if (line.contains("\"")) {//判断当前行是否包含引号
                String reg = "\"";
                String[] ss = line.split(reg); //截取引号内内容
                //System.out.println(ss[1]); //可以测试看引号内的内容对不对
                line = line + "--" + readCSV(ss[1]); //防止覆盖，在原来的line后面添加
            }
            System.out.println(line);
            writeJson(line);

        }
    }

    public static void writeJson(String result) throws IOException {
        /* 写入Txt文件 */
        File writename = new File("E:\\java-learning\\src\\csvTOjson\\newtxt.txt"); // 相对路径，如果没有则要建立一个新的文件
        writename.createNewFile(); // 创建新文件
        BufferedWriter out = new BufferedWriter(new FileWriter(writename));
        out.write(result + "\t\n");
        out.flush(); // 把缓存区内容压入文件
        out.close(); // 最后记得关闭文件
    }

    public static String readCSV(String goal) throws IOException {
        /* 读取csv文件 */
        InputStreamReader isr = new InputStreamReader(new FileInputStream("E:\\java-learning\\src\\csvTOjson\\data.csv"), "GBK");
        BufferedReader reader = new BufferedReader(isr);
        //reader.readLine();//第一行信息，为标题信息，不用，如果需要，注释掉
        String line = null;
        Map<String, String> map = new HashMap<>();
        String rs = null;
        while ((line = reader.readLine()) != null) {
            String[] last = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
            if (last[0].trim().equals(goal)) {
                rs = last[1];
                break;
            }
        }
        return rs;
    }

}

