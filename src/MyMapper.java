
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable, Text, Text, Text>{
	public static List<String> tags = new ArrayList<String>();
	
	@Override
	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String page = value.toString();
		String[] sentences = page.split("\n", 2);
		String[] vals = sentences[0].split(" ");
		context.write(new Text(vals[1]), value);
		
		
	}
	
}
