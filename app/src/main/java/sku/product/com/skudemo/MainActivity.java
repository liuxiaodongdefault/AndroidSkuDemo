package sku.product.com.skudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String TAG = this.getClass().getSimpleName();

//    private EditText mEt;
//    private Button mBtn;
    private TextView mPriceTv;
    private TextView mCheckedTv;
    private RecyclerView mRv;
    private ProductRvAdapter mAdapter;
    private List<RvDataModel> totalDataList; // 总数据集合
    private List<RvDataModel> propertyDataList; // 属性行集合
    private ProductModel productModel; // 商品实体model

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Gson gson = new Gson();
        productModel = gson.fromJson(response, ProductModel.class);
        processRespData(response);
    }

    private void initView() {
//        mEt = (EditText) findViewById(R.id.et);
//        mBtn = (Button) findViewById(R.id.btn);
        mPriceTv = (TextView) findViewById(R.id.tv_price);
        mCheckedTv = (TextView) findViewById(R.id.tv_checked);
        mRv = (RecyclerView) findViewById(R.id.rv_sku_checks);
        initRv();
    }

    // 初始化RecylerView
    private void initRv() {
        MyLayoutManager layoutManager = new MyLayoutManager();
        mRv.setLayoutManager(layoutManager);
        totalDataList = new ArrayList<>();
        mAdapter = new ProductRvAdapter(this, totalDataList);
        mAdapter.setOnItemClickListener(new ProductRvAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (totalDataList.get(position).getType() == ProductRvAdapter.CHECK_TYPE) {
                    // 点击选中菜单项 开始联动逻辑处理
                    doCheckLogic(position);
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRv.setAdapter(mAdapter);

    }

    /**
     * 处理并展示菜单项数据
     * @param response
     */
    private void processRespData(String response) {
        totalDataList.clear();
        propertyDataList = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(response);
            JSONObject data = object.getJSONObject("data");
            JSONArray propertyArray = data.getJSONArray("propertyDataList");
            for (int i = 0; i < propertyArray.length(); i ++) {
                JSONObject proObj = (JSONObject) propertyArray.get(i);
                Iterator<String> sIterator = proObj.keys();
                while(sIterator.hasNext()) {
                    // 获得key
                    String key = sIterator.next();
                    // 根据key获得value, value也可以是JSONObject,JSONArray,使用对应的参数接收即可
                    JSONArray valueArray = proObj.getJSONArray(key);
//                    Log.d(TAG, "key ==>" + key);
                    RvDataModel model = new RvDataModel();
                    model.setName(key);
                    model.setType(ProductRvAdapter.PROPERTY_TYPE);
                    model.setGroupId(i);
                    List<String> groupList = new ArrayList<>();
                    for (int j = 0; j < valueArray.length(); j ++) {
                        groupList.add(valueArray.get(j).toString());
                    }
                    model.setGroupList(groupList);
                    totalDataList.add(model);
                    propertyDataList.add(model);
                    for (int j = 0; j < valueArray.length(); j ++) {
//                        Log.d(TAG, "value ==>" + valueArray.get(j));
                        RvDataModel model1 = new RvDataModel();
                        model1.setName(valueArray.get(j).toString());
                        model1.setType(ProductRvAdapter.CHECK_TYPE);
                        model1.setStatus(0);
                        model1.setGroupId(i);
                        totalDataList.add(model1);
                    }
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 选中项联动逻辑处理
     * @param position
     */
    private void doCheckLogic(int position) {
        // 单选处理
        switch (totalDataList.get(position).getStatus()) {
            case 0:
                // 重置所有该组状态
                resetCheckStatus(position);
                // 改为选中状态
                totalDataList.get(position).setStatus(1);
                break;
            case 1:
                // 改为未选中状态
                totalDataList.get(position).setStatus(0);
                break;
        }
        // 价格
        setPrice();
        // 选中项显示
        setChecksDescription();
        // 置灰
        setDisabledChecks();
        // 图片
        mAdapter.notifyDataSetChanged();
    }

    /**
     * 遍历该组选项数据 并改变状态
     *
     * @param position
     */
    private void resetCheckStatus(int position) {
        for (int i = 0; i < totalDataList.size(); i ++) {
            if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE &&
                    totalDataList.get(i).getGroupId() == totalDataList.get(position).getGroupId()) {
                totalDataList.get(i).setStatus(0);
            }
        }
    }

    List<RvDataModel> checkedList = new ArrayList<>(); // 存储选中项
    List<SkuProPertyModel> skuPropertyList = new ArrayList<>(); //转换选中项为 sku 集合

    // 遍历出选中项的 sku 类型集合
    private void getSkuPropertyList() {
        for (int i = 0; i < totalDataList.size(); i++) {
            if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE
                    && totalDataList.get(i).getStatus() == 1) {
                checkedList.add(totalDataList.get(i));
            }
        }
        for (int j = 0; j < checkedList.size(); j ++) {
            for (int k = 0; k < propertyDataList.size(); k ++) {
                if (checkedList.get(j).getGroupId() == k) {
                    SkuProPertyModel skuPropertyBean =
                            new SkuProPertyModel();
                    skuPropertyBean.setPropertyName(propertyDataList.get(k).getName());
                    skuPropertyBean.setPropertyValue(checkedList.get(j).getName());
                    skuPropertyList.add(skuPropertyBean);
                }
            }
        }
    }

    /**
     * 设置选项对应的价格或价格区间
     */
    private void setPrice() {
        getSkuPropertyList();
        // 遍历sku数组 并找出对应的数据组
        List<ProductModel.DataBean.SkuListBean> skuList = new ArrayList<>();
        for (int i = 0; i < productModel.getData().getSkuList().size(); i++) {
            if (productModel.getData().getSkuList().get(i).getSkuProperty().containsAll(skuPropertyList)) {
                skuList.add(productModel.getData().getSkuList().get(i));
            }
        }
        // 排序 显示价格或价格区间
        Log.d(TAG, "priceCheckList size " + checkedList.size());
        Log.d(TAG, "skuPropertyBeanList size " + skuPropertyList.size());
        Log.d(TAG, "skulist size " + skuList.size());
        double minPrice = 0.00d;
        double maxPrice = 0.00d;
        for (int i = 0; i < skuList.size(); i ++) {
            if (i == 0) {
                minPrice = Double.parseDouble(skuList.get(0).getMarketPrice());
            } else {
                if (Double.parseDouble(skuList.get(i).getMarketPrice()) < minPrice) {
                    minPrice = Double.parseDouble(skuList.get(i).getMarketPrice());
                }
            }
            if (Double.parseDouble(skuList.get(i).getMarketPrice()) >= maxPrice) {
                maxPrice = Double.parseDouble(skuList.get(i).getMarketPrice());
            }
        }
        // 显示价格区间
        if (maxPrice - minPrice > 0) {
            mPriceTv.setText("价格：" + minPrice + "~" + maxPrice);
        } else {
            mPriceTv.setText("价格：" + minPrice);
        }

    }

    private void setChecksDescription() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < totalDataList.size(); i ++) {
            if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE && totalDataList.get(i).getStatus() == 1) {
                sb.append(totalDataList.get(i).getName() + " ");
            }
        }
        mCheckedTv.setText("已选择" + sb);
    }

    // 置灰算法逻辑
    private void setDisabledChecks() {
        // 判断取消所有选中项的状态
        if (skuPropertyList.size() == 0) {
            for (int i = 0; i < totalDataList.size(); i ++) {
                if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE) {
                    totalDataList.get(i).setStatus(0);
                }
            }
            return;
        }
        // 重置所有置灰项
        for (int i = 0; i < totalDataList.size(); i ++) {
            if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE && totalDataList.get(i).getStatus() == 2) {
                totalDataList.get(i).setStatus(0);
            }
        }
        /*
         * 算法描述如下：

         遍历所有非已选元素
         遍历所有属性行
         取： a) 当前元素 b) 非当前元素所在的其它属性已选元素（如果当前属性中没已选元素，则跳过），形成一个路径
         判断此路径是否存在（在所有存在的路径表中查询），如果不存在将当前元素置灰

         */

        // 算出所有元素的幂集
        List<RvDataModel> elementList = new ArrayList<>();
        for (int i = 0; i < totalDataList.size(); i++) {
            if (totalDataList.get(i).getType() == ProductRvAdapter.CHECK_TYPE && totalDataList.get(i).getStatus() == 0) {
                elementList.add(totalDataList.get(i));
            }
        }
        Log.e(TAG, "element list size" + elementList.size());
        List<List<SkuProPertyModel>> pathList = new ArrayList<>(); // 遍历出来的路径组合的集合
        for (int i = 0; i < elementList.size(); i++) {

            for (int j = 0; j < totalDataList.size(); j++) {
                // 当前元素 elementList.get(i) 非当前元素所在的其它属性已选元素 totalDataList.get(j) 组成路径
                if (totalDataList.get(j).getStatus() == 1 && totalDataList.get(j).getGroupId() != elementList.get(i).getGroupId()) {
                    List<SkuProPertyModel> path = new ArrayList<>();
                    SkuProPertyModel model1 = new SkuProPertyModel();
                    model1.setPropertyName(propertyDataList.get(totalDataList.get(j).getGroupId()).getName());
                    model1.setPropertyValue(totalDataList.get(j).getName());
                    SkuProPertyModel model = new SkuProPertyModel();
                    model.setPropertyName(propertyDataList.get(elementList.get(i).getGroupId()).getName());
                    model.setPropertyValue(elementList.get(i).getName());
                    path.add(model);
                    path.add(model1);
                    pathList.add(path);
                }
            }

        }

        // 算出返回数据中给出的所有存在的sku组合 集合
        List<List<SkuProPertyModel>> respSkuList = new ArrayList<>();
        for (int j = 0; j < productModel.getData().getSkuList().size(); j++) {
            respSkuList.add(productModel.getData().getSkuList().get(j).getSkuProperty());
        }

        Log.e(TAG, "respSku list size" + respSkuList.size());
        Log.e(TAG, "path list size" + pathList.size());

        // 判断路径是否存在 如果存在 则从路径集合中移除 剩下的则是需要置灰处理的路径组合
        for (int i = 0; i < pathList.size(); i++) {
            for (int k = 0; k < respSkuList.size(); k ++) {
                if (respSkuList.get(k).containsAll(pathList.get(i))) {
                    pathList.remove(i);
                    i--;
                    break;
                }
            }

        }
        Log.e(TAG, "path list size" + pathList.size());
        // 从置灰路径集合中 找到置灰项进行置灰
        if (pathList.size() > 0) {
            for (int i = 0; i < pathList.size(); i ++) {
                for (int j = 0; j < totalDataList.size(); j++) {
                    if (totalDataList.get(j).getType() == ProductRvAdapter.CHECK_TYPE) {
                        if (totalDataList.get(j).getName().equals(pathList.get(i).get(0).getPropertyValue())) {
                            totalDataList.get(j).setStatus(2);
                        }
                    }
                }
            }
        }
    }
    
//
//    //回溯法求幂集
//    public static void PowerSet(int i,List<String> list,List<String> li){
//
//        if(i>list.size()-1){
//            System.out.println(li);
//        } else {
//            li.add(list.get(i));//左加
//            PowerSet(i+1,list,li);  //递归方法
//            li.remove(list.get(i)); //右去
//            PowerSet(i+1, list, li);
//        }
//    }

    // 固定的json数据 建议属性维度不超过5
    String response = "{\n" +
            "    \"status\": 0,\n" +
            "    \"bizStatus\": 0,\n" +
            "    \"msg\": null,\n" +
            "    \"data\": {\n" +
            "        \"brandName\": \"耐克森\",\n" +
            "        \"skuList\": [\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"1.5平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/d4b0ceca-758d-4151-9ee8-1bf442142135.jpg\",\n" +
            "                    \"/goods/content/2ee90ee2-ae45-45e6-aad9-eecd6f8e839e.jpg\",\n" +
            "                    \"/goods/content/fa31fb9a-cce5-4511-b0f1-373be29ee772.jpg\",\n" +
            "                    \"/goods/content/e30bcf6f-bbf4-4507-b484-6009a2867205.jpg\",\n" +
            "                    \"/goods/content/6094e21d-9ca8-474f-9058-9338ebc773cc.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 972,\n" +
            "                \"marketPrice\": \"149.90\",\n" +
            "                \"memberPrice\": \"149.90\",\n" +
            "                \"saleAmount\": 28,\n" +
            "                \"skuID\": 8441,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002001\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"2.5平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/a17f8b59-4f0a-43e1-972f-a36c370d6bbc.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 994,\n" +
            "                \"marketPrice\": \"245.90\",\n" +
            "                \"memberPrice\": \"245.90\",\n" +
            "                \"saleAmount\": 8,\n" +
            "                \"skuID\": 8442,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002006\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/a284cfe5-be6a-41fa-a7c8-26b787a71991.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 983,\n" +
            "                \"marketPrice\": \"399.90\",\n" +
            "                \"memberPrice\": \"399.90\",\n" +
            "                \"saleAmount\": 26,\n" +
            "                \"skuID\": 8443,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002011\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/352e72a3-4dd6-4c16-816e-828164c34e29.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"599.90\",\n" +
            "                \"memberPrice\": \"599.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8444,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002021\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/c02782de-f944-46c4-a53f-0937192207cc.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1050.00\",\n" +
            "                \"memberPrice\": \"1050.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8445,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002031\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/f79acc67-31df-4cb4-831d-554cb5cd11ed.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1680.00\",\n" +
            "                \"memberPrice\": \"1680.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8446,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002041\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/2d3ccd46-bf6c-42d2-859b-8ed0ac0bc41a.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"5.28\",\n" +
            "                \"memberPrice\": \"5.28\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8447,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002016\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/687c83f0-af7d-4568-a795-21dd7cee24d0.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"7.79\",\n" +
            "                \"memberPrice\": \"7.79\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8448,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002026\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/a3653e66-3c18-4597-b387-b80054274f78.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"13.35\",\n" +
            "                \"memberPrice\": \"13.35\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8449,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002036\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"红色  \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/b2c79621-0bbf-44b8-a34a-a680f67cd3a5.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"21.09\",\n" +
            "                \"memberPrice\": \"21.09\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8450,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002046\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"1.5平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/55e5edc5-ee22-45c1-885a-411e684a05e3.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 979,\n" +
            "                \"marketPrice\": \"149.90\",\n" +
            "                \"memberPrice\": \"149.90\",\n" +
            "                \"saleAmount\": 40,\n" +
            "                \"skuID\": 8451,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002003\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"2.5平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/d699e49c-f515-4c53-8bb7-08211e6fedf7.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"245.90\",\n" +
            "                \"memberPrice\": \"245.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8452,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002008\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/4628d9c7-d101-48e4-8179-aa5f60332e94.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"399.90\",\n" +
            "                \"memberPrice\": \"399.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8453,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002013\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/0e5e026d-c860-4112-94a9-93bbcb027d2d.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"599.90\",\n" +
            "                \"memberPrice\": \"599.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8454,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002023\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/25153832-e8b3-4354-999f-2e3e3d316633.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1050.00\",\n" +
            "                \"memberPrice\": \"1050.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8455,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002033\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/c974ce12-77b1-4f8f-b092-6c37e3d2a9ff.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1682.00\",\n" +
            "                \"memberPrice\": \"1682.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8456,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002043\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/4299fa49-22b8-4709-a319-02c7f6bc9523.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 997,\n" +
            "                \"marketPrice\": \"5.28\",\n" +
            "                \"memberPrice\": \"5.28\",\n" +
            "                \"saleAmount\": 4,\n" +
            "                \"skuID\": 8457,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002018\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/f4f33e90-865e-4bc0-9902-5ce22d375122.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 987,\n" +
            "                \"marketPrice\": \"7.79\",\n" +
            "                \"memberPrice\": \"7.79\",\n" +
            "                \"saleAmount\": 13,\n" +
            "                \"skuID\": 8458,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002028\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/5c70d5e6-b36d-465b-8447-60165ff08e74.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"13.35\",\n" +
            "                \"memberPrice\": \"13.35\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8459,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002038\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"蓝色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/965c28c7-20dd-49ea-b443-68f408fb922f.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 998,\n" +
            "                \"marketPrice\": \"21.09\",\n" +
            "                \"memberPrice\": \"21.09\",\n" +
            "                \"saleAmount\": 2,\n" +
            "                \"skuID\": 8460,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002048\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"1.5平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/1b722625-3d49-4a35-93b2-6e2932229d3b.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"155.90\",\n" +
            "                \"memberPrice\": \"155.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8461,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002005\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"2.5平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/3d82ffe0-1740-47cf-abc1-60a0910e6b7b.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"249.90\",\n" +
            "                \"memberPrice\": \"249.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8462,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002010\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/1a714070-c1d8-41df-aec3-528d2fac1cf1.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"409.90\",\n" +
            "                \"memberPrice\": \"409.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8463,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002015\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/ad16f0a3-bc4b-4691-a0da-3ec2f37baaf1.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"618.00\",\n" +
            "                \"memberPrice\": \"618.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8464,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002025\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/fa1f5a79-211b-4e0f-9bca-462e2ccb7819.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1080.00\",\n" +
            "                \"memberPrice\": \"1080.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8465,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002035\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/8ffb3643-3b59-4a37-9fe6-a8c3366e7264.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1699.00\",\n" +
            "                \"memberPrice\": \"1699.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8466,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002045\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/6207d659-3b92-4f79-b50e-774d808b1c18.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"5.42\",\n" +
            "                \"memberPrice\": \"5.42\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8467,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002020\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/b92df82a-a665-4f74-8650-a321436e36c2.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"7.99\",\n" +
            "                \"memberPrice\": \"7.99\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8468,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002030\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/b9c8ffca-e4ec-4802-9422-78ccb1cf98be.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"13.70\",\n" +
            "                \"memberPrice\": \"13.70\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8469,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002040\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"双色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/5e526deb-3884-4c5d-9118-7fbe8b5a1fb6.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"22.50\",\n" +
            "                \"memberPrice\": \"22.50\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8470,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002050\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"1.5平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/cca0ad9d-a741-4cf8-8dd3-12193eb2103f.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"149.90\",\n" +
            "                \"memberPrice\": \"149.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8471,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002002\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"2.5平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/c96a7618-6aaf-4542-96d9-9226045366c0.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"245.90\",\n" +
            "                \"memberPrice\": \"245.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8472,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002007\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/8a66bd57-cd4b-4f35-8f2c-fb0fcfea7548.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"399.90\",\n" +
            "                \"memberPrice\": \"399.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8473,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002012\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/2380143a-acbd-45a3-8f06-2eed1677fc87.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"599.90\",\n" +
            "                \"memberPrice\": \"599.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8474,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002022\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/3c3ac1f8-dd18-425f-af55-6292e801a4d6.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1050.00\",\n" +
            "                \"memberPrice\": \"1050.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8475,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002032\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/7fe240ae-1514-4489-9276-7441956e9b28.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1681.00\",\n" +
            "                \"memberPrice\": \"1681.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8476,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002042\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/bdf8b37d-b01d-4266-bbe5-7850d9216b91.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"5.28\",\n" +
            "                \"memberPrice\": \"5.28\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8477,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002017\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/850b6df5-0cd4-48ab-b2d2-159825f2a52c.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"7.79\",\n" +
            "                \"memberPrice\": \"7.79\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8478,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002027\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/295982da-8c29-4b91-a9df-b827bf151925.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"13.35\",\n" +
            "                \"memberPrice\": \"13.35\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8479,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002037\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"黄色\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/b2b4f2fe-bf6e-4da8-8b75-fff02f281a05.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"21.09\",\n" +
            "                \"memberPrice\": \"21.09\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8480,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002047\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"1.5平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/72eeccec-7c9f-411d-b3fd-18162e762089.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"149.90\",\n" +
            "                \"memberPrice\": \"149.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8481,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002004\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"2.5平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/88fd48fb-cf03-4ffd-9f29-4722a339ff51.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"245.90\",\n" +
            "                \"memberPrice\": \"245.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8482,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002009\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/b683a3d0-ef22-4f1f-ba6b-cb5a1cc46519.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"399.90\",\n" +
            "                \"memberPrice\": \"399.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8483,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002014\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/0a7baca6-7807-4c0b-b5c1-c1391102b559.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"599.90\",\n" +
            "                \"memberPrice\": \"599.90\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8484,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002024\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"盒\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/d52dc3d6-4d36-4b7b-a113-d4d457977705.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1050.00\",\n" +
            "                \"memberPrice\": \"1050.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8485,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002034\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"100m/盒 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/9985c88f-2422-46f9-b600-2013f9b4728f.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"1683.00\",\n" +
            "                \"memberPrice\": \"1683.00\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8486,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002044\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"卷\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"4平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/dff508d7-aabb-4993-ba08-c2ccfe426f91.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"5.28\",\n" +
            "                \"memberPrice\": \"5.28\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8487,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002019\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"6平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/e14e43ba-c566-406e-99ed-934450396d78.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"7.79\",\n" +
            "                \"memberPrice\": \"7.79\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8488,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002029\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"10平方 \"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/fd72f1d5-2945-4557-877b-b14637439caa.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"13.35\",\n" +
            "                \"memberPrice\": \"13.35\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8489,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002039\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"skuProperty\": [\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类颜色\",\n" +
            "                        \"propertyValue\": \"绿色 \"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"全类单位\",\n" +
            "                        \"propertyValue\": \"零剪\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"propertyName\": \"电类类型\",\n" +
            "                        \"propertyValue\": \"16平方\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"picUrls\": [\n" +
            "                    \"/goods/content/6295eea3-a9d4-4c91-9a50-263690da71b4.jpg\"\n" +
            "                ],\n" +
            "                \"storeAmount\": 999,\n" +
            "                \"marketPrice\": \"21.09\",\n" +
            "                \"memberPrice\": \"21.09\",\n" +
            "                \"saleAmount\": 0,\n" +
            "                \"skuID\": 8490,\n" +
            "                \"isDisCount\": \"notdiscount\",\n" +
            "                \"erpGoodsCode\": \"020201002049\",\n" +
            "                \"giveJDCount\": 0,\n" +
            "                \"erpGoodsUnit\": \"M\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"goodsId\": 1958,\n" +
            "        \"propertyDataList\": [\n" +
            "            {\n" +
            "                \"电类颜色\": [\n" +
            "                    \"红色  \",\n" +
            "                    \"蓝色 \",\n" +
            "                    \"双色 \",\n" +
            "                    \"黄色\",\n" +
            "                    \"绿色 \"\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"全类单位\": [\n" +
            "                    \"100m/盒 \",\n" +
            "                    \"零剪\"\n" +
            "                ]\n" +
            "            },\n" +
            "            {\n" +
            "                \"电类类型\": [\n" +
            "                    \"1.5平方\",\n" +
            "                    \"2.5平方 \",\n" +
            "                    \"4平方 \",\n" +
            "                    \"6平方 \",\n" +
            "                    \"10平方 \",\n" +
            "                    \"16平方\"\n" +
            "                ]\n" +
            "            }\n" +
            "        ],\n" +
            "        \"isShowJd\": \"NO\",\n" +
            "        \"goodsName\": \"耐克森电线ZB-BV N6系列\",\n" +
            "        \"goodsDetail\": \"全球电线电缆领导品牌, 成立于1913年，法国巴黎上市公司 产品特点： 阻燃型产品，离开明火不延燃，符合欧盟RoHS环保认证， 盒装保护，高档包装\"\n" +
            "    }\n" +
            "}";
}
