# springbootscaffold
spring boot 脚手架


1. mvn archetype:create-from-project
2. cd target/generated-sources/archetype/
3. mvn INSTALL

步骤：
1. 在pom.xml同级目录执行`mvn archetype:create-from-project`,会在同级的`target`下生成`generated-sources/archetype`目录，这就生成的`archetype（原型）`
<br/>
`初始化`
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/createProjectInit.png)
<br/>
`初始化成功`
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/createProjectSuccess.png)
<br/>
`install到本地仓库`
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/install2localRepo.png)
<br/>
`install完成`
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/install2localRepoSucess.png)
<br/>
2. 在idea的maven中配置骨架<br/>
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/ideaConfigScaffold.png)
<br/>
`骨架参数可以从maven仓库中获取`<br/>
![生成原型](https://github.com/Zhangchao999/spring-boot-scaffold/raw/main/src/main/resources/githubimg/localRepoXml.png)