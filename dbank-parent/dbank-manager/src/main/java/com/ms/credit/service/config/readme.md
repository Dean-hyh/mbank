#关于service/config文件夹的一些说明
###1.SnowFlakeProperties
   用于读取SnowFlake.properties中的key值对应的value
###2.SnowFlakeConfig配置类
   用于向Spring容器中注入添加了机器ID及数据中心ID的SnowFlake
###3.SnowFlake雪花算法工具类
   用于在分布式系统中生成唯一不重复的ID
   
##问题：
   1.读取配置文件的方式
   
   2.配置文件内容注入Bean属性的时间
   
   3.Bean加入Spring容器的时间（IOC）
