#### jar包打不开报 error open zip file
```
 1. Maven下载到的jar包有问题，一般来说下载下来出现这种问题的jar包都是155KB大小
 2. 解决办法
    2.1.删除有问题的jar包，然后重新下载jar包。不过根据本人经验，大部分时候这个方法都解决不了问题
    2.2.自己去mvn的仓库，找到相关jar包，手动下载下来，然后放到自己本地maven仓库，一般来说做到这
        样就可以了。某些特殊情况下，需要自己手动执行命令mvn install:install-file -DgroupId=GroupId -DartifactId=ArtifactId -Dversion=Version -Dpackaging=jar -Dfile=Jar包路径
        将jar安装到本地mvn仓库，然后清掉自己IDE的缓存，重新加载项目。
```

#### 手动安装本地Jar包到本地mvn仓库
```$xslt
 执行命令 mvn install:install-file -DgroupId=GroupId -DartifactId=ArtifactId -Dversion=Version -Dpackaging=jar -Dfile=Jar包路径
```

#### NoClassDefFoundError: Could not initialize class com.fasterxml.jackson.databind.ObjectMapper
```
 1. 添加依赖
    <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-databind</artifactId>
       <version>版本根据自己实际情况而定2.12.4</version>
       是否排除掉jackson-annotations也根据自己情况而定，如果已经直接或间接引入该依赖就排除掉
       该依赖，否则可能引起依赖冲突
       <exclusions>
          <exclusion>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-annotations</artifactId>
          </exclusion>
       </exclusions>
    </dependency>
```

#### ClassNotFoundException: com.fasterxml.jackson.databind.ObjectMapper
```$xslt
 1. 添加依赖
   <jackson.version>2.12.5</jackson.version>
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>${jackson.version}</version>
   </dependency>
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>${jackson.version}</version>
   </dependency>
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>${jackson.version}</version>
   </dependency>
```

#### ClassNotFoundException: com.fasterxml.jackson.core.Versioned
```
 1. 添加依赖
    <dependency>
       <groupId>com.fasterxml.jackson.core</groupId>
       <artifactId>jackson-core</artifactId>
       <version>版本根据自己实际情况而定2.12.4</version>
    </dependency>
```

#### ClassNotFoundException: org.springframework.data.keyvalue.repository.support.KeyValueRepositoryFactoryBean
```
 1. 添加依赖
   <dependency>
      <groupId>org.springframework.data</groupId>
      <artifactId>spring-data-keyvalue</artifactId>
   </dependency>
   <dependency>
      <groupId>org.springframework.data</groupId>
      <artifactId>spring-data-commons</artifactId>
   </dependency>
```

#### 无法访问 PersistenceExceptionTranslator
```
 1. 添加依赖
   <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-tx</artifactId>
      <version>版本根据自己实际情况而定5.3.9</version>
   </dependency>
```
#### NoClassDefFoundError: org/springframework/orm/jpa/support/PersistenceAnnotationBeanPostProcessor
```$xslt
 1. 添加依赖
    <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-orm</artifactId>
       <version>版本根据自己实际情况而定5.3.2</version>
    </dependency>
```

#### 添加了SpringDataJpa依赖但是jpa相关的很多类都找不到
```$xslt
 1. 添加依赖
   <dependency>
      <groupId>org.springframework.data</groupId>
      <artifactId>spring-data-commons</artifactId>
      <version>版本根据自己实际情况而定2.4.2</version>
   </dependency>
```

#### HttpMessageNotWritableException: No converter found for return value of type
```$xslt
 1. 添加依赖
    这里的版本应该与spring-boot-starter-web中的spring-boot-starter-json引入jackson版本一致
    如果还不行，应该尝试将本地的Jackson Jar包给清除掉，重新下载
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.11.3</version>
   </dependency>
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>2.11.3</version>
   </dependency>
   <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>2.11.3</version>
   </dependency>
```

#### 本地mvn仓库有对应的jar包，且jar包没有任何损坏，但是IDE中pom报找不到版本，始终无法引入
```$xslt
 1. 清除IDE的缓存，重新加载build项目
 2. 清除缓存，重新加载都没用的话，只能自己手动将相关jar导入进来了
    idea：点击File -> Project Structure -> Libraries -> + -> java -> Jar包的绝对路径
    或者：自己在项目新建一个文件夹，然后在pom中,以如下方式进行引入
       <!-- 添加本地jar依赖 -->
       <dependency>
          <!-- 自定义 -->
          <groupId>examples</groupId>
          <!-- 自定义 -->
          <artifactId>examples</artifactId>
          <!-- 自定义 -->
          <version>1.0</version>
          <!-- 必须为system -->
          <scope>system</scope>
          <!-- 必须为jar包的所在路径 -->
          <systemPath>${project.basedir}/libraries/examples.jar</systemPath>
       </dependency>
```

#### plugin 无法引入
```$xslt
 1. 把plugin相关的信息在<dependency></dependency>中copy一份, 此时mvn会自动引入该依赖，依赖引入后，再将dependency中的删掉
```

#### org.springframework.boot相关的代码无法导入，本地mvn仓库jar包、pom文件都是155KB大小
```$xslt
 1. 这种一般是下载的jar包、pom文件出了毛病，本人是将本地的mvn仓库清空,然后将 setting.xml 中关于ali镜像的配置全部注释掉，
    恢复到mvn原本的配置，然后在项目的根目录下执行 mvn idea:idea 重新下载整个项目需要的全部依赖
 2. 另一个办法就是降版本，比如从2.2.6.release降到2.2.0.release
```

#### java: 程序包org.junit.jupiter.api不存在
```$xslt
 1. 添加依赖
    <dependency>
       <groupId>org.junit.jupiter</groupId>
       <artifactId>junit-jupiter-api</artifactId>
       <version>5.5.0</version>
       <scope>test</scope>
    </dependency>
```