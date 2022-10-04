package com.yoga.mp.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @author Jason Lyu
 * @since 2022/1/12
 */
public class Oracle {

        public static void main(String[] args) {
            // 1.创建代码生成器
            AutoGenerator mpg = new AutoGenerator();

            // 2.全局配置
            GlobalConfig gc = new GlobalConfig();
            String projectPath = System.getProperty("user.dir");
            gc.setOutputDir(projectPath + "/src/main/java");
            gc.setAuthor("Jason Lyu");
            gc.setOpen(false); //生成后是否打开资源管理器
            gc.setFileOverride(false); //重新生成时文件是否覆盖
            /**
             * mp生成service层代码，默认接口名称第一个字母有 I
             *
             */
            gc.setServiceName("%sService");//去掉Service接口的首字母I
            gc.setIdType(IdType.AUTO);//主键策略,IdType.AUTO对应的策略为主键自增
            gc.setDateType(DateType.ONLY_DATE);//定义生成的实体类中日期类型
//        gc.setSwagger2(true); // 实体属性 Swagger2 注解
            mpg.setGlobalConfig(gc);

            //3. 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
            dsc.setDbType(DbType.ORACLE);
            dsc.setTypeConvert(new OracleTypeConvert());
            dsc.setDriverName("oracle.jdbc.driver.OracleDriver");
            dsc.setUsername("system");
            dsc.setPassword("root");
            mpg.setDataSource(dsc);

            // 4.包配置
            PackageConfig pc = new PackageConfig();
            pc.setModuleName("sales");
            pc.setParent("com.fleetup");
            pc.setController("controller");
            pc.setEntity("entity");
            pc.setService("service");
            pc.setMapper("mapper");
            mpg.setPackageInfo(pc);

            // 5.策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setInclude(new String[]{"SALES_SURVEY_HISTORY"}); // 表名字，注意一定要大写！大写！否则识别不出来！
            strategy.setNaming(NamingStrategy.underline_to_camel);//数据库表映射到实体的命名策略
            strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);;//数据库表字段映射到实体的命名策略
            strategy.setEntityLombokModel(true);// lombok 模型 @Accessors(chain true) setter链式操作
            strategy.setRestControllerStyle(true); //restful api风格控制器
            strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符

            mpg.setStrategy(strategy);
            mpg.execute();
        }

    }

