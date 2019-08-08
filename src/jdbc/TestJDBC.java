package jdbc;

import java.sql.*;


public class TestJDBC {
    public static void main(String[] args) {
        Connection c = null;
        Statement s = null;
        //初始化驱动
        try {
            //驱动类com.mysql.jdbc.Driver
            //就在 mysql-connector-java-5.0.8-bin.jar中
            //如果忘记了导包，就会抛出ClassNotFoundException
            Class.forName("com.mysql.jdbc.Driver");

            System.out.println("数据库驱动加载成功 ！");

            // 建立与数据库的Connection连接
            // 这里需要提供：
            // 数据库所处于的ip:127.0.0.1/localhost (本机)
            // 数据库的端口号： 3306 （mysql专用端口号）
            // 数据库名称 thirdproject
            // 编码方式 UTF-8
            // 账号 root
            // 密码 123

            c = DriverManager
                    .getConnection(
                            "jdbc:mysql://127.0.0.1:3306/thirdproject?characterEncoding=UTF-8",
                            "root", "123");

            System.out.println("连接成功，获取连接对象： " + c);

            //Statement是用于执行SQL语句的，比如增加，删除
            // 注意：使用的是 java.sql.Statement
            // 不要不小心使用到： com.mysql.jdbc.Statement;
            s = c.createStatement();

            System.out.println("获取 Statement对象： " + s);

            // 准备sql语句
            // 注意： 字符串要用单引号'
            // 注意： 如果插入中文，可能会报错。异常主要是由于数据库的字符编码选择错误造成，MySQL的默认编码是Latin1，不支持中文，最好修改为utf8的字符编码为宜。英文就没有问题。
//            String sql = "insert into hero values(1,'Garen',313.0,50)";
//            s.execute(sql);//返回Boolean值ResultSet rs = s.execute(sql);
            //如果使用executeUpdate可能增删改，但是不能返回resultset查询结果
//
//            System.out.println("执行插入语句成功");
            String sql = "select * from hero";
            //String sql2 = "insert into hero values(NULL ,?, ?, ?)";
            // 执行查询语句，并把结果集返回给ResultSet
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");// 可以使用字段名
                String name = rs.getString(2);// 也可以使用字段的顺序
                float hp = rs.getFloat("hp");
                int damage = rs.getInt(4);
                System.out.printf("%d\t%s\t%f\t%d%n", id, name, hp, damage);
            }

        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            // 数据库的连接时有限资源，相关操作结束后，养成关闭数据库的好习惯
            // 先关闭Statement
            if (s != null)
                try {
                    s.close();
                    System.out.println("Statement已关闭！");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            // 后关闭Connection
            if (c != null)
                try {
                    c.close();
                    System.out.println("Connection已关闭！");
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

        }

    }
}