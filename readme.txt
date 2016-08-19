1.springboot Ĭ���Դ���һ��tomcat���˿�Ĭ��Ϊ8080.�޸Ķ˿ڡ���鿴com.sun.spring.Main.java����ࣻ
2.�����Ŀ��ʵ����һ����򵥵ĵ��ã�û���������ݿ⣻
���������ķ��ʵ�ַ�ֱ�Ϊ��http://localhost:1234  , http://localhost:1234/hu/


�ο����ݣ�
Spring ��ܰ�����ʮ����ͬ������Ŀ������Ӧ�ÿ����Ĳ�ͬ���档��˶������Ŀ�������һ���淽���˿�����Ա��ʹ�ã�����һ������Ҳ������ʹ�÷�������⡣

ÿ������Ŀ����һ����ѧϰ���ߡ�������Ա��Ҫ�˽���Щ����Ŀ������ľ���ϸ�ڣ�����֪����ΰ���Щ����Ŀ���������γ�һ�������Ľ��������

������������Զ����� Spring �ĸ�����������������������ɺ� XML �����ļ���Spring Boot Ҳ�ṩ�˶��ڳ����������Ƽ�������á�Spring Boot ���Դ������ʹ�� Spring ���ʱ�Ŀ���Ч�ʡ�


������飺

1>���ã�

Spring Boot ���������ڴ����������µĻ��� Spring ��ܵ���Ŀ��

2>Spring BootĿ�ģ�

����Ŀ���ǰ���������Ա�����׵Ĵ������������кͲ�Ʒ����Ļ��� Spring ��ܵ�Ӧ��

3>��ô���ģ�

Spring Boot ��ѡ�����ʺϵ� Spring ����Ŀ�͵�������Դ��������ϡ��󲿷� Spring Boot Ӧ��ֻ��Ҫ�ǳ��ٵ����þͿ��Կ�������������

3>Spring Boot �������������£�

���������Զ������е� Spring Ӧ�á�
��ֱ��Ƕ�� Tomcat �� Jetty ������������Ҫ���� WAR �ļ���
���ṩ�Ƽ��Ļ��� POM �ļ����� Apache Maven ���á�
�������ܵĸ�����Ŀ�������Զ����� Spring ��ܡ�
���ṩ����ֱ��������������ʹ�õĹ��ܣ�������ָ�ꡢӦ����Ϣ��Ӧ�ý�����顣
��û�д������ɣ�Ҳû�� XML �����ļ���

����ʹ�ã�ʹ�� Maven ��Ϊ�������ߴ����� Spring Boot Ӧ��

  ����Maven��Ŀ��

1>�嵥 1. Spring Boot ʾ��Ӧ�õ� POM �ļ�

˵����Ӧ�����������������٣�ֻ��һ����org.springframework.boot:spring-boot-starter-web���������������� Spring ��Ŀһ����Ҫ�����ܶ��������

��ʹ�� Maven ���mvn dependency:tree�����鿴��Ŀʵ�ʵ�����ʱ���ᷢ�����а����� Spring MVC ��ܡ�SLF4J��Jackson��Hibernate Validator �� Tomcat ������
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.midgetontoes</groupId>
	<artifactId>spring-boot-simple</artifactId>
	<version>1.0-SNAPSHOT</version>
	<properties>
		<spring.boot.version>1.1.4.RELEASE</spring.boot.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>${spring.boot.version}</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<version>${spring.boot.version}</version>
				<executions>
					<execution>
						<goals>
							<goal>repackage</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>

2> �嵥 2. Spring Boot ʾ��Ӧ�õ� Java ����
@RestController
@EnableAutoConfiguration
public class Application {
 
 @RequestMapping("/")
 String home() {
    return "Hello World!";
 }
 
 public static void main(String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
 }
}

3> ��ϸ˵��

3.1>�����嵥 2 �е� Java �� Application ��һ���򵥵Ŀ��Զ������е� Web Ӧ�á�

3.2>ֱ�����и� Java �������һ����Ƕ�� Tomcat ������������ 8080 �˿ڡ����ʡ�http://localhost:8080�����Կ���ҳ������ʾ��Hello World!����

3.3>�����嵥 2 �еġ�@EnableAutoConfiguration��ע������������� Spring Boot ����Ӧ������������������ Spring ��ܽ����Զ����ã���ͼ����˿�����Ա�Ĺ�������

3.4>ע�⡰@RestController���͡�@RequestMapping���� Spring MVC �ṩ���������� REST ����������ע��� Spring Boot ����û�й�ϵ��