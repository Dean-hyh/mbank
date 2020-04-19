#关于datasource文件夹的一些说明
###1.DataSource注解对象，标注在方法上
   用于标记执行数据读写的数据源
###2.DataSourceContextHolder
   用于操作线程局部变量ThreadLocal，提供get及set方法，用于向ThreadLocal中添加数据源的key值及移除key值
###3.DynamicDataSource
   继承AbstractRoutingDataSource类，依据从ThreadLocal中get到的数据源id（key）信息，动态的从配置文件中获取数据源
###此外：需要使用AOP通知扫描dao层方法上面的@DataSource注解，通知类：advise/DataSourceAspect

##为解决的问题：
   1.读写分离的数据库事务怎么处理?
   
   2.主从库数据同步问题?
   
   3.AOP环绕通知无法实现，是什么原因?
