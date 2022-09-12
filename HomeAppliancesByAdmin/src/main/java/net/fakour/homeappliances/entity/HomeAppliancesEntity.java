package net.fakour.homeappliances.entity;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
public class HomeAppliancesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private BigDecimal price;

    private String category;

    private String code;

    private int stock;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "home_appliances_entity_id")
//    private List<Comment1> comment1List=new ArrayList<>();


    //@ElementCollection
//    @CollectionTable
//    private List<Comment1> comments=new ArrayList<>();


    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}