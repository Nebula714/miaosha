package org.example.service.model;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

public class ItemModel implements Serializable {
    private Integer id;
    @NotBlank(message = "商品名称不能为空")
    private String title;
    @NotNull(message = "价格不能为空")
    @Min(value = 0, message = "商品价格必须大于0")
    private BigDecimal price;
    @NotNull(message = "库存不能为空")
    private Integer stock;
    @NotBlank(message = "商品描述不能为空")
    private String description;
    private Integer sales; // 销量
    @NotBlank(message = "图片不能为空")
    private String imgUrl;
    //使用聚合模型 如果promomodel不为空 表示其拥有还未结束的秒杀活动
    private PromoModel promoModel;

    public Integer getId() {
        return id;
    }

    public Integer getStock() {
        return stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getSales() {
        return sales;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public PromoModel getPromoModel() {
        return promoModel;
    }

    public void setPromoModel(PromoModel promoModel) {
        this.promoModel = promoModel;
    }
}
