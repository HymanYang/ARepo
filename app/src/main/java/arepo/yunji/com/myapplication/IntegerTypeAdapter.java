package arepo.yunji.com.myapplication;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * @Description: Integer数字类型转换
 * @Author: yangZhou
 * @Copyright: 浙江集商优选电子商务有限公司
 * @CreateDate: 2019/5/21 9:33
 * @Version: 1.0.0
 */
public class IntegerTypeAdapter extends TypeAdapter<Integer> {

    @Override
    public void write(JsonWriter out, Integer value) throws IOException {

        if (value == null) {
            out.value("0");
            return;
        }

        out.value(String.valueOf(value));
    }

    @Override
    public Integer read(JsonReader in) throws IOException {
        try {

            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return 0;
            } else {
                String s = in.nextString();

                try {
                    return Long.valueOf(s).intValue();
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }

                try {
                    return Double.valueOf(s).intValue();
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }

                try {
                    return Float.valueOf(s).intValue();
                } catch (NumberFormatException e) {
                    //e.printStackTrace();
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
