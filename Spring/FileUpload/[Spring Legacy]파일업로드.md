# [Spring] 파일 업로드

## 01. commons-io, commons-fileupload 라이브러리 추가

```jsx
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.js</groupId>
	<artifactId>file</artifactId>
	<name>SpringMVC03_File</name>
	<packaging>war</packaging>
	<version>1.0.0-BUILD-SNAPSHOT</version>
	<repositories>
		<repository>
			<id>Datanucleus</id>
			<url>http://www.datanucleus.org/downloads/maven2/</url>
		</repository>
	</repositories>
	<properties>
		<java-version>1.6</java-version>
		<org.springframework-version>3.1.1.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${org.springframework-version}</version>
			<exclusions>
				<!-- Exclude Commons Logging in favor of SLF4j -->
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				 </exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
				
		<!-- AspectJ -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>${org.aspectj-version}</version>
		</dependency>	
		
		<!-- Logging -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>${org.slf4j-version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.15</version>
			<exclusions>
				<exclusion>
					<groupId>javax.mail</groupId>
					<artifactId>mail</artifactId>
				</exclusion>
				<exclusion>
					<groupId>javax.jms</groupId>
					<artifactId>jms</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jdmk</groupId>
					<artifactId>jmxtools</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jmx</groupId>
					<artifactId>jmxri</artifactId>
				</exclusion>
			</exclusions>
			<scope>runtime</scope>
		</dependency>

		<!-- @Inject -->
		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
				
		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.1</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
	
		<!-- Test -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.7</version>
			<scope>test</scope>
		</dependency>        
				<!-- https://mvnrepository.com/artifact/oracle/ojdbc6 -->
		<dependency>
    		<groupId>oracle</groupId>
    		<artifactId>ojdbc6</artifactId>
    		<version>11.2.0.3</version>
		</dependency>
<!-- https://mvnrepository.com/artifact/commons-dbcp/commons-dbcp -->
		<dependency>
    		<groupId>commons-dbcp</groupId>
    		<artifactId>commons-dbcp</artifactId>
    		<version>1.4</version>
		</dependency>

		 <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
		<dependency>
    		<groupId>org.mybatis</groupId>
    		<artifactId>mybatis</artifactId>
    		<version>3.4.6</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
		<dependency>
    		<groupId>org.mybatis</groupId>
    		<artifactId>mybatis-spring</artifactId>
    		<version>1.3.2</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.springframework/spring-orm -->
		<dependency>
    		<groupId>org.springframework</groupId>
    		<artifactId>spring-orm</artifactId>
    		<version>${org.springframework-version}</version>
		</dependency>	
			
			**<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-io -->
		<dependency>
    		<groupId>org.apache.commons</groupId>
    		<artifactId>commons-io</artifactId>
    		<version>1.3.2</version>
		</dependency>
			<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
		<dependency>
    		<groupId>commons-fileupload</groupId>
    		<artifactId>commons-fileupload</artifactId>
    		<version>1.3.2</version>
		</dependency>**
			
	</dependencies>
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-eclipse-plugin</artifactId>
                <version>2.9</version>
                <configuration>
                    <additionalProjectnatures>
                        <projectnature>org.springframework.ide.eclipse.core.springnature</projectnature>
                    </additionalProjectnatures>
                    <additionalBuildcommands>
                        <buildcommand>org.springframework.ide.eclipse.core.springbuilder</buildcommand>
                    </additionalBuildcommands>
                    <downloadSources>true</downloadSources>
                    <downloadJavadocs>true</downloadJavadocs>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.5.1</version>
                <configuration>
                    <source>1.6</source>
                    <target>1.6</target>
                    <compilerArgument>-Xlint:all</compilerArgument>
                    <showWarnings>true</showWarnings>
                    <showDeprecation>true</showDeprecation>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.2.1</version>
                <configuration>
                    <mainClass>org.test.int1.Main</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

## 02. applicationContext.xml에 multipartResolver 추가하기

- 서블릿 공부할 때 적용했던 파일 최대 용량을 여기서 정의
- 기본 인코딩을 명시

```jsx
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- Root Context: defines shared resources visible to all other web components -->
		<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
			<!-- 파일 최대 용량 -->
			<property name="maxUploadSize" value="10000000000"/>
			<!-- 파일 인코딩 -->
			<property name="defaultEncoding" value="UTF-8"/>
		</bean>
</beans>
```

## 03. 기존의 MultipartRequest로 가져올 수 있는 정보를 담은 dto 객체 준비

```jsx
package com.js.file;

import org.springframework.web.multipart.MultipartFile;

public class UploadFile {
	
	private String fileName;
	private String desc;
	private MultipartFile file;
	
	public UploadFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadFile(String fileName, String desc, MultipartFile file) {
		super();
		this.fileName = fileName;
		this.desc = desc;
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UploadFile [fileName=" + fileName + ", desc=" + desc + ", file=" + file + "]";
	}
	
	
	
	
}
```

## 04. (뷰) index.jsp는 form으로 리다이렉트

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%  response.setContentType("text/html;charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Hello</p>
	<c:redirect url="form"/>
</body>
</html>
```

## 05. (뷰) 파일 업로드 폼

```jsx
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="post" enctype="multipart/form-data" action="upload" **modelAttribute="uploadFile">**
		<h3>업로드할 파일 선택</h3>
		파일: <input type="file" name="file"/>
		<p style="color:red; font-weight:bold;">
		<!-- 문제 발생시 에러메시지를 띄울 부분 ! 에러 바인딩!-->
			<form:errors path="**file**"/>
		</p>
		설명: <br>
		<textarea name="desc" rows="10" cols="40">
		</textarea>
		<input type="submit" value="업로드 완료">
	</form:form>
</body>
</html>
```

🌟 modelAttribute는 바인딩 될 객체의 클래스명을 소문자로 시작해서 기재!

🌟 <form:errors> 부분의 path 에러를 띄울 필드 명을 적절히 기재

## 06. FileValidator로 파일에 대한 유효성 검사

- errors는 BindingResult에 연결되는 부분
- erros.rejectValue(필드명(위의 path="file") [,에러코드], 에러 메시지) → 에러 발생 메시지 설정

```jsx
package com.js.file;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Service
public class FileValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		UploadFile file=(UploadFile)target;
		
		if(file.getFile().getSize()==0) {
			errors.rejectValue("file","invalid file" ,"파일을 다시 확인해주십시오!");
		}
	}

}
```

## 07. 파일을 저장하고 파일 정보 보여주기

🌟 서블릿에서 MultipartRequest로 접근한 과정과 유사

- input stream을 이용해서 파일을 읽어오고, 그것을 outputstream에 저장시키는 부분 차이
- 서버 내 실제 경로를 지정할 때 `WebUtils.getRealPath(컨텍스트, 하위경로)로 지정하는 부분 차이`

```jsx
package com.js.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private FileValidator validator;
	
	@RequestMapping(value="/form")
	public String form() {
		return "uploadForm";
	}
	
	@RequestMapping(value="/upload")
	public String upload(HttpServletRequest request, 
			Model model, UploadFile fileUpload, BindingResult bindingResult) {
		//유효성 검사
		validator.validate(fileUpload, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "uploadForm";
		}
		
		//UploadFile내에 MultipartRequest로 받아온 내용들이 다 접근 가능
		//1.파일 가져오기
		MultipartFile file=fileUpload.getFile();
		//업로드 파일의 원본이름
		String origin=file.getOriginalFilename();
		
		//2.설명가져오기
		String desc=fileUpload.getDesc();
		
		//inputstream을 이용해서 원하는 위치에 저장
		//outputstream을 이용해서 출력
		InputStream inputStream=null;
		OutputStream outputStream=null;
		ServletContext context=null;
		UploadFile toSave=new UploadFile();
		
		toSave.setFile(file);
		toSave.setFileName(origin);
		toSave.setDesc(desc);
		
		//원하는 위치에 저장
		try {
			
			inputStream=file.getInputStream();//바이트단위로 읽어올것
			context=request.getSession().getServletContext();
			//업로드할 경로
			String path=WebUtils.getRealPath(context, "/storage");
			
			logger.info("업로드될 실제 경로: {}",path);
			
			//폴더 생성
			File folder=new File(path);
			
			//경로가 없다면 생성
			if(!folder.exists()) {
				folder.mkdirs();
			}
			
			//폴더 위치 하위에 파일 저장
			File realSave=new File(path+"/"+origin);
			
			if(!realSave.exists()) {
				realSave.createNewFile();
			}else {
				Writer writer=new FileWriter(path+"/"+origin,false);//overwrite
			}
			
			//===
			//파일 정보 저장
			outputStream=new FileOutputStream(realSave);
			
			int read =0;
			byte[] arr=new byte[(int)file.getSize()];
			
			while((read=inputStream.read())!=-1) {
				outputStream.write(arr, 0, read);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj",toSave);	
		
		return "uploadFile";
	}
	
}
```