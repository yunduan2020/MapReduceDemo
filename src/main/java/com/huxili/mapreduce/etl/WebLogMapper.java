package com.huxili.mapreduce.etl;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class WebLogMapper extends Mapper<LongWritable, Text,Text, NullWritable> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1 获取一行
        String line = value.toString();

        // 2 ETL
        boolean result = parselog(line, context);

        if(!result){
            return;
        }

        // 3 写出
        context.write(value,NullWritable.get());
    }

    private boolean parselog(String line, Context context){
        // 1 切割
        // 58.215.204.118 - - [18/Sep/2013:06:51:41 +0000] "-" 400 0 "-" "-"
        String[] fields = line.split(" ");

        // 2 判断一下日志的长度是否大于11
        if (fields.length > 11){
            return true;
        }else {
            return false;
        }
    }
}
