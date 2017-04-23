package open.core;

import java.text.ParseException;

/**
 * 属�?�对�?
 * Created by xuzhishen on 2016/5/10.
 */
public class PropertyObject {

    private String name;
    private String lowerName;

    private Object value;
    private ValueTypeEnum valueType;

    /**
     * 属�?�对�?
     * @param name  属�?�名�?
     * @param value 属�?��??
     * @param valueType 属�?�类�?
     */
    public PropertyObject(String name, Object value, ValueTypeEnum valueType)
    {
        this.name = name;
        this.lowerName = name.toLowerCase();
        this.value = value;
        this.valueType = valueType;
    }

    /**
     * 获取属�?�名�?
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 获取小写的属性名�?
     * @return
     */
    public String getLowerName() {
        return lowerName;
    }

    /**
     * 获取属�?��??
     * @return
     */
    public Object getValue() {
        return value;
    }

    /**
     * 是否参与签名
     * @return
     */
    public boolean isSign(){
        return value != null && valueType != ValueTypeEnum.Other;
    }

    @Override
    public String toString() {
        try {
            return PropertyFormater.ObjectFormat(lowerName, value, valueType);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
