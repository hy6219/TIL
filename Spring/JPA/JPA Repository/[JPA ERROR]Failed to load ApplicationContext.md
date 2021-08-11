# JPA 설정 관련 에러-java.lang.IllegalStateException: Failed to load ApplicationContext
   at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext 😭

```java
Failed to load ApplicationContext
java.lang.IllegalStateException: Failed to load ApplicationContext
   at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:132)
   at org.springframework.test.context.support.DefaultTestContext.getApplicationContext(DefaultTestContext.java:124)
   at org.springframework.test.context.web.ServletTestExecutionListener.setUpRequestContextIfNecessary(ServletTestExecutionListener.java:190)
   at org.springframework.test.context.web.ServletTestExecutionListener.prepareTestInstance(ServletTestExecutionListener.java:132)
   at org.springframework.test.context.TestContextManager.prepareTestInstance(TestContextManager.java:244)
   at org.springframework.test.context.junit.jupiter.SpringExtension.postProcessTestInstance(SpringExtension.java:138)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$6(ClassBasedTestDescriptor.java:350)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.executeAndMaskThrowable(ClassBasedTestDescriptor.java:355)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$invokeTestInstancePostProcessors$7(ClassBasedTestDescriptor.java:350)
   at java.util.stream.ReferencePipeline$3$1.accept(ReferencePipeline.java:193)
   at java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:175)
   at java.util.ArrayList$ArrayListSpliterator.forEachRemaining(ArrayList.java:1384)
   at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:482)
   at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
   at java.util.stream.StreamSpliterators$WrappingSpliterator.forEachRemaining(StreamSpliterators.java:313)
   at java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:743)
   at java.util.stream.Streams$ConcatSpliterator.forEachRemaining(Streams.java:742)
   at java.util.stream.ReferencePipeline$Head.forEach(ReferencePipeline.java:647)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.invokeTestInstancePostProcessors(ClassBasedTestDescriptor.java:349)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$instantiateAndPostProcessTestInstance$4(ClassBasedTestDescriptor.java:270)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.instantiateAndPostProcessTestInstance(ClassBasedTestDescriptor.java:269)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$2(ClassBasedTestDescriptor.java:259)
   at java.util.Optional.orElseGet(Optional.java:267)
   at org.junit.jupiter.engine.descriptor.ClassBasedTestDescriptor.lambda$testInstancesProvider$3(ClassBasedTestDescriptor.java:258)
   at org.junit.jupiter.engine.execution.TestInstancesProvider.getTestInstances(TestInstancesProvider.java:31)
   at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$prepare$0(TestMethodTestDescriptor.java:101)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:100)
   at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.prepare(TestMethodTestDescriptor.java:65)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$prepare$1(NodeTestTask.java:111)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.prepare(NodeTestTask.java:111)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:79)
   at java.util.ArrayList.forEach(ArrayList.java:1259)
   at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
   at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
   at java.util.ArrayList.forEach(ArrayList.java:1259)
   at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.invokeAll(SameThreadHierarchicalTestExecutorService.java:38)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$5(NodeTestTask.java:143)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$7(NodeTestTask.java:129)
   at org.junit.platform.engine.support.hierarchical.Node.around(Node.java:137)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.lambda$executeRecursively$8(NodeTestTask.java:127)
   at org.junit.platform.engine.support.hierarchical.ThrowableCollector.execute(ThrowableCollector.java:73)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.executeRecursively(NodeTestTask.java:126)
   at org.junit.platform.engine.support.hierarchical.NodeTestTask.execute(NodeTestTask.java:84)
   at org.junit.platform.engine.support.hierarchical.SameThreadHierarchicalTestExecutorService.submit(SameThreadHierarchicalTestExecutorService.java:32)
   at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:57)
   at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:51)
   at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:108)
   at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:88)
   at org.junit.platform.launcher.core.EngineExecutionOrchestrator.lambda$execute$0(EngineExecutionOrchestrator.java:54)
   at org.junit.platform.launcher.core.EngineExecutionOrchestrator.withInterceptedStreams(EngineExecutionOrchestrator.java:67)
   at org.junit.platform.launcher.core.EngineExecutionOrchestrator.execute(EngineExecutionOrchestrator.java:52)
   at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:96)
   at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:75)
   at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.processAllTestClasses(JUnitPlatformTestClassProcessor.java:99)
   at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor$CollectAllTestClassesExecutor.access$000(JUnitPlatformTestClassProcessor.java:79)
   at org.gradle.api.internal.tasks.testing.junitplatform.JUnitPlatformTestClassProcessor.stop(JUnitPlatformTestClassProcessor.java:75)
   at org.gradle.api.internal.tasks.testing.SuiteTestClassProcessor.stop(SuiteTestClassProcessor.java:61)
   at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
   at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
   at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
   at java.lang.reflect.Method.invoke(Method.java:498)
   at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
   at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
   at org.gradle.internal.dispatch.ContextClassLoaderDispatch.dispatch(ContextClassLoaderDispatch.java:33)
   at org.gradle.internal.dispatch.ProxyDispatchAdapter$DispatchingInvocationHandler.invoke(ProxyDispatchAdapter.java:94)
   at com.sun.proxy.$Proxy2.stop(Unknown Source)
   at org.gradle.api.internal.tasks.testing.worker.TestWorker.stop(TestWorker.java:135)
   at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
   at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
   at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
   at java.lang.reflect.Method.invoke(Method.java:498)
   at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:36)
   at org.gradle.internal.dispatch.ReflectionDispatch.dispatch(ReflectionDispatch.java:24)
   at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:182)
   at org.gradle.internal.remote.internal.hub.MessageHubBackedObjectConnection$DispatchWrapper.dispatch(MessageHubBackedObjectConnection.java:164)
   at org.gradle.internal.remote.internal.hub.MessageHub$Handler.run(MessageHub.java:414)
   at org.gradle.internal.concurrent.ExecutorPolicy$CatchAndRecordFailures.onExecute(ExecutorPolicy.java:64)
   at org.gradle.internal.concurrent.ManagedExecutorImpl$1.run(ManagedExecutorImpl.java:48)
   at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1149)
   at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:624)
   at org.gradle.internal.concurrent.ThreadFactoryImpl$ManagedThreadRunnable.run(ThreadFactoryImpl.java:56)
   at java.lang.Thread.run(Thread.java:748)
Caused by: org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'dataSourceScriptDatabaseInitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/DataSourceInitializationConfiguration.class]: Invocation of init method failed; nested exception is org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of URL [file:/D:/ji_study/패캠%20백엔드%20스터디/Spring/JPA_repository_interface/build/resources/main/data.sql]: INSERT INTO user VALUES(1,'STEVE','steve@gmail.com','210811','210811'); nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USER" not found; SQL statement:
INSERT INTO user VALUES(1,'STEVE','steve@gmail.com','210811','210811') [42102-200]
   at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1786)
   at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:602)
   at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:524)
   at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335)
   at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234)
   at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333)
   at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
   at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:322)
   at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208)
   at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1154)
   at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:908)
   at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583)
   at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754)
   at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:434)
   at org.springframework.boot.SpringApplication.run(SpringApplication.java:338)
   at org.springframework.boot.test.context.SpringBootContextLoader.loadContext(SpringBootContextLoader.java:123)
   at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContextInternal(DefaultCacheAwareContextLoaderDelegate.java:99)
   at org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate.loadContext(DefaultCacheAwareContextLoaderDelegate.java:124)
   ... 92 more
Caused by: org.springframework.jdbc.datasource.init.ScriptStatementFailedException: Failed to execute SQL script statement #1 of URL [file:/D:/ji_study/패캠%20백엔드%20스터디/Spring/JPA_repository_interface/build/resources/main/data.sql]: INSERT INTO user VALUES(1,'STEVE','steve@gmail.com','210811','210811'); nested exception is org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USER" not found; SQL statement:
INSERT INTO user VALUES(1,'STEVE','steve@gmail.com','210811','210811') [42102-200]
   at org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript(ScriptUtils.java:282)
   at org.springframework.jdbc.datasource.init.ResourceDatabasePopulator.populate(ResourceDatabasePopulator.java:254)
   at org.springframework.jdbc.datasource.init.DatabasePopulatorUtils.execute(DatabasePopulatorUtils.java:49)
   at org.springframework.boot.jdbc.init.DataSourceScriptDatabaseInitializer.runScripts(DataSourceScriptDatabaseInitializer.java:89)
   at org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer.runScripts(AbstractScriptDatabaseInitializer.java:145)
   at org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer.applyScripts(AbstractScriptDatabaseInitializer.java:107)
   at org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer.applyDataScripts(AbstractScriptDatabaseInitializer.java:101)
   at org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer.initializeDatabase(AbstractScriptDatabaseInitializer.java:76)
   at org.springframework.boot.sql.init.AbstractScriptDatabaseInitializer.afterPropertiesSet(AbstractScriptDatabaseInitializer.java:65)
   at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1845)
   at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1782)
   ... 109 more
Caused by: org.h2.jdbc.JdbcSQLSyntaxErrorException: Table "USER" not found; SQL statement:
INSERT INTO user VALUES(1,'STEVE','steve@gmail.com','210811','210811') [42102-200]
   at org.h2.message.DbException.getJdbcSQLException(DbException.java:453)
   at org.h2.message.DbException.getJdbcSQLException(DbException.java:429)
   at org.h2.message.DbException.get(DbException.java:205)
   at org.h2.message.DbException.get(DbException.java:181)
   at org.h2.command.Parser.readTableOrView(Parser.java:7628)
   at org.h2.command.Parser.readTableOrView(Parser.java:7599)
   at org.h2.command.Parser.parseInsert(Parser.java:1747)
   at org.h2.command.Parser.parsePrepared(Parser.java:954)
   at org.h2.command.Parser.parse(Parser.java:843)
   at org.h2.command.Parser.parse(Parser.java:815)
   at org.h2.command.Parser.prepareCommand(Parser.java:738)
   at org.h2.engine.Session.prepareLocal(Session.java:657)
   at org.h2.engine.Session.prepareCommand(Session.java:595)
   at org.h2.jdbc.JdbcConnection.prepareCommand(JdbcConnection.java:1235)
   at org.h2.jdbc.JdbcStatement.executeInternal(JdbcStatement.java:212)
   at org.h2.jdbc.JdbcStatement.execute(JdbcStatement.java:201)
   at com.zaxxer.hikari.pool.ProxyStatement.execute(ProxyStatement.java:94)
   at com.zaxxer.hikari.pool.HikariProxyStatement.execute(HikariProxyStatement.java)
   at org.springframework.jdbc.datasource.init.ScriptUtils.executeSqlScript(ScriptUtils.java:261)
   ... 119 more
```

에러에 난 녹아버렸다..

찾아보니까 여러 방식이 있었다

1. repository에 대해서 setter 를 설정하거나
2. EnableAutoConfiguration 혹은 EnableJpaRepositories를 설정
3. spring.jpa.defer-data-source-initialization값을 never로 한 후에 always로 변경

하지만! 나는 ! 삽질의 끝에!!

- url 설정
- 드라이버 설정
- defer-datasource-initialization: true 설정
- sql.init.enabled=true 설정

을 통해서 해결했다

```java
spring:
  h2:
    console:
      enabled: true
  datasource:
  #  initialization-mode: never
    **url: my-jdbc-url
    driver-class-name: org.h2.Driver
  sql:
    init:
      enabled: true
spring.jpa.defer-datasource-initialization: true**
#  datasource:
#    url:jdbc:h2:mem:7cf6e91d-d5af-40f5-abbe-06a8f9e2f5ae
#  jpa:
#    database-platform: org.hibernate.dialect.H2Dialect

server:
  port: 8089
```

[빵은이 막노트 : 네이버 블로그](https://blog.naver.com/qpqpqpqp5/222425484896)

[Spring Boot) H2 데이터베이스 적재 문제 해결 / error creating bean with name 'datasourcescriptdatabaseinitializer' defined in class path resource [org/springframework/boot/autoconfigure/sql/init/datasourceinitializationconfiguration.class]](https://seungyooon.tistory.com/218)

---

(삽질 시작)

[Injecting JpaRepository: Error creating bean with name](https://stackoverflow.com/questions/43237852/injecting-jparepository-error-creating-bean-with-name)

[JPA repository.save is Null (NullPointerException) - feat. @RunWith & @SpringBootTest & @DataJpaTest](https://n1tjrgns.tistory.com/224)

(JUnit5는 ExtendsWith와 함께 SpringExtension.class 값 넣어주기)

[Null pointer exception spring boot jpa](https://stackoverflow.com/questions/49842480/null-pointer-exception-spring-boot-jpa)

setter부분은 링크를 못찾겠다..(거의 하루 종일 삽질해서 링크가 구분이 가질 않는다..ㅠㅠ)