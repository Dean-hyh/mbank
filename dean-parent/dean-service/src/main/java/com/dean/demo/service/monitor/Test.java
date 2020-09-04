package com.dean.demo.service.monitor;

import org.hyperic.sigar.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Properties;

public class Test{
    public static void main(String[] args) throws SigarException,UnknownHostException {
        OperatingSystem OS = OperatingSystem.getInstance();
        System.out.println("=========操作系统========");
        // 操作系统内核类型如： 386、486、586等x86
        System.out.println("操作系统内核 = " + OS.getArch());
        System.out.println("OS.getCpuEndian() = " + OS.getCpuEndian());
        System.out.println("OS.getDataModel() = " + OS.getDataModel());
        // 系统描述
        System.out.println("系统描述 = " + OS.getDescription());

        // 操作系统类型
        System.out.println("系统类型 = " + OS.getName());
        // 操作系统的卖主
        System.out.println("系统卖主 = " + OS.getVendor());
        // 操作系统名称
        System.out.println("系统名称 = " + OS.getVendorName());
        // 操作系统卖主类型
        System.out.println("系统类型 = " + OS.getVendorVersion());
        // 操作系统的版本号
        System.out.println("版本号 = " + OS.getVersion());

        System.out.println("==============cpu===================");
        Sigar sigar = new Sigar();
        CpuInfo infos[] = sigar.getCpuInfoList();
        CpuPerc cpu = sigar.getCpuPerc();
        String address = InetAddress.getLocalHost().getHostAddress();
        System.out.println("本机IP地址" + address);
        for(int i = 0; i<infos.length; i++){
            CpuInfo info = infos[i];
            //CPU的总量MHz
            System.out.println("CPU总量mhz=" + info.getMhz());
            //获得CPU的卖主，如：Intel
            System.out.println("vendor=" + info.getVendor());
            //获得CPU的类别，如：Celeron
            System.out.println("model=" + info.getModel());
            //缓冲存储器数量
            System.out.println("cache size=" + info.getCacheSize());
            // 用户使用率
            System.out.println("User :" + CpuPerc.format(cpu.getUser()));
            // 系统使用率
            System.out.println("Sys :" + CpuPerc.format(cpu.getSys()));
        }
        FileSystem fslist[] = sigar.getFileSystemList();
        System.out.println("长度为什么是:"+fslist.length);

        for (int i = 0; i < fslist.length - 2; i++){
            System.out.println("============硬盘描述============");
            System.out.println("\n~~~~~~~~~~" + i + "~~~~~~~~~~");
            FileSystem fs = fslist[i];
            // 分区的盘符名称
            System.out.println("fs.getDevName() = " + fs.getDevName());
            // 文件系统类型，比如 FAT32、NTFS
            System.out.println("fs.getSysTypeName() = " + fs.getSysTypeName());
            // 文件系统类型名，比如本地硬盘、光驱、网络文件系统等
            System.out.println("fs.getTypeName() = " + fs.getTypeName());
            // 文件系统类型
            FileSystemUsage usage = sigar.getFileSystemUsage(fs.getDirName());
            String sub = fs.getDevName().substring(0, 1);
            // 文件系统总大小
            System.out.println(" 硬盘 " + sub + "=" + usage.getTotal() / 1024
                    / 1024 + "GB");

            // 文件系统剩余大小
            System.out.println(" 硬盘剩余大小= " + usage.getFree() / 1024 / 1024
                    + "GB");
            // 文件系统可用大小
            System.out.println(" 硬盘可用大小 = " + usage.getAvail() / 1024 / 1024
                    + "GB");
            // 文件系统已经使用量
            System.out.println(" 已使用量 = " + usage.getUsed() / 1024 / 1024
                    + "GB");
            double usePercent = usage.getUsePercent() * 100D;
            // 文件系统资源的利用率
            System.out.println(" 利用率 = " + usePercent + "%");

            System.out.println(" DiskReads = " + usage.getDiskReads());
            System.out.println(" DiskWrites = " + usage.getDiskWrites());
        }

        if (java.awt.Desktop.isDesktopSupported()){
            try {
                //创建一个URI实例
                java.net.URI uri = java.net.URI.create("http://www.baidu.com/");
                //获取当前系统桌面扩展
                java.awt.Desktop dp = java.awt.Desktop.getDesktop();
                //获得系统属性集
                Properties props = System.getProperties();
                //操作系统名称
                String osName = props.getProperty("os.name");
                System.out.println("操作系统名称:" + osName);
                //操作系统构架
                String osArch = props.getProperty("os.arch");
                System.out.println("系统架构:" + osArch);
                //操作系统版本
                String osVersion = props.getProperty("os.version");
                System.out.println("操作系统版本:" + osVersion);
                //Java安装目录
                String home = props.getProperty("java.home");
                System.out.println("java安装目录:" + home);
                //用户的账户名称
                String user = props.getProperty("user.home");
                System.out.println("用户帐户名称:" + user);
                //Java 运行时环境规范名称
                String version = props.getProperty("java.specification.name");
                System.out.println("Java 运行时环境规范名称 :" + version);
                //获取当前jdk的版本号
                String number = props.getProperty("java.specification.version");
                System.out.println("jdk的版本号:" + number);
                //判断系统桌面是否支持要执行的功能
                if (dp.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    //获取系统默认浏览器打开链接
                    dp.browse(uri);
                }
            } catch (java.lang.NullPointerException e) {
                //此为uri为空时抛出异常
            } catch (java.io.IOException e) {
                //此为无法获取系统默认浏览器
            }
        }
    }
}

