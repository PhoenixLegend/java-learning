package xmlAnalizy;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.stream.Collectors;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author Jim
 *
 * DOM 解析XML文档
 */
public class DomDemo implements XmlDocument {
    private Document document;


    public void parserXml(String fileName) {
        try {
            //先从工厂获取单例实例dbf
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //通过dbf实例化一个db
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过db，和文件名获取文件对象document
            Document document = db.parse(fileName);
            //通过文件对象，获取文件的节点列表users
            NodeList users = document.getChildNodes();
            //四层，一层一层获取字段和内容
            List<User> list = new ArrayList<>();

            for (int i = 0; i < users.getLength(); i++) {//users最外层节点，将user的子节点给userInfo
                Node user = users.item(i);
                NodeList userInfo = user.getChildNodes();


                for (int j = 0; j < userInfo.getLength(); j++) {//进入user层，获取内部meta标签给userMeta
                    Node node = userInfo.item(j);
                    NodeList userMeta = node.getChildNodes();
                    //设置三个字段，初始化为空，否则会抛出空指针
                    //设置为空的另一个好处可以覆盖前面的值，也可以做if判断是否加入list里面去
                    int age = 0;
                    String name = null;
                    String sex = null;
                    //根据userMeta.getLength()长度便利，按名字找出age等字段
                    for (int k = 0; k < userMeta.getLength(); k++) {//打印最内层数据
//                        if(userMeta.item(k).getNodeName() != "#text") //== "age"
//                            System.out.println(userMeta.item(k).getNodeName()
//                                    + ":" + userMeta.item(k).getTextContent()+":"+k);
                        //k==1 -> name;k==3 -> age;k==5 -> sex;
                        if(userMeta.item(k).getNodeName() == "age") //== "age"
                            age = Integer.valueOf(userMeta.item(k).getTextContent());
                        if(userMeta.item(k).getNodeName() == "name")
                            name = userMeta.item(k).getTextContent();
                        if(userMeta.item(k).getNodeName() == "sex")
                            sex = userMeta.item(k).getTextContent();
                        else continue;
                    }
                    //加入list
                    if (name != null)
                    list.add(new User(name,age,sex));
                    //这个解析会打印多次，因为xml会后很多无意义的行
                    System.out.println("解析完毕");
                }

            }
            //lambda写法，先把排好序的list转化成slist，然后再foreach打印
            if(list!=null) {
                List<User> slist = list.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
                slist.stream().map(p -> p.getName() + p.getAge() + p.getSex()).forEach(System.out::println);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
