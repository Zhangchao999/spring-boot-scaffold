# springbootscaffold
spring boot 脚手架


1. mvn archetype:create-from-project
2. cd target/generated-sources/archetype/
3. mvn INSTALL

步骤：
1. 在pom.xml同级目录执行`mvn archetype:create-from-project`,会在同级的`target`下生成`generated-sources/archetype`目录，这就生成的`archetype（原型）`  
`初始化`  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/createProjectInit.png)  
`初始化成功`  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/createProjectSuccess.png)  
`install到本地仓库`  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/install2localRepo.png)  
`install完成`  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/install2localRepoSucess.png)  
2. 在idea的maven中配置骨架  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/ideaConfigScaffold.png)  
`骨架参数可以从maven仓库中获取`  
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/localRepoXml.png)


### aop
官方文档提出优从高到底的优先级分配是 `@Around`, `@Before`, `@After`, `@AfterReturning`, `@AfterThrowing`  
但是，由于Spring的AspectJAfterAdvice中的实现方式，在`@AfterReturning`或`@AfterThrowing`通知方法之后，都会有效地调用`@After`通知方法
