package sku.product.com.skudemo;

import java.util.List;

/**
 * Created by liuxiaodongdefault
 * Created at 17/11/8
 * Project name SkuDemo
 * Package name sku.product.com.skudemo
 */

public class ProductModel {

    /**
     * status : 0
     * bizStatus : 0
     * msg : null
     * data : {"brandName":"耐克森","skuList":[{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/d4b0ceca-758d-4151-9ee8-1bf442142135.jpg","/goods/content/2ee90ee2-ae45-45e6-aad9-eecd6f8e839e.jpg","/goods/content/fa31fb9a-cce5-4511-b0f1-373be29ee772.jpg","/goods/content/e30bcf6f-bbf4-4507-b484-6009a2867205.jpg","/goods/content/6094e21d-9ca8-474f-9058-9338ebc773cc.jpg"],"storeAmount":998,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":2,"skuID":8441,"isDisCount":"notdiscount","erpGoodsCode":"020201002001","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/a17f8b59-4f0a-43e1-972f-a36c370d6bbc.jpg"],"storeAmount":994,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":8,"skuID":8442,"isDisCount":"notdiscount","erpGoodsCode":"020201002006","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/a284cfe5-be6a-41fa-a7c8-26b787a71991.jpg"],"storeAmount":983,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":26,"skuID":8443,"isDisCount":"notdiscount","erpGoodsCode":"020201002011","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/352e72a3-4dd6-4c16-816e-828164c34e29.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8444,"isDisCount":"notdiscount","erpGoodsCode":"020201002021","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/c02782de-f944-46c4-a53f-0937192207cc.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8445,"isDisCount":"notdiscount","erpGoodsCode":"020201002031","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/f79acc67-31df-4cb4-831d-554cb5cd11ed.jpg"],"storeAmount":999,"marketPrice":"1680.00","memberPrice":"1680.00","saleAmount":0,"skuID":8446,"isDisCount":"notdiscount","erpGoodsCode":"020201002041","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/2d3ccd46-bf6c-42d2-859b-8ed0ac0bc41a.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8447,"isDisCount":"notdiscount","erpGoodsCode":"020201002016","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/687c83f0-af7d-4568-a795-21dd7cee24d0.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8448,"isDisCount":"notdiscount","erpGoodsCode":"020201002026","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/a3653e66-3c18-4597-b387-b80054274f78.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8449,"isDisCount":"notdiscount","erpGoodsCode":"020201002036","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/b2c79621-0bbf-44b8-a34a-a680f67cd3a5.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8450,"isDisCount":"notdiscount","erpGoodsCode":"020201002046","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/55e5edc5-ee22-45c1-885a-411e684a05e3.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8451,"isDisCount":"notdiscount","erpGoodsCode":"020201002003","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/d699e49c-f515-4c53-8bb7-08211e6fedf7.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8452,"isDisCount":"notdiscount","erpGoodsCode":"020201002008","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/4628d9c7-d101-48e4-8179-aa5f60332e94.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8453,"isDisCount":"notdiscount","erpGoodsCode":"020201002013","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/0e5e026d-c860-4112-94a9-93bbcb027d2d.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8454,"isDisCount":"notdiscount","erpGoodsCode":"020201002023","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/25153832-e8b3-4354-999f-2e3e3d316633.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8455,"isDisCount":"notdiscount","erpGoodsCode":"020201002033","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/c974ce12-77b1-4f8f-b092-6c37e3d2a9ff.jpg"],"storeAmount":999,"marketPrice":"1682.00","memberPrice":"1682.00","saleAmount":0,"skuID":8456,"isDisCount":"notdiscount","erpGoodsCode":"020201002043","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/4299fa49-22b8-4709-a319-02c7f6bc9523.jpg"],"storeAmount":997,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":4,"skuID":8457,"isDisCount":"notdiscount","erpGoodsCode":"020201002018","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/f4f33e90-865e-4bc0-9902-5ce22d375122.jpg"],"storeAmount":988,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":12,"skuID":8458,"isDisCount":"notdiscount","erpGoodsCode":"020201002028","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/5c70d5e6-b36d-465b-8447-60165ff08e74.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8459,"isDisCount":"notdiscount","erpGoodsCode":"020201002038","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/965c28c7-20dd-49ea-b443-68f408fb922f.jpg"],"storeAmount":998,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":2,"skuID":8460,"isDisCount":"notdiscount","erpGoodsCode":"020201002048","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/1b722625-3d49-4a35-93b2-6e2932229d3b.jpg"],"storeAmount":999,"marketPrice":"155.90","memberPrice":"155.90","saleAmount":0,"skuID":8461,"isDisCount":"notdiscount","erpGoodsCode":"020201002005","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/3d82ffe0-1740-47cf-abc1-60a0910e6b7b.jpg"],"storeAmount":999,"marketPrice":"249.90","memberPrice":"249.90","saleAmount":0,"skuID":8462,"isDisCount":"notdiscount","erpGoodsCode":"020201002010","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/1a714070-c1d8-41df-aec3-528d2fac1cf1.jpg"],"storeAmount":999,"marketPrice":"409.90","memberPrice":"409.90","saleAmount":0,"skuID":8463,"isDisCount":"notdiscount","erpGoodsCode":"020201002015","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/ad16f0a3-bc4b-4691-a0da-3ec2f37baaf1.jpg"],"storeAmount":999,"marketPrice":"618.00","memberPrice":"618.00","saleAmount":0,"skuID":8464,"isDisCount":"notdiscount","erpGoodsCode":"020201002025","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/fa1f5a79-211b-4e0f-9bca-462e2ccb7819.jpg"],"storeAmount":999,"marketPrice":"1080.00","memberPrice":"1080.00","saleAmount":0,"skuID":8465,"isDisCount":"notdiscount","erpGoodsCode":"020201002035","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/8ffb3643-3b59-4a37-9fe6-a8c3366e7264.jpg"],"storeAmount":999,"marketPrice":"1699.00","memberPrice":"1699.00","saleAmount":0,"skuID":8466,"isDisCount":"notdiscount","erpGoodsCode":"020201002045","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/6207d659-3b92-4f79-b50e-774d808b1c18.jpg"],"storeAmount":999,"marketPrice":"5.42","memberPrice":"5.42","saleAmount":0,"skuID":8467,"isDisCount":"notdiscount","erpGoodsCode":"020201002020","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/b92df82a-a665-4f74-8650-a321436e36c2.jpg"],"storeAmount":999,"marketPrice":"7.99","memberPrice":"7.99","saleAmount":0,"skuID":8468,"isDisCount":"notdiscount","erpGoodsCode":"020201002030","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/b9c8ffca-e4ec-4802-9422-78ccb1cf98be.jpg"],"storeAmount":999,"marketPrice":"13.70","memberPrice":"13.70","saleAmount":0,"skuID":8469,"isDisCount":"notdiscount","erpGoodsCode":"020201002040","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/5e526deb-3884-4c5d-9118-7fbe8b5a1fb6.jpg"],"storeAmount":999,"marketPrice":"22.50","memberPrice":"22.50","saleAmount":0,"skuID":8470,"isDisCount":"notdiscount","erpGoodsCode":"020201002050","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/cca0ad9d-a741-4cf8-8dd3-12193eb2103f.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8471,"isDisCount":"notdiscount","erpGoodsCode":"020201002002","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/c96a7618-6aaf-4542-96d9-9226045366c0.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8472,"isDisCount":"notdiscount","erpGoodsCode":"020201002007","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/8a66bd57-cd4b-4f35-8f2c-fb0fcfea7548.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8473,"isDisCount":"notdiscount","erpGoodsCode":"020201002012","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/2380143a-acbd-45a3-8f06-2eed1677fc87.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8474,"isDisCount":"notdiscount","erpGoodsCode":"020201002022","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/3c3ac1f8-dd18-425f-af55-6292e801a4d6.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8475,"isDisCount":"notdiscount","erpGoodsCode":"020201002032","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/7fe240ae-1514-4489-9276-7441956e9b28.jpg"],"storeAmount":999,"marketPrice":"1681.00","memberPrice":"1681.00","saleAmount":0,"skuID":8476,"isDisCount":"notdiscount","erpGoodsCode":"020201002042","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/bdf8b37d-b01d-4266-bbe5-7850d9216b91.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8477,"isDisCount":"notdiscount","erpGoodsCode":"020201002017","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/850b6df5-0cd4-48ab-b2d2-159825f2a52c.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8478,"isDisCount":"notdiscount","erpGoodsCode":"020201002027","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/295982da-8c29-4b91-a9df-b827bf151925.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8479,"isDisCount":"notdiscount","erpGoodsCode":"020201002037","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/b2b4f2fe-bf6e-4da8-8b75-fff02f281a05.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8480,"isDisCount":"notdiscount","erpGoodsCode":"020201002047","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/72eeccec-7c9f-411d-b3fd-18162e762089.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8481,"isDisCount":"notdiscount","erpGoodsCode":"020201002004","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/88fd48fb-cf03-4ffd-9f29-4722a339ff51.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8482,"isDisCount":"notdiscount","erpGoodsCode":"020201002009","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/b683a3d0-ef22-4f1f-ba6b-cb5a1cc46519.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8483,"isDisCount":"notdiscount","erpGoodsCode":"020201002014","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/0a7baca6-7807-4c0b-b5c1-c1391102b559.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8484,"isDisCount":"notdiscount","erpGoodsCode":"020201002024","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/d52dc3d6-4d36-4b7b-a113-d4d457977705.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8485,"isDisCount":"notdiscount","erpGoodsCode":"020201002034","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/9985c88f-2422-46f9-b600-2013f9b4728f.jpg"],"storeAmount":999,"marketPrice":"1683.00","memberPrice":"1683.00","saleAmount":0,"skuID":8486,"isDisCount":"notdiscount","erpGoodsCode":"020201002044","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/dff508d7-aabb-4993-ba08-c2ccfe426f91.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8487,"isDisCount":"notdiscount","erpGoodsCode":"020201002019","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/e14e43ba-c566-406e-99ed-934450396d78.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8488,"isDisCount":"notdiscount","erpGoodsCode":"020201002029","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/fd72f1d5-2945-4557-877b-b14637439caa.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8489,"isDisCount":"notdiscount","erpGoodsCode":"020201002039","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/6295eea3-a9d4-4c91-9a50-263690da71b4.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8490,"isDisCount":"notdiscount","erpGoodsCode":"020201002049","giveJDCount":0,"erpGoodsUnit":"M"}],"goodsId":1958,"propertyList":[{"电类颜色":["红色  ","蓝色 ","双色 ","黄色","绿色 "]},{"全类单位":["100m/盒 ","零剪"]},{"电类类型":["1.5平方","2.5平方 ","4平方 ","6平方 ","10平方 ","16平方"]}],"isShowJd":"NO","goodsName":"耐克森电线ZB-BV N6系列","goodsDetail":"全球电线电缆领导品牌, 成立于1913年，法国巴黎上市公司 产品特点： 阻燃型产品，离开明火不延燃，符合欧盟RoHS环保认证， 盒装保护，高档包装"}
     */

    private int status;
    private int bizStatus;
    private Object msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getBizStatus() {
        return bizStatus;
    }

    public void setBizStatus(int bizStatus) {
        this.bizStatus = bizStatus;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * brandName : 耐克森
         * skuList : [{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/d4b0ceca-758d-4151-9ee8-1bf442142135.jpg","/goods/content/2ee90ee2-ae45-45e6-aad9-eecd6f8e839e.jpg","/goods/content/fa31fb9a-cce5-4511-b0f1-373be29ee772.jpg","/goods/content/e30bcf6f-bbf4-4507-b484-6009a2867205.jpg","/goods/content/6094e21d-9ca8-474f-9058-9338ebc773cc.jpg"],"storeAmount":998,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":2,"skuID":8441,"isDisCount":"notdiscount","erpGoodsCode":"020201002001","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/a17f8b59-4f0a-43e1-972f-a36c370d6bbc.jpg"],"storeAmount":994,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":8,"skuID":8442,"isDisCount":"notdiscount","erpGoodsCode":"020201002006","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/a284cfe5-be6a-41fa-a7c8-26b787a71991.jpg"],"storeAmount":983,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":26,"skuID":8443,"isDisCount":"notdiscount","erpGoodsCode":"020201002011","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/352e72a3-4dd6-4c16-816e-828164c34e29.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8444,"isDisCount":"notdiscount","erpGoodsCode":"020201002021","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/c02782de-f944-46c4-a53f-0937192207cc.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8445,"isDisCount":"notdiscount","erpGoodsCode":"020201002031","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/f79acc67-31df-4cb4-831d-554cb5cd11ed.jpg"],"storeAmount":999,"marketPrice":"1680.00","memberPrice":"1680.00","saleAmount":0,"skuID":8446,"isDisCount":"notdiscount","erpGoodsCode":"020201002041","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/2d3ccd46-bf6c-42d2-859b-8ed0ac0bc41a.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8447,"isDisCount":"notdiscount","erpGoodsCode":"020201002016","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/687c83f0-af7d-4568-a795-21dd7cee24d0.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8448,"isDisCount":"notdiscount","erpGoodsCode":"020201002026","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/a3653e66-3c18-4597-b387-b80054274f78.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8449,"isDisCount":"notdiscount","erpGoodsCode":"020201002036","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/b2c79621-0bbf-44b8-a34a-a680f67cd3a5.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8450,"isDisCount":"notdiscount","erpGoodsCode":"020201002046","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/55e5edc5-ee22-45c1-885a-411e684a05e3.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8451,"isDisCount":"notdiscount","erpGoodsCode":"020201002003","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/d699e49c-f515-4c53-8bb7-08211e6fedf7.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8452,"isDisCount":"notdiscount","erpGoodsCode":"020201002008","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/4628d9c7-d101-48e4-8179-aa5f60332e94.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8453,"isDisCount":"notdiscount","erpGoodsCode":"020201002013","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/0e5e026d-c860-4112-94a9-93bbcb027d2d.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8454,"isDisCount":"notdiscount","erpGoodsCode":"020201002023","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/25153832-e8b3-4354-999f-2e3e3d316633.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8455,"isDisCount":"notdiscount","erpGoodsCode":"020201002033","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/c974ce12-77b1-4f8f-b092-6c37e3d2a9ff.jpg"],"storeAmount":999,"marketPrice":"1682.00","memberPrice":"1682.00","saleAmount":0,"skuID":8456,"isDisCount":"notdiscount","erpGoodsCode":"020201002043","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/4299fa49-22b8-4709-a319-02c7f6bc9523.jpg"],"storeAmount":997,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":4,"skuID":8457,"isDisCount":"notdiscount","erpGoodsCode":"020201002018","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/f4f33e90-865e-4bc0-9902-5ce22d375122.jpg"],"storeAmount":988,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":12,"skuID":8458,"isDisCount":"notdiscount","erpGoodsCode":"020201002028","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/5c70d5e6-b36d-465b-8447-60165ff08e74.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8459,"isDisCount":"notdiscount","erpGoodsCode":"020201002038","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"蓝色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/965c28c7-20dd-49ea-b443-68f408fb922f.jpg"],"storeAmount":998,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":2,"skuID":8460,"isDisCount":"notdiscount","erpGoodsCode":"020201002048","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/1b722625-3d49-4a35-93b2-6e2932229d3b.jpg"],"storeAmount":999,"marketPrice":"155.90","memberPrice":"155.90","saleAmount":0,"skuID":8461,"isDisCount":"notdiscount","erpGoodsCode":"020201002005","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/3d82ffe0-1740-47cf-abc1-60a0910e6b7b.jpg"],"storeAmount":999,"marketPrice":"249.90","memberPrice":"249.90","saleAmount":0,"skuID":8462,"isDisCount":"notdiscount","erpGoodsCode":"020201002010","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/1a714070-c1d8-41df-aec3-528d2fac1cf1.jpg"],"storeAmount":999,"marketPrice":"409.90","memberPrice":"409.90","saleAmount":0,"skuID":8463,"isDisCount":"notdiscount","erpGoodsCode":"020201002015","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/ad16f0a3-bc4b-4691-a0da-3ec2f37baaf1.jpg"],"storeAmount":999,"marketPrice":"618.00","memberPrice":"618.00","saleAmount":0,"skuID":8464,"isDisCount":"notdiscount","erpGoodsCode":"020201002025","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/fa1f5a79-211b-4e0f-9bca-462e2ccb7819.jpg"],"storeAmount":999,"marketPrice":"1080.00","memberPrice":"1080.00","saleAmount":0,"skuID":8465,"isDisCount":"notdiscount","erpGoodsCode":"020201002035","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/8ffb3643-3b59-4a37-9fe6-a8c3366e7264.jpg"],"storeAmount":999,"marketPrice":"1699.00","memberPrice":"1699.00","saleAmount":0,"skuID":8466,"isDisCount":"notdiscount","erpGoodsCode":"020201002045","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/6207d659-3b92-4f79-b50e-774d808b1c18.jpg"],"storeAmount":999,"marketPrice":"5.42","memberPrice":"5.42","saleAmount":0,"skuID":8467,"isDisCount":"notdiscount","erpGoodsCode":"020201002020","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/b92df82a-a665-4f74-8650-a321436e36c2.jpg"],"storeAmount":999,"marketPrice":"7.99","memberPrice":"7.99","saleAmount":0,"skuID":8468,"isDisCount":"notdiscount","erpGoodsCode":"020201002030","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/b9c8ffca-e4ec-4802-9422-78ccb1cf98be.jpg"],"storeAmount":999,"marketPrice":"13.70","memberPrice":"13.70","saleAmount":0,"skuID":8469,"isDisCount":"notdiscount","erpGoodsCode":"020201002040","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"双色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/5e526deb-3884-4c5d-9118-7fbe8b5a1fb6.jpg"],"storeAmount":999,"marketPrice":"22.50","memberPrice":"22.50","saleAmount":0,"skuID":8470,"isDisCount":"notdiscount","erpGoodsCode":"020201002050","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/cca0ad9d-a741-4cf8-8dd3-12193eb2103f.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8471,"isDisCount":"notdiscount","erpGoodsCode":"020201002002","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/c96a7618-6aaf-4542-96d9-9226045366c0.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8472,"isDisCount":"notdiscount","erpGoodsCode":"020201002007","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/8a66bd57-cd4b-4f35-8f2c-fb0fcfea7548.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8473,"isDisCount":"notdiscount","erpGoodsCode":"020201002012","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/2380143a-acbd-45a3-8f06-2eed1677fc87.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8474,"isDisCount":"notdiscount","erpGoodsCode":"020201002022","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/3c3ac1f8-dd18-425f-af55-6292e801a4d6.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8475,"isDisCount":"notdiscount","erpGoodsCode":"020201002032","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/7fe240ae-1514-4489-9276-7441956e9b28.jpg"],"storeAmount":999,"marketPrice":"1681.00","memberPrice":"1681.00","saleAmount":0,"skuID":8476,"isDisCount":"notdiscount","erpGoodsCode":"020201002042","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/bdf8b37d-b01d-4266-bbe5-7850d9216b91.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8477,"isDisCount":"notdiscount","erpGoodsCode":"020201002017","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/850b6df5-0cd4-48ab-b2d2-159825f2a52c.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8478,"isDisCount":"notdiscount","erpGoodsCode":"020201002027","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/295982da-8c29-4b91-a9df-b827bf151925.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8479,"isDisCount":"notdiscount","erpGoodsCode":"020201002037","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"黄色"},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/b2b4f2fe-bf6e-4da8-8b75-fff02f281a05.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8480,"isDisCount":"notdiscount","erpGoodsCode":"020201002047","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}],"picUrls":["/goods/content/72eeccec-7c9f-411d-b3fd-18162e762089.jpg"],"storeAmount":999,"marketPrice":"149.90","memberPrice":"149.90","saleAmount":0,"skuID":8481,"isDisCount":"notdiscount","erpGoodsCode":"020201002004","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"2.5平方 "}],"picUrls":["/goods/content/88fd48fb-cf03-4ffd-9f29-4722a339ff51.jpg"],"storeAmount":999,"marketPrice":"245.90","memberPrice":"245.90","saleAmount":0,"skuID":8482,"isDisCount":"notdiscount","erpGoodsCode":"020201002009","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/b683a3d0-ef22-4f1f-ba6b-cb5a1cc46519.jpg"],"storeAmount":999,"marketPrice":"399.90","memberPrice":"399.90","saleAmount":0,"skuID":8483,"isDisCount":"notdiscount","erpGoodsCode":"020201002014","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/0a7baca6-7807-4c0b-b5c1-c1391102b559.jpg"],"storeAmount":999,"marketPrice":"599.90","memberPrice":"599.90","saleAmount":0,"skuID":8484,"isDisCount":"notdiscount","erpGoodsCode":"020201002024","giveJDCount":0,"erpGoodsUnit":"盒"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/d52dc3d6-4d36-4b7b-a113-d4d457977705.jpg"],"storeAmount":999,"marketPrice":"1050.00","memberPrice":"1050.00","saleAmount":0,"skuID":8485,"isDisCount":"notdiscount","erpGoodsCode":"020201002034","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/9985c88f-2422-46f9-b600-2013f9b4728f.jpg"],"storeAmount":999,"marketPrice":"1683.00","memberPrice":"1683.00","saleAmount":0,"skuID":8486,"isDisCount":"notdiscount","erpGoodsCode":"020201002044","giveJDCount":0,"erpGoodsUnit":"卷"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"4平方 "}],"picUrls":["/goods/content/dff508d7-aabb-4993-ba08-c2ccfe426f91.jpg"],"storeAmount":999,"marketPrice":"5.28","memberPrice":"5.28","saleAmount":0,"skuID":8487,"isDisCount":"notdiscount","erpGoodsCode":"020201002019","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"6平方 "}],"picUrls":["/goods/content/e14e43ba-c566-406e-99ed-934450396d78.jpg"],"storeAmount":999,"marketPrice":"7.79","memberPrice":"7.79","saleAmount":0,"skuID":8488,"isDisCount":"notdiscount","erpGoodsCode":"020201002029","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"10平方 "}],"picUrls":["/goods/content/fd72f1d5-2945-4557-877b-b14637439caa.jpg"],"storeAmount":999,"marketPrice":"13.35","memberPrice":"13.35","saleAmount":0,"skuID":8489,"isDisCount":"notdiscount","erpGoodsCode":"020201002039","giveJDCount":0,"erpGoodsUnit":"M"},{"skuProperty":[{"propertyName":"电类颜色","propertyValue":"绿色 "},{"propertyName":"全类单位","propertyValue":"零剪"},{"propertyName":"电类类型","propertyValue":"16平方"}],"picUrls":["/goods/content/6295eea3-a9d4-4c91-9a50-263690da71b4.jpg"],"storeAmount":999,"marketPrice":"21.09","memberPrice":"21.09","saleAmount":0,"skuID":8490,"isDisCount":"notdiscount","erpGoodsCode":"020201002049","giveJDCount":0,"erpGoodsUnit":"M"}]
         * goodsId : 1958
         * propertyList : [{"电类颜色":["红色  ","蓝色 ","双色 ","黄色","绿色 "]},{"全类单位":["100m/盒 ","零剪"]},{"电类类型":["1.5平方","2.5平方 ","4平方 ","6平方 ","10平方 ","16平方"]}]
         * isShowJd : NO
         * goodsName : 耐克森电线ZB-BV N6系列
         * goodsDetail : 全球电线电缆领导品牌, 成立于1913年，法国巴黎上市公司 产品特点： 阻燃型产品，离开明火不延燃，符合欧盟RoHS环保认证， 盒装保护，高档包装
         */

        private String brandName;
        private int goodsId;
        private String isShowJd;
        private String goodsName;
        private String goodsDetail;
        private List<SkuListBean> skuList;
//        private List<PropertyListBean> propertyList;

        public String getBrandName() {
            return brandName;
        }

        public void setBrandName(String brandName) {
            this.brandName = brandName;
        }

        public int getGoodsId() {
            return goodsId;
        }

        public void setGoodsId(int goodsId) {
            this.goodsId = goodsId;
        }

        public String getIsShowJd() {
            return isShowJd;
        }

        public void setIsShowJd(String isShowJd) {
            this.isShowJd = isShowJd;
        }

        public String getGoodsName() {
            return goodsName;
        }

        public void setGoodsName(String goodsName) {
            this.goodsName = goodsName;
        }

        public String getGoodsDetail() {
            return goodsDetail;
        }

        public void setGoodsDetail(String goodsDetail) {
            this.goodsDetail = goodsDetail;
        }

        public List<SkuListBean> getSkuList() {
            return skuList;
        }

        public void setSkuList(List<SkuListBean> skuList) {
            this.skuList = skuList;
        }

//        public List<PropertyListBean> getPropertyList() {
//            return propertyList;
//        }
//
//        public void setPropertyList(List<PropertyListBean> propertyList) {
//            this.propertyList = propertyList;
//        }

        public static class SkuListBean {
            /**
             * skuProperty : [{"propertyName":"电类颜色","propertyValue":"红色  "},{"propertyName":"全类单位","propertyValue":"100m/盒 "},{"propertyName":"电类类型","propertyValue":"1.5平方"}]
             * picUrls : ["/goods/content/d4b0ceca-758d-4151-9ee8-1bf442142135.jpg","/goods/content/2ee90ee2-ae45-45e6-aad9-eecd6f8e839e.jpg","/goods/content/fa31fb9a-cce5-4511-b0f1-373be29ee772.jpg","/goods/content/e30bcf6f-bbf4-4507-b484-6009a2867205.jpg","/goods/content/6094e21d-9ca8-474f-9058-9338ebc773cc.jpg"]
             * storeAmount : 998
             * marketPrice : 149.90
             * memberPrice : 149.90
             * saleAmount : 2
             * skuID : 8441
             * isDisCount : notdiscount
             * erpGoodsCode : 020201002001
             * giveJDCount : 0
             * erpGoodsUnit : 盒
             */

            private int storeAmount;
            private String marketPrice;
            private String memberPrice;
            private int saleAmount;
            private int skuID;
            private String isDisCount;
            private String erpGoodsCode;
            private int giveJDCount;
            private String erpGoodsUnit;
            private List<SkuProPertyModel> skuProperty;
            private List<String> picUrls;

            public int getStoreAmount() {
                return storeAmount;
            }

            public void setStoreAmount(int storeAmount) {
                this.storeAmount = storeAmount;
            }

            public String getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(String marketPrice) {
                this.marketPrice = marketPrice;
            }

            public String getMemberPrice() {
                return memberPrice;
            }

            public void setMemberPrice(String memberPrice) {
                this.memberPrice = memberPrice;
            }

            public int getSaleAmount() {
                return saleAmount;
            }

            public void setSaleAmount(int saleAmount) {
                this.saleAmount = saleAmount;
            }

            public int getSkuID() {
                return skuID;
            }

            public void setSkuID(int skuID) {
                this.skuID = skuID;
            }

            public String getIsDisCount() {
                return isDisCount;
            }

            public void setIsDisCount(String isDisCount) {
                this.isDisCount = isDisCount;
            }

            public String getErpGoodsCode() {
                return erpGoodsCode;
            }

            public void setErpGoodsCode(String erpGoodsCode) {
                this.erpGoodsCode = erpGoodsCode;
            }

            public int getGiveJDCount() {
                return giveJDCount;
            }

            public void setGiveJDCount(int giveJDCount) {
                this.giveJDCount = giveJDCount;
            }

            public String getErpGoodsUnit() {
                return erpGoodsUnit;
            }

            public void setErpGoodsUnit(String erpGoodsUnit) {
                this.erpGoodsUnit = erpGoodsUnit;
            }

            public List<SkuProPertyModel> getSkuProperty() {
                return skuProperty;
            }

            public void setSkuProperty(List<SkuProPertyModel> skuProperty) {
                this.skuProperty = skuProperty;
            }

            public List<String> getPicUrls() {
                return picUrls;
            }

            public void setPicUrls(List<String> picUrls) {
                this.picUrls = picUrls;
            }


        }

//        public static class PropertyListBean {
//            private List<String> 电类颜色;
//            private List<String> 全类单位;
//            private List<String> 电类类型;
//
//            public List<String> get电类颜色() {
//                return 电类颜色;
//            }
//
//            public void set电类颜色(List<String> 电类颜色) {
//                this.电类颜色 = 电类颜色;
//            }
//
//            public List<String> get全类单位() {
//                return 全类单位;
//            }
//
//            public void set全类单位(List<String> 全类单位) {
//                this.全类单位 = 全类单位;
//            }
//
//            public List<String> get电类类型() {
//                return 电类类型;
//            }
//
//            public void set电类类型(List<String> 电类类型) {
//                this.电类类型 = 电类类型;
//            }
//        }
    }
}
