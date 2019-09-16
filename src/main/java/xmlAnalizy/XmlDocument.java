package xmlAnalizy;
/**
 * @author Jim
 *
 * 定义XML文档解析的接口
 */
public interface XmlDocument {

    /**
     * 解析XML文档
     *
     * @param xmlDemo.xml
     *            文件全路径名称
     */
    public void parserXml(String fileName);
}