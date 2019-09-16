package annotation;

import java.lang.reflect.Method;

import annotation.MyColumn;
import annotation.MyEntity;
import annotation.MyGeneratedValue;
import annotation.MyId;
import annotation.MyTable;
import annotation.Hero_annotation;
import org.junit.jupiter.api.Test;

public class ParseHibernateAnnotation {
	@Test
	public void testAnnotation() {
		// 获取实体类，也可以用其他两种方式，具体查看反射部分
		Class<Hero_annotation> clazz = Hero_annotation.class;
		// 1. 确定是实体类
		// 2. 对应表
		// 3. 自增长id是，id策略是，对应字段是
		// 4. 其他属性对应字段是
		MyEntity myEntity = (MyEntity) clazz.getAnnotation(MyEntity.class);
		if (null == myEntity) {
			System.out.println("Hero类不是实体类");
		} else {
			System.out.println("Hero类是实体类");
			MyTable myTable= (MyTable) clazz.getAnnotation(MyTable.class);
			String tableName = myTable.name();
			System.out.println("其对应的表名是:" + tableName);
			Method[] methods =clazz.getMethods();
			Method primaryKeyMethod = null;
			for (Method m: methods) {
				MyId myId = m.getAnnotation(MyId.class);
				if(null!=myId){
					// 遍历所有的方法，如果某个方法有MyId注解，那么就记录为主键方法primaryKeyMethod
					primaryKeyMethod = m;
					break;
				}
			}
			// 把主键方法的自增长策略注解MyGeneratedValue和对应的字段注解MyColumn 取出来，并打印
			if(null!=primaryKeyMethod){
				System.out.println("找到主键：" + method2attribute( primaryKeyMethod.getName() ));
				MyGeneratedValue myGeneratedValue =
				primaryKeyMethod.getAnnotation(MyGeneratedValue.class);
				System.out.println("其自增长策略是：" +myGeneratedValue.strategy());
				MyColumn myColumn = primaryKeyMethod.getAnnotation(MyColumn.class);
				System.out.println("对应数据库中的字段是：" +myColumn.value());
			}
			System.out.println("其他非主键属性分别对应的数据库字段如下：");
			for (Method m: methods) {
				if(m==primaryKeyMethod){
					continue;
				}
				MyColumn myColumn = m.getAnnotation(MyColumn.class);
				//那些setter方法上是没有MyColumn注解的
				if(null==myColumn)
					continue;
				System.out.format("属性： %s\t对应的数据库字段是:%s%n",method2attribute(m.getName()),myColumn.value());

			}
			
			
			
		}
		

	}

	private static String method2attribute(String methodName) {
		String result = methodName; ;
		result = result.replaceFirst("get", "");
		result = result.replaceFirst("is", "");
		if(result.length()<=1){
			return result.toLowerCase();
		}
		else{
			return result.substring(0,1).toLowerCase() + result.substring(1,result.length());
		}
		
		
	}
}
