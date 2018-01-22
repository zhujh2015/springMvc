/**
 * Created by Administrator on 2018/1/9.
 */
public class test {
    /*1.spring mvc mybatis
    * 2.bootstrap
    * 3.logback
    * 4.QuartzJob
    * 5.redis*/


    /*redis 两种持久化 （目前用RDB 如果都不用雷同于Memcache）
    RDB，简而言之，就是在不同的时间点，将redis存储的数据生成快照并存储到磁盘等介质上；
         即你每5分钟都持久化一次，所以数据完整性不太敏感。
    AOF，则是换了一个角度来实现持久化，那就是将redis执行过的所有写指令记录下来，在下次redis重新启动时，只要把这些写指令从前到后再重复执行一遍，就可以实现数据恢复了
         即默认的AOF持久化策略是每秒钟fsync一次
    是基于单线程模型实现 高耗时的Redis命令是很危险的，因为会占用唯一的线程*/
}
