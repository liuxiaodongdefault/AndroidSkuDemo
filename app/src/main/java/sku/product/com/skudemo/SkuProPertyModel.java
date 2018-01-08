package sku.product.com.skudemo;

/**
 * Created by liuxiaodongdefault
 * Created at 17/11/9
 * Project name SkuDemo
 * Package name sku.product.com.skudemo
 */

public class SkuProPertyModel {

    // 通过重写equals方法使containsAll方法起效
    @Override
    public boolean equals(Object o) {
        if (o instanceof SkuProPertyModel) {
            SkuProPertyModel spb = (SkuProPertyModel) o;
            return this.propertyName.equals(spb.propertyName)
                    && this.propertyValue.equals(spb.propertyValue);
        }
        return super.equals(o);
    }
    /**
     * propertyName : 电类颜色
     * propertyValue : 红色
     */
    public String propertyName;
    public String propertyValue;

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }
}
