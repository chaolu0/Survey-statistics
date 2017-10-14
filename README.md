# Survey-statistics
纸质版调查问卷统计


example目录下是一个使用实例:

其中：
> * in.txt是手动输入的问卷中的选项，以数字来代替选项。
> * x.xml是关于问卷的xml配置，一个question代表一个问题的配置。每一个question节点有三个子节点，id：题号，isMutil：是多选题，optionCount：选项数量。
> * s.txt是程序的输出结果。

使用：
> * 在config.xml文件中配置输入输出目录，输入目录即是上述x.xml的路径，格式参考x.xml。输出路径即是统计结果的输出路径。
> * run Text.main()方法即可运行得到结果
