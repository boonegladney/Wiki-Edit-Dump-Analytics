

import java.util.ArrayList;
import java.util.List;



import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		int i = 0;
		for (Text value : values) {
			StringBuilder out = new StringBuilder();
			String[] sentences = value.toString().split("\n", 2);
			String[] vals = sentences[0].split(" ");
			
			//get revision id
			out.append(vals[2].trim() + ",");
			
			//get article id
			out.append(vals[1].trim() + ",");
			
			//get article title
			out .append(vals[3].trim() + ",");
			
			//get year
			String[] timeStampInfo = vals[4].split("-");
			out.append(timeStampInfo[0] + ",");
			
			//get username
			out.append(vals[5].trim() + ",");
			
			//get userID
			out.append(vals[6].trim());
			
			context.write(new Text(out.toString()), new Text(""));
		}
	}

	
}
