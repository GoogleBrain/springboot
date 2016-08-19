1.springboot 默认自带了一个tomcat，端口默认为8080.修改端口。请查看com.sun.spring.Main.java这个类；
2.这个项目是实现了一个最简单的调用，没有连接数据库；
两个方法的访问地址分别为：http://localhost:1234  , http://localhost:1234/hu/


参考内容：
Spring 框架包含几十个不同的子项目，涵盖应用开发的不同方面。如此多的子项目和组件，一方面方便了开发人员的使用，另外一个方面也带来了使用方面的问题。

每个子项目都有一定的学习曲线。开发人员需要了解这些子项目和组件的具体细节，才能知道如何把这些子项目整合起来形成一个完整的解决方案。

解决：它可以自动配置 Spring 的各种组件，并不依赖代码生成和 XML 配置文件。Spring Boot 也提供了对于常见场景的推荐组件配置。Spring Boot 可以大大提升使用 Spring 框架时的开发效率。


二、简介：

1>作用：

Spring Boot 的作用在于创建和启动新的基于 Spring 框架的项目。

2>Spring Boot目的：

它的目的是帮助开发人员很容易的创建出独立运行和产品级别的基于 Spring 框架的应用

3>怎么做的？

Spring Boot 会选择最适合的 Spring 子项目和第三方开源库进行整合。大部分 Spring Boot 应用只需要非常少的配置就可以快速运行起来。

3>Spring Boot 包含的特性如下：

。创建可以独立运行的 Spring 应用。
。直接嵌入 Tomcat 或 Jetty 服务器，不需要部署 WAR 文件。
。提供推荐的基础 POM 文件来简化 Apache Maven 配置。
。尽可能的根据项目依赖来自动配置 Spring 框架。
。提供可以直接在生产环境中使用的功能，如性能指标、应用信息和应用健康检查。
。没有代码生成，也没有 XML 配置文件。

三、使用：使用 Maven 作为构建工具创建的 Spring Boot 应用

  创建Maven项目后：

1>清单 1. Spring Boot 示例应用的 POM 文件

说明：应用所声明的依赖很少，只有一个“org.springframework.boot:spring-boot-starter-web”，而不是像其他 Spring 项目一样需要声明很多的依赖。

当使用 Maven 命令“mvn dependency:tree”来查看项目实际的依赖时，会发现其中包含了 Spring MVC 框架、SLF4J、Jackson、Hibernate Validator 和 Tomcat 等依赖
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

2> 清单 2. Spring Boot 示例应用的 Java 代码
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

3> 详细说明

3.1>代码清单 2 中的 Java 类 Application 是一个简单的可以独立运行的 Web 应用。

3.2>直接运行该 Java 类会启动一个内嵌的 Tomcat 服务器运行在 8080 端口。访问“http://localhost:8080”可以看到页面上显示“Hello World!”。

3.3>代码清单 2 中的“@EnableAutoConfiguration”注解的作用在于让 Spring Boot 根据应用所声明的依赖来对 Spring 框架进行自动配置，这就减少了开发人员的工作量。

3.4>注解“@RestController”和”@RequestMapping”由 Spring MVC 提供，用来创建 REST 服务。这两个注解和 Spring Boot 本身并没有关系。