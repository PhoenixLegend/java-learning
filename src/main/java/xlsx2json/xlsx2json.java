package xlsx2json;
import  Utils.JsonFormatUtil;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import com.alibaba.fastjson.JSON;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;

/**
 * 解决思路：采用Apache的POI的API来操作Excel，读取内容后保存到List中，再将List转Json（推荐Linked，增删快，与Excel表顺序保持一致）
 *
 *          Sheet表1  ————>    List1<Map<列头，列值>>
 *          Sheet表2  ————>    List2<Map<列头，列值>>
 *
 * 步骤1：根据Excel版本类型创建对于的Workbook以及CellSytle
 * 步骤2：遍历每一个表中的每一行的每一列
 * 步骤3：一个sheet表就是一个Json，多表就多Json，对应一个 List
 *       一个sheet表的一行数据就是一个 Map
 *       一行中的一列，就把当前列头为key，列值为value存到该列的Map中
 */

public class xlsx2json {
    @Test
    public void testfile() throws IOException {
       try {
           // 你的xls文件地址
           File file = new File("E:\\java-learning\\src\\main\\java\\xlsx2json\\tt.xls");
           System.out.println( JsonFormatUtil.formatJson(excel2json(file).toString()));
       }catch (IOException|InvalidFormatException e ){
           e.printStackTrace();
       }
        //测试代码文件能否读出来
//        File file = new File("E:\\java-learning\\src\\main\\java\\xlsx2json\\readme.md");
//        FileReader fr = new FileReader(file);
//        BufferedReader breader = new BufferedReader(fr);
//        while(true){
//            String line = breader.readLine();
//            System.out.println(line);
//            if (line == null) break;
//        }
    }

    public static LinkedHashMap<String,String> excel2json(File file) throws IOException, InvalidFormatException {

        System.out.println("excel2json方法执行....");

        // 返回的map
        LinkedHashMap<String,String> excelMap = new LinkedHashMap<>();

        // Excel列的样式，主要是为了解决Excel数字科学计数的问题
        CellStyle cellStyle;
        // 根据Excel构成的对象
        Workbook wb;
        // 如果是2007及以上版本，则使用想要的Workbook以及CellStyle
        if(file.getName().endsWith("xlsx")){
            System.out.println("是2007及以上版本  xlsx");
            // 之前这个会报一个"V"的错误，是因为poi和poi-ooxml的版本不一致
            wb = new XSSFWorkbook(OPCPackage.open(file));
            XSSFDataFormat dataFormat = (XSSFDataFormat) wb.createDataFormat();
            cellStyle = wb.createCellStyle();
            // 设置Excel列的样式为文本
            cellStyle.setDataFormat(dataFormat.getFormat("@"));


        }else{
            System.out.println("是2007以下版本  xls");
            POIFSFileSystem fs = new POIFSFileSystem(new BufferedInputStream(new FileInputStream(file)));
            wb = new HSSFWorkbook(fs);
            HSSFDataFormat dataFormat = (HSSFDataFormat) wb.createDataFormat();
            cellStyle = wb.createCellStyle();
            // 设置Excel列的样式为文本
            cellStyle.setDataFormat(dataFormat.getFormat("@"));
        }

        // sheet表个数
        int sheetsCounts = wb.getNumberOfSheets();
        // 遍历每一个sheet
        for (int i = 0; i < sheetsCounts; i++) {
            Sheet sheet = wb.getSheetAt(i);
            System.out.println("第" + i + "个sheet:" + sheet.toString());

            // 一个sheet表对于一个List
            List list = new LinkedList();

            // 将第一行的列值作为整个个json的key
            String[] cellNames;
            // 取第一行列的值作为key
            Row fisrtRow = sheet.getRow(0);
            // 如果第一行就为空，则是空sheet表，该表跳过
            if(null == fisrtRow){
                continue;
            }
            // 得到第一行有多少列
            int curCellNum = fisrtRow.getLastCellNum();
            System.out.println("第一行的列数：" + curCellNum);
            // 根据第一行的列数来生成列头数组
            cellNames = new String[curCellNum];
            // 单独处理第一行，取出第一行的每个列值放在数组中，就得到了整张表的JSON的key
            for (int m = 0; m < curCellNum; m++) {
                Cell cell = fisrtRow.getCell(m);
                // 设置该列的样式是字符串
                cell.setCellStyle(cellStyle);
                // 3.17版本之后改为枚举，这个方法已经过时
                cell.setCellType(Cell.CELL_TYPE_STRING);
                // 取得该列的字符串值
                cellNames[m] = cell.getStringCellValue();
            }
            for (String s : cellNames) {
                System.out.print("得到第" + i +" 张sheet表的列头： " + s + ",");
            }
            System.out.println();

            // 从第二行起遍历每一行
            int rowNum = sheet.getLastRowNum();
            System.out.println("总共有 " + rowNum + " 行");
            for (int j = 1; j <= rowNum; j++) {
                // 一行数据对于一个Map
                LinkedHashMap rowMap = new LinkedHashMap();
                // 取得某一行
                Row row = sheet.getRow(j);
                int cellNum = row.getLastCellNum();
                // 遍历每一列
                for (int k = 0; k < cellNum; k++) {
                    Cell cell = row.getCell(k);
                    cell.setCellStyle(cellStyle);
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    // 保存该单元格的数据到该行中
                    rowMap.put(cellNames[k],cell.getStringCellValue());
                }
                // 保存该行的数据到该表的List中
                list.add(rowMap);
            }
            // 将该sheet表的表名为key，List转为json后的字符串为Value进行存储
            excelMap.put(sheet.getSheetName(), JSON.toJSONString(list,false));
        }

        System.out.println("excel2json方法结束....");

        return excelMap;
    }
}


